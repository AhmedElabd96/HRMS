package com.mounir.hrms.repo.auth;

import com.mounir.hrms.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByName(String roleName);
}
