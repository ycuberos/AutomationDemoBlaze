package src.tests.dBank;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.POM.checking.CheckingPage;
import src.POM.home.HomePage;
import src.POM.login.LoginPage;
import src.POM.registro.RegistroPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dbank {

    //variable driver
    WebDriver driver = null;
    WebDriverWait wait = null;
    int random;


    @Before
    public void before() {

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        //levantar navegador
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

        Random r = new Random();
        int low = 1000;
        int high = 9999;
        random = r.nextInt(high-low) + low;
    }

    @Test
    public void RegistroDbank() throws InterruptedException {

        //region PRIMERA PAGINA

        RegistroPage registroPage = new RegistroPage();
        LoginPage loginPage = new LoginPage();

        driver.get("http://dbankdemo.com/login");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a Sing up here
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.buttonSingUp()));
        driver.findElement(loginPage.buttonSingUp()).click();

        //seleccionar a Mr, Ms o Mrs
        Select dropdown = new Select(driver.findElement(registroPage.SelectorTitle()));
        dropdown.selectByVisibleText("Ms.");

        //escribir Firt name
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.InputFirstName()));
        driver.findElement(registroPage.InputFirstName()).sendKeys("YESSICA");

        //escribir Last name
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.ImputLastName()));
        driver.findElement(registroPage.ImputLastName()).sendKeys("CUBEROS");

        //click a Gender
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.CheckGender()));
        driver.findElement(registroPage.CheckGender()).click();

        //escribir date of birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.ImputDateOfBirth()));
        driver.findElement(registroPage.ImputDateOfBirth()).sendKeys("01/09/1993");

        //escribir social security number
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.ImputSocialSecurityNumber()));
        driver.findElement(registroPage.ImputSocialSecurityNumber()).sendKeys("099-56-" + random);

        //escribir e-mail address
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.ImputEmailAdress()));
        driver.findElement(registroPage.ImputEmailAdress()).sendKeys("ycuberos" + random + "@gmail.com");

        //escribir password
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.ImputPassword()));
        driver.findElement(registroPage.ImputPassword()).sendKeys("Ycuberos93.");

        //escribir password confirm
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.ImputPasswordConfirm()));
        driver.findElement(registroPage.ImputPasswordConfirm()).sendKeys("Ycuberos93.");

        //click a next
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.ButtomNext()));
        driver.findElement(registroPage.ButtomNext()).click();

        //endregion

        //region SEGUNDA PAGINA

        //escribir address
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputAdress()));
        driver.findElement(registroPage.imputAdress()).sendKeys("Charcas 5647");

        //escribir locality
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputLocation()));
        driver.findElement(registroPage.imputLocation()).sendKeys("Palermo");

        //escribir region
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputRegion()));
        driver.findElement(registroPage.imputRegion()).sendKeys("CABA");

        //escribir postal code
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputPostalCode()));
        driver.findElement(registroPage.imputPostalCode()).sendKeys("1010");

        //escribir postal country
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputCountry()));
        driver.findElement(registroPage.imputCountry()).sendKeys("Argentina");

        //escribir home phone
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputHomePhone()));
        driver.findElement(registroPage.imputHomePhone()).sendKeys("(547) 392-5647");

        //escribir mobile phone
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputMobilePhone()));
        driver.findElement(registroPage.imputMobilePhone()).sendKeys("(547) 392-5999");

        //escribir work phone
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.imputWorkPhone()));
        driver.findElement(registroPage.imputWorkPhone()).sendKeys("(547) 392-5677");

        //click a agree the terms and policy
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.checkAgreeTheTermsAndPolicy()));
        driver.findElement(registroPage.checkAgreeTheTermsAndPolicy()).click();

        //click a register
        wait.until(ExpectedConditions.visibilityOfElementLocated(registroPage.buttomRegister()));
        driver.findElement(registroPage.buttomRegister()).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.labelRegistrationSuccessful()));
        String validarlogin = driver.findElement(loginPage.labelRegistrationSuccessful()).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Registration Successful. Please Login.");

        //endregion
    }

    @Test
    public void LoginDbank() throws InterruptedException{

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        driver.get("http://dbankdemo.com/login");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //escribir usarname
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inputUsername()));
        driver.findElement(loginPage.inputUsername()).sendKeys("yessica@gmail.com");

        //escribir contraseña
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inputPassword()));
        driver.findElement(loginPage.inputPassword()).sendKeys("Yessica1.");

        //click a sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.buttonSingIn()));
        driver.findElement(loginPage.buttonSingIn()).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.homeTextValidation()));
        String validarlogin = driver.findElement(homePage.homeTextValidation()).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Welcome Yessica");
    }

    @Test
    public void NewChecking() throws InterruptedException{

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        CheckingPage checkingPage = new CheckingPage();

        driver.get("http://dbankdemo.com/login");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //escribir usarname
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inputUsername()));
        driver.findElement(loginPage.inputUsername()).sendKeys("yessica@gmail.com");

        //escribir contraseña
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inputPassword()));
        driver.findElement(loginPage.inputPassword()).sendKeys("Yessica1.");

        //click a sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.buttonSingIn()));
        driver.findElement(loginPage.buttonSingIn()).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.homeTextValidation()));
        String validarlogin = driver.findElement(homePage.homeTextValidation()).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Welcome Yessica");

        //click a checking
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.bottonchecking()));
        driver.findElement(homePage.bottonchecking()).click();

        //click a newchecking
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.bottonnewChecking()));
        driver.findElement(homePage.bottonnewChecking()).click();

        //seleccionar tipo de cuenta
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkingPage.checkboxStandardChecking()));
        driver.findElement(checkingPage.checkboxStandardChecking()).click();

        //seleccionar propiedad de la cuenta
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkingPage.checkboxSelectAccountOwnership()));
        driver.findElement(checkingPage.checkboxSelectAccountOwnership()).click();

        //escribir nombre de la cuenta
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkingPage.inputAccountName()));
        driver.findElement(checkingPage.inputAccountName()).sendKeys("Yessica CC");

        //escribir monto
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkingPage.inputInitialDepositAmount()));
        driver.findElement(checkingPage.inputInitialDepositAmount()).sendKeys("100");

        //click submit
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkingPage.buttonSubmit()));
        driver.findElement(checkingPage.buttonSubmit()).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkingPage.checkingTextValidation()));
        String validartexto = driver.findElement(checkingPage.checkingTextValidation()).getText();

        //validar que sea igual
        Assert.assertEquals(validartexto, "Yessica CC");

        //sacar importe de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkingPage.checkingAmountValidation()));
        String validarmonto = driver.findElement(checkingPage.checkingAmountValidation()).getText();

        //validar que sea igual
        Assert.assertEquals(validarmonto, "Balance: $100.00");

    }

    @After
    public void after() {

        //cerrar navegador
        driver.close();
    }
}
