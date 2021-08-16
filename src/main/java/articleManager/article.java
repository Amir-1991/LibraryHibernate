package articleManager;

import entity.articleEntity;

import java.time.LocalDate;
import java.util.Scanner;

public class article {
    public static void creatArticle(){
        Scanner scanner = new Scanner(System.in);
        articleEntity newArticle = new articleEntity();
        String artScanner ;
        showSignInMessage("Article Name");
        newArticle.setTitle(scanner.next());
        showSignInMessage("Brief");
        newArticle.setBrief(scanner.next());
        showSignInMessage("Content");
        newArticle.setContent(scanner.next());
        newArticle.setCreatDate(LocalDate.now());
        newArticle.setPublished(false);
        System.out.println("Congratulations Your Article Has Been Created \n" +
                "NOTE: Your Article Now Is NonAccessibility For Another Users" +
                "      You Can Change It In Setting -> Edit Your Article");
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}