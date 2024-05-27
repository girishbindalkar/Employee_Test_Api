package org.employee.api.employee_test_api.component;

import org.employee.api.employee_test_api.Entity.UserInfo;
import org.employee.api.employee_test_api.config.UserInfoUserDetail;
import org.employee.api.employee_test_api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(UserInfoUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
