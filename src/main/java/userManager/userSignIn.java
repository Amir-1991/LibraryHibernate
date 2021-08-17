package userManager;

import entity.userEntity;
import repository.userRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userSignIn {

    public static void logInUser(){
        Scanner logInScanner = new Scanner(System.in);
        List<String> logInfo = new ArrayList<>();
        showSignInMessage("User Name");
        logInfo.add(0,logInScanner.next());
        showSignInMessage("Password");
        logInfo.add(1,logInScanner.next());
        List<userEntity> resUser = userRepository.load(logInfo);
        if (resUser.size() == 0){
            System.out.println("User Not Found");
        }else if (!resUser.get(0).getPassword().equals(logInfo.get(1))){
            System.out.println("Password Is Wrong ");
        }else{
            adminDashboard.mainDashboard(resUser);
        }
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
