package silktest.support.demo;

import com.borland.silktest.jtf.BrowserBaseState;
import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomElement;
import org.junit.Assert;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomListBox;

public class GMOAjax {

	private Desktop desktop = new Desktop();

	@Before
	public void baseState() {
		// Go to web page 'http://demo.borland.com/gmoajax'
		BrowserBaseState baseState = new BrowserBaseState();
		baseState.execute(desktop);
	}

	
	/**
	 * Verifies the About Us message
	 */
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

	/**
	 * Performs a simple transaction against the GMO Ajax test site.
	 * 
	 * Adds two pairs of boots to the cart.
	 * Verifies the total price of the cart.
	 * Confirms the order.
	 * Enters 
	 * 
	 */
	@Test
	public void orderTransaction() {
		desktop.<DomLink>find("demo_borland_com.BrowserWindow.storeBtn").click();
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.qtyInput").setText("2");
		desktop.<DomButton>find("demo_borland_com.BrowserWindow.addButton").click();
		desktop.<DomElement>find("demo_borland_com.BrowserWindow.cart confirm image").click();
		DomElement modalCartTotal = desktop.<DomElement>find("demo_borland_com.BrowserWindow.Modal Cart Total");
		Assert.assertEquals("Total : £229.98", modalCartTotal.getText());
		desktop.<DomLink>find("demo_borland_com.BrowserWindow.modalBtn Confirm").click();
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.full_name").setText("Silk");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.email").setText("demo@test.com");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.phone").setText("441231231234");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.address").setText("A sample address");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.address2").setText("A sample street");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.city").setText("Belfast");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.zip").setText("BT1 3NQ");
		desktop.<DomListBox>find("demo_borland_com.BrowserWindow.countries").select("United Kingdom");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.pay_name").setText("Tester");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.card_num").setText("1234123412341234");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.exp_date").setText("10/2019");
		desktop.<DomTextField>find("demo_borland_com.BrowserWindow.cvv").setText("123");
		desktop.<DomElement>find("demo_borland_com.BrowserWindow.submitFormIMG").click();
		desktop.<DomButton>find("demo_borland_com.BrowserWindow.confirmBtn").click();
		desktop.<DomElement>find("demo_borland_com.BrowserWindow.submitFormIMG").click();
		desktop.<DomButton>find("demo_borland_com.BrowserWindow.confirmBtn").click();
		DomElement headerTitle = desktop.<DomElement>find("demo_borland_com.BrowserWindow.headerTitle");
		Assert.assertEquals("ORDER CONFIRMATION", headerTitle.getText());
		desktop.<DomButton>find("demo_borland_com.BrowserWindow.FinishOrder").click();
	}
	
	

}