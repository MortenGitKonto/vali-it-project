package ee.valiit.project.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Component
public class JWTTokenProvider {

    private static final long VALID_TIME_IN_MILLISECONDS = 60 * 60 * 1000;
    private static final String AUTHENTICATION_HEADER = "Bearer ";
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @Autowired
    private UserDetailsService userDetailsService;

    public String createToken(String username) {
        Date now = new Date();
        Date validUntil = new Date(now.getTime() + VALID_TIME_IN_MILLISECONDS);

        return Jwts.builder()
                .setClaims(Jwts.claims().setSubject(username))
                .setIssuedAt(now)
                .setExpiration(validUntil)
                .signWith(secretKey)
                .compact();
    }

    public Optional<String> resolveToken(HttpServletRequest servletRequest) {
        return Optional.ofNullable(servletRequest.getHeader("Authorization"))
                .filter(header -> header.startsWith(AUTHENTICATION_HEADER))
                .map(header -> header.substring(AUTHENTICATION_HEADER.length()));
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey).build()
                    .parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException e){
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
