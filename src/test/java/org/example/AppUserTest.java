package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    @Test
    public void create_newAppUserWithExpectedUserName_shouldCreateNewAppUser(){
        //given
        AppUser appUser;

        //When
        appUser = new AppUser("Edin1", "1234hej");

        //Then
        assertSame(appUser.getUsername(), "Edin");
    }

}
