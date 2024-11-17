package lk.ijse.Bookshop.model;

import lk.ijse.Bookshop.db.DBConnection;
import lk.ijse.Bookshop.dto.UserDTO;
import lk.ijse.Bookshop.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    public boolean saveUser(UserDTO userDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "insert into user values (?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, userDTO.getUserId());
        pst.setString(2, userDTO.getFirstName());
        pst.setString(3, userDTO.getLastName());
        pst.setString(4, userDTO.getUsername());
        pst.setString(5, userDTO.getEmail());
        pst.setString(6, userDTO.getPassword());

        return pst.executeUpdate() > 0;
    }

    public boolean updateUser(UserDTO userDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "update user set firstName = ?, lastName = ?, username = ?, email = ?, password = ? where User_Id = ?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, userDTO.getFirstName());
        pst.setString(2, userDTO.getLastName());
        pst.setString(3, userDTO.getUsername());
        pst.setString(4, userDTO.getEmail());
        pst.setString(5, userDTO.getPassword());
        pst.setString(6, userDTO.getUserId());

        return pst.executeUpdate() > 0;
    }

    public boolean isEmailExists(String email) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select email from user where email = ?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, email);

        ResultSet rs = pst.executeQuery();

        return rs.next();
    }

    public String getNextUserId() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select User_Id from user order by User_Id desc limit 1";

        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String string = rs.getString(1);
            String subString = string.substring(1);
            int lastIdIndex = Integer.parseInt(subString);
            int nextIdIndex = lastIdIndex + 1;

            String nextId = String.format("U%03d", nextIdIndex);
            return nextId;
        }
        return "U001";
    }

    public List<UserDTO> getAllUsers() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "select * from user";

        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
//
        List<UserDTO> userList = new ArrayList<>();

        while (rs.next()) {
            UserDTO user = new UserDTO(
                    rs.getString("User_Id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")
            );
            userList.add(user);
        }

        return userList;
    }

    public UserDTO findById(String selectedUserId) throws SQLException {
        ResultSet rst = CrudUtil.execute("select * from user where User_Id=?", selectedUserId);

        if (rst.next()) {
            return new UserDTO(
                    rst.getString(1),  // user ID
                    rst.getString(2), // firstname
                    rst.getString(3),  // lastname
                    rst.getString(4), // username
                    rst.getString(5), // email
                    rst.getString(6) // password
            );
        }
        return null;
    }

    public ArrayList<String> getAllUserIds() throws SQLException {
        ResultSet rst = CrudUtil.execute("select User_Id from user");

        ArrayList<String> user_Ids = new ArrayList<>();

        while (rst.next()) {
            user_Ids.add(rst.getString(1));
        }

        return user_Ids;
    }
}