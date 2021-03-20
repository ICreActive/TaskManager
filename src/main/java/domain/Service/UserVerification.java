package domain.Service;

import domain.Model.Users.User;

import java.util.List;

public class UserVerification {

    public static void UserAddWithVerify(List<User> users, User user) {
        boolean userArePresent = users.stream()
                .anyMatch(userInDB -> userInDB.getEmail().equals(user.getEmail()));
        if (!userArePresent) {
            users.add(user);
        }
        else System.out.println("User with email " +user.getEmail() + " are present in DB");

    }

}


