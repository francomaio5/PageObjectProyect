package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
// import org.openqa.selenium.support.PageFactory; -> Se va, lo instanciamos en la BasePage de la que se hereda

public class EmployeePage extends BasePage {
//    private WebDriver driver; -> Se va, lo instanciamos en la BasePage de la que se hereda

    @FindBy(how = How.TAG_NAME, using = "h4")
    //WebElement textoPagina; -> En si no influye en nada ponerle o no el private, pero influye en que
    //lo tenemos más estructurado
    private WebElement textoPagina;

    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.ID, using = "address")
    private WebElement address;

    @FindBy(how = How.CSS, using = "[placeholder=\"City\"]")
    private WebElement city;

    @FindBy(how = How.ID, using = "state")
    private WebElement state;

    @FindBy(how = How.ID, using = "postcode")
    private WebElement postcode;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "phoneNumber")
    private WebElement phone;

    WebElement addButton;

    @FindBy(how = How.ID, using = "success-alert")
    private WebElement success;



   public EmployeePage(WebDriver driver){
   //     this.driver = driver; -> Se va, lo instanciamos en la BasePage de la que se hereda
    //    PageFactory.initElements(driver, this); -> Se va, lo instanciamos en la BasePage de la que se hereda
       super(driver); //->Aca lo estamos heredando desde la super clase o la clase padre para asi usarlo
    }


    public boolean textoPaginaIsDisplayed(){
        return textoPagina.isDisplayed();
    }

    public boolean textoPaginaContainsText(String text){
        return textoPagina.getText().contains(text);
    }

    public void addEmployee (String name, String address, String city, String state,
                             String postal, String email, String phone) {
        this.name.sendKeys(name);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.postcode.sendKeys(postal);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        addButton.click();
    }

    public boolean  messageSuccesIsDisplayed () {
       return success.isDisplayed();
    }

    public boolean messageSuccesTextRight() {
       return success.getText().contains("Employee added successfully.");
    }

}