package hw3.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService{
    @Autowired
    UserRepository user_pe;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user = user_pe.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("Username not exist");
        }
        System.out.println("s:"+ name);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
