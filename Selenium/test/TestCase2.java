package test;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Test Steps:
1. Goto https://memoryzone.com.vn/
2. Click on Laptop menu
3. In the list of all Laptop , read the cost of MSI Laptop (which is 20000000đ)
4. Click on MSI Laptop
5. Read the MSI Laptop from detail page.
6. Compare Product value in list and details page should be equal (20000000đ).
*/
@Test
public class TestCase2 {


    public static void TestLink02(){

        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            /** Step 1. Go to https://memoryzone.com.vn/ */

            driver.get("https://memoryzone.com.vn/");
            //Delay 2 giây
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

            /** Step 2. Click on LAPTOP menu */
            //Đợi rồi Click ---- 2s
            WebElement btnLaptop = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(2) > header:nth-child(2) > div:nth-child(1) > div:nth-child(4) > nav:nth-child(1) > ol:nth-child(1) > li:nth-child(1) > a:nth-child(1)"))));
            //Click vào nút tương ứng
            btnLaptop.click();

            /** Step 3. In the list of all laptop  , read the cost of Laptop MSI  (which is 20000000đ) */
//
//            WebElement sonyPrice = driver.findElement(By.cssSelector("span[id='product-price-1'] span[class='price']"));
//            String sonyPriceReader = sonyPrice.getText().toString().substring(0,4);
//            Assert.assertEquals(sonyPriceReader,"20000000");


            /** Step 4. Click on  */
            WebElement MSI = driver.findElement(By.cssSelector("a[title='MSI']"));
            MSI.click();


            /** Step 5. Read the Sony Xperia mobile from detail page */

            //Chụp maàn hình
            TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
            File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File desFile = new File("C:\\Users\\Admin\\Desktop\\ImageSelenium\\" + "TestCase02_MSI_Detail.png");
            FileHandler.copy(srcFile,desFile);

            /** Step 6. Compare Product value in list and details page should be equal ($100).*/

            WebElement detailSonyPrice = driver.findElement(By.cssSelector(".price"));

            int compareSonyPrice = Integer.parseInt(detailSonyPrice.getText().toString().substring(0,4));

            Assert.assertEquals(100,compareSonyPrice);


        }catch (Exception e){
            e.printStackTrace();
        }
        //Thoát khỏi google chrome driver
        driver.quit();
    }
}
