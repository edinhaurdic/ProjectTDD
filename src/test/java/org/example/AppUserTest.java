package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    @Test
    public void constructor_withoutProp_ShouldExist(){
        //given
        AppUser appUser;

        //When
        appUser = new AppUser();

        //Then
        assertNotNull(appUser);
    }

}
