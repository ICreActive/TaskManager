package domain.Service;

import domain.Model.Users.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class UserVerificationTest extends Assert {


    @Test
    public void UserAddWithVerifyTest() {
        List<User> users = new LinkedList<>();
        User<Object> user = new User.Builder<>()
                .withName("Alex")
                .withSurname("Shkubel")
                .withEmail("negumadness@gmail.com")
                .withUserID(12234)
                .build();
        users.add(user);

        boolean userArePresent = users.stream()
                .anyMatch(userInDB -> userInDB.getEmail().equals(user.getEmail()));
        if (!userArePresent) {
            users.add(user);
        } else System.out.println("User with email " + user.getEmail() + " are present in DB");

        assertTrue(userArePresent);

    }

}
