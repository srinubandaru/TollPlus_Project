package DriverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonFuncLibrary.FunctionLibrary;
import Utilities.ExcelFileUtil;



public class DriverScript 
{
	public static WebDriver driver;
	//// Open Appliaction for PAN and CVV
	//WebDriver dr1;
	//ExtentReports report;
	
	ExtentReports extent ;


	ExtentHtmlReporter report;
	//Extentreports will create html report
	ExtentTest logger;
	
	
	//To create logs in html (pass or fail )
	
	//Driver SCript will drive total framework (Reading excel data and performing operations and generating html report, excel result ex PASS oR Fail)
    
	public void startTest() throws Exception
	{
		ExcelFileUtil excel = new ExcelFileUtil();
		
		for (int i = 1; i <=excel.rowCount("MasterTestCases"); i++) 
		{	
			String ModuleStatus = null;
			
			
			if (excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y")) 
			{			
				// Define Module Name
				String TCModule=excel.getData("MasterTestCases", i, 1);	
				
				  //extent= new ExtentReports();
				
				//report = new ExtentReports("./Reports/"+TCModule+".html "+ FunctionLibrary.getRandomNumberFromDate());
				//  report = new ExtentHtmlReporter("./Reports/"+TCModule+".html " + FunctionLibrary.getRandomNumberFromDate());
				  
				  report = new ExtentHtmlReporter("./Reports/"+TCModule+"_"+FunctionLibrary.getRandomNumberFromDate()+".html");
				  
				  //report.config().setCreateOfflineReport(true);
				  extent= new ExtentReports();
				  extent.attachReporter(report);
				  
				 // extent.config().setCreateOfflineReport(true);
				  
				  
				 
				
			
				// logger = report.startTest(TCModule);
				 
				logger = extent.createTest(TCModule);
				
				
				
				int rowcount = excel.rowCount(TCModule);
				
				for(int j=1;j<=rowcount;j++)
				{
					String Description = excel.getData(TCModule, j, 0);
					String Object_Type = excel.getData(TCModule, j, 1);
					String Locator_Type = excel.getData(TCModule, j, 2);
					String Locator_Value = excel.getData(TCModule, j, 3);
					String Test_Data = excel.getData(TCModule, j, 4); 
					
					
				 try 
				 {						
								
					if(Object_Type.equalsIgnoreCase("Browser"))
					{
						driver=FunctionLibrary.startBrowser(driver);
						
						//(3)
						//driver=FunctionLibrary.startBrowser(driver, Test_Data);
						
						//logger.log(Status.INFO, Description);
						
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("openApp"))
					{
						FunctionLibrary.openApplication(driver,Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					
					if(Object_Type.equalsIgnoreCase("typeText"))
					{
						//FunctionLibrary.highLighterMethod(driver, Locator_Type, Locator_Type, Test_Data);
						FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
						
						
						
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("SelectDropDown"))
					{
						FunctionLibrary.SelectDropDown(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					
					
					/*if(Object_Type.equalsIgnoreCase("clearText"))
					{
						FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					*/
					

					/*if(Object_Type.equalsIgnoreCase("pagination"))
					{
						FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}*/
					
					
					
					
					if(Object_Type.equalsIgnoreCase("typeAction_key"))
					{
						FunctionLibrary.typeAction_key(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("selectAction"))
					{
						FunctionLibrary.selectAction(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("click"))
					{
						FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
						//FunctionLibrary.highLighterMethod(driver, Locator_Type, Locator_Type, Test_Data);
						logger.log(Status.INFO, Description);
					}	
					
					if(Object_Type.equalsIgnoreCase("movetoiFrame"))
					{
						FunctionLibrary.movetoiFrame(driver);
						logger.log(Status.INFO, Description);
					}
					if(Object_Type.equalsIgnoreCase("iFrametoDefault"))
					{
						FunctionLibrary.iFrametoDefault(driver);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("titleValidate"))
					{
						FunctionLibrary.titleValidation(driver,Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("elementValidate"))
					{
						FunctionLibrary.elementValidation(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("waitElement"))
					{
						//FunctionLibrary.highLighterMethod(driver, Locator_Type, Locator_Type, Test_Data);
						FunctionLibrary.waitforelement(driver, Locator_Type, Locator_Value, Test_Data);
						
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("waitforClick"))
					{
						FunctionLibrary.waitforClick(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("clicks"))
					{
						FunctionLibrary.clicks(driver, Locator_Type, Locator_Value, Test_Data);
						//FunctionLibrary.highLighterMethod(driver, Locator_Type, Locator_Type, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					
					if(Object_Type.equalsIgnoreCase("closeApp"))
					{
						FunctionLibrary.closeBrowser(driver);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("pageScrollDown"))
					{
						FunctionLibrary.pageScrollDown(driver);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("pageScrollUP"))
					{
						FunctionLibrary.pageScrollUP(driver);
						logger.log(Status.INFO, Description);
					}
					
					
					if(Object_Type.equalsIgnoreCase("mouseOver"))
					{
						FunctionLibrary.mouseActions(driver, Locator_Type, Locator_Value);
						logger.log(Status.INFO, Description);
					}
					
					
					if(Object_Type.equalsIgnoreCase("takeText"))
					{
						FunctionLibrary.takeText(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("takeAccountNumber"))
					{
						FunctionLibrary.takeAccountNumber(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("takeReferenceID"))
					{
						FunctionLibrary.takeReferenceID(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					
					if(Object_Type.equalsIgnoreCase("tableValidation"))
					{
						System.out.println("tableValidation in Driver Script ");
						
						FunctionLibrary.tableValidation(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("searchText"))
					{
						System.out.println("tableValidation in Driver Script ");
						
						FunctionLibrary.searchText(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("DBValidation"))
					{
						System.out.println("DBValidation in Driver Script ");
						
						FunctionLibrary.DBValidation();
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("DataBaseValidation"))
					{
						System.out.println("DataBaseValidation in Driver Script ");
						
						FunctionLibrary.DataBaseValidation();
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("dBEmailValidation"))
					{
						System.out.println("dBEmailValidation in Driver Script ");
						
						FunctionLibrary.dBEmailValidation();
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("dBMobileValidation"))
					{
						System.out.println("dBMobileValidation in Driver Script ");
						
						FunctionLibrary.dBEmailValidation();
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("dbPBMAccountNumber"))
					{
						System.out.println("dbPBMAccountNumber in Driver Script ");
						
						FunctionLibrary.dbPBMAccountNumber();
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("getInvoiceNumber"))
					{
						System.out.println("getInvoiceNumber in Driver Script ");
						
						FunctionLibrary.getInvoiceNumber();
						logger.log(Status.INFO, Description);
					}
					
/*//Continue Click in BackOffice
					
					if(Object_Type.equalsIgnoreCase("tableElementClick"))
					{
						FunctionLibrary.tableEleClick(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					*/
					
					
					if(Object_Type.equalsIgnoreCase("currentDateSelection"))
					{
						FunctionLibrary.currentDateSelection(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("fileUpload"))
					{
						FunctionLibrary.fileUpload(driver, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("disputefileUpload"))
					{
						FunctionLibrary.disputefileUpload(driver, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
									if(Object_Type.equalsIgnoreCase("multiWindow"))
					{
						FunctionLibrary.multiWindow(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("closeNewTab"))
					{
						FunctionLibrary.closeNewTab(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("webEleValidate"))
					{
						FunctionLibrary.webEleValidate(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					if(Object_Type.equalsIgnoreCase("username"))
					{
						FunctionLibrary.username(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					
					
					if(Object_Type.equalsIgnoreCase("textValidation"))
					{
						FunctionLibrary.textValidation(driver, Locator_Type, Locator_Value, Test_Data);
						logger.log(Status.INFO, Description);
					}
					
					
				
					excel.setData(TCModule, j, 5, "Pass");	
					
					ModuleStatus="true";
					
					logger.log(Status.PASS, Description + " Pass");
					
					
					// For PASS ScreenSHots
					/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					String imagePath="./Screenshots/FailedScreens/"+" "+Description+"_"+FunctionLibrary.getRandomNumberFromDate()+".png";
					
					File imageFile=new File(imagePath);
					
					FileUtils.copyFile(scrFile, imageFile);
						// Add Screenshot image into Extent Report
						
						//String image = logger.addScreenCapture("./Screenshots/PassedScreens/"+" "+Description+"_"+FunctionLibrary.getRandomNumberFromDate()+".jpg");
						Thread.sleep(1000);
						MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(imageFile.getCanonicalPath()).build();
						
						logger.log(Status.PASS, TCModule, mediaModel);*/
						
						
						//logger.log(Status.PASS, TCModule, image);
					
					
						
					
					
				}
				 //New Code for PASS------------------------------
				 
				 
				
				 
				 
				 
				 
				 //New Code for PASS----
				
				catch(Exception e)
				{
					excel.setData(TCModule, j, 5, "Fail");						
					
					ModuleStatus="False";
					
					logger.log(Status.FAIL, Description + " Fail");
					
					try {
						FunctionLibrary.highLighterMethod(driver, Locator_Type, Locator_Value, Test_Data);
						
					} catch (Exception e2) {
						System.out.println("Screenshot Hilight issue :"+e2);
					}
					
					
					// For Generating Screenshot
					 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					String imagePath="./Screenshots/FailedScreens/"+" "+Description+"_"+FunctionLibrary.getRandomNumberFromDate()+".png";
					
                    File imageFile=new File(imagePath);
					
					FileUtils.copyFile(scrFile, imageFile);
					
					//FileUtils.copyFile(scrFile, new File(imagePath));
					
					// Add Screenshot image into Extent Report
					
					// String image = logger.addScreenCapture("./Screenshots/FailedScreens/"+" "+Description+"_"+FunctionLibrary.getRandomNumberFromDate()+".jpg");
					
					// logger.log(LogStatus.FAIL, TCModule, image);
					
					Thread.sleep(1000);
					
					MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(imageFile.getCanonicalPath()).build();
					
					logger.log(Status.FAIL, TCModule, mediaModel);
					
					System.out.println("Driver Script Exception Error Message: "+e);
					
					//to continue the script even it is FAIL
					
					
					break;					
				}
				
				catch(AssertionError a)
				{
					excel.setData(TCModule, j, 5, "Fail");						
						
					ModuleStatus="False";
						
					logger.log(Status.FAIL, Description + " Fail");
						
					// For Generating Screenshot
						
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					
					String imagePath="./Screenshots/FailedScreens/"+" "+Description+"_"+FunctionLibrary.getRandomNumberFromDate()+".png";
						
					
					 File imageFile=new File(imagePath);
						
				    FileUtils.copyFile(scrFile, imageFile);
					//FileUtils.copyFile(scrFile, new File(imagePath));
						
					// Add Screenshot image into Extent Report
						
					// String image = logger.addScreenCapture("./Screenshots/"+" "+Description+"_"+FunctionLibrary.getRandomNumberFromDate()+".jpg");
						
					// logger.log(LogStatus.FAIL, TCModule, image);
					
					Thread.sleep(1000);
					
					MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(imageFile.getCanonicalPath()).build();
					
					logger.log(Status.FAIL, TCModule, mediaModel);
					
					//to continue the script even it is FAIL
					break;	
				}
					
			  }
				
				if(ModuleStatus.equalsIgnoreCase("true"))
				{
					excel.setData("MasterTestCases", i, 3, "Pass");
				}
				else
				{
					excel.setData("MasterTestCases", i, 3, "Fail");
				}				
		    }
			else 
			{		
				excel.setData("MasterTestCases", i, 3, "Not Executed");
			}
			
			
			try {
				System.out.println("Report in catch block logger");
				
				//report.endTest(logger);
				
				//extent.removeTest(logger);
				
				report.stop();
				
				report.flush();	
				extent.flush();
				
			} catch (Exception e2) {
				
				System.out.println("Report Flushing : "+e2);
				
			}
			
					
		}
	}
}