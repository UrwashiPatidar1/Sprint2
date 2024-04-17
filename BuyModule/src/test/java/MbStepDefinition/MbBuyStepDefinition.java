package MbStepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import MbDriverSetup.BuyDriverSetup;
import MbPages.MbBuyPage;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class MbBuyStepDefinition 
{
    WebDriver driver;
	MbBuyPage mbp;
	WebDriverWait wait;

//---------------------------------------Shortlist Property---------------------------------------------------
	/*
	 * Created By: Urwashi Patidar
	 * Reviewed By:
	 * Motive: This is to check that property is added to shortlisted
	 */
	
	@Given("User is inside Ready to move shortcut")
	public void user_is_inside_ready_to_move_shortcut() 
	{
     	driver=BuyDriverSetup.chromedriver();
//		driver=BuyDriverSetup.edgedriver();
     	
		mbp=new MbBuyPage(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(mbp.getBuyHeading()));
		mbp.HoverOnBuyOption();

		wait.until(ExpectedConditions.elementToBeClickable(mbp.getReadyToMoveFeature()));
		mbp.ClickOnReadyToMoveFea();
		
        mbp.SwitchToReadyToMove();

	}

	@When("User click on heart present on property card")
	public void user_click_on_heart_present_on_property_card() throws InterruptedException
	{    
	
		wait.until(ExpectedConditions.elementToBeClickable(mbp.getHeartIcon()));
		mbp.ClickOnHeartIcon();
	 
	}

	@Then("Property is added to shortlisted property list")
	public void property_is_added_to_shortlisted_property_list() 
	{
		String message=mbp.FormAfterClickingHeart();
		Assert.assertEquals(message, "Login to view Shortlisted Properties later");
	  
	}
	
	
//-------------------------------------Sort Property High To Low---------------------------------------------------
	 /*
     * Created By: Urwashi Patidar
	 * Reviewed By:
	 * Motive: This is to check if properties are sorted in high to low order
	 */
		
	

     @When("User click on Sort By Price High to Low")
     public void user_click_on_sort_by_price_high_to_low() throws InterruptedException  
     {
     
     	Thread.sleep(2000);
     //	wait.until(ExpectedConditions.elementToBeClickable(mbp1.getSortByOptions()));
     	mbp.ClickOnSortByOption();
     
     	
     	wait.until(ExpectedConditions.elementToBeClickable(mbp.getSortFilter()));
     	mbp.ClickOnSortFilter();
     	
     }
     
     @Then("Properties are sorted By Price High to Low")
     public void properties_are_sorted_by_price_high_to_low() throws InterruptedException 
     {
     	
     //	wait.until(ExpectedConditions.elementToBeClickable(mbp1.getPriceOfProperties1()));
        Thread.sleep(2000);
        List price=mbp.GetPriceOfProperties();
        
        boolean compared=mbp.ComparePrices(price);
        Assert.assertTrue(compared, "All Prices are Sorted according to price from high to low.");
         
     }
     	

//---------------------------------------Get Contact Details(Valid Data)---------------------------------------------------
   	 /*
     * Created By: Urwashi Patidar
   	 * Reviewed By:
   	 * Motive: This is to check if user is able to get contact details with valid credentials
   	 */

     @When("User click on Get Phone no. button")
     public void user_click_on_get_phone_no_button() throws InterruptedException 
     {
        //    Thread.sleep(2000);
     	wait.until(ExpectedConditions.elementToBeClickable(mbp.getGetPhoneNoButton()));
        mbp.ScrollDown();
     	mbp.ClickOnGetPhoneNoButton();
     }
     
     @And("User click on Get Contact Details button")
     public void user_click_on_get_contact_details_button() throws InterruptedException 
     {
     	mbp.ClickOnContinueButton();
     }
     
     @And("^User Fill the details (.*), (.*), (.*)")
     public void user_fill_the_details(String userName, String email, String phoneNo) throws InterruptedException 
     {
     	mbp.SendDetails(userName, email, phoneNo);    
     }
     
     
     @When("User click on Get Contact Details button again")
     public void user_click_on_get_contact_details_button_again()
     {
     	mbp.ClickOnContinueButton();
     }
     
     @When("User Enter otp")
     public void user_enter_otp() throws InterruptedException 
     {
         mbp.ClickOnVerifyButton();
     }
     
     @Then("User is able to get the details via email")
     public void user_is_able_to_get_the_details_via_email() 
     {
         wait.until(ExpectedConditions.elementToBeClickable(mbp.getContactDetails()));
         Assert.assertTrue(mbp.GetcontactDetailsOrNot());
     }

//---------------------------------------Get Contact Details(Valid Data)---------------------------------------------------
   	 /*
     * Created By: Urwashi Patidar
   	 * Reviewed By:
   	 * Motive: This is to check if user is able to get error messges with invalid credentials
   	 */
     @When("User click on Get Phone no. button to fill invalid details")
     public void user_click_on_get_phone_no_button_to_fill_invalid_details() 
     {
     	 wait.until(ExpectedConditions.elementToBeClickable(mbp.getGetPhoneNoButton()));
         mbp.ClickOnGetPhoneNoButton();
     }
     
     @When("User click on Get Contact Details button to fill invalid details")
     public void user_click_on_get_contact_details_button_to_fill_invalid_details() 
     {
     	mbp.ClickOnContinueButton();
     }
     
     @Then("User is able to get diffrent error messages details via email")
     public void user_is_able_to_get_diffrent_error_messages_details_via_email() 
     {
         Assert.assertTrue(mbp.ChechAllErrors());
     }
   

//---------------------------------------Get Contact Details(Invalid Data)---------------------------------------------------
   	 /*
     * Created By: Urwashi Patidar
   	 * Reviewed By:
   	 * Motive: This is to check if user is able to get error messges with invalid credentials
   	 */

     @When("User click on share icon button on property card")
     public void user_click_on_share_icon_button_on_property_card() 
     {
     	wait.until(ExpectedConditions.elementToBeClickable(mbp.getShareIcon()));
     	mbp.ClickOnShareIcon();
     }
     
     @When("User click on whatsapp icon")
     public void user_click_on_whatsapp_icon() 
     {         
     	wait.until(ExpectedConditions.elementToBeClickable(mbp.getWhatsappIcon()));
        mbp.ClickOnWhatsappIcon();
        mbp.SwitchToReadyToMove();
     }
     
     
     @Then("User is able to get property details via whatsapp")
     public void user_is_able_to_get_property_details_via_whatsapp() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://web.whatsapp.com");
        //   Assert.assertNotEquals(driver.getCurrentUrl(), "https://web.whatsapp.com");
     }
     
     
     @AfterStep
     public  void takeScreendown(Scenario scenerio) {
     
     	   TakesScreenshot ts= (TakesScreenshot) driver;
     	   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
     	   scenerio.attach(src, "image/png",scenerio.getName());
     	   
     }
     @AfterTest
     public void afterTest()
     {
   	       driver.close();
     }
     
}
