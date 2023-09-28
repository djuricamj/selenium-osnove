package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {

//Zadatak
//Napisati program koji vrsi dodavanje 5 redova
//Maksimizirati prozor
//Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//Klik na dugme Add New
//Unesite name,departmant i phone (uvek iste vrednost)
//Trazenje po name atributu
//Kliknite na zeleno Add dugme.
//PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit, add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
//Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i last() fukncionalnost za xpath. Koristan link last mehnizma
//Cekanje od 0.5s
//Na kraju programa ugasite pretrazivac.


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

//        List<WebElement> data = driver.findElements(By.cssSelector(".todo-list>li>div>input"));

        for (int i = 0; i < 5; i++) {
            driver
                    .findElement(By.cssSelector(".btn-info")).click();

            driver
                    .findElement(By.name("name")).sendKeys("Marijana");
            driver
                    .findElement(By.name("department")).sendKeys("HR");
            driver
                    .findElement(By.name("phone")).sendKeys("(312)564-322");

            driver
                    .findElement(By.xpath("//tr[" + (i + 4) + "]/td[4]/a[1]/i")).click();


        }
        Thread.sleep(500);

        driver.quit();



    }
}
