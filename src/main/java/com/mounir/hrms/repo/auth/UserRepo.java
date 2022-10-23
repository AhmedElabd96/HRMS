package com.mounir.hrms.repo.auth;

import com.mounir.hrms.models.auth.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser , Long> {
    AppUser findUserByUsername(String username);
}
