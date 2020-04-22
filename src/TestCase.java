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

        // region LEVANTAR LAVEGARDOR
        //variable driver
        WebDriver driver = null;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //levantar navegador
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

        //endregion

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

        //cerrar navegador
        driver.close();


    }

    @Test
    public void Login() throws InterruptedException {

        //region LEVANTAR EL NAVEGADOR

        //variable driver
        WebDriver driver = null;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //levantar navegador
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

        //endregion

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

        //cerrar navegador
        driver.close();

    }

    @Test
    public void BuscarMonitor() throws InterruptedException {

       //region LEVANTAR NEVEGADOR

        //variable driver
        WebDriver driver;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //levantar navegador
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

        //endregion

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

        //cerrar navegador
        driver.close();


    }

    @Test
    public void EscribirTwitter() throws InterruptedException {

        //region LEVANTAR NAVEGADOR

        //variable driver
        WebDriver driver;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //levantar navegador
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

        //endregion

        //region LOGEARSE EN TWITTER

        //abrir Twitter
        driver.get("https://twitter.com/explore");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        //click a Iniciar secion
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div[2]/div[1]/div/div[2]/div[1]/div[1]/a/div/span/span")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div[2]/div[1]/div/div[2]/div[1]/div[1]/a/div/span/span")).click();

        //escribir Teléfono, correo o usuario
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[1]/label/div/div[2]/div/input")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[1]/label/div/div[2]/div/input")).sendKeys("ycuberos93@gmail.com");

        //escribir contraseña
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[2]/label/div/div[2]/div/input")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[2]/label/div/div[2]/div/input")).sendKeys("yacr21284903");

        //click a boton Iniciar sesión
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[3]/div/div/span/span")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[3]/div/div/span/span")).click();

        //endregion

        //region POSTEAR

        //click a Inicio
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[1]/div")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div[1]/div[2]/nav/a[1]/div")).click();

        //escribir en Muro ¿Que estas pensando?
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")).sendKeys("¡Feliz inicio de semana!");

        //click a Twittear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/span/span")));
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/span/span")).click();

        //click en Perfil
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div/div[2]/nav/a[7]")));
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/header/div/div/div/div/div[2]/nav/a[7]")).click();

        //sacar texto de la app (Feliz viernes)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/div[2]/section/div/div/div/div[1]/div/div/div/article/div/div[2]/div[2]/div[2]/div[1]/div/span")));
        String Feliziniciodesemana = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div/div[2]/section/div/div/div/div[1]/div/div/div/article/div/div[2]/div[2]/div[2]/div[1]/div/span")).getText();

        //validar que sea igual (Feliz viernes)
        Assert.assertEquals(Feliziniciodesemana, "¡Feliz inicio de semana!");

        //endregion

        //cerrar navegador
        driver.close();


    }

    @Test
    public void Compra() throws InterruptedException {

        //region LEVANTASR NAVEGADOR

        //variable driver
        WebDriver driver;

        //decirle donde esta el chromedriver
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //levantar navegador
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 60);

        //maximizar el navegador
        driver.manage().window().maximize();

        //abrir demoblaze
        driver.get("https://www.demoblaze.com/#");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


        //endregion

        //region LOGIN

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\"//*[@id=\\\"tbodyid\\\"]/h2\"")));
        String nombredeltelefono = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/h2")).getText();

        //click a Add to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")));
        driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")).click();

        //ALERT
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


        //cerrar navegador
        driver.close();


    }

}

