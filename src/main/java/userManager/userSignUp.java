package userManager;

import config.constantValue;
import entity.userEntity;
import repository.userRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class userSignUp {
    public static void creatUser() {
        Scanner scanner = new Scanner(System.in);
        userEntity newUser = new userEntity();
        String resScanner;
        do {
            System.out.println("You Are: \n" +
                    "1: Artist \n" +
                    "2: Reader ");
            resScanner = scanner.next();
            if (resScanner.equals("1")) {
                newUser.setRollUser("Artist");
            } else if (resScanner.equals("2")) {
                newUser.setRollUser("Reader");
            }else System.out.println("Your Input Value Not Valid");
        } while (!resScanner.matches(constantValue.MENU_REGEX));
        showSignInMessage("User Name");
        newUser.setUserName(scanner.next());
        do {
            showSignInMessage("First Name");
            resScanner = scanner.next();
            newUser.setFirstName(resScanner);
        } while (!resScanner.matches(constantValue.NAME_REGEX));
        do {
            showSignInMessage("Last Name");
            resScanner = scanner.next();
            newUser.setLastName(resScanner);
        } while (!resScanner.matches(constantValue.NAME_REGEX));
        do {
            showSignInMessage("National Code");
            resScanner = scanner.next();
            if (resScanner.matches(constantValue.NATIONAL_CODE_REGEX)) {
                newUser.setNationalCode(resScanner);
                newUser.setPassword(resScanner);
            } else {
                System.out.println("Please Enter Valid National Code \n" +
                        "NOTE: NationalCode Must Be Number 10 Character Without Letters You Enter: \n" +
                        "" + resScanner + " And " + resScanner.length() + " Character ");
            }
        }while (!resScanner.matches(constantValue.NATIONAL_CODE_REGEX));
        do {
            showSignInMessage("Birthday With This Format: yyyy-MM-dd");
            resScanner = scanner.next();
            if (resScanner.matches(constantValue.DATE_FORMATTER_REGEX)){
                LocalDate birthDay = LocalDate.parse(resScanner);
                newUser.setBirthday(birthDay);
            }else{
                System.out.println("Your Date Is Not Match Of Date Format");
            }
        } while (!resScanner.matches(constantValue.DATE_FORMATTER_REGEX));
        userRepository.save();
        System.out.println("Congratulations Your Register Account Has Successful Please LohIn In Your Account ");
    }

    public static void showSignInMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
