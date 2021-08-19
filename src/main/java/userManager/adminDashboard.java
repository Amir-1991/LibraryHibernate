package userManager;

import articleManager.article;
import categoryManager.category;
import config.constantValue;
import entity.userEntity;
import repository.categoryRepository;
import repository.userRepository;
import tag.tag;

import java.util.List;
import java.util.Scanner;

public class adminDashboard {
    public static void mainDashboard(List<userEntity> resUser) {
        if (resUser.get(0).getRollTitle().equals("admin")) {
            adminDashboard(resUser);
        } else if (resUser.get(0).getRollTitle().equals("writer")) {
            userDashboard.writerDashboard(resUser);
        } else if (resUser.get(0).getRollTitle().equals("reader")) {
            userDashboard.readerDashboard(resUser);
        }
    }

    private static void adminDashboard(List<userEntity> resUser) {
        dashboardMessage(resUser);
        Scanner adminScanner = new Scanner(System.in);
        String adminChoice;
        do {
            System.out.println("1: Manage Users \n" +
                    "2: Manage Categories \n" +
                    "3: Manage Articles \n" +
                    "4: Manage Tags \n" +
                    "5: Exit");
            adminChoice = adminScanner.next();
        } while (!adminChoice.matches(constantValue.MENU_REGEX));
        switch (adminChoice) {
            case "1":
                userManager();
                break;
            case "2":
                categoryManager();
                break;
            case "3":
                articleManager();
                break;
            case "4":
                tagManager();
                break;
            case "5":
                userSignIn.logInUser();
                break;
            default:
                break;
        }
    }

    private static void userManager() {
        Scanner userManagerScan = new Scanner(System.in);
        String userManagerChoice;
        do {
            System.out.println("1: Update Users \n" +
                    "2: Delete User \n" +
                    "3: Back To Admin Dashboard");
            userManagerChoice = userManagerScan.next();
        } while (!userManagerChoice.matches(constantValue.MENU_REGEX));
        switch (userManagerChoice) {
            case "1":
                updateUser();
                break;
            case "2":
                userRepository.deleteUser();
                break;
            case "3":
                break;
        }
    }

    private static void updateUser() {
        Scanner userUpdateScan = new Scanner(System.in);
        String userUpdateChoice;
        do {
            System.out.println("1: Update Roll \n" +
                    "2: Update User Name \n" +
                    "3: Update User Sessions \n" +
                    "4: Back To Admin Dashboard");
            userUpdateChoice = userUpdateScan.next();
        } while (!userUpdateChoice.matches(constantValue.MENU_REGEX));
        switch (userUpdateChoice) {
            case "1":
                editUser.editRoll();
                break;
            case "2":
                userRepository.deleteUser();
                break;
            case "3":
                userRepository.updateUserSession();
                break;
            case "4":
                break;
        }
    }

    private static void categoryManager() {
        Scanner categoryScan = new Scanner(System.in);
        String categoryChoice;
        do {
            System.out.println("1: Creat Category \n" +
                    "2: Edit Category \n" +
                    "3: Delete Category \n" +
                    "4: Back To Admin Dashboard");
            categoryChoice = categoryScan.next();
        } while (!categoryChoice.matches(constantValue.MENU_REGEX));
        switch (categoryChoice) {
            case "1":
                category.creatCategory();
                break;
            case "2":
                category.editCategory();
                break;
            case "3":
                categoryRepository.deleteCategory();
                break;
            case "4":
                break;
        }
    }

    private static void articleManager() {
        Scanner articleScan = new Scanner(System.in);
        String artManageChoice;
        do {
            System.out.println("1: Creat Article \n" +
                    "2: Edit Article \n" +
                    "3: Delete Article \n" +
                    "4: Attach Tag Article \n" +
                    "5: Back To Admin Dashboard");
            artManageChoice = articleScan.next();
        } while (!artManageChoice.matches(constantValue.MENU_REGEX));
        switch (artManageChoice) {
            case "1":
                article.creatArticle();
                break;
            case "2":
                article.editArticle();
                break;
            case "3":
                article.deleteArticle();
                break;
            case "4":
                break;
        }
    }

    private static void tagManager() {
        Scanner tagScan = new Scanner(System.in);
        String tagManageChoice;
        do {
            System.out.println("1: Creat Tag \n" +
                    "2: Attach To Article \n" +
                    "3: Back To Admin Dashboard");
            tagManageChoice = tagScan.next();
        } while (!tagManageChoice.matches(constantValue.MENU_REGEX));
        switch (tagManageChoice) {
            case "1":
                tag.creatTag();
                break;
            case "2":
                tag.attachTag();
                break;
            case "3":
                break;
        }
    }

    private static void dashboardMessage(List<userEntity> resUser) {
        System.out.println("Welcome To Your Home " + resUser.get(0).getUserName() + " \n" +
                "Dear " + resUser.get(0).getFirstName() + " " + resUser.get(0).getLastName() + " You Are " + resUser.get(0).getRollTitle());
    }
}
