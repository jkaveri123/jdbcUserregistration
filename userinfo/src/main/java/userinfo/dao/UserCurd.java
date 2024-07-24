package userinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

import userinfo.dto.Userdto;

public class UserCurd {
	public void saveStudent(Userdto userinfo) throws SQLException {

		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_user?user=root&password=root");
		PreparedStatement ps = con.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, userinfo.getId());
		ps.setString(2, userinfo.getName());
		ps.setString(3, userinfo.getEmail());
		ps.setLong(4, userinfo.getPhone());
		ps.setString(5, userinfo.getPassword());
		ps.setString(6, userinfo.getQualification());
		ps.setString(7, userinfo.getDistrict());
		ps.setInt(8, userinfo.getPincode());
		ps.setInt(9, userinfo.getAge());
		ps.setString(10, userinfo.getStream());

		int data = ps.executeUpdate();
		ps.close();
		con.close();

		if (data > 0) {
			System.out.println("data inserted: " + userinfo.getName() + "txn");
		}

	}

	public boolean loginUser(Userdto userinfo) throws SQLException {

		try (Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jdbc_user?user=root&password=root");
				PreparedStatement ps = con
						.prepareStatement("SELECT * FROM userinfo WHERE email = ? AND password = ?")) {

			ps.setString(1, userinfo.getEmail());
			ps.setString(2, userinfo.getPassword());

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println("Login successful for user: " + userinfo.getEmail());
					return true;
				} else {
					System.out.println("Invalid email or password");
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong during login: " + e.getMessage());
			throw e;
		}
	}

	public Userdto fetchUser(Userdto s) throws SQLException {
		String query = "SELECT * FROM userinfo WHERE email = ?";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_user?user=root&password=root");
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, s.getEmail());

		ResultSet resultSet = ps.executeQuery();
		if (resultSet.next()) {
			return new Userdto(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"),
					resultSet.getInt("phone"), resultSet.getString("password"), resultSet.getString("qualification"),
					resultSet.getString("district"), resultSet.getInt("pincode"), resultSet.getInt("age"),
					resultSet.getString("stream"));
		} else
			return null;
	}

	public void updateUser(Userdto userinfo) throws SQLException {

		try (Connection con = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/jdbc_user?user=root&password=root");
				PreparedStatement stmt = con.prepareStatement(
						"UPDATE userinfo SET id= ?,name = ?, phone = ?, password = ?, qualification = ?, district = ?, pincode = ?, age = ?, stream = ? WHERE email = ?")) {

			stmt.setInt(1, userinfo.getId());
			stmt.setString(2, userinfo.getName());
			stmt.setLong(3, userinfo.getPhone());
			stmt.setString(4, userinfo.getPassword());
			stmt.setString(5, userinfo.getQualification());
			stmt.setString(6, userinfo.getDistrict());
			stmt.setInt(7, userinfo.getPincode());
			stmt.setInt(8, userinfo.getAge());
			stmt.setString(9, userinfo.getStream());
			stmt.setString(10, userinfo.getEmail());

			stmt.executeUpdate();
		}
	}

////////
	public void deleteUser(String email) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_user?user=root&password=root");
		PreparedStatement stmt = con.prepareStatement("delete from userinfo  where  email=? ");

		stmt.setString(1, email);

		stmt.executeUpdate();
	}

	public static void exitStudent() {
		System.out.println("Exiting...");

	}

	public static void exitStudent1() {
		System.out.println("Exiting...");

	}

}
