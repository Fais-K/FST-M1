package CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestCRM {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test(priority = 0)
    public void verifyTitle(){
        String title = driver.getTitle();

        Assert.assertEquals(title, "SuiteCRM");

        System.out.println("Title verification passed.");
    }

    @Test(priority = 1)
    public void printURL(){
        WebElement img = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));

        String src = img.getAttribute("src");

        System.out.println("src: " + src);

    }

    @Test(priority = 2)
    public void printCopyright(){
        WebElement elem = driver.findElement(By.xpath("//a[@id='admin_options']"));
        String copyrightText = elem.getText();

        System.out.println("Copyright Text: " + copyrightText);

    }

    @Test(priority = 3)
    public void login(){
        WebElement user = driver.findElement(By.xpath("//input[@id='user_name']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='username_password']"));

        WebElement login = driver.findElement(By.xpath("//input[@id='bigbutton']"));

        user.sendKeys("admin");
        pass.sendKeys("pa$$w0rd");

        login.click();

        Assert.assertEquals("https://alchemy.hguy.co/crm/index.php?module=Home&action=index", driver.getCurrentUrl());

        System.out.println("Login successful.");

    }

    @Test(priority = 4)
    public void getNavigationColor(){
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toolbar']")));

        WebElement menu = driver.findElement(By.xpath("//div[@id='toolbar']"));

        String color = menu.getCssValue("color");

        System.out.println("Color: " + color);
    }

    @Test(priority = 5)
    public void activitiesExists(){
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='grouptab_3']")));

        WebElement elem = driver.findElement(By.xpath("//a[@id='grouptab_3']"));
        Assert.assertTrue(elem.isDisplayed());
        Assert.assertTrue(elem.isEnabled());

        System.out.println("Activities menu item exists and clickable.");
    }

    @Test(priority = 6)
    public void popup() throws InterruptedException {
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='grouptab_0']")));

        WebElement menu = driver.findElement(By.xpath("//a[@id='grouptab_0']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a[1]"));

        actions.moveToElement(subMenu);

        actions.click().build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='adspan_1bf01e91-1f26-5249-ed14-63294367a7e5']//span[@title='Additional Details']")));

        WebElement infoBtn = driver.findElement(By.xpath("//span[@id='adspan_1bf01e91-1f26-5249-ed14-63294367a7e5']//span[@title='Additional Details']"));

        infoBtn.click();

        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));

        WebElement phone = driver.findElement(By.xpath("//span[@class='phone']"));

        String mob = phone.getText();

        System.out.println("Phone: " + mob);

        Thread.sleep(1000);
    }

    @Test(priority = 7)
    public void printAccountDetails(){
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='grouptab_0']")));

        WebElement menu = driver.findElement(By.xpath("//a[@id='grouptab_0']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[2]//a[1]"));

        actions.moveToElement(subMenu);

        actions.click().build().perform();

        //List<WebElement> webelements = driver.findElements(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/*"));

        for(int i=1; i<11; i+=2){
            String Xpath = "//tbody/tr["+String.valueOf(i)+"]/td[3]/b[1]/a[1]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

            String name = driver.findElement(By.xpath(Xpath)).getText();

            System.out.println(name);
        }
    }

    @Test(priority = 8)
    public void traverseLeadPage(){
        login();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='grouptab_0']")));

        WebElement menu = driver.findElement(By.xpath("//a[@id='grouptab_0']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(menu);

        WebElement subMenu = driver.findElement(By.xpath("//li[2]//span[2]//ul[1]//li[5]//a[1]"));

        actions.moveToElement(subMenu);

        actions.click().build().perform();

        for(int i=1; i<11; i++){
            String nameXpath = "//tbody/tr["+String.valueOf(i)+"]/td[3]/b[1]/a[1]";
            String userXpath = "//tbody/tr["+String.valueOf(i)+"]/td[8]/a[1]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameXpath)));

            String name = driver.findElement(By.xpath(nameXpath)).getText();
            String user = driver.findElement(By.xpath(userXpath)).getText();

            System.out.println("Name: "+name+"\t User: "+user);
        }
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }



}
