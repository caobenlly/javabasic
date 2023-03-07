package vti.finalexam.backend.businesslayer;


import vti.finalexam.backend.datalayer.UserRepository;
import vti.finalexam.entity.Employee;
import vti.finalexam.entity.Manager;
import vti.finalexam.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

	private UserRepository userRepository;

	public UserService() {
		userRepository = new UserRepository();
	}

	public List<User> getUserByProjectId(int ProjectId){
		return userRepository.getUserByProjectId(ProjectId);
	}
	public boolean isUserExistsByEmail(String email) throws ClassNotFoundException, SQLException {
		return userRepository.isUserExistsByEmail(email);
	}


	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		return userRepository.login(email, password);
	}



	public void createUser(String fullname, String email) throws ClassNotFoundException, SQLException {
		userRepository.createUser(fullname, email);
	}
}
