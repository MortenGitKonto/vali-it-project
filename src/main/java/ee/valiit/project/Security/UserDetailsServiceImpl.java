package ee.valiit.project.Security;

import ee.valiit.project.Repository.RepositoryTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private RepositoryTechnician repositoryTechnician;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.withUsername(username).
                password(repositoryTechnician.getTechnicianPassword(username)).
                roles("USER").build();
    }
}
