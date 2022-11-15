package starter.api;

import com.github.javafaker.Faker;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ReqresIn {

    @Steps
    ReqresApiActions reqresApi;

    @Test
    public void firstTest() {
        reqresApi.whenGetUsersPage(2);
        reqresApi.thenIGetAResult();
    }

    @Test
    public void secondTest() {
        Faker faker = new Faker();
        UsersModel user = new UsersModel();

        user.setName(faker.name().fullName());
        user.setJob(faker.job().position());

        reqresApi.whenCreateUser(user, user.getName(), user.getJob());
        reqresApi.userIsCreated(user.getName(), user.getJob());
    }
}
