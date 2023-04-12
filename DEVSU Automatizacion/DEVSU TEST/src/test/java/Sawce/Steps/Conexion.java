package Sawce.Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conexion {

	private WebDriver driver;

	public Conexion() {

	}

	@Before
	@Step
	public WebDriver abrirNavegador()  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this.driver;

	}
	

}
