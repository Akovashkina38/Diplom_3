package user;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerate {
    public static User getRandomUser() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = name.toLowerCase() + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(8);

        Allure.addAttachment("Name : ", name);
        Allure.addAttachment("Email : ", email);
        Allure.addAttachment("Password : ", password);

        return new User(name, email, password);
    }
}
