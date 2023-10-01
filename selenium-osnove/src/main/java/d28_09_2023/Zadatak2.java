package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
//    2.Zadatak
//Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//Klik na svako dugme od PRIMARY do DARK
//Sacekati da se toasts u desnom gornjem uglu pojavi
//Pauza izmedju klikova 1s
//Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s
public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

    List<WebElement> btns = driver.findElements(By.cssSelector(".pb-4>div>section>div>button"));

    for (int i = 0; i < btns.size(); i++) {
        btns.get(i).click();
        wait
                .withMessage("Element nije vidljiv")
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'toast fade mx-auto toast-')]")));
        Thread.sleep(1000);

    }








    driver.quit();






}
}
