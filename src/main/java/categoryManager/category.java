package categoryManager;

import entity.categoryEntity;
import repository.categoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class category {
    public static void creatCategory(){
        Scanner scanner = new Scanner(System.in);
        categoryEntity newCategory = new categoryEntity();
        showSignInMessage("Category Title");
        newCategory.setTitle(scanner.next());
        showSignInMessage("Description");
        newCategory.setDesc(scanner.next());
        categoryRepository.save(newCategory);
        System.out.println("Congratulations Your Category Has Been Created ");
    }
    public static void editCategory(){
        Scanner scanner = new Scanner(System.in);
        List<String> editCategory = new ArrayList<>();
        showSignInMessage("Old Category Title");
        editCategory.add(0,scanner.next());
        showSignInMessage("New Category Title");
        editCategory.add(1,scanner.next());
        showSignInMessage("New Category Description");
        editCategory.add(2,scanner.next());
        categoryRepository.editCategory(editCategory);
        System.out.println("Congratulations Your Category Has Been Updated ");
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }

}
