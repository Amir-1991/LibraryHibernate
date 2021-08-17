package userManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userSigIn {

    public static void logInUser(){
        Scanner logInScanner = new Scanner(System.in);
        List<String> logInfo = new ArrayList<>();
        showSignInMessage("User Name");
        logInfo.add(0,logInScanner.next());
        showSignInMessage("Password");
        logInfo.add(1,logInScanner.next());

    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
