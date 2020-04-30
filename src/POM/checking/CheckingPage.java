package src.POM.checking;

import org.openqa.selenium.By;

public class CheckingPage {

    public By checkboxStandardChecking(){
        return By.id("Standard Checking");
    }

    public By checkboxSelectAccountOwnership(){
        return By.id("Individual");
    }

    public By inputAccountName() {
        return By.id("name");
    }

    public By inputInitialDepositAmount() {
        return By.id("openingBalance");
    }

    public By buttonSubmit(){
        return By.xpath("//*[@id=\"right-panel\"]/div[2]/div/div/div/div/form/div[2]/button[1]");
    }

    public By checkingTextValidation(){
        return By.xpath("//*[@id=\"firstRow\"]/div/div/form/div/div[1]");
    }

    public By checkingAmountValidation(){
        return By.xpath("//*[@id=\"firstRow\"]/div/div/form/div/div[7]");
    }

}
