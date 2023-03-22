package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Format;

/*  Verify Discount Coupon works correctly

Test Case Description:
1. Go to http://live.techpanda.org/
2. Go to Mobile and add IPHONE to cart
3. Enter Coupon Code
4. Verify the discount generated

TestData:  Coupon Code: GURU50
Expected result:
1) Price is discounted by 5%
*/
@Test
public class TestCase9 {
    public static void TestLink() {


        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            /** Step 1. Go to https://memoryzone.com.vn/ */

            driver.get("https://memoryzone.com.vn//");




            /** Step 2. đi tới danh mục  */


            //Đi tới phần danh mục

            WebElement danhmucSP = driver.findElement(By.cssSelector(".title_"));
            Thread.sleep(200);
            Actions actions = new Actions(driver);

            //Dùng để hover phần danh mục để chọn loại sản phẩm
            actions.moveToElement(danhmucSP).perform();
            Thread.sleep(2000);


            //Click vào Mục [ Laptop ]
            driver.findElement(By.cssSelector("a[title='Laptop'][target='_blank']")).click();



            //***Qua tab mới

            //Lưu lại cửa sổ cũ
            String oldWindow = driver.getWindowHandle();


            //Đi tới Tab mới
            driver.switchTo().newWindow(WindowType.TAB);



            //Chọn 1 sản phẩm
            Thread.sleep(1000);
            //** Sản phẩm test: [ Laptop Asus Zenbook 14 OLED UX3402VA-KM203W (i5-1340P EVO, Iris Xe Graphics, Ram 16GB DDR5, SSD 512GB, 14 Inch OLED 2.8K) ]

            driver.findElement(By.cssSelector("h3[class='product-name'] a[title='Laptop Asus Zenbook 14 OLED UX3402VA-KM203W (i5-1340P EVO, Iris Xe Graphics, Ram 16GB DDR5, SSD 512GB, 14 Inch OLED 2.8K)']")).click();

            //Click vào Mua ngay => Add to Cart
            driver.findElement(By.cssSelector("button[class='btn btn_base btn_add_cart btn-cart'] span[class='text_2']")).click();






            //Click Mobile
//            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > header:nth-child(2) > div:nth-child(1) > div:nth-child(4) > nav:nth-child(1) > ol:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).click();



            //ADd Iphone to Cart
//            driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();




            /** Step 3. Enter Coupon Code
             TestData:  Coupon Code: GURU50

             Expected result:
             1) Price is discounted by 5%
             */

            //Click vào "thực hiện thanh toán" để đi tới cửa sổ thanh toán => Nhập mã giảm giá
            driver.findElement(By.cssSelector("button[title='Thực hiện thanh toán'] span")).click();
            //Lấy khung giá
            WebElement price = driver.findElement(By.cssSelector(".payment-due__price"));

            //Lưu lại tổng giá cũ
            //Vì giá parse ra là ###.###đ nên em phải lấy chuỗi từ 0 -> độ dài trừ đi kí tự "đ"
            String fstPrice = price.getText().substring(0,price.getText().length()-2);

            //cắt đi dấu chấm
            int oldPrice = Integer.parseInt(fstPrice.replaceAll(".",""));

            //Nhập mã giảm giá


            WebElement couponCode= driver.findElement(By.cssSelector("#reductionCode"));
                //Dọn sạch ô trươớc
            couponCode.clear();
                //Nhập mã giảm giá
            // Vì không có mã giảm giá nên em Skip phần này
//            couponCode.sendKeys("TEST123456789");



            //Áp dụng mã giảm giá
            Thread.sleep(500);
//            driver.findElement(By.cssSelector("button[type='button']")).click();




            //Lấy tổng giá mới

            //
            String newPriceElement = price.getText().substring(0,price.getText().length()-2);
            int newPrice = Integer.parseInt(newPriceElement.replaceAll(".",""));

//
            //Vì em không biết mã giảm giá bao nhiêu nên em skip phần này
//            Assert.assertEquals(newPrice,oldPrice-oldPrice*0.05);
//
//            Thread.sleep(2000);
//


            /** Step 4. Verify the discount generated */


//          Thẩm định giá giảm và chụp hình lại

            //Skip
//            String path = "C:\\Users\\Admin\\Desktop\\ImageSelenium\\";
//            TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
//            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            File desFile = new File(path + "TestCase09_04_VerifyDiscountGenerated.png");
//            FileHandler.copy(srcFile, desFile);


        } catch (Exception e) {

            e.printStackTrace();
        }
        driver.quit();

    }


}
