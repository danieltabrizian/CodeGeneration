package io.swagger.filter;

import io.swagger.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import io.swagger.jwt.JwtTokenProvider;


@Component
public class jwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(httpServletRequest);    // retrieve the token from the request

        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {        // check if the token is valid
                try{
                    Authentication auth = jwtTokenProvider.getAuthentication(token);    // retrieve the user from the database
                    SecurityContextHolder.getContext().setAuthentication(auth);    // apply the user to the security context of the request
                }catch (UsernameNotFoundException e){
                    System.out.println("[jwtTokenFilter] Authentication token received but probably expired because username is not found!");
                }

            }

        } catch (ResponseStatusException ex) {
            SecurityContextHolder.clearContext();                // if the token is invalid, clear the security context
            httpServletResponse.setStatus(401);
            httpServletResponse.sendError(ex.getStatus().value(), "Token not authorised");
            System.out.println(httpServletRequest.getMethod());
//            httpServletResponse.sendError(ex.getStatus().value(), ex.getMessage());
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);        // move on to the next filter
    }
}
