package dao;

import model.User;
import java.sql.*;

public class UserDao {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Pet_Adoption";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Anmol12@";

    private Connection getConnection() throws SQLException {
    	System.out.println(this.URL);
    	System.out.println(this.USERNAME);
    	System.out.println(this.PASSWORD);
    	return DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
    }
    public boolean registerUser(User user) {
        String query = "INSERT INTO users (name, address, email, mobile, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getAddress());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getMobile());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getRole().name());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public User loginUser(String email, String password) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(User.Role.valueOf(resultSet.getString("role")));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
