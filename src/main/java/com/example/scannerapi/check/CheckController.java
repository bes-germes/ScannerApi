package com.example.scannerapi.check;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/check")
public class CheckController {

    @GetMapping()
    public String getCheck() {

//        WebDriver driver = new ChromeDriver();
//        driver.get("");
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


//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        String jsonString = null;
//
//        try {
//            System.out.println(clipboard.getData(DataFlavor.stringFlavor));
//            System.out.println(clipboard.getData(DataFlavor.stringFlavor).getClass().getSimpleName());
//            jsonString = (String) clipboard.getData(DataFlavor.stringFlavor);
//        } catch (UnsupportedFlavorException | IOException e) {
//            e.printStackTrace();
//        }
//
//        CheckModel checkModel = new CheckModel();
//        return jsonString;
          return"[\n" +
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
