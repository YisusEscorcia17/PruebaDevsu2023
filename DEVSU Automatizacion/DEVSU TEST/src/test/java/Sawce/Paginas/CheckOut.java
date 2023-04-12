package Sawce.Paginas;


import Sawce.Steps.Botones;
import Sawce.Steps.Questions;
import Sawce.Steps.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class CheckOut {

    private WebDriver driver;
    private Botones botones;
    private Questions questions;

     public CheckOut(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.botones= new Botones(driver);
        this.questions= new Questions(driver);
    }

    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
    private WebElement carrito;

    ///////////Elementos formulario
    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
    private WebElement shopping_cart;
    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkout;
    @FindBy(how = How.ID, using = "first-name")
    private WebElement FirstName;
    @FindBy(how = How.ID, using = "last-name")
    private WebElement LastName;
    @FindBy(how = How.ID, using = "postal-code")
    private WebElement pcode;
    @FindBy(how = How.ID, using = "continue")
    private WebElement Continue;
    @FindBy(how = How.ID, using = "finish")
    private WebElement finish;


    public void ValidaCheckout () throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(carrito));
        carrito.click();
        this.questions.AssertCheckOut();
    }

    public void DiligenciarFormulario () throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(shopping_cart));
        shopping_cart.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout));
        checkout.click();
        wait.until(ExpectedConditions.elementToBeClickable(FirstName));
        FirstName.clear();
        FirstName.sendKeys(Utility.locatorValues("Nombre"));
        wait.until(ExpectedConditions.elementToBeClickable(LastName));
        LastName.clear();
        LastName.sendKeys(Utility.locatorValues("Apellido"));
        wait.until(ExpectedConditions.elementToBeClickable(pcode));
        pcode.clear();
        pcode.sendKeys(Utility.locatorValues("PostalCodeP"));

        String box1 = FirstName.getAttribute("value");
        String box2 = LastName.getAttribute("value");
        String box3 = pcode.getAttribute("value");
    }

    public void ValidaForm() throws  IOException {
        this.questions.AssertForm();
    }


    public void FinishShopping ()  {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(Continue));
        Continue.click();
        wait.until(ExpectedConditions.elementToBeClickable(finish));
        finish.click();
    }

    public void validorder () throws IOException {
        this.questions.Assertorder();

    }


}
