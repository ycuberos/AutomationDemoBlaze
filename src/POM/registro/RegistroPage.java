package src.POM.registro;

import org.openqa.selenium.By;

public class RegistroPage {

    //region REGISTRO PARTE 1


    public By SelectorTitle() {
        return By.id("title");
    }

    public By InputFirstName(){
        return By.xpath("//*[@id=\"firstName\"]");
    }

    public By ImputLastName(){
        return By.xpath("//*[@id=\"lastName\"]");
    }

    public By CheckGender(){
        return By.xpath("/html/body/div[1]/div/div/div[2]/form/div[5]/label[2]/input");
    }

    public By ImputDateOfBirth(){
        return By.xpath("//*[@id=\"dob\"]");
    }

    public By ImputSocialSecurityNumber(){
        return By.xpath("//*[@id=\"ssn\"]");
    }

    public By ImputEmailAdress(){
        return By.xpath("//*[@id=\"emailAddress\"]");
    }

    public By ImputPassword(){
        return By.xpath("//*[@id=\"password\"]");
    }

    public By ImputPasswordConfirm(){
        return By.xpath("//*[@id=\"confirmPassword\"]");
    }

    public By ButtomNext(){
        return By.xpath("/html/body/div[1]/div/div/div[2]/form/button");
    }

    //endregion

    //region REGISTRO PARTE 2

    public By imputAdress(){
        return By.xpath("//*[@id=\"address\"]");
    }

    public By imputLocation(){
        return By.xpath("//*[@id=\"locality\"]");
    }

    public By imputRegion(){
        return By.xpath("//*[@id=\"region\"]");
    }

    public By imputPostalCode(){
        return By.xpath("//*[@id=\"postalCode\"]");
    }

    public By imputCountry(){
        return By.xpath("//*[@id=\"country\"]");
    }

    public By imputHomePhone(){
        return By.xpath("//*[@id=\"homePhone\"]");
    }

    public By imputMobilePhone(){
        return By.xpath("//*[@id=\"mobilePhone\"]");
    }

    public By imputWorkPhone(){
        return By.xpath("//*[@id=\"workPhone\"]");
    }

    public By checkAgreeTheTermsAndPolicy(){
        return By.xpath("//*[@id=\"agree-terms\"]");
    }

    public By buttomRegister(){
        return By.xpath("/html/body/div[1]/div/div/div[2]/form/button");
    }

    //endregion

}
