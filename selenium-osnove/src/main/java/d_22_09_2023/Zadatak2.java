package d_22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> url = new ArrayList<>();

        url.add("https://www.google.com/");
        url.add("https://www.facebook.com/");
        url.add("https://www.youtube.com/");
        url.add("https://www.ebay.com/");
        url.add("https://www.katalon.com/");
        WebDriverManager.chromedriver().setup();
        for (int i = 0; i < url.size(); i++) {
            WebDriver driver = new ChromeDriver();
            driver.get(url.get(i));
            Thread.sleep(1000);
            driver.quit();

        }


    }
}
