package userManager;

import config.ConstantValue;
import entity.UserEntity;
import repository.RollRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditUser {

    public static void editRoll() {
        Scanner scanner = new Scanner(System.in);
        List<String> editRollAdmin = new ArrayList<>();
        List<String> rollEntityList = RollRepository.loadRoll();
        showEditUserMessage("User Name");
        editRollAdmin.add(0, scanner.next());
        List<UserEntity> resList = UserRepository.load(editRollAdmin);
        System.out.println("Your User Selection Rolls Is: " + resList.get(0).getRollTitle() + "\n");
        String adminChoice;
        do {
            System.out.println("Choice Roll: \n");
            for (int rolls = 0; rolls < rollEntityList.size(); rolls++) {
                System.out.println((rolls + 1) + ": " + rollEntityList.get(rolls));
            }
            adminChoice = scanner.next();
            if (adminChoice.equals("1")) {
                editRollAdmin.add(1, rollEntityList.get(0));
            } else if (adminChoice.equals("2")) {
                editRollAdmin.add(1, rollEntityList.get(1));
            } else System.out.println("Your Input Value Not Valid");
        } while (!adminChoice.matches(ConstantValue.MENU_REGEX));
        UserRepository.updateUserRoll(editRollAdmin);
    }

    public static void editUser() {
        Scanner scanner = new Scanner(System.in);
        List<String> editUser = new ArrayList<>();
        List<String> rollEntityList = RollRepository.loadRoll();
        showEditUserMessage("User Name");
        editUser.add(0, scanner.next());
        showEditUserMessage("Password");
        String password;
        do {
            password = scanner.next();
        } while (password.matches(ConstantValue.PASSWORD_REGEX));
        editUser.add(1, password);
        System.out.println("Do You Want To Change User Roll ? y/n");
        String changeRoll = scanner.next();
        while (changeRoll.matches(ConstantValue.NAME_REGEX)) {
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
                } while (!strScanner.matches(ConstantValue.MENU_REGEX));
            } else if (changeRoll.equals("n")) {
                break;
            } else System.out.println("Your Operation Not Valid");
        }
    }

    public static void showEditUserMessage(String inputMsg) {
        System.out.println("Please Enter " + inputMsg);
    }
}
