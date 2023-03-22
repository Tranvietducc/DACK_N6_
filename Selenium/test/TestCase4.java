package test;


import driver.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;


/*
Test Steps:
1. Go to https://memoryzone.com.vn/
2. Click on Laptop menu
3. In laptop products list , click on �Add To Compare� for 2 laptops (MSI & Apple)
4. Click on �COMPARE� button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/


@Test
public class TestCase4 {
    public static void TestLink04(){
        System.setProperty("webdriver.http.factory","jdk-http-client");
        WebDriver driver = driverFactory.getChromeDriver();
        try{


            /** Step 1. Go to https://memoryzone.com.vn/  */

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


            /** Step 3. In laptop products list , click on �Add To Compare� for
             *          2 mobiles (MSI & Apple)
             * */

            //Skip


            /** Step 4. Click on �COMPARE� button. A popup window opens */


            //Skip

            /** Step 5. Verify the pop-up window and check that the products are reflected in it
                        Heading "COMPARE PRODUCTS" with selected products in it.
             */

            //Skip


            driver.close();
            driver.switchTo().window(winHandleBefore);




        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();






    }




}
