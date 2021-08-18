package articleManager;

import config.constantValue;
import entity.articleEntity;
import repository.articleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class article {
    public static void creatArticle(){
        Scanner scanner = new Scanner(System.in);
        articleEntity newArticle = new articleEntity();
        showSignInMessage("Article Name");
        newArticle.setTitle(scanner.next());
        showSignInMessage("Brief");
        newArticle.setBrief(scanner.next());
        showSignInMessage("Content");
        newArticle.setContent(scanner.next());
        newArticle.setCreatDate(LocalDate.now());
        newArticle.setPublished(false);
        newArticle.setPublishedDate(LocalDate.now());
        newArticle.setLastUpdateDate(LocalDate.now());
        articleRepository.save(newArticle);
        System.out.println("Congratulations Your Article Has Been Created \n" +
                "NOTE: Your Article Now Is NonAccessibility For Another Users" +
                "      You Can Change It In Setting -> Edit Article");
    }

    public static void editArticle(){
        Scanner scanner = new Scanner(System.in);
        List<String> editArticle = new ArrayList<>();
        showSignInMessage("Article Name");
        editArticle.add(0,scanner.next());
        showSignInMessage("Brief");
        editArticle.add(1,scanner.next());
        showSignInMessage("Content");
        editArticle.add(2,scanner.next());
        System.out.println("Do You Want To Change Article Published ? y/n");
        String changePublish = scanner.next();
        while (changePublish.matches(constantValue.NAME_REGEX)){
            if (changePublish.equals("y")){
                editArticle.add(3,"change");
            }else if (changePublish.equals("n")){
                editArticle.add(3,"notChange");
            }
        }
        articleRepository.editArticle(editArticle);
    }

    public static void deleteArticle(){
        Scanner scanner = new Scanner(System.in);
        List<String> deleteArticle = new ArrayList<>();
        showSignInMessage("Article Name");
        deleteArticle.add(0,scanner.next());
        showSignInMessage("Brief");
        deleteArticle.add(1,scanner.next());
        showSignInMessage("Content");
        deleteArticle.add(2,scanner.next());
        System.out.println("Do You Want To Change Article Published ? y/n");
        String changePublish = scanner.next();
        while (changePublish.matches(constantValue.NAME_REGEX)){
            if (changePublish.equals("y")){
                deleteArticle.add(3,"change");
            }else if (changePublish.equals("n")){
                deleteArticle.add(3,"notChange");
            }
        }
        articleRepository.deleteArticle(deleteArticle);
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}