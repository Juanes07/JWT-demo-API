package com.DEMOJWT.demo.controller;

import com.DEMOJWT.demo.Entity.User;
import com.DEMOJWT.demo.dto.UserDto;
import com.DEMOJWT.demo.repository.UserRepository;
import com.DEMOJWT.demo.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody UserDto userDto) throws Exception {
        User existe = userService.loadById(userDto.getId());
        String token = "no tiene acceso";
        existe.setToken(token);
        try {
            System.out.println("hola estoy dentro del try");
            if (userDto.getUser().equalsIgnoreCase(existe.getUser()) && userDto.getPwd().equalsIgnoreCase(existe.getPwd())) {
                token = getJWTToken(existe.getUser());
                System.out.println("hola entre al if" );
                existe.setToken(token);
            }
        } catch (Exception e) {
            throw new Exception("Credenciales Incorrectas");
        }
        return existe;

//        String token = getJWTToken(userDto.getUser());
//        User user = new User();
//        user.setUser(userDto.getUser());
//        user.setToken(token);
//        return userRepository.save(user);

//        userDto.getUser() == existe.getUser() && userDto.getPwd() == existe.getPwd()
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
