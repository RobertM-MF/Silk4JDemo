package silktest.support.demo;

import com.borland.silktest.jtf.BrowserBaseState;
import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomElement;
import org.junit.Assert;
import com.borland.silktest.jtf.Desktop;

public class GMOAjax {

	private Desktop desktop = new Desktop();

	@Before
	public void baseState() {
		// Go to web page 'http://demo.borland.com/gmoajax'
		BrowserBaseState baseState = new BrowserBaseState();
		baseState.execute(desktop);
	}

	@Test
	public void verifyAboutUsMessage() {
		desktop.<DomLink>find("demo_borland_com.BrowserWindow.storeBtn").click();
		desktop.<DomElement>find("demo_borland_com.BrowserWindow.showMenu").click();
		desktop.<DomLink>find("demo_borland_com.BrowserWindow.mnuAbout").click();
		DomElement sctGMOtxt = desktop.<DomElement>find("demo_borland_com.BrowserWindow.sctGMOtxt");
		Assert.assertEquals(
				"This is a sample online commerce application. It is not real. Green Mountain Outpost is a fictitious company. Any resemblance to actual companies, either living or dead, is purely coincidental.",
				sctGMOtxt.getText());
	}

}