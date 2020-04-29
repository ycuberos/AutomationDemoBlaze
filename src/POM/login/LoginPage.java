package src.POM.login;

import org.openqa.selenium.By;

public class LoginPage {

    public By buttonSingUp(){
        return By.xpath("/html/body/div[1]/div/div/div[2]/form/div[4]/p/a");
    }

    public By inputUsername(){
        return By.id("username");
    }

    public By inputPassword(){
        return By.id("password");
    }

    public By buttonSingIn(){
        return By.id("submit");
    }

    public By labelRegistrationSuccessful(){
        return By.xpath("/html/body/div[1]/div/div/div[2]/div/span[2]");
    }
}
