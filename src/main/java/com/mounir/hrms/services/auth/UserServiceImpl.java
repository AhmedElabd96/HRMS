package com.mounir.hrms.services.auth;

import com.mounir.hrms.models.auth.AppUser;
import com.mounir.hrms.models.auth.Role;
import com.mounir.hrms.repo.auth.RoleRepo;
import com.mounir.hrms.repo.auth.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl  implements  UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepo.findUserByUsername(username);
        if(user != null){
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
            return new User(user.getUsername() , user.getPassword() , authorities);
        }else {
            log.info("User not Found in the database");
            throw new UsernameNotFoundException("User not Found in the database");
        }

    }
    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
            AppUser user = userRepo.findUserByUsername(username);
            Role role = roleRepo.findRoleByName(roleName);
            if(user != null && role != null){
                user.getRoles().add(role);
            }
    }

    @Override
    public AppUser getUser(String username) {
        log.info("User name is : {}" , username);
        return userRepo.findUserByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }


}
