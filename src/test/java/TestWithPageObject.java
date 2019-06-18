import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions; -> Ya lo heredan las clases de cada página de la BasePage
//import org.openqa.selenium.support.ui.WebDriverWait; -> Ya lo heredan las clases de cada página de la BasePage
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.EmployeePage;
import pageObjects.HomePage;

public class TestWithPageObject {
    private WebDriver driver;
    private HomePage homePage;
    private EmployeePage employeePage;
    //private WebDriverWait wait; ->Se va, ya lo heredan las clases de cada página de la BasePage

    @BeforeMethod
    public void setupTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://verstandqa.com/login-employee-v2/");
        //wait = new WebDriverWait(driver, 10); ->Se va, ya lo heredan las clases de cada página de la BasePage
        homePage = new HomePage(driver);
    }

    @Test
    public void testLogin(){
        employeePage = homePage.login("admin", "admin123");
        //wait.until(ExpectedConditions.titleIs("Add Employee v2 – Verstand QA")); ->Se va, ya lo sentenciamos las clase de la página

        /*Assert.assertTrue(employeePage.textoPaginaIsDisplayed() &&
                employeePage.textoPaginaContainsText("Add Employee"));*/
        //->A partir de las modificaciones de la PáginaEmployee cambiamos, modificamos y mejoramos los assert
        Assert.assertTrue(employeePage.textoPaginaIsDisplayed());
        Assert.assertTrue(employeePage.textoPaginaContainsText("Add Employee"));
        driver.quit();
    }

    @Test
    public void addEmployer () {
        employeePage = homePage.login("admin", "admin123");
        employeePage.addEmployee("Simon", "Rivera 123", "Montevideo", "Montevideo",
                "123456", "s.s@gmail.com", "1324312");
        Assert.assertTrue(employeePage.messageSuccesIsDisplayed());
        Assert.assertTrue(employeePage.messageSuccesTextRight());
    }

    @Test
    public void testLoginIncorrecto(){
        homePage.incorrectLogin("administrador", "admin1234");
        Assert.assertTrue(homePage.messageErrorIsDisplayed());
    }

    public void tearDown(){
        driver.quit();
        }
    }