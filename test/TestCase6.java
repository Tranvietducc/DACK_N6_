package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

@Test
public class TestCase6 {


    /* Verify user is able to purchase product using registered email id(USE CHROME BROWSER)
    Test Steps:
    1. Go to http://live.techpanda.org/
    2. Click on my account link
    3. Login in application using previously created credential
    4. Click on MY WISHLIST link*/
    public static void TestLink06() {

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


            /** Step 4. Click on MY WISHLIST link */

            //Skip
//
//            /*
//            5. In next page, Click ADD TO CART link
//            6. Enter general shipping country, state/province and zip for the shipping cost estimate
//            7. Click Estimate
//            8. Verify Shipping cost generated
//            */
//
            /** Step 5. In the next page,
             * Pick "Laptop Gaming Asus ROG Flow X16 GV601VV-NL016W (i9-13900H, RTX 4060 8GB, Ram 16GB DDR5, SSD 1TB, 16 Inch 240Hz WQXGA, TouchScreen)" in Laptop Category
             * Click Add to Cart link
             * */


            //Về trang chủ
            driver.findElement(By.cssSelector("img[alt='logo ']")).click();

            //Chọn sản phẩm

            WebElement productTest1 = driver.findElement(By.cssSelector("h3[class='product-name'] a[title='Laptop Asus Zenbook 14 OLED UX3402VA-KM203W (i5-1340P EVO, Iris Xe Graphics, Ram 16GB DDR5, SSD 512GB, 14 Inch OLED 2.8K)']"));

            Thread.sleep(500);
            productTest1.click();

            Thread.sleep(500);
            //click "Mua Ngay"
            driver.findElement(By.cssSelector("button[class='btn btn_base btn_add_cart btn-cart'] span[class='text_1']")).click();


            Thread.sleep(500);

            /** Step 6. Enter general shipping country, state/province and zip for the shipping cost estimate */


            //Skip

            /** Step 7. Click Estimate */

            //Skip


            /** Step 8. Verify Shipping cost generated */


            //Skip




            Thread.sleep(500);

//            /*
//            9. Select Shipping Cost, Update Total
//            10. Verify shipping cost is added to total
//            11. Click "Proceed to Checkout"
//            12a. Enter Billing Information, and click Continue
//            12b. Enter Shipping Information, and click Continue
//            13. In Shipping Method, Click Continue
//            14. In Payment Information select 'Check/Money Order' radio button. Click Continue
//            15. Click 'PLACE ORDER' button
//            16. Verify Oder is generated. Note the order number
//            */
//
//
            /** Step 8. Click tăng số lượng để Update sản phẩm */

//
            driver.findElement(By.cssSelector(".increase_pop.items-count.btn-plus"));
            Thread.sleep(2000);


            /** Step 9.
             * Click vào thực hiện thanh toán */


            driver.findElement(By.cssSelector("button[title='Thực hiện thanh toán']")).click();


            /** Step 11a + 11b. Enter Billing Information, and click Continue  */

            WebElement userAddress = driver.findElement(By.cssSelector("#billingAddress"));
            userAddress.sendKeys("Abc XYZ đường GHJ quận Tân Phú");
            Thread.sleep(1000);


            WebElement userPhone = driver.findElement(By.cssSelector("#billingPhone"));
            userPhone.sendKeys("0782822152");
            Thread.sleep(1000);


            //**
            // Do auto selection trên Website bị lỗi nên em Skip đoạn này

//            WebElement userCity = driver.findElement(By.cssSelector("#select2-billingProvince-container"));
//            Select sltCity = new Select(userCity);
//            sltCity.selectByVisibleText("TP Hồ Chí Minh");
//            Thread.sleep(1000);










            /** Step 13. In Shipping Method, Click Continue */

            //Skip


            /** Step 14. In Payment Information select 'Check/Money Order' radio button. Click Continue */


            //Click vào nút Thanh toán khi giao hàng
            driver.findElement(By.cssSelector("label[for='paymentMethod-523801'] span[class='radio__label__primary']")).click();



            /** Step 15. Click 'Đặt Hàng' button */

            //Skip

            //PLACE ORDER Click
//            driver.findElement(By.cssSelector("div[class='order-summary__nav field__input-btn-wrapper hide-on-mobile layout-flex--row-reverse'] button[type='submit']")).click();




            /** Step 16. Verify Oder is generated. Note the order number */

//            TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
//            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            desFile = new File(path + "TestCase06_16_VerifyOrder.png");
//            FileHandler.copy(srcFile, desFile);

//            String noteOrderNum = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(3)")).getText();
//            Files.writeString(Path.of(path + "OrderNumber.txt"),noteOrderNum, StandardCharsets.UTF_8);







        } catch (Exception e) {

            e.printStackTrace();
        }
        driver.quit();


    }
}