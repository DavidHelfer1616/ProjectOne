package services;

import daos.UsersDao;
import models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    UsersDao userDaoInstance = Mockito.mock(UsersDao.class);
    UserService userServiceInstance;

    public UserServiceTest(){
        this.userServiceInstance = new UserService(userDaoInstance);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUserValidInput() {
        Users expectedResult = new Users(1, "username",
                "password", "David", "Helfer", "david.helfer@hmail.com", "role");
        Mockito.when(userDaoInstance.getUser("username")).thenReturn(expectedResult);

        Users actualResult = userServiceInstance.getUser("username", "password");

        assertEquals(expectedResult, actualResult);
    }
    @Test
    void getUseInvalidInput() {
        Users user= new Users(1, "username",
                "password", "David", "Helfer", "david.helfer@hmail.com", "role");
        Mockito.when(userDaoInstance.getUser("username")).thenReturn(user);

        Users actualResult = userServiceInstance.getUser("username", "paword");

        assertNull(actualResult);
    }

}