package daos;

import models.Reimbursements;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementsDaoImpl implements ReimbursementsDao{

    String url;
    String username;
    String password;

    public ReimbursementsDaoImpl() {
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/ersdatabase";
        this.username = System.getenv("AWS_RDS_USERNAME");
        this.password = System.getenv("AWS_RDS_PASSWORD");
    }

    public ReimbursementsDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Reimbursements> getAllReimbursements() {
        List<Reimbursements> reimbursements = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept,\n" +
                    "author.user_first_name authorFirst, author.user_last_name authorLast, resolver.user_first_name resolverFirst, resolver.user_last_name resolverLast,\n" +
                    "reimb_status_id, reimb_type_id \n" +
                    "FROM reimbursement\n" +
                    "LEFT JOIN users author ON reimb_author = author.ers_users_id\n" +
                    "LEFT JOIN users resolver ON reimb_resolver = resolver.ers_users_id;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursements.add(new Reimbursements(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
                        rs.getTimestamp(4), rs.getString(5), rs.getBytes(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10),rs.getInt(11),
                        rs.getInt(12)));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
            return reimbursements;
    }

    @Override
    public List<Reimbursements> getAllReimbursementsForEmployee(Integer authorId) {
        List<Reimbursements> reimbursements = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept,\n" +
                    "author.user_first_name authorFirst, author.user_last_name authorLast, resolver.user_first_name resolverFirst, resolver.user_last_name resolverLast,\n" +
                    "reimb_status_id, reimb_type_id \n" +
                    "FROM reimbursement\n" +
                    "LEFT JOIN users author ON reimb_author = author.ers_users_id\n" +
                    "LEFT JOIN users resolver ON reimb_resolver = resolver.ers_users_id WHERE reimb_author = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,authorId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursements.add(new Reimbursements(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
                        rs.getTimestamp(4), rs.getString(5), rs.getBytes(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10),rs.getInt(11),
                        rs.getInt(12)));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return reimbursements;
    }


    @Override
    public Reimbursements getReimbursement(Integer reimbId) {
        Reimbursements reimbursements = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept,\n" +
                    "author.user_first_name authorFirst, author.user_last_name authorLast, resolver.user_first_name resolverFirst, resolver.user_last_name resolverLast,\n" +
                    "reimb_status_id, reimb_type_id \n" +
                    "FROM reimbursement\n" +
                    "LEFT JOIN users author ON reimb_author = author.ers_users_id\n" +
                    "LEFT JOIN users resolver ON reimb_resolver = resolver.ers_users_id WHERE reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursements = new Reimbursements(rs.getInt(1), rs.getDouble(2), rs.getTimestamp(3),
                        rs.getTimestamp(4), rs.getString(5), rs.getBytes(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10),rs.getInt(11),
                        rs.getInt(12));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return reimbursements;
    }

    @Override
    public Boolean createReimbursement(Reimbursements reimbDTO) {

        try(Connection conn = DriverManager.getConnection(url,username,password)){
            String sql = "INSERT INTO reimbursement VALUES \n" +
                    "(DEFAULT, ?, DEFAULT, NULL, ?, NULL, ?, NULL, 2, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, reimbDTO.getReimbAmount());
            ps.setString(2, reimbDTO.getReimbDescription());
            ps.setInt(3, reimbDTO.getAuthorId());
            ps.setInt(4, reimbDTO.getReimbType());

            ps.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }


    }

    @Override
    public Boolean updateReimbursement(Reimbursements reimbDTO) {
        String sql = "UPDATE reimbursement\n" +
                "SET reimb_resolved = now(), reimb_resolver = ?, reimb_status_id = ?\n" +
                "WHERE reimb_id = ?;";
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbDTO.getResolverId());
            ps.setInt(2, reimbDTO.getReimbStatus());
            ps.setInt(3, reimbDTO.getReimbId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
