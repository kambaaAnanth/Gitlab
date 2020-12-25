package com.gitlab.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnterInvalidEmailAndValidPassword {
	
	public WebDriver driver;
@Test
	public void enterValidEmailAndInvalidPassword() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32(V_86)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://gitlab.com/users/sign_in#register-pane");

		WebElement invalidEmail = driver.findElement(By.xpath("//input[@id='user_login']"));

		invalidEmail.sendKeys("ananthtesting86@gmail.com");

		WebElement validPassword = driver.findElement(By.xpath("//input[@id='user_password']"));

		validPassword.sendKeys("Test@1234");

		WebElement signin_Button = driver.findElement(By.xpath(
				"//body/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/input[1]"));

		signin_Button.click();

		String expeted_Data = driver.findElement(By.xpath("//label[contains(text(),'Username or email')]")).getText();

		String actual_Data = "Username or email";

		Assert.assertEquals(actual_Data, expeted_Data);
	}

}
