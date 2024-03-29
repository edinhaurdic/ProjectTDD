package org.example;

import org.example.entity.AppUser;
import org.example.repo.AppUserRepo;
import org.example.service.AppUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppUserTest {

    @Mock
    AppUserRepo appUserRepo;

    private AppUserService appUserService;
    private static String username = "Göran";
    private static String password = "1234hej";

    @BeforeEach
    public void init(){
        appUserService = new AppUserService(appUserRepo);
    }

    @Test
    @DisplayName("Create new User with the expected Username")
    public void create_newAppUserWithExpectedUserName_shouldCreateNewAppUser(){
        //given
        AppUser appUser;

        //When
        appUser = new AppUser( "Edin", "1234hej");

        //Then
        assertSame(appUser.getUsername(), "Edin");
    }

    @Test
    public void findUserByUsername_ifUsernameExists_shouldLogin(){
        //given
        AppUser appUser = new AppUser(username,password);

        //When
        when(appUserRepo.findByUsername(username)).thenReturn(Optional.of(appUser));
        AppUser loggedInUser = appUserService.findByUsername(username);

        //assert
        assertEquals(appUser, loggedInUser);
        verify(appUserRepo, times(1)).findByUsername(username);
    }

    @Test
    public void login_withCorrectCredentials_shouldReturnTrue() {
        //GIVEN
        String existingUsername = "Björn";
        String correctPassword = "1111";

        //WHEN
        when(appUserRepo.findByUsername(existingUsername)).thenReturn(Optional.of(new AppUser(existingUsername, correctPassword)));
        boolean result = appUserService.login(existingUsername,correctPassword);

        //THEN
        assertTrue(result);

    }
    @Test
    public void login_withWrongUsername_shouldThrowException(){
        //Given
        String wrongUser = "Bettan";
        String rightUser = "Börje";

        //WHEN
        when(appUserRepo.findByUsername(wrongUser)).thenThrow(WrongUserNameException.class);
        assertThrows(WrongUserNameException.class, () -> appUserRepo.findByUsername(wrongUser));

        //THEN


    }
    @Test
    public void login_withWrongPassword_shouldThrowException(){
        //given
        String rightUser = "Börje";
        String wrongPassword = "1122";
        String correctPassword = "1234";

        //when
        when(appUserRepo.findByUsername(rightUser)).thenReturn(Optional.of(new AppUser(rightUser, correctPassword)));
        assertThrows(WrongPasswordException.class, () -> appUserService.login(rightUser, wrongPassword));


        //then

    }


}
