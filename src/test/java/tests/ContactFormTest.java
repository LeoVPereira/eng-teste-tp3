package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;

public class ContactFormTest extends BaseTest {

    @Test
    public void testContactForm() {

        driver.get("https://demo.prestashop.com/#/en/front");

        driver.get("https://demo.prestashop.com/#/en/contact-us");

        ContactPage contact = new ContactPage(driver);

        contact.selectSubject("Customer service");
        contact.fillEmail("teste@exemplo.com");
        contact.fillMessage("Olá! Esta é uma mensagem de teste.");
        contact.clickSend();

        Assert.assertTrue(contact.isMessageSent());
    }
}
