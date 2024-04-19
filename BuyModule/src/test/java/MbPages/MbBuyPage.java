package MbPages;

import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MbBuyPage {
	 WebDriver driver;
	 JavascriptExecutor js;
	

	 @FindBy(id="buyheading")
	 @CacheLookup
	 WebElement buyHeading;
	 
	 @FindBy(xpath="//a[@href=\"https://www.magicbricks.com/ready-to-move-flats-in-mumbai-pppfs\"]")
	 @CacheLookup
	 WebElement readyToMoveFeature;
	 
	 @FindAll({
		 @FindBy(css= "span.mb-srp__card__sort--icon")
		
	 }) WebElement heartIcon ;
	
     @FindBy(className="mbform-otf__heading")
     @CacheLookup
     WebElement LoginForm;
      
     @FindBy(xpath="//div[starts-with(@id,\"cardid\")][1]/div/div[2]/div[1]/div[1]")
     @CacheLookup
     WebElement priceOfProperties1;
 
	 @FindBy(xpath="//div[starts-with(@id,\"cardid\")][2]/div/div[2]/div[1]/div[1]")
     @CacheLookup
     WebElement priceOfProperties2;
     
     @FindBy(xpath="//div[starts-with(@id,\"cardid\")][3]/div/div[2]/div[1]/div[1]")
     @CacheLookup
     WebElement priceOfProperties3;
     
     @FindBy(xpath="//div[starts-with(@id,\"cardid\")][4]/div/div[2]/div[1]/div[1]")
     @CacheLookup
     WebElement priceOfProperties4;
     
     @FindBy(xpath="//div[starts-with(@id,\"cardid\")][5]/div/div[2]/div[1]/div[1]")
     @CacheLookup
     WebElement priceOfProperties5;
    
     @FindBy(xpath="(//span[@class=\"mb-srp__action--btn medium btn-white\"])[3]")
     @CacheLookup
     WebElement getPhoneNoButton;
  
     @FindBy(className="contact-form__btn")
     @CacheLookup
     WebElement ContinueButton;
     
     @FindBy(id="userName")
     @CacheLookup
     WebElement userName;
     
     @FindBy(id="userEmail")
     @CacheLookup
     WebElement emailId;
     
     @FindBy(id="userMobile")
     @CacheLookup
     WebElement PhoneNo;
     
     @FindBy(className="contact-form__btn")
     @CacheLookup
     WebElement verifyButton;
     
     @FindBy(className="cont_sec_am")
     @CacheLookup
     WebElement contactDetails;
     
     @FindBy(xpath="//div[@class=\"mb-srp__tabs__sortby\"]")
     @CacheLookup
     WebElement SortByOptions;
     
     @FindBy(xpath="//ul[@class=\"mb-srp__tabs__sortby__dd__list\"]/li[3]")
     @CacheLookup
     WebElement SortFilter;
         
     @FindBy(xpath="(//div[@class=\"contact-form__error\"])[1]")
     @CacheLookup
     WebElement userNameError;
     
     @FindBy(xpath="(//div[@class=\"contact-form__error\"])[2]")
     @CacheLookup
     WebElement emailIdError;
     
     @FindBy(xpath="(//div[@class=\"contact-form__error\"])[3]")
     @CacheLookup
     WebElement PhoneNoError;
     
     @FindBy(css = "[data-ico='ico-share'].mb-srp__card__share--icon")
     @CacheLookup
     WebElement shareIcon;
     
     @FindBy(xpath="(//div[@class=\"mb-srp__share-prop__list--icon\"])[2]")
     @CacheLookup
     WebElement whatsappIcon;
    	
             
     public MbBuyPage(WebDriver driver) 
     {
          this.driver=driver;
		  PageFactory.initElements(driver, this);
	 }
	 
	 public void ExplicitWait(WebElement webElement)
	 {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(webElement));
	 }
	
	 public WebDriverWait ExplicitWaitTime(WebElement webElement)
	 {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  return wait;
	 }
	
     public void ScrollDown() 
   	 {
   	      js = (JavascriptExecutor) driver;
   		  js.executeScript("window.scroll(0,700)");
   	 }
     
	 
	 public void HoverOnBuyOption() 
	 {
		  Actions act = new Actions(driver);
		  act.moveToElement(buyHeading).build().perform(); 
	 }
	 
	 public void ClickOnReadyToMoveFea() 
	 {
		  readyToMoveFeature.click(); 
	 }
	  
