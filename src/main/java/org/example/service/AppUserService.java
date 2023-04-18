package org.example.service;

import org.example.WrongUserNameException;
import org.example.entity.AppUser;
import org.example.repo.AppUserRepo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public AppUser findByUsername(String username) {
        return appUserRepo.findByUsername(username).orElseThrow();
    }

    public boolean login(String username, String password) {
       AppUser loginUser = appUserRepo.findByUsername(username).orElseThrow();
       loginUser.getPassword();
       if(password.equals(loginUser.getPassword())){
           return true;
       }
       else{
           return false;
       }
    }
    

/*    public static class wrongUsername(String rightUser, String wrongUser){

    }*/


/*    public void wrongUsername() throws WrongUserNameException {
        throw new WrongUserNameException();
    }*/

    public static class wrongUsername {
        public wrongUsername(String rightUser, String wrongUser) {
            if(rightUser.equals(wrongUser))
            throw new WrongUserNameException();
        }
    }
}
