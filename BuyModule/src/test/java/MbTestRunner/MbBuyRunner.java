package MbTestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\URPATIDA\\eclipse\\BuyModule\\src\\test\\resource\\MbFeatures",
glue="MbStepDefinition"
//,tags="@GetPhoneNoWithValidDetails"

,plugin= {("pretty")
,"html:target/HTMLReports/SwagReport.html"
,"json:target/JSONReports/SwagReport.json"
,"junit:target/JUNITReports/SwagReport.xml",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)


public class MbBuyRunner extends AbstractTestNGCucumberTests
{

} 
 