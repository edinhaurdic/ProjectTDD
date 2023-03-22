package org.example.entity;

import java.util.Objects;

public class AppUser {

    //@Autowired
    //private final AppUserRepo appUserRepo;
    private String username;
    private String password;

    public AppUser(String username, String password) {
        this.username=username;
        this.password=password;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(getUsername(), appUser.getUsername()) && Objects.equals(getPassword(), appUser.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
}
