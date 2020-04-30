package src.POM.home;

import org.openqa.selenium.By;

public class HomePage {

    public By homeTextValidation(){
        return By.xpath("//*[@id='right-panel']/div[1]/div[2]/div/div/ol/li");
    }

    public By bottonchecking(){
        return By.xpath("//*[@id='main-menu']/ul/li[2]/a");
    }

    public  By bottonnewChecking(){
        return By.xpath("//*[@id='main-menu']/ul/li[2]/ul/li[2]/a");
    }


}
