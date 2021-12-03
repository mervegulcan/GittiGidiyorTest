package test;

import org.example.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class FirstTest  extends BaseTest {

    String userName = "projeodevihesabi@gmail.com";
    String userPass = "369852asd.";

    @Test
    public  void login() throws InterruptedException {
        //kullanıcı login olur
        TimeUnit.SECONDS.sleep(2);
        WebElement element = driver.findElement(By.xpath("//div[@class='gekhq4-8 iHquZr']"));
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("a[data-cy='header-login-button']")).click();
        TimeUnit.SECONDS.sleep(3);

        WebElement inputName = driver.findElement(By.id("L-UserNameField"));
        inputName.sendKeys(userName + Keys.ENTER);
        Thread.sleep(3);
        System.out.println("Kullanıcı adı yazıldı");


        Thread.sleep(3);

        WebElement inputPass = driver.findElement(By.id("L-PasswordField"));
        inputPass.sendKeys(userPass + Keys.ENTER);
        Thread.sleep(3);

        System.out.println("Password yazıldı");

        //Vazo ürünü aranır.
        WebElement productSearch = driver.findElement(By.name("k"));
        productSearch.sendKeys("Vazo"+ Keys.ENTER);
        Thread.sleep(10);

        //Sayfa scroll edilir.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        TimeUnit.SECONDS.sleep(10);

        //Vazo ürü
        List<String> randomClick = new LinkedList<String>();
        String[] random = new String[5];
        List<Integer> numberList = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < 32; i++) {
            randomClick.add("(//div[@data-cy='product-favorite'])["+(i+1)+"]");
        }

        for (int i = 0; i < 4; i++) {
            int ran = rand.nextInt(31);

            if (numberList.contains(ran)){
                i--;
            }else {
                random[i] = randomClick.get(ran);
                numberList.add(ran);
            }
            System.out.println(randomClick.get(ran));
        }

        for (int i = 0; i < 4; i++) {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath(random[i]))).click().build().perform();
        }
        TimeUnit.SECONDS.sleep(10);

        js.executeScript("window.location = 'http://www.gittigidiyor.com/'");
        TimeUnit.SECONDS.sleep(10);


        WebElement cantaAra = driver.findElement(By.name("k"));
        cantaAra.sendKeys("çanta"+ Keys.ENTER);
        Thread.sleep(10);


        WebElement cantaTıkla = driver.findElement(By.xpath("//*[@title='LÜKS KARE HASIR BAYAN ÇANTA']"));
        cantaTıkla.click();
        Thread.sleep(1000);

        WebElement sepeteEkle = driver.findElement(By.xpath("//button[@id='add-to-basket']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()",sepeteEkle);


        Thread.sleep(1000);

        WebElement sepeteGit = driver.findElement(By.xpath("//a[@class='gg-ui-btn-default padding-none']"));
        sepeteGit.click();
        Thread.sleep(1000);

        Select selectProduct = new Select(driver.findElement(By.xpath("//select[@class='amount']")));
        selectProduct.selectByIndex(1);
        TimeUnit.SECONDS.sleep(5);

        WebElement odemeYap = driver.findElement(By.xpath("//input[@type='submit']"));
        odemeYap.click();
        System.out.println( "ödeme");


        WebElement odemeyiTamamla = driver.findElement(By.xpath("//button[@value='Kaydet']"));
        odemeyiTamamla.click();

        WebElement hataAdres = driver.findElement(By.xpath("//div[@class='gg-input-error-text gg-d-24']"));
        String adress = hataAdres.getText();
        Assert.assertEquals("Adres Bilgisi Hatalı",adress,hataAdres.getText());


       WebElement sepetiDuzenle = driver.findElement(By.xpath("//a[@title='Sepeti Düzenle']"));
       sepetiDuzenle.click();
        TimeUnit.SECONDS.sleep(5);

        WebElement favoriSepeteEkle = driver.findElement(By.xpath("(//a[@class='gg-ui-btn-default btn-add-to-basket'])[6]"));
        favoriSepeteEkle.click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sepete eklendi");


        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='gekhq4-4 egoSnI'])[1]"))).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='gekhq4-4 egoSnI'])[1]"))).clickAndHold().pause(2000)
                .click().build().perform();


        WebElement logOut = driver.findElement(By.xpath("(//a[@class='sc-84am1q-0 sc-1r48nyr-0 dGMkVn sc-12t95ss-6 jfpyWy'])[16]"));
        logOut.click();
        System.out.println("çıkış yapıldı");
        driver.quit();
    }


}
