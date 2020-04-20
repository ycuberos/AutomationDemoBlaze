package src;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestCase {


    @Before
    public void before() {

    }

    @Test
    public void Registro() throws InterruptedException {

        //variable driver
        WebDriver driver = null;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        //levantar navegador
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

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

        //ALERT
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //cerrar navegador
        driver.close();


    }

    @Test
    public void Login() throws InterruptedException {

        //variable driver
        WebDriver driver = null;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        //levantar navegador
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

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

        //click en logout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logout2\"]")));
        driver.findElement(By.xpath("//*[@id=\"logout2\"]")).click();

        //sacar texto de la app
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signin2\"]")));
        String validarlogout = driver.findElement(By.xpath("//*[@id=\"signin2\"]")).getText();

        //validar que sea igual
        Assert.assertEquals(validarlogout, "Sign up");

        //cerrar navegador
        driver.close();

    }

    @Test
    public void BuscarMonitor() throws InterruptedException {

        //variable driver
        WebDriver driver;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        //levantar navegador
        driver = new ChromeDriver();

        //maximizar el navegador
        driver.manage().window().maximize();

        //abrir demoblaze
        driver.get("https://www.demoblaze.com/#");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a login
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
        Thread.sleep(3500);

        //escribir username
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("yessica");
        Thread.sleep(3500);


        //escribir contraseña
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("12345");
        Thread.sleep(3500);

        //click en login
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(3500);

        //sacar texto de la app
        String validarlogin = driver.findElement(By.xpath("//*[@id=\"nameofuser\"]")).getText();
        Thread.sleep(3500);

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Welcome yessica");
        Thread.sleep(3500);

        //click en monitors
        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[4]")).click();
        Thread.sleep(3500);

        //click en Apple monitor 24
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click();
        Thread.sleep(3500);

        //sacar texto de la app (add to card)
        String Addtocart = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).getText();
        Thread.sleep(3500);

        //validar que sea igual (add to card)
        Assert.assertEquals(Addtocart, "Add to cart");
        Thread.sleep(3500);

        //cerrar navegador
        driver.close();


    }

    @Test
    public void PostearTwitter() throws InterruptedException {

        //variable driver
        WebDriver driver;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        //levantar navegador
        driver = new ChromeDriver();

        //maximizar el navegador
        driver.manage().window().maximize();

        //abrir Twitter
        driver.get("https://twitter.com/explore");
        Thread.sleep(3500);

        //click a Iniciar secion
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div[2]/div[1]/div/div[2]/div[1]/div[1]/a/div/span/span")).click();
        Thread.sleep(3500);

        //escribir Teléfono, correo o usuario
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[1]/label/div/div[2]/div/input")).sendKeys("ycuberos93@gmail.com");
        Thread.sleep(3500);

        //escribir contraseña
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[2]/label/div/div[2]/div/input")).sendKeys("yacr21284903");
        Thread.sleep(3500);

        //click a boton Iniciar sesión
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[3]/div/div/span/span")).click();
        Thread.sleep(3500);

        //click a Inicio
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div/div[2]/nav/a[1]")).click();
        Thread.sleep(3500);

        //escribir en Muro ¿Que estas pensando?
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")).sendKeys("Feliz viernes");
        Thread.sleep(3500);

        //click a Twittear
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/span/span")).click();
        Thread.sleep(3500);

        //click en Perfil
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div/div[2]/nav/a[7]")).click();
        Thread.sleep(3500);

        //sacar texto de la app (Feliz viernes)
        String Felizviernes = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/div[2]/section/div/div/div/div[1]/div/div/div/article/div/div[2]/div[2]/div[2]/div[1]/div/span")).getText();
        Thread.sleep(3500);

        //validar que sea igual (Feliz viernes)
        Assert.assertEquals(Felizviernes, "Feliz viernes");
        Thread.sleep(3500);

        //cerrar navegador
        driver.close();


    }

    @Test
    public void Compra() throws InterruptedException {

        //region LEVANTASR NAVEGADOR

        //variable driver
        WebDriver driver;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        //levantar navegador
        driver = new ChromeDriver();

        //maximizar el navegador
        driver.manage().window().maximize();

        //abrir demoblaze
        driver.get("https://www.demoblaze.com/#");
        Thread.sleep(3500);

        //endregion

        //region LOGIN

        //click a login
        driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
        Thread.sleep(3500);

        //escribir username
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("yessica");
        Thread.sleep(3500);

        //escribir contraseña
        driver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("12345");
        Thread.sleep(3500);

        //click en login
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(3500);


        //sacar texto de la app
        String validarlogin = driver.findElement(By.xpath("//*[@id=\"nameofuser\"]")).getText();
        Thread.sleep(3500);

        //validar que sea igual
        Assert.assertEquals(validarlogin, "Welcome yessica");
        Thread.sleep(3500);

        //endregion

        // region COMPRA DE TELEFONO

        //click en Phones
        driver.findElement(By.xpath("//*[@id=\"itemc\"]")).click();
        Thread.sleep(3500);

        //click en Nexus 6
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[3]/div/div/h4/a")).click();
        Thread.sleep(3500);

        //sacar texto de la app
        String nombredeltelefono = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")).getText();
        Thread.sleep(3500);

        //click a Add to cart
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();
        Thread.sleep(3500);

        //ALERT
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //click a home
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();
        Thread.sleep(3500);

        //endregion


        //region VALIDAR CARRITO DE COMPRA

        //click a Cart
        driver.findElement(By.xpath("//*[@id=\"cartur\"]")).click();
        Thread.sleep(3500);

        //sacar texto de la app (nombre del telefono)
        String validarnombretelefono = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[2]")).getText();
        Thread.sleep(3500);

        //validar que sea igual
        Assert.assertEquals(validarnombretelefono, nombredeltelefono);
        Thread.sleep(3500);

        //endregion

        // region COMPRA

        //click a Place order
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();
        Thread.sleep(3500);

        //escribir name
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Yessica Cuberos");
        Thread.sleep(3500);

        //escribir country
        driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("Argentina");
        Thread.sleep(3500);

        //escribir city
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Buenos Aires");
        Thread.sleep(3500);

        //escribir credit card
        driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("1234567890");
        Thread.sleep(3500);

        //escribir Month
        driver.findElement(By.xpath("//*[@id=\"month\"]")).sendKeys("09");
        Thread.sleep(3500);

        //escribir year
        driver.findElement(By.xpath("//*[@id=\"year\"]")).sendKeys("2021");
        Thread.sleep(3500);

        //click a purchase
        driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
        Thread.sleep(3500);

        //sacar texto de la app
        String transaccionexitosa = driver.findElement(By.xpath("/html/body/div[10]/h2")).getText();
        Thread.sleep(3500);

        //validar que sea igual
        Assert.assertEquals(transaccionexitosa, "Thank you for your purchase!");
        Thread.sleep(3500);

        //click a ok
        driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
        Thread.sleep(3500);

        //endregion


        //cerrar navegador
        driver.close();


    }
}
