package com.louisamoros.cdb.itest;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * The Class AddComputerTest.
 */
public class AddComputerTest {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    /**
     * Set up.
     *
     * @throws Exception the exception
     */
    @Before
    public final void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8180";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    @Test
    public final void test() throws Exception {
        driver.get(baseUrl + "/cdb/computer/list");
        driver.findElement(By.linkText("2")).click();
        driver.findElement(By.linkText("3")).click();
        driver.findElement(By.cssSelector("i.glyphicon.glyphicon-chevron-right")).click();
        driver.findElement(By.cssSelector("i.glyphicon.glyphicon-step-forward")).click();
        driver.findElement(By.cssSelector("i.glyphicon.glyphicon-chevron-left")).click();
        driver.findElement(By.cssSelector("i.glyphicon.glyphicon-step-backward")).click();
        driver.findElement(By.linkText("50")).click();
        driver.findElement(By.linkText("100")).click();
        driver.findElement(By.id("addComputer")).click();
        driver.findElement(By.id("computerName")).clear();
        driver.findElement(By.id("computerName")).sendKeys("TEST");
        driver.findElement(By.id("introduced")).clear();
        driver.findElement(By.id("introduced")).sendKeys("2016-02-01");
        driver.findElement(By.id("discontinued")).clear();
        driver.findElement(By.id("discontinued")).sendKeys("2016-02-29");
        new Select(driver.findElement(By.id("companyId"))).selectByVisibleText("Apple Inc.");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public final void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
