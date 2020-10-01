package ee.valiit.project.Security;

import ee.valiit.project.Security.JWTTokenProvider;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilter {
    private JWTTokenProvider tokenProvider;
    public JwtTokenFilter(JWTTokenProvider jwtTokenProvider) {
        this.tokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if(!httpServletRequest.getMethod().equals("OPTIONS")){
            tokenProvider.resolveToken((HttpServletRequest) servletRequest)
                    .filter(tokenProvider::validateToken)
                    .map(tokenProvider::getAuthentication)
                    .ifPresent(auth -> SecurityContextHolder.getContext().setAuthentication(auth));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
