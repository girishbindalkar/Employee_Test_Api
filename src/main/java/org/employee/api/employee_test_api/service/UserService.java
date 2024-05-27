package org.employee.api.employee_test_api.service;

import org.employee.api.employee_test_api.Entity.UserInfo;
import org.employee.api.employee_test_api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserInfoRepository userCredentialRepository;

    @Autowired
    JwtService jwtService;
    @Autowired
    UserInfoRepository userInfoRepository;
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "user added to system ";
    }

    public String generateToken(String  userName)
    {
        return jwtService.generateToken(userName);
    }

    public void validateToken(String  token)
    {
        jwtService.validateToken4(token);
    }
}
