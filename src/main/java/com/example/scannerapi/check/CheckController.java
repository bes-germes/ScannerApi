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
    public String getCheck() {

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-gpu");
//        options.addArguments("--no-sandbox");
//        options.setBinary("C:\\bin\\chromedriver.exe");

//        char[] information = info.toCharArray();
//
//        List<String> parsedInfo = new ArrayList<>();
//        List<Character> tmp = new ArrayList<>();
//        for (char c : information) {
//            if (c == '&') {
//                Character firstCharacter = tmp.get(0);
//                if (firstCharacter.equals('t')
//                        || firstCharacter.equals('s')
//                        || firstCharacter.equals('i')) {
//                    parsedInfo.add(tmp.toString().substring(2));
//                } else if (firstCharacter.equals('f')) {
//                    parsedInfo.add(tmp.toString().substring(3));
//                }
//                tmp.clear();
//            }
//            tmp.add(c);
//        }


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.setBinary("GOOGLE_CHROME_BIN");

        WebDriver driver = new ChromeDriver(options);
        System.out.println(driver.getPageSource());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        driver.get("https://proverkacheka.com/");

        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='.b-checkform_tab-props']"))).click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-checkform_fn"))).click();
        WebElement chekform_fn = driver.findElement(By.id("b-checkform_fn"));
        executor.executeScript("arguments[0].scrollIntoView(true);", chekform_fn);
        chekform_fn.sendKeys("9285440300237214");


        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-checkform_fd"))).click();
        WebElement chekform_fd = driver.findElement(By.id("b-checkform_fd"));
        executor.executeScript("arguments[0].scrollIntoView(true);", chekform_fd);
        chekform_fd.sendKeys("19789");

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("b-checkform_fp"))).click();
        WebElement chekform_fp = driver.findElement(By.id("b-checkform_fp"));
        executor.executeScript("arguments[0].scrollIntoView(true);", chekform_fp);
        chekform_fp.sendKeys("0643502697");

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='b-checkform_s form-control']"))).click();
        WebElement sum = driver.findElement(By.xpath("//input[@class='b-checkform_s form-control']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", sum);
        sum.sendKeys("779,36");

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='b-checkform_date form-control']"))).click();
        WebElement date = driver.findElement(By.xpath("//input[@class='b-checkform_date form-control']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", date);
        date.sendKeys("18052021");

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='b-checkform_time form-control']"))).click();
        WebElement time = driver.findElement(By.xpath("//input[@class='b-checkform_time form-control']"));
        executor.executeScript("arguments[0].scrollIntoView(true);", time);
        time.sendKeys("1949");

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

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String jsonString = null;

        try {
            System.out.println(clipboard.getData(DataFlavor.stringFlavor));
            System.out.println(clipboard.getData(DataFlavor.stringFlavor).getClass().getSimpleName());
            jsonString = (String) clipboard.getData(DataFlavor.stringFlavor);
            return           "[\n" +
                    "    {\n" +
                    "        \"sum\": 300,\n" +
                    "        \"name\": \"Пиво\",\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"price\": 150\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"sum\": 300,\n" +
                    "        \"name\": \"Водка\",\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"price\": 300\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"sum\": 520,\n" +
                    "        \"name\": \"Вино\",\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"price\": 260\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"sum\": 72,\n" +
                    "        \"name\": \"Кириешки\",\n" +
                    "        \"quantity\": 3,\n" +
                    "        \"price\": 24\n" +
                    "    },\n" +
                    "    {\n" +
                    "        \"sum\": 241,\n" +
                    "        \"name\": \"Сыр КИПР. рос.\",\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"price\": 241\n" +
                    "    }\n" +
                    "]";
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hello, logs!??");
        LOGGER.log(Level.INFO,"STEPA plz ");
//        CheckModel checkModel = new CheckModel();
//        return jsonString;
          return
          "[\n" +
                "    {\n" +
                "        \"sum\": 300,\n" +
                "        \"name\": \"Пиво\",\n" +
                "        \"quantity\": 2,\n" +
                "        \"price\": 150\n" +
                "    },\n" +
                "    {\n" +
                "        \"sum\": 300,\n" +
                "        \"name\": \"Водка\",\n" +
                "        \"quantity\": 1,\n" +
                "        \"price\": 300\n" +
                "    },\n" +
                "    {\n" +
                "        \"sum\": 520,\n" +
                "        \"name\": \"Вино\",\n" +
                "        \"quantity\": 2,\n" +
                "        \"price\": 260\n" +
                "    },\n" +
                "    {\n" +
                "        \"sum\": 72,\n" +
                "        \"name\": \"Кириешки\",\n" +
                "        \"quantity\": 3,\n" +
                "        \"price\": 24\n" +
                "    },\n" +
                "    {\n" +
                "        \"sum\": 241,\n" +
                "        \"name\": \"Сыр КИПР. рос.\",\n" +
                "        \"quantity\": 1,\n" +
                "        \"price\": 241\n" +
                "    }\n" +
                "]";
    }
}
