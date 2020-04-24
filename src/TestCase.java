package src;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestCase {

    //variable driver
    WebDriver driver = null;
    WebDriverWait wait = null;
    int random;


    @Before
    public void before() {

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

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
    public void Registro() throws InterruptedException {

        // region REGISTRO

        //abrir demoblaze
        driver.get("https://www.demoblaze.com/#");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a sign up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signin2\"]")));
        driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();

        //escribir username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/input")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/form/div[1]/input")).sendKeys("yessica1");

        //escribir contraseña
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sign-password\"]")));
        driver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("12345");

        //click en sign up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();

        //endregion

        //ALERT
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
    @Test
    public void Login() throws InterruptedException {

        //region LOGIN

        //abrir demoblaze
        driver.get("https://www.demoblaze.com/#");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login2\"]")));
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();

        //escribir username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginusername\"]")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("yessica");

        //escribir contraseña
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginpassword\"]")));
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("12345");

        //click en login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
        String validarlogin = driver.findElement(By.xpath("//*[@id=\"nameofuser\"]")).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Welcome yessica");

        //endregion

        //region LOGOUT

        //click en logout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logout2\"]")));
        driver.findElement(By.xpath("//*[@id=\"logout2\"]")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signin2\"]")));
        String validarlogout = driver.findElement(By.xpath("//*[@id=\"signin2\"]")).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogout, "Sign up");

        //endregion

    }

    @Test
    public void BuscarMonitor() throws InterruptedException {

        //region LOGIN

        //abrir demoblaze
        driver.get("https://www.demoblaze.com/#");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login2\"]")));
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();

        //escribir username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginusername\"]")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("yessica");

        //escribir contraseña
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginpassword\"]")));
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("12345");

        //click en login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
        String validarlogin = driver.findElement(By.xpath("//*[@id=\"nameofuser\"]")).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Welcome yessica");

        //endregion

        //region COMPRA MONITOR

        //click en monitors
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[1]/div/a[4]")));
        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[4]")).click();

        //click en Apple monitor 24
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click();

        //sacar texto de la app (add to card)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        String Addtocart = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).getText();

        //validar que sea igual (add to card)
        Assert.assertEquals(Addtocart, "Add to cart");

        //endregion

    }

    @Test
    public void Compra() throws InterruptedException {

        //region LOGIN

        //abrir demoblaze
        driver.get("https://www.demoblaze.com/#");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login2\"]")));
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();

        //escribir username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginusername\"]")));
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("yessica");

        //escribir contraseña
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginpassword\"]")));
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("12345");

        //click en login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
        String validarlogin = driver.findElement(By.xpath("//*[@id=\"nameofuser\"]")).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Welcome yessica");

        //endregion

        // region COMPRA DE TELEFONO

        //click en Phones
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"itemc\"]")));
        driver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();

        //click en Nexus 6
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/h2")));
        String nombredeltelefono = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")).getText();

        //click a Add to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")));
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();

        //ALERT
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //click a home
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")));
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();

        //endregion


        //region VALIDAR CARRITO DE COMPRA

        //click a Cart
        driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();

        //sacar texto de la app (nombre del telefono)
        String validarnombretelefono = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]")).getText();
        Thread.sleep(3500);

        //validar que sea igual
        Assert.assertEquals(validarnombretelefono, nombredeltelefono);
        Thread.sleep(3500);

        //endregion

        // region COMPRA

        //click a Place order
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")));
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();

        //escribir name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"name\"]")));
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Yessica Cuberos");

        //escribir country
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"country\"]")));
        driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("Argentina");

        //escribir city
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"city\"]")));
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Buenos Aires");

        //escribir credit card
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"card\"]")));
        driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("1234567890");

        //escribir Month
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"month\"]")));
        driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("09");

        //escribir year
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"year\"]")));
        driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2021");

        //click a purchase
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/h2")));
        String transaccionexitosa = driver.findElement(By.xpath("/html/body/div[10]/h2")).getText();

        //validar que sea igual
        Assert.assertEquals(transaccionexitosa, "Thank you for your purchase!");

        //click a ok
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div[7]/div/button")));
        driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();

        //endregion

    }

    @Test
    public void RegistroDbank() throws InterruptedException {

        driver.get("http://dbankdemo.com/login");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a Sing up here
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[4]/p/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[4]/p/a")).click();

        //seleccionar a Mr, Ms o Mrs
        Select dropdown = new Select(driver.findElement(By.id("title")));
        dropdown.selectByVisibleText("Ms.");

        //escribir Firt name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("YESSICA");

        //escribir Last name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lastName\"]")));
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("CUBEROS");

        //click a Gender
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[5]/label[2]/input")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/div[5]/label[2]/input")).click();

        //escribir date of birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dob\"]")));
        driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("01/09/1993");

        //escribir social security number
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ssn\"]")));
        driver.findElement(By.xpath("//*[@id=\"ssn\"]")).sendKeys("099-56-" + random);

        //escribir e-mail address
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"emailAddress\"]")));
        driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("ycuberos" + random + "@gmail.com");

        //escribir password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ycuberos93.");

        //escribir password confirm
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"confirmPassword\"]")));
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("Ycuberos93.");

        //click a next
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")).click();

        //escribir address
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"address\"]")));
        driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Charcas 5647");

        //escribir locality
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"locality\"]")));
        driver.findElement(By.xpath("//*[@id=\"locality\"]")).sendKeys("Palermo");

        //escribir region
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"region\"]")));
        driver.findElement(By.xpath("//*[@id=\"region\"]")).sendKeys("CABA");

        //escribir postal code
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"postalCode\"]")));
        driver.findElement(By.xpath("//*[@id=\"postalCode\"]")).sendKeys("1010");

        //escribir postal country
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"country\"]")));
        driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("Argentina");

        //escribir home phone
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"homePhone\"]")));
        driver.findElement(By.xpath("//*[@id=\"homePhone\"]")).sendKeys("(547) 392-5647");

        //escribir mobile phone
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mobilePhone\"]")));
        driver.findElement(By.xpath("//*[@id=\"mobilePhone\"]")).sendKeys("(547) 392-5999");

        //escribir work phone
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"workPhone\"]")));
        driver.findElement(By.xpath("//*[@id=\"workPhone\"]")).sendKeys("(547) 392-5677");

        //click a agree the terms and policy
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"agree-terms\"]")));
        driver.findElement(By.xpath("//*[@id=\"agree-terms\"]")).click();

        //click a register
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/form/button")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/span[2]")));
        String validarlogin = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/span[2]")).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Registration Successful. Please Login.");
    }

    @After
    public void after() {

        //cerrar navegador
        driver.close();
    }

}

