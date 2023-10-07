package d03_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Zadatak1 {
    private WebDriver driver;
    private WebDriverWait wait;
    String baseUrl = "https://s.bootsnipp.com/iframe/K5yrx";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to(baseUrl);
    }

    @Test(priority = 1)
    public void editRow() {

        String firstName = "Nikola";
        String lastName = "Jovic";
        String middleName = "Stefan";

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Home page title should be 'Table with Edit and Update Data - Bootsnipp.com' ");

        driver.findElement(By.cssSelector("tr#d1 [data-target='#edit']")).click();

        wait
                .withMessage("Edit dialog is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#edit > div.modal-dialog > div > div.modal-header > h4")));

        driver.findElement(By.cssSelector("input#fn")).clear();
        driver.findElement(By.cssSelector("input#fn")).sendKeys(firstName);

        driver.findElement(By.cssSelector("input#ln")).clear();
        driver.findElement(By.cssSelector("input#ln")).sendKeys(lastName);

        driver.findElement(By.cssSelector("input#mn")).clear();
        driver.findElement(By.cssSelector("input#mn")).sendKeys(middleName);

        driver.findElement(By.cssSelector("button#up")).click();

        wait
                .withMessage("Edit dialog is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit > div.modal-dialog > div")));

        Assert.assertEquals(driver.findElement(By.cssSelector("td#f1")).getText(), firstName, "New First Name in first row doesn't match input value.");
        Assert.assertEquals(driver.findElement(By.cssSelector("td#l1")).getText(), lastName, "New Last Name in first row doesn't match input value.");
        Assert.assertEquals(driver.findElement(By.cssSelector("td#m1")).getText(), middleName, "New Middle Name in first row doesn't match input value.");

    }

    @Test(priority = 2)
    public void deleteRow () {

        Assert.assertEquals(driver.getTitle(),
                "Table with Edit and Update Data - Bootsnipp.com",
                "Home page title should be 'Table with Edit and Update Data - Bootsnipp.com' ");

        driver.findElement(By.cssSelector("tr#d1 [data-target='#delete']")).click();

        wait
                .withMessage("Edit dialog is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#delete > div.modal-dialog > div > div.modal-header > h4")));

        List<WebElement> previousRows = driver.findElements(By.cssSelector("tbody > tr > td"));

        List<WebElement> numberOfCellsInEachRow = driver.findElements(By.cssSelector("#d1 > td"));

        driver.findElement(By.cssSelector("button#del")).click();

        wait
                .withMessage("Edit dialog is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#delete > div.modal-dialog > div > div.modal-header > h4")));

        List<WebElement> formerRows = driver.findElements(By.cssSelector("tbody > tr > td"));

        Assert.assertEquals(formerRows.size(), previousRows.size() - numberOfCellsInEachRow.size(), "Number of rows should be less by one");

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

