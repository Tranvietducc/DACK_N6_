package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


/*
Test Steps
Step 1. Go to https://memoryzone.com.vn/
Step 2. Verify Title of the page
Step 3. Click on -> LAPTOP -> menu
Step 4. In the list of all laptop , select SORT BY -> dropdown as name
Step 5. Verify all products are sorted by name
*/
@Test
public class TestCase1 {
    public static void testHandleDropdown() {

         System.setProperty("webdriver.http.factory","jdk-http-client");
        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page - Login Form
            driver.get("https://memoryzone.com.vn");


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

            Thread.sleep(200);

            //3. Locate dropdown element
            WebElement dropdownElement = driver.findElement(By.cssSelector("body > div:nth-child(9) > div:nth-child(1) > section:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1)"));
            //4. Init a Select Option instance
            actions.moveToElement(dropdownElement).perform();
            Thread.sleep(200);

            driver.findElement(By.cssSelector("a[onclick=\"sortby('alpha-asc')\"]")).click();
            //select options in dropdown list by Text
            Thread.sleep(3000);

            //Tuỳ chọn
//            selectOption.selectByVisibleText("Z->A");
//            selectOption.selectByVisibleText("Giá tăng dần");
//            selectOption.selectByVisibleText("Giá giảm dần");
//            selectOption.selectByVisibleText("Hàng mới nhất");
//            selectOption.selectByVisibleText("Hàng cũ nhất");


            //Or select option in dropdown list by value
            //debug purpose only
//            Thread.sleep(900);
//            selectOption.selectByIndex(1);
//            selectOption.selectByIndex(2);


            driver.close();
            driver.switchTo().window(winHandleBefore);
        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
