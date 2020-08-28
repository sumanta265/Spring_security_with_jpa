package springsecurity.securitydemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import springsecurity.securitydemo.User;

public class UserDetailsImpl implements UserDetails{

	public UserDetailsImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;
	public UserDetailsImpl(User user) {
	
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isActive = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	public int getId() {
		return id;
	}

	
	
	public String getPassword() {
		return password;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
}
