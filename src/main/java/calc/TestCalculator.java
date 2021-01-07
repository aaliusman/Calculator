package calc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculator {

    WebDriver driver;
    String url = "https://duffmanns.github.io/calc-test/calculator/app/index.html";

    @Test
    public void testAddition() {

        System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver");
        driver = new ChromeDriver();

        //Expected result
        int expectedSum1 = 4;
        int expectedSum2 = 11;
        int expectedSum3 = 10;
        int expectedTotal = expectedSum1 + expectedSum2 + expectedSum3;

        //Test one
        driver.get(url);
        waitUntilVisible(By.id("one"));
        driver.findElement(By.id("one")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.id("three")).click();
        driver.findElement(By.id("equals")).click();
        String sumOne = driver.findElement(By.id("display")).getText();
        int actualSum1 = Integer.parseInt(sumOne);
        Assert.assertEquals(actualSum1, expectedSum1, "Addition Test one failed");

        //Test two
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("five")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.id("six")).click();
        driver.findElement(By.id("equals")).click();
        String sumTwo = driver.findElement(By.id("display")).getText();
        int actualSum2 = Integer.parseInt(sumTwo);
        Assert.assertEquals(actualSum2, expectedSum2, "Addition Test two failed");

        //Test three
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("three")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.id("seven")).click();
        driver.findElement(By.id("equals")).click();
        String sumhThree = driver.findElement(By.id("display")).getText();
        int actualSum3 = Integer.parseInt(sumhThree);
        Assert.assertEquals(actualSum3, expectedSum3, "Addition Test three failed");

        //Test four
        int actualTotal = actualSum1 + actualSum2 + actualSum3;
        Assert.assertEquals(actualTotal, expectedTotal, "Addition Test Four Failed");
    }

    @Test
    public void testDecimals() {

        //Expected result
        int expectedDiv1 = 5;
        int expectedDiv2 = 3;
        int expectedDiv3 = 50;
        int expectedDiv4 = 0;
        String expectedDiv5 = "Error";

        //Test one
        waitUntilVisible(By.id("five"));
        driver.findElement(By.id("five")).click();
        driver.findElement(By.xpath("//input[@value='÷']")).click();
        driver.findElement(By.id("one")).click();
        driver.findElement(By.id("equals")).click();
        String divOne = driver.findElement(By.id("display")).getText();
        int actualDiv1 = Integer.parseInt(divOne);
        Assert.assertEquals(actualDiv1, expectedDiv1, "Division Test one failed");

        //Test two
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("six")).click();
        driver.findElement(By.xpath("//input[@value='÷']")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("equals")).click();
        String divTwo = driver.findElement(By.id("display")).getText();
        int actualDiv2 = Integer.parseInt(divTwo);
        Assert.assertEquals(actualDiv2, expectedDiv2, "Division Test two failed");

        //Test Three
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("one")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.xpath("//input[@value='÷']")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("equals")).click();
        String divThree = driver.findElement(By.id("display")).getText();
        int actualDiv3 = Integer.parseInt(divThree);
        Assert.assertEquals(actualDiv3, expectedDiv3, "Division Test three failed");

        //Test Four
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.xpath("//input[@value='÷']")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("equals")).click();
        String divFour = driver.findElement(By.id("display")).getText();
        int actualDiv4 = Integer.parseInt(divFour);
        Assert.assertEquals(actualDiv4, expectedDiv4, "Division Test four failed");

        //Test Five
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("four")).click();
        driver.findElement(By.xpath("//input[@value='÷']")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("equals")).click();
        String actualDiv5 = driver.findElement(By.id("display")).getText();
        Assert.assertEquals(actualDiv5, expectedDiv5, "Division Test five failed");
    }

    @Test
    public void testDivision() {

        //Expected result
        double expectedDec1 = 3.15354;
        String expectedDec2 = "Error";

        //Test one
        waitUntilVisible(By.id("zero"));
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.xpath("//input[@value='.']")).click();
        driver.findElement(By.id("five")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.xpath("//input[@value='.']")).click();
        driver.findElement(By.id("six")).click();
        driver.findElement(By.id("five")).click();
        driver.findElement(By.id("three")).click();
        driver.findElement(By.id("five")).click();
        driver.findElement(By.id("four")).click();
        driver.findElement(By.id("equals")).click();
        String decOne = driver.findElement(By.id("display")).getText();
        Double actualDec1 = Double.parseDouble(decOne);
        Assert.assertEquals(actualDec1, expectedDec1, "Decimal Test one failed");

        //Test two
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("one")).click();
        driver.findElement(By.xpath("//input[@value='.']")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("five")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='.']")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("five")).click();
        driver.findElement(By.xpath("//input[@value='÷']")).click();
        driver.findElement(By.id("zero")).click();
        driver.findElement(By.id("equals")).click();
        String actualDec2 = driver.findElement(By.id("display")).getText();
        Assert.assertEquals(actualDec2, expectedDec2, "Decimal Test two failed");
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
