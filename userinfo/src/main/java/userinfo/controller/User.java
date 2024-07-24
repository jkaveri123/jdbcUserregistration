package userinfo.controller;

import java.sql.SQLException;
import java.util.Scanner;

import userinfo.dao.UserCurd;
import userinfo.dto.Userdto;

public class User {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("...............welcome................");

		boolean value = true;
		while (value) {
			System.out.println("Enter your choice: \n1. Registration \n2. Login \n3. Exit");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				System.out.println(".............registration...................");
				save();
				break;
			case 2:
				System.out.println(".............login...................");
				login();
				break;
			case 3:
				System.out.println("Exiting...................");
				value = false;
				exit();
				break;
			default:
				System.out.println("Please choose a correct option.");
			}
		}

		while (value)
			;
		System.out.println("thank you...........");

	}

	public static void save() {
		// System.out.println("................save..........");
		System.out.println("enter id");
		int id = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter email");
		String email = sc.next();
		System.out.println("enter phone");
		int phone = sc.nextInt();
		System.out.println("enter password");
		String password = sc.next();

		System.out.println("enter qualification");
		String qualification = sc.next();
		System.out.println("enter district");
		String district = sc.next();
		System.out.println("enter pincode");
		int pincode = sc.nextInt();
		System.out.println("enter age");
		int age = sc.nextInt();
		System.out.println("enter stream");
		String stream = sc.next();

		Userdto s = new Userdto(id, name, email, phone, password, qualification, district, pincode, age, stream);

		System.out.println(s);
		UserCurd curd = new UserCurd();
		try {
			curd.saveStudent(s);
			System.out.println("data is inserted successfully");

		} catch (SQLException e) {

			System.out.println("something error occured" + e.getMessage());
			save();
			// throw e;

		}
	}

	public static void login() {
		System.out.println("Enter email:");
		String email = sc.next();
		System.out.println("Enter password:");
		String password = sc.next();

		Userdto user = new Userdto(email, password);
		System.out.println(user);
		UserCurd curd = new UserCurd();
		try {
			boolean loginSuccess = curd.loginUser(user);
			if (loginSuccess) {
				System.out.println("Login successful");
			} else {
				System.out.println("Invalid email or password");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			System.out.println("something error occured" + e.getMessage());
			e.printStackTrace();
		}
		
		
		boolean value1 = true;
		while (value1) {
			System.out.println("Enter your choice: \n1. update \n 2. fetch \n 3. delete \n 4.exit");
			int key1 = sc.nextInt();
			switch (key1) {
			case 1:
				System.out.println(".............upadate...................");
				update();
				break;
			case 2:
				System.out.println(".............fetch...................");
				fetch();
				break;
			case 3:
				System.out.println(".............delete...................");
				delete();
				break;	
			case 4:
				System.out.println(".......exit...................");
				value1 = false;
				exit();
				break;
			default:
				System.out.println("Please choose a correct option.");
				
				
			}
		}

		}
	////////////////////////////////////////////////////// update and delete exit
	
	public static void update() {
		// System.out.println("................save..........");
		System.out.println("enter the registered  email");
		String email = sc.next();
		System.out.println("enter the registered id");
		int id = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter phone");
		int phone = sc.nextInt();
		System.out.println("enter password");
		String password = sc.next();

		System.out.println("enter qualification");
		String qualification = sc.next();
		System.out.println("enter district");
		String district = sc.next();
		System.out.println("enter pincode");
		int pincode = sc.nextInt();
		System.out.println("enter age");
		int age = sc.nextInt();
		System.out.println("enter stream");
		String stream = sc.next();

		Userdto s = new Userdto(id, name, email, phone, password, qualification, district, pincode, age, stream);

		System.out.println(s);
		UserCurd curd = new UserCurd();
		try {
			curd.updateUser(s);
			System.out.println("data is inserted successfully");

		} catch (SQLException e) {

			System.out.println("something error occured" + e.getMessage());
			save();
			// throw e;

		}
	}

	
	/////////////////////////////////////
	
	public static void fetch() {
        System.out.println("enter email of the user to fetch:");
        String email = sc.next();
//        System.out.println("enter password to fetch");
//        String password=sc.next();

		Userdto s = new Userdto(email);
		System.out.println(s);
        UserCurd curd = new UserCurd();
        
        try {
            Userdto user = curd.fetchUser(s);
            if (user != null) {
                System.out.println("User details: " + user);
            } else {
                System.out.println("No user found with the given email");
            }
        } catch (SQLException e) {
            System.out.println("something error occured: " + e.getMessage());
        }
    }
		
		
		//////////////////
	public static void delete() {
		
	        System.out.println("enter email of the user to delete:");
	        String email = sc.next();

	        UserCurd curd = new UserCurd();
	        try {
	            curd.deleteUser(email);
	            System.out.println("User deleted successfully");
	        } catch (SQLException e) {
	            System.out.println("something error occured: " + e.getMessage());
	        }
	    }
		
		
		
		
		
		
	
////////////////////////////////
	public static void exit() {
		// UserCurd.exitStudent();
		System.out.println("Exited successfully");
		sc.close(); // Ensure the Scanner is closed.
		System.exit(0); // Terminate the program immediately.

	}
}
