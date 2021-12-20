package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Util {
    public static String url = "jdbc:h2:./h2/db";
    public static String username = "sa";
    public static String password = "sa";

    public static void createTablesAndValues() {
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "CREATE TABLE reimbursement_status (\n" +
                    "\treimb_status_id serial PRIMARY KEY,\n" +
                    "\treimb_status varchar(10) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE reimbursement_type (\n" +
                    "\treimb_type_id serial PRIMARY KEY,\n" +
                    "\treimb_type varchar(10) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE user_roles (\n" +
                    "\ters_user_role_id serial PRIMARY KEY,\n" +
                    "\tuser_role varchar(20) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE users (\n" +
                    "\ters_users_id serial PRIMARY KEY,\n" +
                    "\ters_username varchar(50) UNIQUE NOT NULL,\n" +
                    "\ters_password varchar(50) NOT NULL,\n" +
                    "\tuser_first_name varchar(100) NOT NULL,\n" +
                    "\tuser_last_name varchar(100) NOT NULL,\n" +
                    "\tuser_email varchar(150) UNIQUE NOT NULL,\n" +
                    "\tuser_role_id int NOT NULL,\n" +
                    "\tFOREIGN KEY (user_role_id) REFERENCES user_roles(ers_user_role_id) ON DELETE CASCADE\n" +
                    ");\n" +
                    "\n" +
                    "CREATE TABLE reimbursement (\n" +
                    "\treimb_id serial PRIMARY KEY,\n" +
                    "\treimb_amount decimal(10, 2) NOT NULL,\n" +
                    "\treimb_submitted timestamp,\n" +
                    "\treimb_resolved timestamp,\n" +
                    "\treimb_description varchar(250),\n" +
                    "\treimb_reciept bytea,\n" +
                    "\treimb_author int NOT NULL,\n" +
                    "\treimb_resolver int,\n" +
                    "\treimb_status_id int NOT NULL,\n" +
                    "\treimb_type_id int NOT NULL,\n" +
                    "\tFOREIGN KEY (reimb_author) REFERENCES users(ers_users_id) ON DELETE CASCADE,\n" +
                    "\tFOREIGN KEY (reimb_resolver) REFERENCES users(ers_users_id) ON DELETE CASCADE,\n" +
                    "\tFOREIGN KEY (reimb_status_id) REFERENCES reimbursement_status(reimb_status_id) ON DELETE CASCADE,\n" +
                    "\tFOREIGN KEY (reimb_type_id) REFERENCES reimbursement_type(reimb_type_id) ON DELETE CASCADE\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO reimbursement_status VALUES \n" +
                    "(DEFAULT, 'Approved'),\n" +
                    "(DEFAULT, 'Pending'),\n" +
                    "(DEFAULT, 'Denied');\n" +
                    "\n" +
                    "INSERT INTO reimbursement_type VALUES \n" +
                    "(DEFAULT, 'LODGING'),\n" +
                    "(DEFAULT, 'TRAVEL'),\n" +
                    "(DEFAULT, 'FOOD'),\n" +
                    "(DEFAULT, 'OTHER');\n" +
                    "\n" +
                    "INSERT INTO user_roles VALUES \n" +
                    "(DEFAULT, 'Employee'),\n" +
                    "(DEFAULT, 'Financial Manager');\n" +
                    "\n" +
                    "INSERT INTO users VALUES \n" +
                    "(DEFAULT, 'stinkydragon', 'p4ssw0rd', 'David', 'Helfer', 'david.helfer@gmail.com', 1),\n" +
                    "(DEFAULT, 'bluejeans', 'bigjeans', 'Susanna', 'Jacobson', 'susanna.jacobson@gmail.com', 2);\n" +
                    "\n" +
                    "\n" +
                    "INSERT INTO reimbursement VALUES \n" +
                    "(DEFAULT, 1500.56, DEFAULT, NULL, 'Marriot Hotel', NULL, 1, NULL, 2, 1),\n" +
                    "(DEFAULT, 65.00, DEFAULT, NULL, 'Lakewood Steakhouse', NULL, 1, NULL, 2, 3);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropTables(){
        try{
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "DROP TABLE reimbursement;\n" +
                    "DROP TABLE users;\n" +
                    "DROP TABLE reimbursement_status;\n" +
                    "DROP TABLE reimbursement_type;\n" +
                    "DROP TABLE user_roles;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.executeUpdate();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
