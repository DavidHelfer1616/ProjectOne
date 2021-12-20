package services;

import daos.UsersDao;
import daos.UsersDaoImpl;
import models.Users;


public class UserService {

    UsersDao userDaoInstance;

    public UserService(UsersDao passedUserDao) {
        this.userDaoInstance = passedUserDao;
    }

    public UserService(){
        this.userDaoInstance = new UsersDaoImpl();
    }

    public Users getUser(String username, String password){
        Users user = userDaoInstance.getUser(username);
        if (user.getPassword().equals(password)){
            return user;
        } else {
            return null;
        }
    }

}
