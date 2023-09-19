import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogout {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ConstructorSection.URL);
    }

    @After
    public void setDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void testLogout() {
        LoginPage objLoginPage = new LoginPage(driver);
        LogoutPage objLogoutPage = new LogoutPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail("whte208@gmail.com");
        objLoginPage.enterPassword("qwerty124");
        objLoginPage.clickButtonEnterModal();
        objLoginPage.clickButtonEnterPersonal();
        objLogoutPage.waitForLoadPage();
        objLogoutPage.clickButtonExit();
        objLogoutPage.verifyLogout();
    }

}
