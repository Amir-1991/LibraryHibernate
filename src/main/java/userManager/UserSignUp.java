package userManager;

import config.ConstantValue;
import entity.UserEntity;
import repository.RollRepository;
import repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserSignUp {
    public static void creatUser() {
        Scanner scanner = new Scanner(System.in);
        UserEntity newUser = new UserEntity();
        List<String> rollEntityList = RollRepository.loadRoll();
        String resScanner;
        do {
            System.out.println("You Are: \n");
            for (int rolls = 0; rolls < rollEntityList.size(); rolls++) {
                System.out.println((rolls+1)+": "+rollEntityList.get(rolls));
            }
            resScanner = scanner.next();
            if (resScanner.equals("1")) {
                newUser.setRollTitle(rollEntityList.get(0));
            } else if (resScanner.equals("2")) {
                newUser.setRollTitle(rollEntityList.get(1));
            } else System.out.println("Your Input Value Not Valid");
        } while (!resScanner.matches(ConstantValue.MENU_REGEX));
        showSignUpMessage("User Name");
        newUser.setUserName(scanner.next());
        do {
            showSignUpMessage("First Name");
            resScanner = scanner.next();
            newUser.setFirstName(resScanner);
        } while (!resScanner.matches(ConstantValue.NAME_REGEX));
        do {
            showSignUpMessage("Last Name");
            resScanner = scanner.next();
            newUser.setLastName(resScanner);
        } while (!resScanner.matches(ConstantValue.NAME_REGEX));
        do {
            showSignUpMessage("National Code");
            resScanner = scanner.next();
            if (resScanner.matches(ConstantValue.NATIONAL_CODE_REGEX)) {
                newUser.setNationalCode(resScanner);
                newUser.setPassword(resScanner);
            } else {
                System.out.println("Please Enter Valid National Code \n" +
                        "NOTE: NationalCode Must Be Number 10 Character Without Letters You Enter: \n" +
                        "" + resScanner + " And " + resScanner.length() + " Character ");
            }
        } while (!resScanner.matches(ConstantValue.NATIONAL_CODE_REGEX));
        do {
            showSignUpMessage("Birthday With This Format: yyyy-MM-dd");
            resScanner = scanner.next();
            if (resScanner.matches(ConstantValue.DATE_FORMATTER_REGEX)) {
                LocalDate birthDay = LocalDate.parse(resScanner);
                newUser.setBirthday(birthDay);
            } else {
                System.out.println("Your Date Is Not Match Of Date Format");
            }
        } while (!resScanner.matches(ConstantValue.DATE_FORMATTER_REGEX));
        do {
            showSignUpMessage("Phone Number");
            resScanner = scanner.next();
            if (resScanner.matches(ConstantValue.PHONE_NUMBER_REGEX)) {
                newUser.setPhoneNumber(resScanner);
            } else {
                System.out.println("Valid Phone Number Is 11 Number Please TryAgain");
            }
        } while (!resScanner.matches(ConstantValue.PHONE_NUMBER_REGEX));
        UserRepository.save(newUser);
        System.out.println("Congratulations Your Register Account Has Successful Please LohIn In Your Account ");
    }

    public static void showSignUpMessage(String inputMsg) {
        System.out.println("Please Enter Your " + inputMsg);
    }
}
