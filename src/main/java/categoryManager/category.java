package categoryManager;

import entity.articleEntity;

import java.util.Scanner;

public class category {
    public static void creatCategory(){
        Scanner scanner = new Scanner(System.in);
        articleEntity newCategory = new articleEntity();
        showSignInMessage("Category Title");
        newCategory.setTitle(scanner.next());
        showSignInMessage("Description");
        newCategory.setBrief(scanner.next());
        System.out.println("Congratulations Your Category Has Been Created ");
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }

}
