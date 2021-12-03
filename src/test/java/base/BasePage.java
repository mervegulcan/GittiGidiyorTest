package base;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends BaseTest {

    public  BasePage(WebDriver driver) {
        this.driver = driver;

    }
    public WebElement findElement(By by){
        return  wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected JavascriptExecutor getJSExecutor(){
        return (JavascriptExecutor)  driver;

    }
    protected  void scrollTo(int x,int y){
        String jsStmt =String.format("window.scrollTo(%d,%d);",x,y);
        getJSExecutor().executeScript(jsStmt,true);
    }

    public void  hoverElement(By by){
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }
}
