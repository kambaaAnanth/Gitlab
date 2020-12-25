package com.gitlab.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyingRegisterSuccessWhenWithoutEnterData {

	public WebDriver driver;

	@Test
	public void verifyingRegisterSuccessWhenWithoutEnterData() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32(V_86)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://gitlab.com/users/sign_up");

		WebElement register_Button = driver.findElement(
				By.xpath("//body/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[9]/input[1]"));

		register_Button.click();

		String expected_Data = driver.findElement(By.xpath("//label[contains(text(),'First name')]")).getText();

		String actual_Data = "First name";

		Assert.assertEquals(actual_Data, expected_Data);

	}

}
