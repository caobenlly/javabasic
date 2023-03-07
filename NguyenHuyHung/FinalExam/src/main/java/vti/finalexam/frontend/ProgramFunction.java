package vti.finalexam.frontend;

import vti.finalexam.backend.presentationlayer.UserController;
import vti.finalexam.entity.Employee;
import vti.finalexam.entity.Manager;
import vti.finalexam.entity.User;
import vti.finalexam.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

public class ProgramFunction {
    private UserController userController;

    public ProgramFunction() {
        userController = new UserController();
    }

    public   void getUserById(int id){
        List<User> users = userController.getUserByProjectId(id);
        System.out.println("-------------------------");
        System.out.println("|   id:   |    Email                     |       fullname     |     password   |       role       |");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (User value :
                users) {
            System.out.printf("|   %-3d   |%15s|    %10s  |  %10s    |    %10s    | \n", value.getId(), value.getEmail(), value.getFullName(), value.getPassword(),value.getRole());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }




    public User login() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.print("Mời bạn nhập vào Email: ");
            String email = ScannerUtils.inputEmail("Email chưa đúng định dạng.");

            System.out.print("Mời bạn nhập password: ");
            String password = ScannerUtils.inputPassword("Password phai dai tu 6--> 12 ki tu");

            User user = userController.login(email, password);

            if (user != null) {
                System.out.println("Chào mừng " + user.getFullName());
                return user;
            } else {
                System.err.println("Bạn đã đien Email/Password khong đung! nhập lại!");
            }
        }
    }

    public void addUser() throws ClassNotFoundException, SQLException {
        System.out.print("Mời bạn nhập vào Fullname của account: ");
        String fullname = ScannerUtils.inputName("Fullname chưa đúng định dạng.");

        String email;
        System.out.print("Mời bạn nhập vào Email của account: ");
        while (true) {
            email = ScannerUtils.inputEmail("Email chưa đúng định dạng.");
            boolean resultExistsEmail = userController.isUserExistsByEmail(email);
            if (resultExistsEmail) {
                System.err.printf("\nEmail %s đã tồn tại! Mời bạn nhập mail khác: ", email);
            } else {
                break;
            }
        }

        userController.createUser(fullname, email);
        System.out.printf("Bạn đã tạo user %s thành công!", fullname);
    }
}
