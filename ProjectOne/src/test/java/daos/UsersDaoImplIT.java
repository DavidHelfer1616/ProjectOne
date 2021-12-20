package daos;

import models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import util.H2Util;

class UsersDaoImplIT {

    UsersDao usersDaoInstance;

    public UsersDaoImplIT() {
        this.usersDaoInstance = new UsersDaoImpl(H2Util.url, H2Util.username, H2Util.password);
    }

    @BeforeEach
    void setUp() {
        H2Util.createTablesAndValues();
    }

    @AfterEach
    void tearDown() {
        H2Util.dropTables();
    }

    @Test
    void getUser() {

        Users expectedResult = new Users(1, "stinkydragon", "p4ssw0rd",
                "David", "Helfer", "david.helfer@gmail.com", "Employee");

        Users actualResult = usersDaoInstance.getUser("stinkydragon");

        assertEquals(expectedResult, actualResult);
    }
}