package userManager;

import entity.UserEntity;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserSignIn {

    public static void logInUser(){
        Scanner logInScanner = new Scanner(System.in);
        List<String> logInfo = new ArrayList<>();
        showSignInMessage("User Name");
        logInfo.add(0,logInScanner.next());
        showSignInMessage("Password");
        logInfo.add(1,logInScanner.next());
        List<UserEntity> resUser = UserRepository.load(logInfo);
        if (resUser.size() == 0){
            System.out.println("User Not Found");
        }else if (!resUser.get(0).getPassword().equals(logInfo.get(1))){
            System.out.println("Password Is Wrong ");
        }else{
            Dashboard.mainDashboard(resUser);
        }
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
