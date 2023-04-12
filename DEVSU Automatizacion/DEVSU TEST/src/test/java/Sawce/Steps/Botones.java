package Sawce.Steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Botones {

    private WebDriver driver;


    public Botones(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //////////// LOGIN
    @FindBy(how = How.ID, using = "user-name")
    private WebElement User;
    @FindBy(how = How.ID, using = "password")
    private WebElement pass;
    @FindBy(how = How.ID, using = "login-button")
    private WebElement LoginButton;

    @FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
    private WebElement ShoppinCart;

    ////////////////RESET APP STATUS
    @FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']")
    private WebElement OpenMenu;

    @FindBy(how = How.XPATH, using = "//a[@id='reset_sidebar_link']")
    private WebElement reset;

    @FindBy(how = How.XPATH, using = "//button[@id='react-burger-cross-btn']")
    private WebElement CloseMenu;

    @Step //ingreso de credenciales al portal
    public void DiligenciarCredenciales() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(User));
        User.clear();
        User.sendKeys(Utility.locatorValues("userName"));
        wait.until(ExpectedConditions.elementToBeClickable(pass));
        pass.clear();
        pass.sendKeys(Utility.locatorValues("Password"));
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
    }


    @Step
    public void EjecutarLogin() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
        LoginButton.click();
    }

    @Step // resetear estado de app
    public void ResetStatusApp ( ) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(OpenMenu));
        OpenMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(reset));
        reset.click();
        wait.until(ExpectedConditions.elementToBeClickable(CloseMenu));
        CloseMenu.click();
    }

}
