package com.gitlab.Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyingRegisterSuccessOrNotWhenEnterInvlidFormatEmail {

	public WebDriver driver;
@Test
	public void verifyingRegisterSuccessOrNotWhenEnterInvlidFormatEmail() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32(V_86)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://gitlab.com/users/sign_up");

		WebElement firstName = driver.findElement(By.xpath("//input[@id='new_user_first_name']"));

		firstName.sendKeys("Sample");

		WebElement lastName = driver.findElement(By.xpath("//input[@id='new_user_last_name']"));

		lastName.sendKeys("Testing");

		WebElement userName = driver.findElement(By.xpath("//input[@id='new_user_username']"));

		userName.sendKeys("SmapleTesting");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='new_user_email']"));

		email.sendKeys("testgmailcom");


		WebElement password = driver.findElement(By.xpath("//input[@id='new_user_password']"));

		password.sendKeys("Test@1234");

		WebElement registerButton = driver.findElement(By.xpath("//body/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[9]/input[1]"));

		registerButton.click();
		
		//Madam we cannot Handle captcha using selenium i have created gitlab login manually for testing
	}

}
