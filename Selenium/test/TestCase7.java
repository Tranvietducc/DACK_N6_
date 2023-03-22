package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;


/*
Verify that you will be able to save previously placed order as a pdf file
 *
 *   Note: This TestCase7a version is due to the below amended steps.
 *
Test Steps:
1. Go to http://live.techpanda.org/
2. Click on My Account link
3. Login in application using previously created credential
4. Click on 'My Orders'
5. Click on 'View Order'
6. *** note: After steps 4 and 5, step 6 "RECENT ORDERS" was not displayed
   Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending
7. Click on 'Print Order' link


8. *** note: the link was not found.
 Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link.


*/
@Test
public class TestCase7 {
    public static void TestLink07() {


        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            /** Step 1. Go to https://memoryzone.com.vn/ */

            driver.get("https://memoryzone.com.vn//");

            /** Step 2. Click vào phần tài khoản */

            WebElement btnMyAccount = driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.hidden-md"));
            Thread.sleep(800);
            btnMyAccount.click();
            Thread.sleep(800);

            /** Step 3. Đăng nhập với tài khoản đã tạo trước đó */

            //Điền thông tin đăng nhập gồm email và password
            WebElement lgAccount = driver.findElement(By.cssSelector("#customer_email"));
            WebElement lgPassword = driver.findElement(By.cssSelector("#customer_password"));
            lgAccount.sendKeys("tranhuuloc2110@gmail.com");
            lgPassword.sendKeys("123456789");
            Thread.sleep(1000);

            //Click nút đăng nhập
            WebElement btnLoginAcc = driver.findElement(By.cssSelector("input[value='Đăng nhập']"));
            btnLoginAcc.click();
            Thread.sleep(1000);




            /** Step 4. Click on "My Orders" */

            //Skip vì không có thanh toán đơn hàng trước đó => ko có Order cũ


            /** Step 5. Click on 'View Order' */

            //Skip vì không có thanh toán đơn hàng trước đó => ko có Order cũ


            /** Step 6. Verify the previously created order is displayed in 'RECENT ORDERS' table and status is Pending */


            //Skip vì không có thanh toán đơn hàng trước đó => ko có Order cũ

            /** Step 7. Click on 'Print Order' link */

            //Skip vì không có thanh toán đơn hàng trước đó => ko có Order cũ

            /** Step 8. Click 'Change...' link and a popup will be opened as 'Select a destination' , select 'Save as PDF' link. */


            //Skip vì không có thanh toán đơn hàng trước đó => ko có Order cũ


        } catch (
                Exception e) {

            e.printStackTrace();
        }

        driver.quit();
    }
}
