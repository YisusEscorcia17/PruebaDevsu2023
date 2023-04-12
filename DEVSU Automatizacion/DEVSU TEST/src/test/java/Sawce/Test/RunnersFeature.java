package Sawce.Test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features" }, glue = { "Sawce.Definitions" }
       // ,tags = "@tag5"  //Quitar comentario si se sdesea ejecutar unicamente un caso en especifico
         )

public class RunnersFeature {

}
