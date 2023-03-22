package test;


import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

/*  Verify you are able to change or reorder previously added product
        *  Test Data = QTY = 10
        Test Steps:
        1. Go to http://live.techpanda.org/
        2. Click on my account link
        3. Login in application using previously created credential
        4. Click on 'REORDER' link , change QTY & click Update
        5. Verify Grand Total is changed
        6. Complete Billing & Shipping Information
        7. Verify order is generated and note the order number

        Expected outcomes:
        1) Grand Total is Changed
        2) Order number is generated
        */
@Test
public class TestCase8 {
    public static void TestLink08() {


        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            /** Step 1. Go to https://memoryzone.com.vn/ */

            driver.get("https://memoryzone.com.vn//");

            /** Step 2. Click vào phần tài khoản */

            WebElement btnMyAccount = driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.hidden-md"));
            Thread.sleep(100);
//            Thread.sleep(800);
            btnMyAccount.click();
//            Thread.sleep(800);
            Thread.sleep(100);

            /** Step 3. Đăng nhập với tài khoản đã tạo trước đó */

            //Điền thông tin đăng nhập gồm email và password
            WebElement lgAccount = driver.findElement(By.cssSelector("#customer_email"));
            WebElement lgPassword = driver.findElement(By.cssSelector("#customer_password"));
            lgAccount.sendKeys("tranhuuloc2110@gmail.com");
            lgPassword.sendKeys("123456789");
            Thread.sleep(200);

            //Click nút đăng nhập
            WebElement btnLoginAcc = driver.findElement(By.cssSelector("input[value='Đăng nhập']"));
            btnLoginAcc.click();
            Thread.sleep(200);



            /** Step 4. Click on 'REORDER' link , change QTY & click Update */


            //Skip vì không có ReOrder => Mua 1 mặt hàng ngẫu nhiên sau đó thay đổi số lượng => thay đổi giá

            //Về trang chủ để mua hàng
            driver.findElement(By.cssSelector("img[alt='logo ']")).click();

            //Sản phẩm mẫu: [ SSD MSI SPATIUM S270 2.5-Inch SATA III 120GB SPATIUM-S270-120GB ]

            Thread.sleep(100);

            //Click vào mặt hàng
            driver.findElement(By.cssSelector("h3[class='product-name'] a[title='SSD MSI SPATIUM S270 2.5-Inch SATA III 120GB SPATIUM-S270-120GB']")).click();

            //Mua mặt hàng
            Thread.sleep(100);
            driver.findElement(By.cssSelector("button[class='btn btn_base btn_add_cart btn-cart'] span[class='text_2']")).click();

//            Thread.sleep(600);

            // Lưu lại giá cũ
            String oldPrice = driver.findElement(By.cssSelector(".totals_price.price")).getText();



            //Thay đổi số lượng mặt hàng
            driver.findElement(By.cssSelector("#qtyItem69437230")).clear();
            Thread.sleep(100);
            driver.findElement(By.cssSelector("#qtyItem69437230")).sendKeys("2");
            Thread.sleep(600);

            //Vì không có nút Update Total nên em sẽ click ở phần body web
            driver.findElement(By.cssSelector(".main.container.hidden-xs")).click();


            /** Step 5. Verify Grand Total is changed */

            // Lưu giá mới
            Thread.sleep(500);
            String newPrice = driver.findElement(By.cssSelector(".totals_price.price")).getText();



            String path = "C:\\Users\\Admin\\Desktop\\ImageSelenium\\";
            TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File desFile = new File(path + "TestCase08_05_VerifyGrandTotal.png");
            FileHandler.copy(srcFile, desFile);

            //Kiểm tra nếu giá cũ và mới khác nhau => Pass
            Assert.assertNotEquals(newPrice,oldPrice);




            /** Step 6. Complete Billing & Shipping Information */

            //Click thanh toán
            driver.findElement(By.cssSelector("button[title='Thực hiện thanh toán'] span")).click();

            //Tương tự TestCase 06 => Điền thông tin thanh toán

            Thread.sleep(500);
            WebElement userAddress = driver.findElement(By.cssSelector("#billingAddress"));
            userAddress.sendKeys("Abc XYZ đường GHJ quận Tân Phú");
            Thread.sleep(1000);


            //Skip phần City vì lý do bên dưới
            //**
            // Do auto selection trên Website bị lỗi nên em Skip đoạn này

//            WebElement userCity = driver.findElement(By.cssSelector("#select2-billingProvince-container"));
//            Select sltCity = new Select(userCity);
//            sltCity.selectByVisibleText("TP Hồ Chí Minh");
//            Thread.sleep(1000);



            WebElement userPhone = driver.findElement(By.cssSelector("#billingPhone"));
            userPhone.sendKeys("0782822152");
            Thread.sleep(1000);




            /** Step 7. Verify order is generated and note the order number

             Expected outcomes:
             1) Grand Total is Changed
             2) Order number is generated
             */


            //Skip phần này vì không có thanh toán đơn hàng

            //Verify Order is generated
//            desFile = new File(path + "TestCase08_07_VerifyOrderGenerated.png");
//            FileHandler.copy(srcFile, desFile);



            //Lưu lại mã Order
//            String ordNumber = driver.findElement(By.cssSelector("Vị trí mã Order")).getText();
//            Files.writeString(Path.of(path + "OrderNumber.txt"),ordNumber, StandardCharsets.UTF_8);




            Thread.sleep(2000);





        } catch (Exception e) {

            e.printStackTrace();
        }
        driver.quit();

    }
}
