package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    //Creamos e instanciamos un nuevo WebDriver que servira de base para la herencia que van a
    //realizar con las otras clases a fin de ahorrar codigo y hacerlo "mas estructurado y prolijo"

    protected WebDriverWait wait;
    //Al igual que con el WebDriver, creamos e instanciamos un Wait para que este sea base y la referencia
    //para las demas clases

    public BasePage(WebDriver driver){

        this.driver = driver;
        //Inicializamos el WebDriber

        wait = new WebDriverWait(driver, 10);
        //Inicializamos y creamos el Wait

        PageFactory.initElements(driver, this);
        //Creamos e inicializamos el PageFactory
    }



}