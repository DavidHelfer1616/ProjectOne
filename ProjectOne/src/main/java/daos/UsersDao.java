package daos;

import models.Users;

public interface UsersDao {

    Users getUser (String username);
}
