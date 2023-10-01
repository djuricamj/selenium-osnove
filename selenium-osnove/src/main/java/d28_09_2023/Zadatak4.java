package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
//4.Zadatak
//Ucitati stranicu http://seleniumdemo.com/?post_type=product
//Klik na search dugme u gornjem desnom uglu
//Cekati da forma za pretragu bude vidljiva
//Uneti sledeci tekst za pretragu BDD Cucumber i ENTER
//Dohvatiti prvi rezultat pretrage i proveriti da li u nazivu sadrzi tekst koji je unet za pretragu. Ispisati odgovarajuce poruke u terminalu
public static void main(String[] args) {

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    driver.get("http://seleniumdemo.com/?post_type=product");

    driver
            .findElement(By.cssSelector(".topbar-nav__utils>ul>li> a")).click();

    wait
            .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search__wrapper")));

    driver
            .findElement(By.cssSelector(".search__wrapper")).sendKeys("BDD Cucumber");
    driver
            .findElement(By.cssSelector(".search__wrapper")).sendKeys(Keys.ENTER);

    String text = driver
                         .findElement(By.cssSelector(".czr-title")).getText();

    if (text.equals("BDD Cucumber")){
        System.out.println("U nazivu postoji BDD Cucumber" );
    }else System.out.println(" nazivu ne postoji BDD Cucumber");






}
}
