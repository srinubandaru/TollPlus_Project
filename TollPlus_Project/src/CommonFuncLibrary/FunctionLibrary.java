package CommonFuncLibrary;

import java.awt.RenderingHints.Key;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.Keys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import Utilities.PropertyFileUtil;
import junit.framework.Assert;


public class FunctionLibrary


{
	

	

	// ALl browser actions like click, send keys and generic code for waiting like
	// Imp, exp wait

	public static void openApplication(WebDriver driver, String url) throws Exception {
		driver.manage().window().maximize();

		driver.get(url);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	

	public static WebDriver startBrowser(WebDriver driver) throws Exception

	// (1) to open browser from excelpublic static WebDriver startBrowser(WebDriver
	// driver, String browsername) throws Exception

	{

		if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox"))

		// (2)
		// if(browsername.equalsIgnoreCase("firefox"))

		{

			System.setProperty("webdriver.gecko.driver", "CommonJarFiles/geckodriver.exe");
			ProfilesIni allProfiles = new ProfilesIni();
			FirefoxProfile profile = allProfiles.getProfile("Selenium");
			// driver = new FirefoxDriver(profile);

			// driver=new FirefoxDriver();

		} else if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "CommonJarFiles/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("IE"))

		{
			System.setProperty("webdriver.ie.driver", "CommonJarFiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("edge"))

		{
			System.setProperty("webdriver.edge.driver", "CommonJarFiles/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "CommonJarFiles/edge.exe");
			driver = new InternetExplorerDriver();
		}

		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		driver.close();
	}

	public static void clickAction(WebDriver driver, String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		}
	}

	/*
	 * public static void pagination(WebDriver driver, String locatorType, String
	 * locatorValue) { //List<WebElement> elements = driver.findElements(By.xpath(
	 * "//a[@href='#/admin/businessPartner/manageBusinessPartners/13/MyChoiceUK/UK_corphub'][text()='Continue']"
	 * )); List<WebElement> pagination
	 * =driver.findElemnts(By.xpath("//div[@class='nav-pages']//a")); // checkif
	 * pagination link exists
	 * 
	 * if(pagination .size()>0){ sop("pagination exists");
	 * 
	 * // click on pagination link
	 * 
	 * for(int i=0; i<pagination .size(); i++){ pagination.get(i).click(); } } else
	 * { sop("pagination not exists"); } }
	 */
	
	
	public static void highLighterMethod(WebDriver driver, String locatorType, String locatorValue, String data){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.xpath(locatorValue)));
		 }

	public static void typeAction(WebDriver driver, String locatorType, String locatorValue, String data)
			throws Exception {
		if (locatorType.equalsIgnoreCase("id")) {
			/*
			 * driver.findElement(By.id(locatorValue)).clear();
			 * driver.findElement(By.id(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.xpath(locatorValue)));

			/*
			 * driver.findElement(By.xpath(locatorValue)).clear();
			 * driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			/*
			 * driver.findElement(By.name(locatorValue)).clear();
			 * driver.findElement(By.name(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}
	}

	public static void SelectDropDown(WebDriver driver, String locatorType, String locatorValue, String data)
			throws Exception {
		if (locatorType.equalsIgnoreCase("id")) {
			/*
			 * driver.findElement(By.id(locatorValue)).clear();
			 * driver.findElement(By.id(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}

		else if (locatorType.equalsIgnoreCase("xpath")) {

			/*
			 * driver.findElement(By.xpath(locatorValue)).clear();
			 * driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.click();

						// new
						// Actions(driver).sendKeys(data).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
						new Actions(driver).sendKeys(data).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
								.sendKeys(Keys.ENTER).build().perform();
						// webelement.click();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}
		/*
		 * else if(locatorType.equalsIgnoreCase("xpath")) { { }
		 * 
		 * driver.findElement(By.xpath(locatorValue)).clear();
		 * driver.findElement(By.xpath(locatorValue)).sendKeys(data);
		 * 
		 * WebElement webelement=driver.findElement(By.xpath(locatorValue));
		 * 
		 * try{
		 * 
		 * 
		 * for(int m=0;m<20;m++){ try{ webelement.clear(); webelement.sendKeys(data);
		 * break; }catch(Exception e){ Thread.sleep(1000); } }
		 * 
		 * }catch(Exception e){
		 * 
		 * throw e;
		 * 
		 * } }
		 * 
		 * try{
		 * 
		 * 
		 * for(int m=0;m<20;m++){ try{ webelement.clear(); webelement.sendKeys(data);
		 * 
		 * Thread.sleep(2000);
		 * 
		 * List<WebElement> DropList=driver.findElements(By.xpath(
		 * "//span[@role='status'][@class='ui-helper-hidden-accessible'][text()='1277132']"
		 * )); System.out.println(DropList.size()); for (int i = 0; i < DropList.size();
		 * i++) {
		 * 
		 * if (DropList.get(i).getText().equalsIgnoreCase(data)) {
		 * 
		 * DropList.get(i).click();
		 * 
		 * break;
		 * 
		 * 
		 * 
		 * }
		 * 
		 * }
		 * 
		 * break; }catch(Exception e){ Thread.sleep(1000); } }
		 * 
		 * }catch(Exception e){
		 * 
		 * throw e;
		 * 
		 * }}
		 */
		else if (locatorType.equalsIgnoreCase("name")) {
			/*
			 * driver.findElement(By.name(locatorValue)).clear();
			 * driver.findElement(By.name(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}
	}

	public static void currentDateSelection(WebDriver driver, String locatorType, String locatorValue, String data)
			throws Exception {
		/*
		 * Date today = new Date();
		 * 
		 * 
		 * int dd = today.getDate(); System.out.println("todays date : "+dd); int mm =
		 * today.getMonth()+1; //January is 0!
		 * 
		 * System.out.println("todays date month : "+mm);
		 * 
		 * int yyyy = today.getYear();
		 * 
		 * System.out.println("todays date year : "+yyyy);
		 * 
		 * if(dd<10){ dd='0'+dd; } if(mm<10){ mm='0'+mm; } int today1 =
		 * dd+'-'+mm+'-'+yyyy;
		 * 
		 * System.out.println("Total Date  : " + today1);
		 * 
		 */

		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy ");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1 = dateFormat.format(date);

		// Print the Date
		System.out.println("Current date Formate : " + date1);

		String[] td = date1.split("-");

		String day = td[0];
		String month = td[1];
		String year = td[2];

		System.out.println("Spliting date : " + day + "   " + month + "   " + year);

		if (locatorType.equalsIgnoreCase("id")) {
			/*
			 * driver.findElement(By.id(locatorValue)).clear();
			 * driver.findElement(By.id(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {

						webelement.click();

						new Actions(driver).sendKeys(day).sendKeys(month).sendKeys(year).build().perform();

						/*
						 * JavascriptExecutor js=(JavascriptExecutor)driver;
						 * js.executeScript("document.getElementById("+locatorValue+").value='"+day+"';"
						 * );
						 * 
						 * new Actions(driver).sendKeys(Keys.TAB).build().perform();
						 * 
						 * js.executeScript("document.getElementById("+locatorValue+").value='"+month+
						 * "';");
						 * 
						 * new Actions(driver).sendKeys(Keys.TAB).build().perform();
						 * 
						 * js.executeScript("document.getElementById("+locatorValue+").value='"+year+
						 * "';");
						 */

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("xpath")) {

			/*
			 * driver.findElement(By.xpath(locatorValue)).clear();
			 * driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.click();

						new Actions(driver).sendKeys(day).sendKeys(month).sendKeys(year).build().perform();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			/*
			 * driver.findElement(By.name(locatorValue)).clear();
			 * driver.findElement(By.name(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.click();

						new Actions(driver).sendKeys(day).sendKeys(month).sendKeys(year).build().perform();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}
	}

	public static void typeAction_key(WebDriver driver, String locatorType, String locatorValue, String data)
			throws Exception {
		if (locatorType.equalsIgnoreCase("id")) {
			/*
			 * driver.findElement(By.id(locatorValue)).clear();
			 * driver.findElement(By.id(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(PropertyFileUtil.getValueForKey(data));
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("xpath")) {

			/*
			 * driver.findElement(By.xpath(locatorValue)).clear();
			 * driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(PropertyFileUtil.getValueForKey(data));
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			/*
			 * driver.findElement(By.name(locatorValue)).clear();
			 * driver.findElement(By.name(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(PropertyFileUtil.getValueForKey(data));
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}
	}

	public static void searchText(WebDriver driver, String locatorType, String locatorValue, String data)
			throws Exception {
		if (locatorType.equalsIgnoreCase("id")) {
			/*
			 * driver.findElement(By.id(locatorValue)).clear();
			 * driver.findElement(By.id(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(PropertyFileUtil.getValueForKey(data));
						System.out.println("Search Text : " + data);
						new Actions(driver).sendKeys(Keys.ENTER).build().perform();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("xpath")) {

			/*
			 * driver.findElement(By.xpath(locatorValue)).clear();
			 * driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(PropertyFileUtil.getValueForKey(data));
						System.out.println("Search Text : " + data);
						new Actions(driver).sendKeys(Keys.ENTER).build().perform();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			/*
			 * driver.findElement(By.name(locatorValue)).clear();
			 * driver.findElement(By.name(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.clear();
						webelement.sendKeys(PropertyFileUtil.getValueForKey(data));
						System.out.println("Search Text : " + data);
						new Actions(driver).sendKeys(Keys.ENTER).build().perform();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}
	}

	// table Validation

	public static void tableValidation(WebDriver driver, String locatorType, String locatorValue, String data)
			throws Exception {

		String act_Text = null;

		String exp_Text = data;

		if (locatorType.equalsIgnoreCase("id")) {

			// Identifying card holder user ID in view card holder

			List<WebElement> tableRows = driver.findElements(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						for (int i = 0; i < tableRows.size(); i++) {

							System.out.println("Rows Size  " + tableRows.size());

							WebElement ele = tableRows.get(i);
							act_Text = ele.getText();

							if (act_Text.contains(exp_Text)) {

								System.out.println("Amount Validation done");

								break;
							}
							break;

						}

						break;

					}

					catch (Exception e) {
						Thread.sleep(1000);
					}
				}
			}

			catch (Exception e) {

				throw e;

			}
		}

		else if (locatorType.equalsIgnoreCase("xpath")) {
			// Identifying card holder user ID in view card holder

			List<WebElement> tableRows = driver.findElements(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						for (int i = 0; i < tableRows.size(); i++) {

							System.out.println("Rows Size  " + tableRows.size());

							WebElement ele = tableRows.get(i);
							act_Text = ele.getText();

							if (act_Text.contains(exp_Text)) {
								// FunctionLibrary.clicks(driver, "xpath", "//table[@class='table ng-scope
								// ng-table']/tbody/tr["+i+"]/td[4]/a","NA");

								System.out.println(" ch Amount Validation done");

								break;
							}
							break;

						}

						break;

					}

					catch (Exception e) {
						Thread.sleep(1000);
					}
				}
			}

			catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			// Identifying card holder user ID in view card holder

			List<WebElement> tableRows = driver.findElements(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						for (int i = 0; i < tableRows.size(); i++) {

							System.out.println("Rows Size  " + tableRows.size());

							WebElement ele = tableRows.get(i);
							act_Text = ele.getText();

							if (act_Text.contains(exp_Text)) {

								System.out.println("CH Amount Validation done");

								break;
							}
							break;

						}

						break;

					}

					catch (Exception e) {
						Thread.sleep(1000);
					}
				}
			}

			catch (Exception e) {

				throw e;

			}
		}
	}

	/*
	 * // Table click for Continue in back office
	 * 
	 * 
	 * public static void tableEleClick(WebDriver driver, String locatorType, String
	 * locatorValue, String data) throws Exception {
	 * 
	 * 
	 * 
	 * String act_Text = null;
	 * 
	 * String exp_Text=data;
	 * 
	 * if(locatorType.equalsIgnoreCase("id")) {
	 * 
	 * 
	 * // Identifying card holder user ID in view card holder
	 * 
	 * List<WebElement> tableRows=driver.findElements(By.id(locatorValue));
	 * 
	 * try{
	 * 
	 * 
	 * for(int m=0;m<20;m++){ try{ for (int i = 0; i < tableRows.size(); i++) {
	 * 
	 * System.out.println("Rows Size  "+ tableRows.size());
	 * 
	 * WebElement ele=tableRows.get(i); act_Text = ele.getText();
	 * 
	 * if (act_Text.contains(exp_Text)) {
	 * 
	 * //Continue Button for Business Program Name // FunctionLibrary.clicks(driver,
	 * "xpath",
	 * "//table[@class='table ng-scope ng-table']/tbody/tr["+i+"]/td[4]/a","NA");
	 * FunctionLibrary.clicks(driver, "xpath",
	 * "//a[@class='btn btn-primary btnMore'][@href='#/admin/businessPartner/manageBusinessPartners/11/MyChoiceUK/UK_corphub']"
	 * ,"NA");
	 * 
	 * System.out.println("Program Name Continue button Click");
	 * 
	 * 
	 * break; } break;
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * 
	 * catch(Exception e){ Thread.sleep(1000); } } }
	 * 
	 * catch(Exception e){
	 * 
	 * throw e;
	 * 
	 * } }
	 * 
	 * else if(locatorType.equalsIgnoreCase("xpath")) { // Identifying card holder
	 * user ID in view card holder
	 * 
	 * List<WebElement> tableRows=driver.findElements(By.xpath(locatorValue));
	 * 
	 * try{
	 * 
	 * 
	 * for(int m=0;m<20;m++){ try{ for (int i = 0; i < tableRows.size(); i++) {
	 * 
	 * System.out.println("Rows Size  "+ tableRows.size());
	 * 
	 * WebElement ele=tableRows.get(i); act_Text = ele.getText();
	 * 
	 * if (act_Text.contains(exp_Text)) { FunctionLibrary.clicks(driver, "xpath",
	 * "//table[@class='table ng-scope ng-table']/tbody/tr["+i+"]/td[4]/a","NA");
	 * 
	 * System.out.println("Program Name Continue button Click");
	 * 
	 * 
	 * break; } break;
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * 
	 * catch(Exception e){ Thread.sleep(1000); } } }
	 * 
	 * catch(Exception e){
	 * 
	 * throw e;
	 * 
	 * } } else if(locatorType.equalsIgnoreCase("name")) { // Identifying card
	 * holder user ID in view card holder
	 * 
	 * List<WebElement> tableRows=driver.findElements(By.id(locatorValue));
	 * 
	 * try{
	 * 
	 * 
	 * for(int m=0;m<20;m++){ try{ for (int i = 0; i < tableRows.size(); i++) {
	 * 
	 * System.out.println("Rows Size  "+ tableRows.size());
	 * 
	 * WebElement ele=tableRows.get(i); act_Text = ele.getText();
	 * 
	 * if (act_Text.contains(exp_Text)) {
	 * 
	 * FunctionLibrary.clicks(driver, "xpath",
	 * "//table[@class='table ng-scope ng-table']/tbody/tr["+i+"]/td[4]/a","NA");
	 * 
	 * System.out.println("Program Name Continue button Click");
	 * 
	 * break; } break;
	 * 
	 * }
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * 
	 * catch(Exception e){ Thread.sleep(1000); } } }
	 * 
	 * catch(Exception e){
	 * 
	 * throw e;
	 * 
	 * } } }
	 * 
	 */

	public static void selectAction(WebDriver driver, String locatorType, String locatorValue, String data)
			throws Exception
		
	{
		if (locatorType.equalsIgnoreCase("id")) {
			/*
			 * driver.findElement(By.id(locatorValue)).clear();
			 * driver.findElement(By.id(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						// new Select(webelement).selectByVisibleText(data);
						new Select(webelement).selectByValue(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("xpath")) {

			/*
			 * driver.findElement(By.xpath(locatorValue)).clear();
			 * driver.findElement(By.xpath(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						// new Select(webelement).selectByVisibleText(data);
						// new Select(webelement).selectByValue(data);
						new Select(webelement).selectByValue(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			/*
			 * driver.findElement(By.name(locatorValue)).clear();
			 * driver.findElement(By.name(locatorValue)).sendKeys(data);
			 */

			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						new Select(webelement).selectByVisibleText(data);
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}
	}

	public static void waitforelement(WebDriver driver, String locatorType, String locatorValue, String waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(waitTime));

		if (locatorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.xpath(locatorValue)));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		} else if (locatorType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
		}
	}

	public static void waitforClick(WebDriver driver, String locatorType, String locatorValue, String waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(waitTime));

		if (locatorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
		} else if (locatorType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
		}
	}

	public static void clicks(WebDriver driver, String locatorType, String locatorValue, String waitTime)
			throws Exception {

		if (locatorType.equalsIgnoreCase("id")) {
			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.click();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.xpath(locatorValue)));

			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.click();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						webelement.click();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}

	}

	public static void titleValidation(WebDriver driver, String validData) {
		String act_title = driver.getTitle();
		String exp_title = validData;

		Assert.assertEquals(act_title, exp_title);
	}

	public static void elementValidation(WebDriver driver, String locatorType, String locatorValue, String textData)
			throws Exception {
		String act_Text = null;

		String exp_Text = textData;

		if (locatorType.equalsIgnoreCase("id")) {

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}

		System.out.println(act_Text + "       " + exp_Text);

		Assert.assertEquals(act_Text.trim(), exp_Text.trim());

	}

	// Element validation with Contains

	public static void textValidation(WebDriver driver, String locatorType, String locatorValue, String textData)
			throws Exception {
		String act_Text = null;

		String exp_Text = textData;

		if (locatorType.equalsIgnoreCase("id")) {

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {
			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}

		System.out.println(act_Text + "       " + exp_Text);

		if (!act_Text.contains(exp_Text)) {
			System.out.println("Text validation");
			Assert.assertEquals(act_Text, exp_Text);

		}

	}

	// Web Element size Validation

	public static void webEleValidate(WebDriver driver, String locatorType, String locatorValue, String textData)
			throws Exception {
		String act_Text = null;

		String exp_Text = "1";

		if (locatorType.equalsIgnoreCase("id")) {

			// List<WebElement> webelement=driver.findElements(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						List<WebElement> webelement = driver.findElements(By.id(locatorValue));
						act_Text = String.valueOf(webelement.size());

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("xpath")) {

			try {

				for (int m = 0; m < 20; m++) {
					try {
						List<WebElement> webelement = driver.findElements(By.id(locatorValue));
						act_Text = String.valueOf(webelement.size());
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		} else if (locatorType.equalsIgnoreCase("name")) {

			try {

				for (int m = 0; m < 20; m++) {
					try {
						List<WebElement> webelement = driver.findElements(By.id(locatorValue));
						act_Text = String.valueOf(webelement.size());
						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}
		}

		System.out.println("Act Element size : " + act_Text + "       Exp Element size : " + exp_Text);

		Assert.assertEquals(act_Text.trim(), exp_Text.trim());

	}

	// take User ID from Success POP UP

	// take User ID from Success POP UP

	public static void takeText(WebDriver driver, String locatorType, String locatorValue, String textData)
			throws Exception {
		String act_Text = null;
		String neededText = null;

		if (locatorType.equalsIgnoreCase("id")) {

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[6]);

						neededText = messageData[6];

						PropertyFileUtil.insetValueForKey(textData, neededText);

						System.out.println("insert text in Prop in FL" + neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[6]);

						neededText = messageData[6];

						PropertyFileUtil.insetValueForKey(textData, neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("name")) {
			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[6]);

						neededText = messageData[6];

						PropertyFileUtil.insetValueForKey(textData, neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		}

		// System.out.println(act_Text+" "+ exp_Text);

		// Assert.assertEquals(act_Text, exp_Text);

	}

	// take Reference ID from Documents for account upgrade has been received by us

	public static void takeReferenceID(WebDriver driver, String locatorType, String locatorValue, String textData)
			throws Exception {
		String act_Text = null;
		String neededText = null;

		if (locatorType.equalsIgnoreCase("id")) {

			WebElement webelement = driver.findElement(By.id(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[40]);

						neededText = messageData[40];

						PropertyFileUtil.insetValueForreferenceID(textData, neededText);

						System.out.println("insert text in Prop in FL" + neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[40]);

						neededText = messageData[40];

						PropertyFileUtil.insetValueForreferenceID(textData, neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("name")) {
			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[40]);

						neededText = messageData[40];

						PropertyFileUtil.insetValueForreferenceID(textData, neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		}

		// System.out.println(act_Text+" "+ exp_Text);

		// Assert.assertEquals(act_Text, exp_Text);

	}

	public static String getRandomNumberFromDate() {
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_dd_ss");

		return sdf.format(date);
	}

	public static void pageScrollDown(WebDriver driver) {
//		 Actions action = new Actions(driver);
//		 action.sendKeys(Keys.PAGE_DOWN);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");
	}

	public static void fileUpload(WebDriver driver, String autoitPath) throws IOException {

		Runtime.getRuntime().exec(autoitPath);

	}

	public static void pageScrollUP(WebDriver driver) {
//		 Actions action = new Actions(driver);
//		 action.sendKeys(Keys.PAGE_DOWN);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-400)", "");
	}

	// DB Validation

	public static void DBValidation() throws Exception {

		String PanNo = null;
		String WcProxy = null;
		String realPan;
		String realCvv;
		// String accessCode = null;
		// String verficationCode = null;

		// String allowAtmTxn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			System.out.println("Loading");

			Thread.sleep(3000);

			Connection con = DriverManager.getConnection(
					// "jdbc:mysql://10.10.10.68:3306/paycentral","wcuser","wcuser@123");
					"jdbc:mysql://10.10.8.30:49397/paycentral", "wcuser", "wcuser@123");
			// "jdbc:mysql://172.17.0.2:3306/paycentral","wcuser","wcuser@123");
			// 10.10.8.30:49158
			// "jdbc:mysql://10.10.8.30:49158/paycentral","wcuser","wcuser@123"“ip
			// 10.10.40.56 port 3306”

			System.out.println("Connections");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM Card WHERE user_id='" + PropertyFileUtil.getValueForKey("UserID") + "'");

			// Email Verification
			// ResultSet rs2=stmt.executeQuery("SELECT * FROM VerificationCode WHERE
			// deviceId='"+PropertyFileUtil.getValueForKey("EmailVerification")+"'");

			// Switch ON/OFF
			// ResultSet rs3=stmt.executeQuery("SELECT * FROM UserCardPreference WHERE
			// card_id IN (SELECT id FROM Card WHERE
			// user_id='"+PropertyFileUtil.getValueForKey("UserID")+"')");

			System.out.println("Query Excution");
			while (rs.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

				PanNo = rs.getNString("PAN");

				System.out.println(PanNo);

				WcProxy = rs.getNString("wcProxy");

				System.out.println(WcProxy);

				/*
				 * accessCode=rs.getNString("accessCode");
				 * 
				 * System.out.println(accessCode);
				 */

			}

			/*
			 * while(rs2.next()) {
			 * //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			 * 
			 * verficationCode=rs2.getNString("verficationCode");
			 * 
			 * System.out.println(verficationCode);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * }
			 * 
			 * while(rs3.next()) {
			 * //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			 * 
			 * allowAtmTxn=rs3.getNString("allowAtmTxns");
			 * 
			 * System.out.println(allowAtmTxn);
			 * 
			 * 
			 * 
			 * 
			 * 
			 * }
			 */

			con.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}

		// Urls to get PAN and Cvv By User ID

		// --------------------PAN & CVV URLS---------------
		// accessCode in Property file
		/*
		 * PropertyFileUtil.insetValueForKey("accessCode", accessCode); //Email
		 * Varification in Property file
		 * PropertyFileUtil.insetValueForKey("verficationCode", verficationCode);
		 * 
		 * 
		 * // PropertyFileUtil.insetValueForKey("allowAtmTxn", allowAtmTxn);
		 */

		String PanURL = "https://wcapi.wavecrest.in/orchestration-web/wallet/crypto/" + PanNo + "/decrypt";

		// CvvURL=
		// "https://api.wavecrest.in/orchestration-web/wallet/cdata/"+WcProxy+"/cabconnect";
		String CvvURL = "https://api.qaalpha.wcdevcloud.com:49172/orchestration-web/wallet/cdata/" + WcProxy
				+ "/MyChoiceUK";

		// ------------Getting PAN And CVV From URLs----------------------------

		realPan = GetPanNo(PanURL);

		// realPan=GetPanNo("https://wcapi.wavecrest.in/orchestration-web/wallet/crypto/1_91bc41396ba4ea1b942b755dede04536d4c6b51324667357b3354a75d4c6b89b/decrypt");

		System.out.println("Pan  From URL   " + realPan);
		// String PAN = null;
		PropertyFileUtil.insetValueForKey("PAN", realPan);

		Thread.sleep(2000);

		realCvv = GetCvvNo(CvvURL);

		// realCvv=GetCvvNo("https://api.qaalpha.wcdevcloud.com:49172/orchestration-web/wallet/cdata/253116988153860/MyChoiceUK");

		System.out.println("realCvv   From URL   " + realCvv);
		// String CVV = null;

		PropertyFileUtil.insetValueForKey("CVV", realCvv);

	}

	// DB Email Verification

	public static void dBEmailValidation() {

		// String accessCode = null;
		String verificationCode = null;

		// String allowAtmTxn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			System.out.println("Loading");

			Thread.sleep(3000);

			Connection con = DriverManager.getConnection(
					// "jdbc:mysql://10.10.10.68:3306/paycentral","wcuser","wcuser@123");
					"jdbc:mysql://10.10.8.30:49397/paycentral", "wcuser", "wcuser@123");
			// "jdbc:mysql://172.17.0.2:3306/paycentral","wcuser","wcuser@123");
			// 10.10.8.30:49158
			// "jdbc:mysql://10.10.8.30:49158/paycentral","wcuser","wcuser@123"“ip
			// 10.10.40.56 port 3306”

			System.out.println("Connections");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();

			// Email Verification
			// SELECT * FROM VerificationCode WHERE deviceID='demobsbch5@yopmail.com'
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM VerificationCode WHERE deviceId='"
					+ PropertyFileUtil.getValueForKey("EmailVerification") + "'");
			// ResultSet rs1=stmt.executeQuery("SELECT * FROM VerificationCode WHERE
			// deviceId='"+PropertyFileUtil.getValueForKey("verficationCode")+"'");
			// ResultSet rs1=stmt.executeQuery("SELECT * FROM VerificationCode WHERE
			// deviceId='demobsbch5@yopmail.com''"+PropertyFileUtil.getValueForKey("verificationCode")+"'");
			// Switch ON/OFF
			// ResultSet rs3=stmt.executeQuery("SELECT * FROM UserCardPreference WHERE
			// card_id IN (SELECT id FROM Card WHERE
			// user_id='"+PropertyFileUtil.getValueForKey("UserID")+"')");

			System.out.println("Query Excution");

			while (rs1.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

				verificationCode = rs1.getNString("verificationCode");

				System.out.println(verificationCode);

				PropertyFileUtil.insetValueForKey("emailverificationCode", verificationCode);

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}

	}

	// DB Mobile Verification

	public static void dBMobileValidation() {

		// String accessCode = null;
		String verificationCode = null;

		// String allowAtmTxn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			System.out.println("Loading");

			Thread.sleep(3000);

			Connection con = DriverManager.getConnection(
					// "jdbc:mysql://10.10.10.68:3306/paycentral","wcuser","wcuser@123");
					"jdbc:mysql://10.10.8.30:49397/paycentral", "wcuser", "wcuser@123");

			System.out.println("Connections");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();

			// Mobile Verification
			// SELECT * FROM VerificationCode WHERE deviceID='demobsbch5@yopmail.com'
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM VerificationCode WHERE deviceId ='"
					+ PropertyFileUtil.getValueForKey("MobileVerification") + "'");

			System.out.println("Query Excution");

			while (rs1.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

				verificationCode = rs1.getNString("verificationCode");

				System.out.println(verificationCode);

				PropertyFileUtil.insetValueForKey("mobileverificationCode", verificationCode);

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}

	}

	// DB CardControl Verification

	public static void dBCardControl() {

		String allowAtmTxns = null;
		String allowPosTxns = null;
		String allowEposTxns = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			System.out.println("Loading");

			Thread.sleep(3000);

			Connection con = DriverManager.getConnection(
					// "jdbc:mysql://10.10.10.68:3306/paycentral","wcuser","wcuser@123");
					"jdbc:mysql://10.10.8.30:49397/paycentral", "wcuser", "wcuser@123");
			// "jdbc:mysql://172.17.0.2:3306/paycentral","wcuser","wcuser@123");
			// 10.10.8.30:49158
			// "jdbc:mysql://10.10.8.30:49158/paycentral","wcuser","wcuser@123"“ip
			// 10.10.40.56 port 3306”

			System.out.println("Connections");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();

			// Email Verification
			// SELECT * FROM VerificationCode WHERE deviceID='demobsbch5@yopmail.com'
			// SELECT * FROM UserCardPreference WHERE card_id IN (SELECT id FROM Card WHERE
			// user_id=16887760)
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM UserCardPreference WHERE card_id IN (SELECT id FROM Card WHERE user_id='"
							+ PropertyFileUtil.getValueForKey("UserID") + "'");

			System.out.println("Query Excution");

			while (rs.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

				allowAtmTxns = rs.getNString("allowAtmTxns");

				System.out.println(allowAtmTxns + " allowAtmTxns   ");

				PropertyFileUtil.insetValueForKey("allowAtmTxns", allowAtmTxns);

				allowEposTxns = rs.getNString("allowEposTxns");

				System.out.println(allowEposTxns + " allowEposTxns   ");

				PropertyFileUtil.insetValueForKey("allowEposTxns", allowEposTxns);

				allowPosTxns = rs.getNString("allowPosTxns");

				System.out.println(allowPosTxns + " allowPosTxns   ");

				PropertyFileUtil.insetValueForKey("allowPosTxns", allowPosTxns);

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}

	}

	/*
	 * //For one switch ON/OFF condition
	 * 
	 * public static void cardComparisonON(String value) throws Exception { if
	 * (!PropertyFileUtil.getValueForKey(value).equalsIgnoreCase("1")) {
	 * 
	 * Assert.assertEquals("0","1");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * public static void cardComparisonOFF(String value) throws Exception { if
	 * (!PropertyFileUtil.getValueForKey(value).equalsIgnoreCase("0")) {
	 * 
	 * Assert.assertEquals("0","1");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	// Methods for CardControl ON/OFF Comparison

	public static void cardComparisonON() throws Exception {
		if (!PropertyFileUtil.getValueForKey("allowAtmTxns").equalsIgnoreCase("1")
				&& !PropertyFileUtil.getValueForKey("allowEposTxns").equalsIgnoreCase("1")
				&& !PropertyFileUtil.getValueForKey("allowPosTxns").equalsIgnoreCase("1")) {

			Assert.assertEquals("0", "1");

		}

	}

	public static void cardComparisonOFF() throws Exception {
		if (!PropertyFileUtil.getValueForKey("allowAtmTxns").equalsIgnoreCase("0")
				&& !PropertyFileUtil.getValueForKey("allowEposTxns").equalsIgnoreCase("0")
				&& !PropertyFileUtil.getValueForKey("allowPosTxns").equalsIgnoreCase("0")) {

			Assert.assertEquals("1", "0");

		}
	}

	public static String GetPanNo(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr2 = new ChromeDriver();
		dr2.manage().window().maximize();
		dr2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		dr2.get(url);

		String panString = dr2.findElement(By.xpath(".//pre[@style='word-wrap: break-word; white-space: pre-wrap;']"))
				.getText();

		System.out.println(panString);

		System.out.println(panString.replaceAll("[^0-9]", ""));

		String MyPan = panString.replaceAll("[^0-9]", "");

		// dr2.close();
		return MyPan;

	}

	public static String GetCvvNo(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver dr2 = new ChromeDriver();
		dr2.manage().window().maximize();
		dr2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		dr2.get(url);

		String cvvString = dr2.findElement(By.xpath(".//pre[@style='word-wrap: break-word; white-space: pre-wrap;']"))
				.getText();

		System.out.println(cvvString);

		System.out.println(cvvString.replaceAll("[^0-9]", ""));

		String Mycvv = cvvString.replaceAll("[^0-9]", "");

		// dr2.close();

		return Mycvv;

	}

	public static void tableValidation(WebDriver driver, String reqNum, String exp_data) throws Exception {
		// Conversion form String to int
		int reqNum1 = Integer.parseInt(reqNum);

		if (driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.box"))).isDisplayed()) {

			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.box"))).clear();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.box"))).sendKeys(exp_data);

			Thread.sleep(2000);
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.btn"))).click();
			Thread.sleep(2000);

		} else {
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.option"))).click();

			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.box"))).clear();
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.box"))).sendKeys(exp_data);

			Thread.sleep(2000);
			driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Search.btn"))).click();
			Thread.sleep(2000);

			WebElement webtable = driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("webtable.path")));

			List<WebElement> rows = webtable.findElements(By.tagName("tr"));

			String act_data = null;

			for (int i = 1; i <= rows.size(); i++) {
				act_data = driver.findElement(By.xpath(
						".//*[@id='ewContentColumn']/div[3]/form/div/div//table[@class='table ewTable']/tbody/tr[" + i
								+ "]/td[" + reqNum1 + "]/div/span/span"))
						.getText();

				Assert.assertEquals(act_data, exp_data);
				break;
			}
		}
	}

	public static void mouseActions(WebDriver driver, String locatorType, String locatorValue) {
		Actions action = new Actions(driver);

		if (locatorType.equalsIgnoreCase("id")) {
			action.moveToElement(driver.findElement(By.id(locatorValue))).build().perform();
		} else if (locatorType.equalsIgnoreCase("xpath")) {

			action.moveToElement(driver.findElement(By.xpath(locatorValue))).build().perform();
		} else if (locatorType.equalsIgnoreCase("name")) {
			action.moveToElement(driver.findElement(By.name(locatorValue))).build().perform();
		}
	}

	public static void multiWindow(WebDriver driver, String locatorType, String locatorValue, String tabURL) {
		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		 * 
		 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 * System.out.println(tabs.size()+"---->   Tabs ");
		 * driver.switchTo().window(tabs.get(1)); //switches to new tab
		 * driver.get(tabURL);
		 */

		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size() + "---->   Tabs ");
		driver.switchTo().window(tabs.get(1));
		driver.get(tabURL);

	}

	public static void closeNewTab(WebDriver driver, String locatorType, String locatorValue, String tabURL) {
		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		 * 
		 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 * System.out.println(tabs.size()+"---->   Tabs ");
		 * driver.switchTo().window(tabs.get(1)); //switches to new tab
		 * driver.get(tabURL);
		 */

		// ((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size() + "---->   Tabs ");

		driver.switchTo().window(tabs.get(1)).close();

		driver.switchTo().window(tabs.get(0));

	}

	public static void close(WebDriver driver, String locatorType, String locatorValue, String tabURL) {
		/*
		 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		 * 
		 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 * System.out.println(tabs.size()+"---->   Tabs ");
		 * driver.switchTo().window(tabs.get(1)); //switches to new tab
		 * driver.get(tabURL);
		 */

		// ((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size() + "---->   Tabs ");

		driver.switchTo().window(tabs.get(0)).close();

	}

	public static void movetoiFrame(WebDriver driver) {
		// TODO Auto-generated method stub
		driver.switchTo().frame(0);
	}

	/*
	 * public static void iFrametoDefault(WebDriver driver) { // TODO Auto-generated
	 * method stub driver.switchTo().defaultContent(); }
	 */

	public static void iFrametoDefault(WebDriver driver) {

		driver.switchTo().defaultContent();

	}

	public static void username(WebDriver driver, String locator_Type, String locator_Value, String test_Data) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		String username = "Snehal" + new Random().nextInt(1000);
	}

	public static void takeAccountNumber(WebDriver driver, String locatorType, String locatorValue, String textData)
			throws Exception {

		String act_Text = null;
		String neededText = null;

		if (locatorType.equalsIgnoreCase("id")) {

			WebElement webelement = driver.findElement(By.id(locatorType));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[2]);

						neededText = messageData[2];

						PropertyFileUtil.insetValueForreferenceID(textData, neededText);

						System.out.println("insert text in Prop in FL" + neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			WebElement webelement = driver.findElement(By.xpath(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[2]);

						neededText = messageData[2];

						PropertyFileUtil.insetValueForreferenceID(textData, neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		} else if (locatorType.equalsIgnoreCase("name")) {
			WebElement webelement = driver.findElement(By.name(locatorValue));

			try {

				for (int m = 0; m < 20; m++) {
					try {
						act_Text = webelement.getText();

						String[] messageData = act_Text.split(" ");

						for (int i = 0; i < messageData.length; i++) {

							// System.out.println(messageData[i]);

						}

						System.out.println(messageData[40]);

						neededText = messageData[40];

						PropertyFileUtil.insetValueForreferenceID(textData, neededText);

						break;
					} catch (Exception e) {
						Thread.sleep(1000);
					}
				}

			} catch (Exception e) {

				throw e;

			}

		}

		// System.out.println(act_Text+" "+ exp_Text);

		// Assert.assertEquals(act_Text, exp_Text);

	}

	public static void DataBaseValidation() {

		String CUSTOMERID = null;
		// String allowAtmTxns = null;

		// String allowPosTxns = null;
		// String allowEposTxns = null;

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			System.out.println("Loading");

			Thread.sleep(3000);

			// Local QA DB
			// Connection con =
			// DriverManager.getConnection("jdbc:sqlserver://192.168.50.203:1433;DatabaseName=CTRMA_QA","devuser","devuser");
			// "jdbc:mysql://10.10.8.30:49397/paycentral","wcuser","wcuser@123");

			Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.50.219:1433;DatabaseName=NTTA_QA",
					"nttaappuser", "Ntt@Us3r");
			// "jdbc:mysql://10.10.8.30:49397/paycentral","wcuser","wcuser@123");
			System.out.println("Connections");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();

			// Email Verification
			// SELECT * FROM VerificationCode WHERE deviceID='demobsbch5@yopmail.com'
			// SELECT * FROM UserCardPreference WHERE card_id IN (SELECT id FROM Card WHERE
			// user_id=16887760)
			ResultSet rs = stmt.executeQuery("Select * from tollplus.tp_customers where CUSTOMERID='"
					+ PropertyFileUtil.getValueForKey("AccountNumber") + "'");

			System.out.println("Query Excution");

			while (rs.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

				CUSTOMERID = rs.getString("CustomerID");

				System.out.println(CUSTOMERID + " CUSTOMERID   ");

				PropertyFileUtil.insetValueForKey("CustomerID", CUSTOMERID);

				/*
				 * allowEposTxns=rs.getNString("allowEposTxns");
				 * 
				 * System.out.println(allowEposTxns+ " allowEposTxns   ");
				 * 
				 * PropertyFileUtil.insetValueForKey("allowEposTxns", allowEposTxns);
				 * 
				 * allowPosTxns=rs.getNString("allowPosTxns");
				 * 
				 * System.out.println(allowPosTxns+ " allowPosTxns   ");
				 * 
				 * PropertyFileUtil.insetValueForKey("allowPosTxns", allowPosTxns);
				 */

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}

	}

	public static void dbPBMAccountNumber() {

		String VIOLATORID = null;

		// String allowPosTxns = null;
		// String allowEposTxns = null;
		// VIOLATORID

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("Loading");

			Thread.sleep(3000);

			// Local QA---
			Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.50.203:1433;DatabaseName=CTRMA_QA","devuser","devuser");

		//	Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.50.219:1433;DatabaseName=NTTA_QA","nttaappuser", "Ntt@Us3r");
			// "jdbc:mysql://10.10.8.30:49397/paycentral","wcuser","wcuser@123");
			System.out.println("Connections");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"Select Top 1 * from TOLLPLUS.TP_VIOLATEDTRIPS where  CITATIONSTAGE='INVOICE' and CITATIONSTATUS='init' and VIOLATORID != 10246334");

			System.out.println("Query Excution");
			while (rs.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

				VIOLATORID = rs.getString("ViolatorID");

				PropertyFileUtil.insetValueForKey("ViolatorID", VIOLATORID);

				System.out.println(VIOLATORID);

				/*
				 * CUSTOMERID=rs.getString("CustomerID");
				 * 
				 * System.out.println(CUSTOMERID+ " CUSTOMERID   ");
				 * 
				 * PropertyFileUtil.insetValueForKey("CustomerID", CUSTOMERID);
				 */

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}

	}

	

	public static void getInvoiceNumber() {

		String INVOICENUMBER = null;

		// String allowPosTxns = null;
		// String allowEposTxns = null;
		// VIOLATORID

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("Loading");

			Thread.sleep(3000);

			// Local QA--- 
			Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.50.203:1433;DatabaseName=CTRMA_QA","devuser","devuser");

			//Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.50.219:1433;DatabaseName=NTTA_QA","nttaappuser", "Ntt@Us3r");
			// "jdbc:mysql://10.10.8.30:49397/paycentral","wcuser","wcuser@123");
			System.out.println("Connections");
			// here sonoo is database name, root is username and password
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"select Top 1 * from TOLLPLUS.INVOICE_HEADER (nolock)");

			System.out.println("Query Excution");
			while (rs.next()) {
				// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));

				INVOICENUMBER = rs.getString("InvoiceNumber");

				PropertyFileUtil.insetValueForKey("InvoiceNumber", INVOICENUMBER);

				System.out.println(INVOICENUMBER);

				/*
				 * CUSTOMERID=rs.getString("CustomerID");
				 * 
				 * System.out.println(CUSTOMERID+ " CUSTOMERID   ");
				 * 
				 * PropertyFileUtil.insetValueForKey("CustomerID", CUSTOMERID);
				 */

			}

			con.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println(e.getStackTrace());

			System.out.println(e.getMessage());
		}

	}

	public static void disputefileUpload(WebDriver driver, String autoitPath) throws IOException {
		// TODO Auto-generated method stub
		
		Runtime.getRuntime().exec(autoitPath);
		
	}

	

	

	/*
	 * public static void movetoiFrame(WebDriver driver)
	 * 
	 * { driver.switchTo().frame(0);
	 * 
	 * //driver.switchTo().defaultContent(); }
	 * 
	 * public static void comebackiFrame(WebDriver driver)
	 * 
	 * { //driver.switchTo().frame(0);
	 * 
	 * driver.switchTo().defaultContent(); }
	 */

	/*
	 * public static void conditionValidation(WebDriver driver, String locatorType,
	 * String locatorValue, String textData) throws Exception { String act_Text =
	 * null;
	 * 
	 * String exp_Text=textData;
	 * 
	 * 
	 * if(locatorType.equalsIgnoreCase("id")) {
	 * act_Text=driver.findElement(By.id(locatorValue)).getText(); } else
	 * if(locatorType.equalsIgnoreCase("xpath")) {
	 * act_Text=driver.findElement(By.xpath(locatorValue)).getText(); } else
	 * if(locatorType.equalsIgnoreCase("name")) {
	 * act_Text=driver.findElement(By.name(locatorValue)).getText(); }
	 * 
	 * 
	 * 
	 * if (!act_Text.equalsIgnoreCase(exp_Text)) {
	 * 
	 * int min = 0, max = 9999999;
	 * 
	 * Thread.sleep(3000);
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Second_OK"))).
	 * click();
	 * 
	 * int randomNum = min + (int)(Math.random() * max);
	 * 
	 * String duplicateData = String.valueOf(randomNum);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("UOM_ID"))).clear
	 * ();
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("UOM_Desc"))).
	 * clear();
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("UOM_ID"))).
	 * sendKeys(duplicateData);
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("UOM_Desc"))).
	 * sendKeys("shjhjh");
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Add_Button"))).
	 * click();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("First_OK"))).
	 * click();
	 * 
	 * driver.findElement(By.xpath(PropertyFileUtil.getValueForKey("Second_OK"))).
	 * click(); } }
	 */
}