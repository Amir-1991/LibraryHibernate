package userManager;

import config.constantValue;
import repository.rollRepository;
import repository.userRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class editUser {
    public static void editUser() {
        Scanner scanner = new Scanner(System.in);
        List<String> editUser = new ArrayList<>();
        List<String> rollEntityList = rollRepository.loadRoll();
        showEditUserMessage("User Name");
        editUser.add(0, scanner.next());
        showEditUserMessage("Password");
        String password;
        do {
            password = scanner.next();
        } while (password.matches(constantValue.PASSWORD_REGEX));
        editUser.add(1, password);
        System.out.println("Do You Want To Change User Roll ? y/n");
        String changeRoll = scanner.next();
        while (changeRoll.matches(constantValue.NAME_REGEX)) {
            String strScanner;
            if (changeRoll.equals("y")) {
                do {
                    System.out.println("Choice Roll: \n");
                    for (int rolls = 0; rolls < rollEntityList.size(); rolls++) {
                        System.out.println((rolls + 1) + ": " + rollEntityList.get(rolls));
                    }
                    strScanner = scanner.next();
                    if (strScanner.equals("1")) {
                        editUser.add(2, rollEntityList.get(0));
                    } else if (strScanner.equals("2")) {
                        editUser.add(2, rollEntityList.get(1));
                    } else System.out.println("Your Input Value Not Valid");
                } while (!strScanner.matches(constantValue.MENU_REGEX));
            } else if (changeRoll.equals("n")) {
                break;
            } else System.out.println("Your Operation Not Valid");
        }
        userRepository.updateUser(editUser);
    }

    public static void showEditUserMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
