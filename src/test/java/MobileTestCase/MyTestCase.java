package MobileTestCase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.management.DescriptorAccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MyTestCase {

	AndroidDriver driver;

	DesiredCapabilities caps = new DesiredCapabilities();

	Random rand = new Random();

	@BeforeTest

	public void Setup() {

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ABC");
		File MyApp = new File("src/test/java/Calculator/calculator.apk");

		caps.setCapability(MobileCapabilityType.APP, MyApp.getAbsolutePath());

	}

	@BeforeMethod
	public void ThisPartStartsBeforeEaceTest() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

	}

	@Test(priority = 1, description = "multiply 2 numbers", groups = "happy", enabled = false)

	public void MyTest() {

		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();

		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();

		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

	}

	@Test(priority = 2, enabled = false)

	public void ClickNumberOnly() {

		List<WebElement> ClickAllButton = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < ClickAllButton.size(); i = i + 1) {

			if (ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit"))

				ClickAllButton.get(i).click();

		}

		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();

		driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();

		String Result = driver.findElement(By.id("com.google.android.calculator:id/formula")).getText();
		System.out.println(Result);
		String ExpectedResult = "7894561230×1";
		org.testng.Assert.assertEquals(Result, ExpectedResult);
	}

	@Test(priority = 3, enabled = false)

	public void ClickOddNumberOnly() {

		List<WebElement> ClickAllButton = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < ClickAllButton.size(); i++) {

			if (ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_7")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_9")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_5")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_1")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_3"))

				ClickAllButton.get(i).click();

		}

	}

	@Test(priority = 4, enabled = false)

	public void ClickEvenNumberOnly() {

		List<WebElement> ClickAllButton = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < ClickAllButton.size(); i++) {

			if (ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_8")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_6")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_4")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_2")
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains("digit_0"))

				ClickAllButton.get(i).click();

		}

	}

	@Test(priority = 5)

	public void ClickInTwoRandomNumber() {

		rand.nextInt(0, 10);

		String FirstNumber = Integer.toString(rand.nextInt(0, 10));

		String SecondNumber = Integer.toString(rand.nextInt(0, 10));

		System.out.println(FirstNumber);

		System.out.println(SecondNumber);

		List<WebElement> ClickAllButton = driver.findElements(By.className("android.widget.ImageButton"));

		for (int i = 0; i < ClickAllButton.size(); i++) {

			if (ClickAllButton.get(i).getDomAttribute("resource-id").contains(FirstNumber)
					|| ClickAllButton.get(i).getDomAttribute("resource-id").contains(SecondNumber))
			
			{
				
			ClickAllButton.get(i).click();

			driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
			
			}
			
			
			if (ClickAllButton.get(i).getDomAttribute("resource-id").contains(SecondNumber)||
					ClickAllButton.get(i).getDomAttribute("resource-id").contains(FirstNumber)) {

				ClickAllButton.get(i).click();
			}
		}
			
		
		
		

	}

	@AfterTest

	public void AfterMyTest() {

	}

}
