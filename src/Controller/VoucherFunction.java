package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Voucher;
import java.sql.PreparedStatement;

public class VoucherFunction {

    static DatabaseHandler conn = new DatabaseHandler();

    public static ArrayList<Voucher> getVouchersList() {
        conn.connect();
        String query = "SELECT * FROM voucher";
        ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Voucher temp = new Voucher();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setDesc(rs.getString("desc"));
                temp.setDiscount(rs.getDouble("discount"));
                temp.setCondition(rs.getDouble("condition"));
                vouchers.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    public static Voucher getVoucherByID(String voucherID) {
        conn.connect();
        String query = "SELECT * FROM voucher WHERE id=" + voucherID;
        Voucher voucher = new Voucher();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                voucher.setId(rs.getInt("id"));
                voucher.setName(rs.getString("name"));
                voucher.setDesc(rs.getString("desc"));
                voucher.setDiscount(rs.getDouble("discount"));
                voucher.setCondition(rs.getDouble("condition"));
            }
            return voucher;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean insertVoucher(int id, String name, String desc, double discount, double condition) {
        conn.connect();
        try {
            String query = "INSERT INTO voucher (`id` ,name, `desc`, discount, `condition`) VALUES (?,?, ?, ?, ?)";
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, desc);
            statement.setDouble(4, discount);
            statement.setDouble(5, condition);

            statement.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public static boolean updateVoucher(int id, String name, String desc, double discount, double condition) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            String query = "UPDATE voucher SET name=?, `desc`=?, discount=?, `condition`=? WHERE id=?";
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, desc);
            statement.setDouble(3, discount);
            statement.setDouble(4, condition);
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
