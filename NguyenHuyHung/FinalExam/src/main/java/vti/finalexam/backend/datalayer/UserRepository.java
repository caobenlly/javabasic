package vti.finalexam.backend.datalayer;



import vti.finalexam.entity.Employee;
import vti.finalexam.entity.Manager;
import vti.finalexam.entity.Role;
import vti.finalexam.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	private utils.JDBCUtils jdbcUtils;

	public UserRepository() {
		jdbcUtils = new utils.JDBCUtils();
	}
	public List<User> getUserByProjectId(int ProjectId)  {
		List<User> users = new ArrayList<>();
		try {
			Connection connection = jdbcUtils.connectDB();
			String sql = "select  * from `User` where ProjectId = ? and (`Role` = 'Employee' OR  `Role` = 'Manager')";
			PreparedStatement statement = null;
			statement = connection.prepareStatement(sql);
			statement.setInt(1,ProjectId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setEmail(resultSet.getString("email"));
				user.setFullName(resultSet.getString("fullname"));
				user.setPassword(resultSet.getString("password"));
				Role role = Role.valueOf(resultSet.getString("role").toUpperCase());
				user.setRole(role);
				users.add(user);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return users;
	}



	public User login(String email, String password) throws SQLException, ClassNotFoundException {



			Connection connection = jdbcUtils.connectDB();


			String sql = "SELECT id, FullName FROM `User` WHERE Email = ? AND `Password` = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
	

			ResultSet resultSet = statement.executeQuery();


			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String fullName = resultSet.getString("FullName");



				User user = new Manager(id, fullName, email);
				return user;

			} else {
				return null;
			}

	}

	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException {

		try {
			// Step 1: get connection
			Connection connection = jdbcUtils.connectDB();

			// Step 2: Create a statement obiect
			String sql = "SELECT 1 FROM `User` WHERE Email = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);

			// Step 3: Execute SQL query
			ResultSet resultSet = statement.executeQuery();

			// Step 4: Handling Result Set
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} finally {
			jdbcUtils.disconnect();
		}
	}
	public void createUser(String fullname, String email) throws SQLException, ClassNotFoundException {
		try {
			// Step 1: get connection
			Connection connection = jdbcUtils.connectDB();

			// Step 2: Create a statement obiect
			String sql = "INSERT INTO `User`  (FullName	, 	Email	,	`Password`	,	ExpInYear	, 	ProSkill,ProjectId	, 	`Role`		)" +
					"VALUES		      (		?	,	  ?		, 	'123456'	,		null	,	  null		, null, 'Employee'	)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, fullname);
			statement.setString(2, email);

			// Step 3: Execute SQL query
			statement.executeUpdate();

		} finally {
			jdbcUtils.disconnect();
		}
	}
}
