package vti.finalexam.backend.presentationlayer;


import vti.finalexam.backend.businesslayer.UserService;
import vti.finalexam.entity.Employee;
import vti.finalexam.entity.Manager;
import vti.finalexam.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	public List<User> getUserByProjectId(int ProjectId){
		return userService.getUserByProjectId(ProjectId);
	}
	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		return userService.login(email, password);
	}


	public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
		return userService.isUserExistsByEmail(email);
	}
	public void createUser(String fullname, String email) throws ClassNotFoundException, SQLException {
		userService.createUser(fullname, email);
	}
}
