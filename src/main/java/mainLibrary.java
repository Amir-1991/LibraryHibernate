import config.constantValue;

import java.util.Scanner;

public class mainLibrary {
    public static void main(String[] args) {
        System.out.println("Welcome To Biggest Article Library In The World :D \n" +
                "1: SignUp \n" +
                "2: SignIn \n" +
                "3: Exit ");
        Scanner scanner = new Scanner(System.in);
        String firstOperation = scanner.next();
        while (firstOperation.matches(constantValue.menuRegex)) {
            switch (firstOperation) {
                case "1":

            }
        }
    }
}
