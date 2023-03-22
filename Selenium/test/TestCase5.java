package test;


import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

/* Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.
Test Steps:
1. Go to https://memoryzone.com.vn/
2. Click on my account link
3. Click Create an Account link and fill New User information except Email ID
4. Click Register
5. Verify Registration is done. Expected account registration done.
6. Go to PC menu
7. Add product in your wish list - use product - PC
8. Click SHARE WISHLIST
9. In next page enter Email and a message and click SHARE WISHLIST
10.Check wishlist is shared. Expected wishlist shared successfully.
*/
@Test
public class TestCase5 {

    public static void TestLink05(){
        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriver driver =  driverFactory.getChromeDriver();

        try {
            /** Step 1. Go to https://memoryzone.com.vn/ */

            driver.get("https://memoryzone.com.vn/");

            /** Step 2. Click on my account link */
            //Đợi rồi Click ---- 2s
            WebElement btnMyAccount = driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.hidden-md"));
            Thread.sleep(800);
            btnMyAccount.click();
            Thread.sleep(800);



            /** Step 3. Click Create an Account link and fill New User information except Email ID */

            //Click dađăng ký tài khoản
            driver.findElement(By.cssSelector(".btn-link-style.btn-register")).click();

            WebElement createAcc = driver.findElement(By.cssSelector("a[title='Register']"));
            createAcc.click();

            WebElement firstName= driver.findElement(By.cssSelector("#firstName"));
            firstName.sendKeys("Bùi");
            WebElement lastName = driver.findElement(By.cssSelector("#lastName"));
            lastName.sendKeys("Tình");
            WebElement password = driver.findElement(By.cssSelector("#password"));
            password.sendKeys("123456");


            Thread.sleep(500);


            /** Step 4. Click Register */
            WebElement btnRegister = driver.findElement(By.cssSelector("button[title='Register'] span span"));
            btnRegister.click();

            Thread.sleep(1000);
            /** Step 5. Verify Registration is done. Expected account registration done. */

            String errMsg = driver.findElement(By.cssSelector("p[class='required']")).getText();
            Assert.assertNotEquals(errMsg,null);

            /** Step 6. Go to PC menu */
            WebElement pcMenu = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > header:nth-child(2) > div:nth-child(1) > div:nth-child(4) > nav:nth-child(1) > ol:nth-child(1) > li:nth-child(2) > a:nth-child(1)"));
            pcMenu.click();

            /** Step 7. Add product in your wish list - use product - LG LCD */
            WebElement wishList = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
            wishList.click();


            /** Step 8. Click SHARE WISHLIST */
            WebElement btnShareWL = driver.findElement(By.cssSelector("button[title='Share Wishlist'] span span"));
            btnShareWL.click();

            /** Step 9. In next page enter Email and a message and click SHARE WISHLIST */
            WebElement etEmail = driver.findElement(By.cssSelector("#email_address"));
            etEmail.sendKeys("bluestarkng@gmail.com");
            WebElement btnShareClk = driver.findElement(By.cssSelector("button[title='Share Wishlist'] span span"));
            btnShareClk.click();


            /** Step 10.Check wishlist is shared. Expected wishlist shared successfully. */

            WebElement msgShared = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span"));
            Assert.assertNotEquals(null,msgShared.getText());



        }catch (Exception e){
            e.printStackTrace();
        }
        //Thoát khỏi google chrome driver
        driver.quit();
    }
}