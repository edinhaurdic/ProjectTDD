package org.example.service;

import org.example.AppUser;
import org.example.repo.AppUserRepo;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public AppUser findByUsername(String username) {
        return appUserRepo.findByUsername(username).orElseThrow();
    }
}
