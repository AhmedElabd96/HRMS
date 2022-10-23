package com.mounir.hrms.services.auth;

import com.mounir.hrms.models.auth.AppUser;
import com.mounir.hrms.models.auth.Role;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username , String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers(); //TODO: Convert this method to pagging.
}
