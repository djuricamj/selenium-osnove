package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jshell.spi.ExecutionControl;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {

//    Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//Visit Paris
//Visit Prague
//Visit London
//Visit New York
//Visit Belgrade
//Maksimizirati prozor
//Ucitati stranicu https://example.cypress.io/todo
//Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//Nakon svakog unosa todo-a, unosi se enter. Koristan link
//Nakon svih unosa proci petljom kroz svaki todo koji je na stranici i za svaki cekirati da je completed.
//Cekanje od 5s
//Zatvorite pretrazivac

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        ArrayList<String> toDos = new ArrayList<>();
        toDos.add("Visit Paris");
        toDos.add("Visit Prague");
        toDos.add("Visit London");
        toDos.add("Visit New York");
        toDos.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.get(" https://example.cypress.io/todo");

        Thread.sleep(1000);

        for (int i = 0; i < toDos.size(); i++) {
            driver
                    .findElement(By.cssSelector(".new-todo")).sendKeys(toDos.get(i));
            driver
                    .findElement(By.cssSelector(".new-todo")).sendKeys(Keys.ENTERz);

        }

        List<WebElement> check = driver.findElements(By.cssSelector(".todo-list>li>div>input"));

        for (int i = 0; i < check.size() ; i++) {
            check.get(i).click();

        }

        Thread.sleep(5000);

        driver.quit();






    }
}
