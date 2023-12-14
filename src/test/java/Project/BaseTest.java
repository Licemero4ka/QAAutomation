package Project;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static Utils.PropertyHelper.*;
import static Utils.PropertyHelper.getPageLoadTimeout;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.pageLoadTimeout;


public class BaseTest {

    @BeforeClass
    protected void setBrowser() {
        browser = getBrowserProperty();
        browserSize = getBrowserSizeProperty();
        timeout = getTimeoutProperty();
        pageLoadTimeout = getPageLoadTimeout();
    }

    @AfterMethod
    public void cleanUp() {
        Selenide.closeWebDriver();
    }
}
