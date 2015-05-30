/**
 * 
 */
package com.dt.hippo.service;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.dt.hippo.auto.model.Account;
import com.dt.hippo.core.security.SecurityUser;
import com.dt.hippo.my.service.MyAccountService;

/**
 * @author Siva
 *
 */
@Component
public class CustomUserDetailsService implements UserDetailsService,
		AuthenticationSuccessHandler {

	@Resource
	private MyAccountService myAccountService;

//    @Autowired
//    private AuthenticationSuccessHandler defaultAuthenticationSuccessHandler;
    
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Account user = myAccountService.getUser(userName);//userService.findUserByEmail(userName);
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + userName
					+ " not found");
		}
		return new SecurityUser(user);
	}

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		if (roles.contains("ROLE_USER")) {
			response.sendRedirect("/userpage");
		}
//		UserDetails userDetails =
//				 (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		defaultAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authentication);
	}
	
	
	@Autowired
	protected AuthenticationManager authenticationManager;

	public void authenticateUserAndSetSession(User user,
			HttpServletRequest request) {
		String username = user.getUsername();
		String password = user.getPassword();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				username, password);

		// generate session if one doesn't exist
		authenticateWithToken(request, token);
	}


	private void authenticateWithToken(HttpServletRequest request,
			UsernamePasswordAuthenticationToken token) {
		request.getSession();

		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager
				.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
	
	public void authenticateUserWithoutPasswordAndSetSession(Account user,
			HttpServletRequest request) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(new SecurityUser(user), null,SecurityUser.extractAuthoritiesFromUser(user));
		SecurityContextHolder.getContext().setAuthentication(authentication);
//			    AuthorityUtils.createAuthorityList("ROLE_USER"));
//		UserDetails userDetail= new SecurityUser(user);
//		
//		//UserDetails userDetail = userDetailService.loadUserByUsername(userId);
//        RunAsUserToken runAsUserToken = new RunAsUserToken("mykey", userDetail, "creds",
//                userDetail.getAuthorities(), null);
// 
//        Authentication authentication = authenticationManager.authenticate(runAsUserToken);
//        
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//        if (authentication.isAuthenticated()) {
//            SecurityContext sc = new SecurityContextImpl();
//            sc.setAuthentication(authentication);
//            SecurityContextHolder.setContext(sc);
//        }
// 
//        try {
//            return invocation.proceed();
//        } finally {
//            SecurityContextHolder.clearContext();
// 
//        }
        
		// generate session if one doesn't exist
//		request.getSession();
//
//		runAsUserToken.setDetails(new WebAuthenticationDetails(request));
//		Authentication authenticatedUser = authenticationManager
//				.authenticate(runAsUserToken);
//
//		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
}
