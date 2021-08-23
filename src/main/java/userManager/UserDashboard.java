package userManager;

import articleManager.ArticleService;
import config.ConstantValue;
import entity.UserEntity;
import java.util.List;
import java.util.Scanner;

public class UserDashboard {

    public static void  writerDashboard(List<UserEntity> resUser) {
        dashboardMessage(resUser);
        Scanner writerScanner = new Scanner(System.in);
        String writerChoice;
        do {
            System.out.println("1: Creat Articles \n" +
                    "2: Edit Article \n" +
                    "2: Setting \n" +
                    "3: Exit");
            writerChoice = writerScanner.next();
        } while (!writerChoice.matches(ConstantValue.MENU_REGEX));
        switch (writerChoice) {
            case "1":
                ArticleService.creatArticle();
                break;
            case "2":
                ArticleService.editArticle();
                break;
            case "3":
                setting();
                break;
            default:
                break;
        }

    }

    private static void setting() {
    }


    public static void readerDashboard(List<UserEntity> resUser) {
        dashboardMessage(resUser);


    }

    private static void dashboardMessage(List<UserEntity> resUser) {
        System.out.println("Welcome To Your Home " + resUser.get(0).getUserName() + " \n" +
                "Dear " + resUser.get(0).getFirstName() + " " + resUser.get(0).getLastName() + " You Are " + resUser.get(0).getRollTitle());
    }
}
