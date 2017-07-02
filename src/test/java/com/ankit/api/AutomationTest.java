package com.ankit.api;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class AutomationTest {

	WebDriver driver = new FirefoxDriver();

	@Test
	public void visitIndexPage() throws Exception {

		driver.get("http://localhost:8080/");
		WebElement working = driver.findElement(By.id("News-form"));

		Assert.assertThat(working.getText(), is(equalTo("News")));
		driver.quit();
	}

}
