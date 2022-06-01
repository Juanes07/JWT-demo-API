package com.DEMOJWT.demo.controller;

import com.DEMOJWT.demo.Entity.User;
import com.DEMOJWT.demo.dto.UserDto;
import com.DEMOJWT.demo.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody UserDto userDto) throws Exception {
        User existe = userService.loadUserbyUser(userDto.getUser());
        try {
            if (userDto.getUser() == existe.getUser() && userDto.getPwd() == existe.getPwd()) {
                String token = getJWTToken(existe.getUser());
                return existe;
            }
        } catch (Exception e) {
            throw new Exception("Credenciales Incorrectas");
        }


//        String token = getJWTToken(username);
//        User user = new User();
//        user.setUser(username);
//        user.setToken(token);
        return null;

    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("sofkaJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Valido " + token;
    }
}
