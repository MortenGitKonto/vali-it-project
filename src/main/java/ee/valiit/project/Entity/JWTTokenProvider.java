package ee.valiit.project.Entity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Serializer;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ServiceLoader;

@Component
public class JWTTokenProvider {

    private static final long VALID_TIME_IN_MILLISECONDS = 60 * 60 * 1000;
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    
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
}
