package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

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


        //WebElement dellLaptopList = webDriver.findElement(By.xpath("//div[@class='grid-products clearfix product-list-container']"));

        List<WebElement> dellLaptopList = webDriver.findElements(By.xpath("//body[contains(@class,'nisp with-branding active-branding')]/div[@id='container']/div[@class='main-content clearfix']/div[@id='content-wrapper']/div[@id='listing-right']/div[@class='grid-products clearfix product-list-container']/div"));

        dellLaptopList.forEach( laptop ->
                System.out.println(laptop.findElement(By.xpath("//div[2]//div[2]//div[1]//a")).getAttribute("title")));

/*
        WebElement laptopCompartment = webDriver.findElement(By.xpath("//a[@href='/laptop-desktop-it/cpl/']"));
        laptopCompartment.click();

        WebElement laptopAsus = webDriver.findElement(By.xpath("//a[@href='https://altex.ro/laptop-asus/cpl/']"));
        laptopAsus.click();

        WebElement extremeLaptopAsus  = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://altex.ro/laptop-asus/cpl/filtru/tip-4618/extrem/']")));

        Actions actions = new Actions(webDriver);
        actions.moveToElement(extremeLaptopAsus);
        actions.perform();
        extremeLaptopAsus.click();


        List<Laptop> asusLaptops = new ArrayList<>();
        List<WebElement>extremeAsusLaptopList = webDriver.findElements(By.xpath("//ul[@class='Products Products--grid Products--4to2']/li[@class='Products-item']"));

//        WebElement ul = webDriver.findElement(By.xpath("//ul[@class='Products Products--grid Products--4to2']"));
//        List<WebElement>extremeAsusLaptopList = ul.findElements(By.xpath("/li[@class='Products-item']"));

//        extremeAsusLaptopList.forEach(laptop -> {
//            WebElement title = laptop.findElement(By.xpath("//a[@class='Product-name ']"));
//            WebElement price = laptop.findElement(By.xpath("//span[@class='Price-int']"));
//
//            String ttt = title.getAttribute("title");
//            String ppp = price.getText();
//            Laptop asusLaptop = new Laptop();
//        });


        WebElement title = null;
        WebElement price = null;

        for (WebElement laptop : extremeAsusLaptopList){

//            System.out.println("\n----------------\n" + laptop.getText());
//            String price = laptop.getText().split("\n")[0].replace(".","").replace(",",".").replace("LEI","").replace("lei","").replace("REDUCERE\n","");
//            String title = laptop.getText().split("\n")[2];


                    title = laptop.findElement(By.xpath("//div[@class='Product']/div[@class='Product-list-right']/h2[@class='Product-nameHeading']/a[@class='Product-name ']"));



            price = laptop.findElement(By.xpath("//span[@class='Price-int']"));

            System.out.println(title.getText());
            System.out.println(price.getText());
            String ttt = title.getAttribute("title");
            String ppp = price.getText();
//            System.out.println("\nPrice: " + ppp);
//            System.out.println("\nTitle: " + ttt);
            asusLaptops.add(new Laptop(ttt,Double.valueOf(ppp)));
        }


*/
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();


    }
}
