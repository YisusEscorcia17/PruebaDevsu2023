package Sawce.Steps;


import Sawce.Paginas.Home;
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


public class Questions {

	private WebDriver driver;
	private Botones botones;
	private Home home;

	public Questions(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botones = new Botones(driver);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='header_container']/div[2]/div[2]/span/select")
	private WebElement OrdenamientoProductos;
	@FindBy(how = How.XPATH, using = "//div[@id='shopping_cart_container']/a")
	private WebElement carrito;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Sauce Labs Backpack']")
	private WebElement LabelBackpack;
	@FindBy(how = How.XPATH, using = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
	private WebElement LabelJacket;


	////////////////Formulario
	@FindBy(how = How.ID, using = "first-name")
	private WebElement FirstName;
	@FindBy(how = How.ID, using = "last-name")
	private WebElement LastName;
	@FindBy(how = How.ID, using = "postal-code")
	private WebElement pcode;
	@FindBy(how = How.ID, using = "continue")
	private WebElement Continue;

	@FindBy(how = How.XPATH, using = "//div[@id='checkout_complete_container']//h2")
	private WebElement checkout_complete;



	@Step //assert para validar login
	public void AssertLogin(WebDriver driver) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		try {
			ExpectedConditions.visibilityOf(OrdenamientoProductos);
			System.out.println("Se logueo correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// se imprime el error arrojado
			System.out.println("NO se logueo correctamente");
		}
	}


	@Step  // se Valida que se añaden dos productos al carrito
	public void AssertCantidadDeproductos() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(carrito));
		String cantidad = carrito.getText();
		System.out.println(cantidad);
		try {
			if (cantidad.equals("2"))
				System.out.println("la cantidad de productos es crreccta");
			else
				System.out.println("la cantidad de productos NO es crreccta");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// se imprime el error arrojado
		}
	}

	public void AssertCheckOut() throws IOException {
		String backpac = LabelBackpack.getText();
		String Jacket = LabelJacket.getText();
		System.out.println(backpac);
		System.out.println(Jacket);

		try {
			if (backpac.equals("Sauce Labs Backpack"))
				if (Jacket.equals("Sauce Labs Fleece Jacket"))
					System.out.println("El resumen de checkout concuerda con los productos agregados ");
				else
					System.out.println("EL check out es incorrecto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// se imprime el error arrojado

		}
	}

	public void AssertForm() throws IOException {
		String box1 = FirstName.getAttribute("value");
		String box2 = LastName.getAttribute("value");
		String box3 = pcode.getAttribute("value");
		try {
		if (!box1.isEmpty())  {
			System.out.println("campo diligenciado");
			System.out.println(box1);
			System.out.println(box2);
			System.out.println(box3);

		} else {
			System.out.println("campo NO diligenciado");
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// se imprime el error arrojado

		}

	}

	public void Assertorder() throws IOException {
		String Thanks = checkout_complete.getText();
		System.out.println(Thanks);


			if (Thanks.equals("Thank you for your order!"))
				System.out.println("la orden se generó con exito");
			else
				System.out.println("No se pudo finalizar el proceso de compra ");


	}

}






