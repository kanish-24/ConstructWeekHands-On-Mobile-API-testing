package hybridApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class KhanAcademyApp_Capabilities {

	// in this class I will give the desired capabilities

	public static AndroidDriver<AndroidElement> cap() throws MalformedURLException {

		DesiredCapabilities dC = new DesiredCapabilities();

		dC.setCapability(MobileCapabilityType.DEVICE_NAME, "My_Emulator");

		// I specified here that I am using Android
		dC.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");

		dC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");

		dC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				dC);

		return driver;
		// com.androidsample.generalstore.SplashActivity - GeneralStore

	}

}
