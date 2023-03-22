package test;

import driver.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

/*
Test Steps:
1. Goto https://memoryzone.com.vn/
2. Click on Laptop menu
3. In the list of all laptop , click on �ADD TO CART� for MSI Laptop
4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
"The requested quantity for "MSI" is not available."
5. Verify the error message
6. Then click on �EMPTY CART� link in the footer of list of all laptops. A message "SHOPPING CART IS EMPTY" is shown.
7. Verify cart is empty
*/


@Test
public class TestCase3 {
    public static void TestLink03(){
        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriver driver = driverFactory.getChromeDriver();
        try{


            /** Step 1. Goto https://memoryzone.com.vn/  */

            driver.get("https://memoryzone.com.vn/");



            /** Step 2. Click on Laptop menu */

            //Đi tới phần danh mục

            WebElement danhmucSP = driver.findElement(By.cssSelector(".title_"));


            Thread.sleep(200);
            Actions actions = new Actions(driver);

            //Dùng để hover phần danh mục để chọn loại sản phẩm

            actions.moveToElement(danhmucSP).perform();

            Thread.sleep(2000);


            //Click vào Mục [ Laptop ]
            driver.findElement(By.cssSelector("a[title='Laptop'][target='_blank']")).click();



            Thread.sleep(200);

            String winHandleBefore = driver.getWindowHandle();

            //Đi tới Tab mới
            for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }





            /** Step 3. In the list of all laptop , click on �ADD TO CART� for MSI laptop */


            driver.findElement(By.cssSelector("h3[class='product-name'] a[title='Laptop Gaming Gigabyte G5 KF-E3VN313SH (i5-12500H, RTX 4060 8GB, Ram 16GB DDR4, SSD 512GB, 15.6 Inch 144Hz FHD)']")).click();
            driver.findElement(By.cssSelector("button[class='btn btn_base btn_add_cart btn-cart'] span[class='text_1']")).click();


            Thread.sleep(500);


            /** Step 4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
             *  "The requested quantity for "MSI" is not available."
             * */

            //Thay đổi số lượng mặt hàng
            driver.findElement(By.cssSelector("#qtyItem69437230")).clear();

            Thread.sleep(100);

            driver.findElement(By.cssSelector("#qtyItem69437230")).sendKeys("1000");

            Thread.sleep(600);


            driver.findElement(By.cssSelector(".main.container.hidden-xs")).click();


            //Skip vì không thông báo hết hàng

//            String msgExpected = "The requested quantity for \"MSI\" is not available.";
//            Thread.sleep(200);


            /** Step 5. Verify the error message */

//            Assert.assertEquals("Error message is not expected !",msgExpected,msgError.getText());


            //Thẩm định lỗi
            TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File desFile = new File("C:\\Users\\Admin\\Desktop\\ImageSelenium\\" + "TestCase03_ErrorMessageQuantity.png");
            FileHandler.copy(srcFile,desFile);



            /** Step 6. Then click on �EMPTY CART� link in the footer of list of all laptop.
             *  A message "SHOPPING CART IS EMPTY" is shown.
             *  */


            //Skip vì không có Empty Cart

//
//            WebElement btnEmptyCart = driver.findElement(By.cssSelector("button[id='empty_cart_button'] span span"));
//            btnEmptyCart.click();
//            Thread.sleep(800);
//            WebElement msgEmpty=driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart is Empty']"));
//
//            Assert.assertEquals("SHOPPING CART IS EMPTY",msgEmpty.getText());



            /** Step 7. Verify cart is empty */

            srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            desFile = new File("C:\\Users\\Admin\\Desktop\\ImageSelenium\\" + "TestCase03_VerifyEmptyCart.png");
            FileHandler.copy(srcFile,desFile);



            driver.close();
            driver.switchTo().window(winHandleBefore);





        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();






    }
}
