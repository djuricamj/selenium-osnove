package d02_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to(" https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("img.edit-image")).click();
        driver.findElement(By.cssSelector("#image-option-remove svg")).click();


        for (int i = 0; i < 4; i++) {
            driver.findElement(By.cssSelector("img.edit-image")).click();

            wait
                    .withMessage("Image upload menu is not present.")
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("imageUpload")));

            File uploadFile = new File("test_data/intelij.png");

            driver.findElement(By.id("imageUpload")).sendKeys(uploadFile.getAbsolutePath());

            wait
                    .withMessage("Number of uploads is 0.")
                    .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.sc-gLDzan"), (i + 1)));

            driver.findElement(By.id("image-option-" + i)).click();
            driver.findElement(By.cssSelector("button.sc-beqWaB")).click();
            Thread.sleep(1500);

            driver.findElement(By.id("next-button")).click();
            driver.findElement(By.id("textareaID")).click();
            driver.findElement(By.id("textareaID")).sendKeys("abc");
        }

            for (int i = 0; i < 4; i++) {
                driver.findElement(By.id("next-button")).click();
                Thread.sleep(1500);
            }

            Thread.sleep(5000);

            driver.quit();
        }
    }











    
