package org.employee.api.employee_test_api.controller;

import org.employee.api.employee_test_api.Entity.UserInfo;
import org.employee.api.employee_test_api.service.JwtService;
import org.employee.api.employee_test_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserControler {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")

    public String addNewUser(@RequestBody UserInfo userInfo) {
        return userService.addUser(userInfo);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserInfo userInfo)
    {

            System.out.println(jwtService.generateToken(userInfo.getName()));
            return jwtService.generateToken(userInfo.getName());


        // return  "token"+authService.generateToken(userCredential.getName());



    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token)
    {
        jwtService.validateToken4(token);
        return "token is valid";
    }


}
