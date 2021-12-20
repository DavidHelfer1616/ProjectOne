package daos;

import models.Users;

import java.sql.*;

public class UsersDaoImpl implements UsersDao {

    String url;
    String username;
    String password;

    public UsersDaoImpl() {
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/ersdatabase";
        this.username = System.getenv("AWS_RDS_USERNAME");
        this.password = System.getenv("AWS_RDS_PASSWORD");
    }

    public UsersDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Users getUser(String username) {
        Users user = null;

        try(Connection conn = DriverManager.getConnection(url, this.username, this.password)){
            String sql = "SELECT ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_roles.user_role \n" +
                    "FROM users\n" +
                    "LEFT JOIN user_roles ON user_role_id = ers_user_role_id WHERE ers_username = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                user = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
