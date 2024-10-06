package hybridApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class KhanAcademy_APP extends KhanAcademyApp_Capabilities {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		driver = cap();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void explore() throws InterruptedException {

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();

		// Click on Explore/Search icon
		driver.findElement(MobileBy.AccessibilityId("Search tab")).click();

		// Click on computing Subject //
		// driver.findElements(MobileBy.className("android.widget.Button")).get(6).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Computing\")")).click();

		// Then Click on Computer Science theory topic //
		// driver.findElements(MobileBy.className("android.widget.Button")).get(0).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Computer science theory\")")).click();

		// Then Click on Cryptography topic
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Cryptography\")")).click();
	}

	@Test(priority = 2)
	public void bookmarks() throws InterruptedException {

		// Bookmark 3 Topics: Ancient Cryptography,Cryptography Challenge 101 and
		// Modular Arithmetic

		// Ancient Cryptography bookmark
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(0).click();

		// click on Got it button
		driver.findElement(MobileBy.id("android:id/button2")).click();

		// Cryptography Challenge 101 bookmark

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"Cryptography challenge 101\"))"));
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(7).click();

		// Modular Arithmetic
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"Modular arithmetic\"))"));

		driver.findElements(MobileBy.className("android.widget.ImageView")).get(6).click();

	}

	@Test(priority = 3)
	public void computerScience() throws InterruptedException {

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Thread.sleep(3000);
		// text = Information theory
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Information theory\")")).click();

		// scroll down and bookmark Modern Information Theory
		// Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"Modern information theory\"))"));
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(10).click();

	}

	@Test(priority = 4)
	public void checkallBookmarks() throws InterruptedException {

		// accessibility id = Bookmarks tab

		driver.findElement(MobileBy.AccessibilityId("Bookmarks tab")).click();

		// assert all the bookmarks are present or not

		// Ancient cryptography bookmark
		Thread.sleep(2000);
		String actualBM1Text = driver
				.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Ancient cryptography\")")).getText();

		String expectedBM1Text = "Ancient cryptography";
		Assert.assertEquals(actualBM1Text, expectedBM1Text);
		System.out.println(actualBM1Text);

		// Cryptography challenge 101 bookmark
		Thread.sleep(2000);
		String actualBM2Text = driver
				.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Cryptography challenge 101\")"))
				.getText();

		String expectedBM2Text = "Cryptography challenge 101";
		Assert.assertEquals(actualBM2Text, expectedBM2Text);
		System.out.println(actualBM2Text);

		// Modular arithmetic bookmark
		Thread.sleep(2000);
		String actualBM3Text = driver
				.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Modular arithmetic\")")).getText();

		String expectedBM3Text = "Modular arithmetic";
		Assert.assertEquals(actualBM3Text, expectedBM3Text);
		System.out.println(actualBM3Text);

		// Modern information theory bookmark
		Thread.sleep(2000);
		String actualBM4Text = driver
				.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Modern information theory\")")).getText();
		String expectedBM4Text = "Modern information theory";

		Assert.assertEquals(actualBM4Text, expectedBM4Text);
		System.out.println(actualBM4Text);

	}

	@Test(priority = 5)
	public void clearallBookmarks() throws InterruptedException {

		// click on edit- text = Edit
		Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Edit\")")).click();

		// select all the check boxes - classname = android.widget.Button(use

		driver.findElements(MobileBy.className("android.widget.Button")).get(1).click();

		driver.findElements(MobileBy.className("android.widget.Button")).get(2).click();
		driver.findElements(MobileBy.className("android.widget.Button")).get(3).click();
		driver.findElements(MobileBy.className("android.widget.Button")).get(4).click();

		// to delete all the bookmarks use either classname
		// =android.view.ViewGroup(index=2) or text = Delete
		// driver.findElements(MobileBy.className("android.view.ViewGroup")).get(2).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Delete\")")).click();

	}

	@Test(priority = 6)
	public void lifeSkills() throws InterruptedException {

		// Click on Explore/Search icon

		Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Search tab")).click();
		driver.findElement(MobileBy.AccessibilityId("Search tab")).click();

		// choose the topic life skills

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Life skills\")")).click();

		// select or click on financial literacy subject
		driver.findElement(MobileBy.AccessibilityId("Financial Literacy")).click();

		// click on the first topic
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Welcome to Financial Literacy\")")).click();

		// play the first session video
		driver.findElements(MobileBy.className("android.widget.Button")).get(1).click();

		// To close the video
		// driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();

		// tap on home icon accessibility id = Explore tab
		driver.findElement(MobileBy.AccessibilityId("Explore tab")).click();

		// assert text = Recent lessons
		String actualText = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Recent lessons\")"))
				.getText();
		String expectedText = "Recent lessons";

		Assert.assertEquals(actualText, expectedText);
		System.out.println(actualText);

		// assert if that topic is present in the homepage or not text = Intro to
		// Financial Literacy
		String actualText2 = driver
				.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Intro to Financial Literacy\")"))
				.getText();

		String expectedText2 = "Intro to Financial Literacy";

		Assert.assertEquals(actualText2, expectedText2);
		System.out.println(actualText2);

		// Close the application after the test completion.
		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

}
