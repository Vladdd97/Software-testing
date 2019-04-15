package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String path = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080");
        webDriver.manage().window().maximize();


        //loginPage
        WebElement nameInput = webDriver.findElement(By.xpath("//input[@id='loginUsername']"));
        WebElement passwordInput = webDriver.findElement(By.xpath("//input[@id='loginPassword']"));
        WebElement submitButton = webDriver.findElement(By.xpath("//button[@id='loginButton']"));

        nameInput.clear();
        nameInput.sendKeys("dev");
        passwordInput.sendKeys("dev");
        submitButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();

    }
}
