package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    @Test
    public void create_newAppUser_shouldCreateAppUser(){
        //given
        AppUser appUser;

        //When
        appUser = new AppUser("Edin", "1234hej");

        //Then
        assertNotNull(appUser);
    }

}
