package org.example.repo;

import org.example.entity.AppUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo {
    Optional<AppUser> findByUsername(String username);

}
