package Sawce.Definitions;
import Sawce.Paginas.CheckOut;
import Sawce.Paginas.Home;
import Sawce.Paginas.LogIn;
import Sawce.Steps.Questions;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import Sawce.Steps.Conexion;

import java.io.IOException;


public class DefinitionsSteps {


	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private Questions questions;
	private LogIn logIn;
	private Home home;
	private CheckOut checkOut;



	@Given("^usuario abre el navegador$")
	public void usuario_abre_el_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();
	}
	@When("^Usuario Diligencia credenciasles$")
	public void Usuario_diligencia_credenciasles() throws IOException {
		this.logIn = new LogIn(driver);
		this.logIn.Credenciales();
	}

	@And("^usuario inicia sesion")
	public void usuario_iniciar_sesion() throws IOException {
		this.logIn = new LogIn(driver);
		this.logIn.IniciarSesion();
	}
	@Then("^validar inicio de sesion correcto$")
	public void validar_inicio_de_sesion_correcto() throws IOException {
		this.logIn = new LogIn(driver);
		logIn.ValidarLogin();
	}

	@When("^Usuario resetea estado de la aplicacion$")
	public void usuario_resetea_estado_de_la_aplicacion() throws IOException {
		this.home = new Home(driver);
		this.home.ResetCar();
	}
	@When("^usuario agrega productos  producto al carrito$")
	public void usuario_agrega_productos_producto_al_carrito() throws InterruptedException {
		this.home = new Home(driver);
		this.home.Agregarjacket();
		this.home.Agregarbackpack();
	}
	@Then("validar cantidad de productos agregados")
	public void validarCantidadDeProductosAgregados() throws InterruptedException, IOException {
		this.home = new Home(driver);
		this.home.ValidarNumeroproductos();
	}

	@Then("validar Productos agregados en el carrito")
	public void validarProductosAgregadosEnElCarrito() throws InterruptedException, IOException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.ValidaCheckout();
	}

	@And("usuario diligencia formulario de checkout")
	public void usuarioDiligenciaFormularioDeCheckout() throws InterruptedException, IOException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.DiligenciarFormulario();
	}

	@Then("validar formulario diligenciado")
	public void validarFormularioDiligenciado() throws IOException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.ValidaForm();
	}

	@And("usuario finaliza compra")
	public void usuarioFinalizaCompra() throws InterruptedException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.FinishShopping();
	}

	@Then("Validar proceso de compras finalizado")
	public void validarProcesoDeComprasFinalizado() throws IOException, InterruptedException {
		this.checkOut = new CheckOut(driver);
		this.checkOut.validorder();
	}


}




