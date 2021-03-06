package com.experitest.auto;

import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDemoTest4 extends BaseTest {
	protected IOSDriver<IOSElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception {
		init(deviceQuery);
		// Init application / device capabilities
		dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");

		dc.setCapability("testName", "IOSDemoTest");
		driver = new IOSDriver<>(new URL(getProperty("url",cloudProperties) + "/wd/hub"), dc);
	}

	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@accessibilityLabel='usernameTextField']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@accessibilityLabel='passwordTextField']")).sendKeys("company");
		driver.findElement(By.xpath("//*[@text='loginButton']")).click();


	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
