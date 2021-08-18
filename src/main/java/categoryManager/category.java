package categoryManager;

import entity.categoryEntity;

import java.util.Scanner;

public class category {
    public static void creatCategory(){
        Scanner scanner = new Scanner(System.in);
        categoryEntity newCategory = new categoryEntity();
        showSignInMessage("Category Title");
        newCategory.setTitle(scanner.next());
        showSignInMessage("Description");
        newCategory.setDesc(scanner.next());
        System.out.println("Congratulations Your Category Has Been Created ");
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }

}
