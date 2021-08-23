import config.ConstantValue;
import userManager.UserSignIn;
import userManager.UserSignUp;

import java.util.Scanner;

public class mainLibrary {
    public static void main(String[] args) {
        System.out.println("Welcome To Biggest Article Library In The World :D \n" +
                "1: SignUp \n" +
                "2: SignIn \n" +
                "3: Exit ");
        Scanner scanner = new Scanner(System.in);
        String firstOperation = scanner.next();
        if (firstOperation.matches(ConstantValue.MENU_REGEX)) {
            switch (firstOperation) {
                case "1":
                    UserSignUp.creatUser();
                    break;
                case "2":
                    UserSignIn.logInUser();
                    break;
                case "3":
                    System.out.println("GOOD-BYE");
                default:
                    System.out.println("This Operation Not Valid");
                    break;
            }
        }else{
            System.out.println("This Operation Not Valid");
            main(args);
        }
        main(args);
    }
}