//---------------------------------------Shortlist Property---------------------------------------------------
	 
	 public void SwitchToReadyToMove() 
	 {
		  String mainWindowHandle = driver.getWindowHandle();

		  Set<String> allWindowHandles = driver.getWindowHandles();

		  for (String handle : allWindowHandles) 
		  {
			 if (!handle.equals(mainWindowHandle)) 
			 {
			     driver.switchTo().window(handle); 
			 }
		  }
	 }
	 public void ClickOnHeartIcon() throws InterruptedException 
	 {
	        heartIcon.click();
	 }
	 
	 public String FormAfterClickingHeart() 	 
	 {
		 String message=LoginForm.getText();
		 return message;
	 }
	 
	 

//-------------------------------------Sort Property High To Low---------------------------------------------------
	  
     public void ClickOnSortByOption() 
     {
    	 SortByOptions.click();
     }
     
     public void ClickOnSortFilter()
     {
    	 SortFilter.click();
     }
	  
     public List GetPriceOfProperties() 
     {
    	 List<String> Prices= new ArrayList<>();
    	 Prices.add(priceOfProperties1.getText());
    	 Prices.add(priceOfProperties2.getText());
    	 Prices.add(priceOfProperties3.getText());
    	 Prices.add(priceOfProperties4.getText());
    	 Prices.add(priceOfProperties5.getText()); 
    	 return Prices;
     }
   
	 public boolean ComparePrices(List<String> listOfPrices) 
	 {
		 int numberOfProperty=5;
		 double Prices[]= new double[numberOfProperty];
		 String Tags[] = new String[numberOfProperty];
		 boolean flag=false;
		 int i=0;
		 for(String price:listOfPrices) 
		 {
			 String[] parts = price.split(" ");
			 String money=parts[0].substring(1).trim();
			 
			 Prices[i] = Double.parseDouble(money);
			 Tags[i++]=parts[1].trim();
			 
			 
		 }
		 for(int j=0;j<numberOfProperty-1;j++) 
		 {
		   	 if((Tags[j].equalsIgnoreCase("cr")) && (Tags[j+1].equalsIgnoreCase("cr"))) 
		   	 {
		   		 if(Prices[j]>=Prices[j+1]) 
		   		 {
		   			 flag=true;
		   		 }
		   		 else 
		   		 {
		   			 flag=false;
		   			 break;
		   		 }
		   	 }
		   	 else if((Tags[j].equalsIgnoreCase("cr")) && !(Tags[j+1].equalsIgnoreCase("cr")))
		   	 {
		   		 flag=true;
		   	 }
		   	 else 
		   	 {
		   		 if(Prices[j]>=Prices[j+1])
		   		 {
		   			 flag=true;
		   		 }
		   		 else 
		   		 {
		   			 flag=false;
		   			 break;
		   		 }
		   	 }
		 }
		 return flag;
	 }
	 
	 
//---------------------------------------Get Contact Details(Invalid Data)--------------------------------------------------- 
	 
	 
	  public void ClickOnGetPhoneNoButton() 
	  {	  	 
	  	  getPhoneNoButton.click();
	  }
	  
     
	  public void ClickOnContinueButton() 
	  {
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  	  wait.until(ExpectedConditions.elementToBeClickable(ContinueButton)).click();
	  }
	  
	  public void ClickOnVerifyButton() throws InterruptedException 
	  {
		  Thread.sleep(17000);
		  verifyButton.click();
	  }
	  
	  public boolean ChechAllErrors() {
		  if(userNameError.getText().equalsIgnoreCase("Name field can't be left blank. Please enter your name!") 
			  ||emailIdError.getText().equalsIgnoreCase("Email ID field can't be left blank. Please enter!") 
			  ||PhoneNoError.getText().equalsIgnoreCase("Please enter a 10-digit Mobile number!")) {
			  return true;
		  }
		  return false;
	  }
	 
//---------------------------------------Get Contact Details(Valid Data)---------------------------------------------------

	 

	  public void SendDetails(String UserName,String email,String phoneNo) throws InterruptedException 
	  {
		  userName.sendKeys(UserName);	
		  emailId.sendKeys(email);	      
		  ContinueButton.click();		  
		  PhoneNo.sendKeys(phoneNo);		  
	  }
	  
	  
	  
	  public boolean GetcontactDetailsOrNot() 
	  {
		 String message=contactDetails.getText();
		 if(message.equalsIgnoreCase("Your request is being shared with the Owner.")) 
		 {
			 return true;
		 }
		 else 
		 {
			 return false;
		 }
	  }

	  

