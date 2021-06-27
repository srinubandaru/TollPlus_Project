
package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtil 
{
	public static String getValueForKey(String key) throws Exception
	{
		
		Properties configProporties=new Properties();
		
		configProporties.load(new FileInputStream(new File("./PropertiesFile/Environment.properties")));
		
		int randomNum =  (int)(Math.random() * 100000); 
		
		String duplicateData = String.valueOf(randomNum);
		
		String randomEmailCH="SnehalCH"+duplicateData+"@yopmail.com";
		
		String randomEmail="Snehal"+duplicateData+"@yopmail.com";
		
		String randomUserName= "Snehal"+duplicateData+"Babu";
		
		String randomNumberPlate= "TS"+duplicateData+"99";
		
		String CustomerID= "CUSTOMERID";
		String ViolatorID= "VIOLATORID";
		String InvoiceNumber= "INVOICENUMBER";
		
		
		
		
		insetValueForKey("PayeeID", duplicateData);
		insetValueForKey("CUSTOMERID", CustomerID);
		
		insetValueForKey("INVOICENUMBER", InvoiceNumber);
		
		insetValueForKey("VIOLATORID", ViolatorID);
			
		insetValueForKey("RandomMailCH", randomEmailCH);
		
		insetValueForKey("RandomMail", randomEmail);
		
		insetValueForKey("RandomUserName", randomUserName);
		
		insetValueForKey("RandomNumberPlate", randomNumberPlate);
		
		
		
		
		return configProporties.getProperty(key);
		
	}
	
	
	
	
	
	
	public static void insetValueForKey(String newKey,String valueText) throws Exception
	{
		
		Properties insertProp=new Properties();
		
		
		insertProp.load(new FileInputStream(new File("./PropertiesFile/Environment.properties")));
		insertProp.setProperty(newKey,valueText);
		
		//System.out.println(newKey+"  "+valueText  +"  in Property class");
		
		insertProp.store(new FileOutputStream("./PropertiesFile/Environment.properties"), "Inserting Card Holder UserID");
		
		
	}
	
	public static void insetValueForreferenceID(String newKey,String valueText) throws Exception
	{
		
		Properties insertProp=new Properties();
		
		
		insertProp.load(new FileInputStream(new File("./PropertiesFile/Environment.properties")));
		insertProp.setProperty(newKey,valueText);
		
		System.out.println(newKey+"  "+valueText  +"  in Property class");
		
		insertProp.store(new FileOutputStream("./PropertiesFile/Environment.properties"), "Inserting referenceID");
		
		
	}
	

	public static void insetValueForAccountNumber(String newKey,String valueText) throws Exception
	{
		
		Properties insertProp=new Properties();
		
		
		insertProp.load(new FileInputStream(new File("./PropertiesFile/Environment.properties")));
		insertProp.setProperty(newKey,valueText);
		
		System.out.println(newKey+"  "+valueText  +"  in Property class");
		
		insertProp.store(new FileOutputStream("./PropertiesFile/Environment.properties"), "Inserting AccountNumber");
		
		
	}
}



