package springsecurity.securitydemo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springsecurity.securitydemo.UserDetailsImpl;
import springsecurity.securitydemo.UserRepository;
import springsecurity.securitydemo.User;
@Service
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		
		Optional<User> user = userRepository.findByuserName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return user.map(UserDetailsImpl::new).get();
	}
		
	
	
	
	
	
	
	
}
