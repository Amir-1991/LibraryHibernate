package userManager;

import entity.userEntity;

import java.util.List;

public class userDashboard {
    public static void mainDashboard(List<userEntity> resUser) {
        System.out.println(resUser.get(0).getUserName());
        System.out.println(resUser.get(0).getFirstName());
        System.out.println(resUser.get(0).getLastName());
        System.out.println(resUser.get(0).getNationalCode());
    }
}
