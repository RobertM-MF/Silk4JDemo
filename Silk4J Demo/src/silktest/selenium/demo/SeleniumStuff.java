package silktest.selenium.demo;

import org.junit.Test;
import org.openqa.selenium.By;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.BrowserType;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.SilkTestWebDriver;

public class SeleniumStuff {
	
	private Desktop desktop = new Desktop();
	
	
	public String getSessionId(SilkTestWebDriver driver) {
		String sessionID = null;
		
		if((sessionID = driver.getSessionId().toString())==null) {
			System.out.println("DEBUG: getSessionID was null");
			driver.getCapabilities().getCapability("sessionid");
		}
		
		return sessionID;
	}
	
	@Test
	public void debug() {
		
		BrowserBaseState baseState = new BrowserBaseState(BrowserType.Firefox, "www.arbeitsagentur.de");
		baseState.execute(desktop);
		
		SilkTestWebDriver driver = desktop.<BrowserApplication>find("//BrowserApplication").getWebDriver();
		//SilkTestWebDriver driver = desktop.<BrowserWindow>find("//BrowserWindow").getWebDriver();		
		
		
		System.out.println(getSessionId(driver));
		
		//driver.findElement(By.xpath("//A[text()='Demo Application']")).click();
		System.out.println(driver.getCapabilities());
		
		
	}

}
