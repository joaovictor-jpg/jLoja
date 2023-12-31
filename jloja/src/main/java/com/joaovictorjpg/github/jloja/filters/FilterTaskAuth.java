package com.joaovictorjpg.github.jloja.filters;

import com.joaovictorjpg.github.jloja.Helpers.Bcrypt;
import com.joaovictorjpg.github.jloja.model.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private UserService service;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var servLetPath = request.getServletPath();
        if(!servLetPath.startsWith("/users")) {

            // capturar o user na request
            String[] authorization = request.getHeader("Authorization").split(" ");
            byte[] authDecode = Base64.getDecoder().decode(authorization[1]);
            String[] authString = new String(authDecode).split(":");
            String username = authString[0];
            String password = authString[1];

            // validar user
            var user = service.findByName(username);
            if(user == null) {
                response.sendError(401);
            } else {
                var isTrue = Bcrypt.correctPassword(password, user);
                if(isTrue) {
                    // Passando request para frente
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
            }

        } else {
            filterChain.doFilter(request, response);
        }
    }
}
