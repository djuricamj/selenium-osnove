import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    //    Zadatak
//Maksimizirati prozor
//Ucitati stranicu https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//Prijavite se na sistem
//Username: Admin
//Password: admin123
//Cekanje od 5s
//U input za pretragu iz navigacije unesite tekst Me
//Kliknite na prvi rezultat pretrage (to ce biti Time)
//Cekanje od 1s
//Kliknite u headeru na svog avatara (to ce biti na ime: Paul Collings)
//Klinkite na logout
//Cekanje od 5s
//Zatvorite pretrazivac
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);

        driver
                .findElement(By.xpath("//input[@placeholder='Username']")).clear();
        driver
                .findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");


        driver
                .findElement(By.xpath("//input[@placeholder='Password']")).clear();
        driver
                .findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

        driver
                .findElement(By.xpath("//button[@type='submit']")).click();


        Thread.sleep(5000);


        driver
                .findElement(By.xpath("//input[@placeholder='Search']")).clear();
        driver
                .findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Me");
        driver
                .findElement(By.xpath("//span[contains(@class,'oxd-text oxd-text--span')]")).click();


        Thread.sleep(1000);


        driver
                .findElement(By.xpath("//p[contains(@class, 'oxd-userdropdown-name')]")).click();
        driver
                .findElement(By.xpath("//ul[contains(@class,'oxd-dropdown-menu')]/li[4]/a")).click();


        Thread.sleep(5000);

        driver.quit();



    }
    }