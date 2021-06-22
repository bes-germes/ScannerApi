package com.example.scannerapi.check;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/check")
public class CheckController {

    static Logger LOGGER;

    @GetMapping()
    public String getCheck(@RequestParam String checkString) {

        String[] elementsArray = checkString.split("&");

        for (int i = 0; i < elementsArray.length; ++i) {
            if (elementsArray[i].startsWith("f")) {
                elementsArray[i] = elementsArray[i].substring(3);
            } else {
                elementsArray[i] = elementsArray[i].substring(2);
            }
        }
        System.out.println("");
        String beforeT = elementsArray[0].substring(0, elementsArray[0].lastIndexOf("T"));
        String afterT = elementsArray[0].substring(elementsArray[0].lastIndexOf("T") + 1);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
//        options.setBinary("CHROMEDRIVER_PATH");

        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("https://proverkacheka.com/");


        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='.b-checkform_tab-props']"))).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-checkform_fn"))).click();
        WebElement chekform_fn = driver.findElement(By.id("b-checkform_fn"));
        executor.executeScript("arguments[0].scrollIntoView(true);", chekform_fn);
        chekform_fn.sendKeys(elementsArray[2]);


        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-checkform_fd"))).click();
        WebElement chekform_fd = driver.findElement(By.id("b-checkform_fd"));
        executor.executeScript("arguments[0].scrollIntoView(true);", chekform_fd);
        chekform_fd.sendKeys(elementsArray[3]);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-checkform_fp"))).click();
        WebElement chekform_fp = driver.findElement(By.id("b-checkform_fp"));
        executor.executeScript("arguments[0].scrollIntoView(true);", chekform_fp);
        chekform_fp.sendKeys(elementsArray[4]);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='b-checkform_s form-control']"))).click();
        WebElement sum = driver.findElement(By.xpath("//input[@class='b-checkform_s form-control']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", sum);
        sum.sendKeys(elementsArray[1]);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='b-checkform_date form-control']"))).click();
        WebElement date = driver.findElement(By.xpath("//input[@class='b-checkform_date form-control']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", date);
        date.sendKeys(beforeT.substring(6) + beforeT.substring(4, 6) + beforeT.substring(0, 4));

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='b-checkform_time form-control']"))).click();
        WebElement time = driver.findElement(By.xpath("//input[@class='b-checkform_time form-control']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", time);
        time.sendKeys(afterT.substring(0, 4));

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='b-checkform_n']"))).click();
        WebElement checkform_n = driver.findElement(By.xpath("//select[@id='b-checkform_n']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", checkform_n);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='1']"))).click();
        WebElement value_1 = driver.findElement(By.xpath("//option[@value='1']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", value_1);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='b-checkform_btn-send btn btn-primary btn-sm pull-right']"))).click();
        WebElement value_2 = driver.findElement(By.xpath("//button[@class='b-checkform_btn-send btn btn-primary btn-sm pull-right']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", value_2);

        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary btn-sm dropdown-toggle']"))).click();
        WebElement fin = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm dropdown-toggle']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", fin);

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='b-check_btn-buffer']"))).click();
        WebElement buffer = driver.findElement(By.xpath("//a[@class='b-check_btn-buffer']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", buffer);

        driver.quit();

        System.setProperty("java.awt.headless", "false");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Clipboard clipboard = tk.getSystemClipboard();

        try {
            String result = clipboard.getData(DataFlavor.stringFlavor).toString();
            String r = result.substring(result.lastIndexOf("["), result.lastIndexOf("]") + 1);
            return r;
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
