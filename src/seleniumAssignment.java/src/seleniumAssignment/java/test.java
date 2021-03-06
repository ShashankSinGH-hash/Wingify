/**
 * 
 */
package seleniumAssignment.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Shashank
 *
 */
public class test {

	/**
	 * @param args
	 */
	
    static boolean arraySortedOrNot(double arr[], int n)
    {
        // Array has one or no element
        if (n == 0 || n == 1)
            return true;
        for (int i = 1; i < n; i++)
            // Unsorted pair found
            if (arr[i - 1] > arr[i])
                return false;
        // No unsorted pair found
        return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Login
		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.findElement(By.id("username")).sendKeys("Shashank");
		driver.findElement(By.id("password")).sendKeys("Admin@123");
		driver.findElement(By.id("log-in")).click();
	
		// Home Page
		driver.findElement(By.id("amount")).click();
		// Enetring all amounts to list
		List<WebElement> amounts = driver.findElements(By.className("text-right"));
		
		//checking for sort
		
		amounts.remove(0);
		double arr[]= new double[amounts.size()];
		int c=0;
		for (WebElement amount : amounts) {
			String amt = (amount.getText()).replace(",", "");
            double numAmount = Double.parseDouble(amt.substring(0,1)+amt.substring(2,amt.indexOf("U")-1));
            arr[c++]=numAmount;
        }
		
		if(arraySortedOrNot(arr, arr.length) == true) System.out.println("SORTED");
		else System.out.println("NOT SORTED");
	}

}