//---------------------------------------Share property via whatsapp---------------------------------------------------
	  
	  public void ClickOnShareIcon() {
		  shareIcon.click();
	  }
	  
	  public void ClickOnWhatsappIcon() {
		  whatsappIcon.click();
	  }
	  
	 
//---------------------------------------Share property via whatsapp---------------------------------------------------

	 public void login() {
		 driver.findElement(By.xpath("//section[@class=\"mb-header__main\"]/child::div/child::div[2]/div[2]/a")).click();
		 SwitchToReadyToMove();
		 driver.findElement(By.xpath("//a[@onclick=\"window.open('https://accounts.magicbricks.com/userauth/login', '_blank');fireLoginGTM(event,'Login','Login CTA clicked','');\"]")).click();
		 SwitchToReadyToMove();
		 driver.findElement(By.id("emailOrMobile")).sendKeys("8463837881");
		 driver.findElement(By.id("btnStep1")).click(); 
	 }
	
	 
	
	 

//---------------------------------------Getter Setter---------------------------------------------------	 
	 
	 
	 
	     public WebElement getBuyHeading() {
			return buyHeading;
		}

		public void setBuyHeading(WebElement buyHeading) {
			this.buyHeading = buyHeading;
		}

		public WebElement getReadyToMoveFeature() {
			return readyToMoveFeature;
		}

		public void setReadyToMoveFeature(WebElement readyToMoveFeature) {
			this.readyToMoveFeature = readyToMoveFeature;
		}

		public WebElement getHeartIcon() {
			return heartIcon;
		}

		public void setHeartIcon(WebElement heartIcon) {
			this.heartIcon = heartIcon;
		}

		public WebElement getSortByOptions() {
				return SortByOptions;
		}

		public void setSortByOptions(WebElement sortByOptions) {
				SortByOptions = sortByOptions;
		}

		public WebElement getSortFilter() {
				return SortFilter;
		}

		public void setSortFilter(WebElement sortFilter) {
				SortFilter = sortFilter;
		}
		
		public WebElement getPriceOfProperties2() {
				return priceOfProperties1;
	    }

		public WebElement getPriceOfProperties1() {
			return priceOfProperties1;
		}

		public void setPriceOfProperties1(WebElement priceOfProperties1) {
			this.priceOfProperties1 = priceOfProperties1;
		}

		public WebElement getPriceOfProperties3() {
			return priceOfProperties3;
		}

		public void setPriceOfProperties3(WebElement priceOfProperties3) {
			this.priceOfProperties3 = priceOfProperties3;
		}

		public WebElement getPriceOfProperties4() {
			return priceOfProperties4;
		}

		public void setPriceOfProperties4(WebElement priceOfProperties4) {
			this.priceOfProperties4 = priceOfProperties4;
		}

		public WebElement getPriceOfProperties5() {
			return priceOfProperties5;
		}

		public void setPriceOfProperties5(WebElement priceOfProperties5) {
			this.priceOfProperties5 = priceOfProperties5;
		}

		public void setPriceOfProperties2(WebElement priceOfProperties2) {
			this.priceOfProperties2 = priceOfProperties2;
		}
		public WebElement getGetPhoneNoButton() {
				return getPhoneNoButton;
		}
        public void setGetPhoneNoButton(WebElement getPhoneNoButton) {
				this.getPhoneNoButton = getPhoneNoButton;
			}
        public WebElement getContactDetails() {
    		    return contactDetails;
    	}

    	public void setContactDetails(WebElement contactDetails) {
    		   this.contactDetails = contactDetails;
    	}

    	public WebElement getShareIcon() {
    			return shareIcon;
    	}

    	public void setShareIcon(WebElement shareIcon) {
    			this.shareIcon = shareIcon;
    	}

        public WebElement getWhatsappIcon() {
   	    	return whatsappIcon;
   	    }
        
   	    public void setWhatsappIcon(WebElement whatsappIcon) {
   	    	this.whatsappIcon = whatsappIcon;
   	    }

}
