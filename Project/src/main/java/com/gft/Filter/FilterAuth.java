package com.gft.Filter;

import com.gft.entities.SystemUser;
import com.gft.service.AuthService;
import com.gft.service.SystemUserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterAuth extends OncePerRequestFilter {

    private SystemUserService userService;
    private AuthService authService;

    public FilterAuth(SystemUserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String token = null;
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7, header.length());
        }

        if (authService.validateAcessToken(token)) {

            Long idUser = authService.returnIdUser(token);
            SystemUser user = userService.buscarPorId(idUser);
            SecurityContextHolder.getContext()
                    .setAuthentication(new
                            UsernamePasswordAuthenticationToken(user,
                            null, user.getAuthorities()));
        }

        filterChain.doFilter(request, response);

    }

}
