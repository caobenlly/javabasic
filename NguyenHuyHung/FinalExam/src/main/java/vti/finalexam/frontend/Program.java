package vti.finalexam.frontend;

import vti.finalexam.entity.Manager;
import vti.finalexam.entity.User;
import vti.finalexam.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    static ProgramFunction programFunction = new ProgramFunction();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        loginProgram();
    }

    public static void loginProgram() throws SQLException, ClassNotFoundException {
        System.out.println("Moi đang nhap:");
        User user = programFunction.login();

        if(user != null) {
            menu();
        }

    }
    public static void menu() throws SQLException, ClassNotFoundException {
        System.out.println("Moi ban nhap chuc nang muon su dung:\n" + "1: In ra danh sach cac employee va manager theo projectID\n"
                + "2: Them moi user\n" + "3: Thoat");
        boolean flag = true;
        while (flag) {
            System.out.println("\nMoi ban nhap tinh nang: ");
            int choose = ScannerUtils.inputFunction(1, 3, "Chon sai. Moi nhap lai!");

            switch (choose) {
                case 1:
                    System.out.println("Nhap projectID:");
                    int projectID = ScannerUtils.inputPositiveInt("Nhap sai");

                    programFunction.getUserById(projectID);
                    break;
                case 2:
                    programFunction.addUser();
                    break;
                case 3:
                    System.out.println("Ban đa thoat khai chuong trinh!");
                    flag = false;
                    return;

            }
        }
    }

}
