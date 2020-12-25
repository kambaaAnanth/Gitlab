package com.gitlab.NewGitLabProjectCreate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreatingNewProject {

	public WebDriver driver;
	
	@Test
	public void creatingNewProject() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32(V_86)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://gitlab.com/users/sign_in#register-pane");

		WebElement validEmail = driver.findElement(By.xpath("//input[@id='user_login']"));

		validEmail.sendKeys("ananthtesting96@gmail.com");

		WebElement validPassword = driver.findElement(By.xpath("//input[@id='user_password']"));

		validPassword.sendKeys("Test@1234");

		WebElement signin_Button = driver.findElement(By.xpath(
				"//body/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[5]/input[1]"));

		signin_Button.click();

		String expeted_Data = driver.findElement(By.xpath("//label[contains(text(),'Username or email')]")).getText();

		String actual_Data = "Username or email";

		Assert.assertNotEquals(actual_Data, expeted_Data);

		driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);

		WebElement ClickNewProjectDropDown = driver
				.findElement(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/*[2]"));

		ClickNewProjectDropDown.click();

		WebElement ClickNewProjectLink = driver
				.findElement(By.xpath("//header/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/ul[1]/li[1]"));

		Actions action = new Actions(driver);

		action.moveToElement(ClickNewProjectLink).click().build().perform();

		WebElement ClickCreateNewBlankProject = driver.findElement(By.xpath(
				"//body[1]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/a[1]/div[1]/svg[1]/g[1]/g[1]/g[1]/g[1]/circle[1]"));

		Actions action1 = new Actions(driver);

		action1.moveToElement(ClickCreateNewBlankProject).click().build().perform();

		WebElement projectName = driver.findElement(By.xpath(
				"//body/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]"));

		projectName.sendKeys("GitLab");

		WebElement projectSlug = driver.findElement(By.xpath(
				"//body/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[3]/input[1]"));

		projectSlug.sendKeys("GitLab");

		WebElement clickPrivate = driver.findElement(By.xpath(
				"//body/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/div[4]/div[2]/input[1]"));

		clickPrivate.click();

		WebElement clickCreateProject = driver.findElement(
				By.xpath("//body/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/form[1]/input[3]"));

		clickCreateProject.click();

	}
}
