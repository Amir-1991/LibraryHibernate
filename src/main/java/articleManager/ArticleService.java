package articleManager;

import config.ConstantValue;
import entity.ArticleEntity;
import repository.ArticleRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleService {
    public static void creatArticle(){
        Scanner scanner = new Scanner(System.in);
        ArticleEntity newArticle = new ArticleEntity();
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
        ArticleRepository.save(newArticle);
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
        while (changePublish.matches(ConstantValue.NAME_REGEX)){
            if (changePublish.equals("y")){
                editArticle.add(3,"change");
            }else if (changePublish.equals("n")){
                editArticle.add(3,"notChange");
            }
        }
        ArticleRepository.editArticle(editArticle);
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
        while (changePublish.matches(ConstantValue.NAME_REGEX)){
            if (changePublish.equals("y")){
                deleteArticle.add(3,"change");
            }else if (changePublish.equals("n")){
                deleteArticle.add(3,"notChange");
            }
        }
        ArticleRepository.deleteArticle(deleteArticle);
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}