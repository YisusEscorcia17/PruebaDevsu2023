package Sawce.Paginas;



import Sawce.Steps.Botones;
import Sawce.Steps.Questions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Home {

    private WebDriver driver;
    private Botones botones;
    private Questions questions;

    static String NameItem1;
    static String Nameitem2;
    public Home(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones = new Botones(driver);
        this.questions = new Questions(driver);
    }


    /////// AGREGAR PRODUCTOS
    @FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement jacket;

    @FindBy(how = How.XPATH, using = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
    private WebElement Namejacket;



    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    private WebElement backpack;

    @FindBy(how = How.XPATH, using = "//div[normalize-space()='Sauce Labs Backpack']")
    private WebElement Namebackpack;



    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
    private WebElement carrito;



    @Step
    public void ResetCar() throws IOException {
        this.botones.ResetStatusApp();
    }


    @Step  // se añaden dos productos al carrito
    public String Agregarbackpack() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(backpack));
        backpack.click();
        NameItem1= Namebackpack.getText();
        System.out.println(NameItem1);
        return NameItem1;
    }



    @Step  // se añaden dos productos al carrito
    public String Agregarjacket()  {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(jacket));
        jacket.click();
        Nameitem2=Namejacket.getText();
        System.out.println(Nameitem2);
       return Nameitem2;
    }



    @Step  // se vali dos productos al carrito
    public void ValidarNumeroproductos() throws IOException {
        this.questions.AssertCantidadDeproductos();
    }

}
