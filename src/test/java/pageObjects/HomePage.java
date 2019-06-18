package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.PageFactory; -> Se va, lo instanciamos en la BasePage de la que se hereda

public class HomePage extends BasePage {

    //WebDriver driver; -> Se va, lo instanciamos en la BasePage de la que se hereda

    @FindBy(how = How.ID, using = "user")
    private WebElement inputUser;

    @FindBy(how = How.ID, using = "pass")
    private WebElement inputPassword;

    @FindBy(how = How.ID, using = "loginButton")
    private WebElement loginButton;

    @FindBy(how = How.NAME, using = "errorMessage")
    private WebElement messageError;

    public HomePage(WebDriver driver) {
        //this.driver = driver; -> Se va, lo instanciamos en la BasePage de la que se hereda
        //PageFactory.initElements(driver, this); -> Se va, lo instanciamos en la BasePage de la que se hereda
        //-> Para llamarlo desde la clase BasePage lo hacemos de la siguiente forma:
        super(driver);
         }

    public EmployeePage login(String usuario, String password) {
        inputUser.sendKeys(usuario);
        inputPassword.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.titleIs("Add Employee v2 – Verstand QA"));
        //->Como el wait lo creamos en la BasePage y lo heredamos, lo que podemos crear aqui ya para aprovechar y ahorrar codigo
        // en nustros casos de prueba es el conjunto del wait + el "until Expected condition" asi ya solo lo tendremos incluido
        //dentro del código de la página que corresponda con el fin de que ya se procese solo
        return new EmployeePage(driver);
    }

    public void incorrectLogin(String usuario, String password) {
        inputUser.sendKeys(usuario);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public boolean messageErrorIsDisplayed() {
        return messageError.isDisplayed();
    }
}