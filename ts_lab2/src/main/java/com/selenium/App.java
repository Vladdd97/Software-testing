package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Comparator.comparing;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<Laptop>laptopList = new ArrayList<>();
        String path = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.pcgarage.ro/");
        webDriver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(webDriver, 5);


        WebElement cookiesButton = webDriver.findElement(By.xpath("//a[@id='cookie_agree']"));
        if (cookiesButton != null)
            cookiesButton.click();

        WebElement laptopButton = webDriver.findElement(By.xpath("//a[@class='cat-nav-tab'][contains(text(),'Laptop')]"));
        laptopButton.click();

        WebElement ultraBookButton = webDriver.findElement(By.xpath("//ul[@class='filters']//a[contains(text(),'Ultrabook')]"));
        ultraBookButton.click();

        WebElement selectPrice = webDriver.findElement(By.xpath("//div[@class='lc-box with-filters-type']//div[2]//p[2]"));
        selectPrice.click();


        WebElement choosePrice = webDriver.findElement(By.xpath("//a[contains(text(),'Peste 10.200 RON')]"));
        wait.until(ExpectedConditions.visibilityOf(choosePrice));
        choosePrice.click();


        WebElement selectProducer = webDriver.findElement(By.xpath("//p[@id='ff_01']"));
        selectProducer.click();


        WebElement chooseProducer = webDriver.findElement(By.xpath("//a[contains(text(),'DELL')]"));
        wait.until(ExpectedConditions.visibilityOf(chooseProducer));
        chooseProducer.click();




        List<WebElement> dellLaptopTitleList = webDriver.findElements(By.xpath("//div[@class='grid-products clearfix product-list-container']/div[@class='product-box-container']/div[@class='product-box']/div[@class='pb-specs-container']/div[@class='pb-name']/a"));

        dellLaptopTitleList.forEach(laptop -> {
                    laptopList.add(new Laptop(laptop.getAttribute("title")));
                }
        );

        List<WebElement> dellLaptopPriceList = webDriver.findElements(By.xpath("//div[@class='grid-products clearfix product-list-container']/div[@class='product-box-container']/div[@class='product-box']/div[@class='pb-price-container']/div[@class='pb-price']/p[@class='price']"));

        for(int i = 0; i < dellLaptopPriceList.size(); i++){
            String strPrice = dellLaptopPriceList.get(i).getText();
            strPrice = strPrice.replaceAll("RON","");
            strPrice = strPrice.replaceAll("\\.","");
            strPrice = strPrice.replaceAll(",",".");
            laptopList.get(i).setPrice(Double.valueOf(strPrice));

        }

        laptopList.sort(comparing(laptop -> laptop.getPrice()));

        laptopList.forEach(l -> System.out.println(l));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();


    }
}
