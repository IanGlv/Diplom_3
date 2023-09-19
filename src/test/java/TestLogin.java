import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestLogin {

    private final String Email;
    private final String Password;

    public TestLogin(String Email, String Password) {
        this.Email = Email;
        this.Password = Password;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][] {
                { "whte208@gmail.com", "qwerty124"},
        };
    }

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverCreator.createWebDriver();
    }
    @After
    public void setDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginMainPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterMain();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
        objLoginPage.clickButtonEnterModal();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginPersonalPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterPersonal();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginRegistrationPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/register");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterRegistration();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginForgotPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickButtonEnterForgot();
        objLoginPage.enterEmail(Email);
        objLoginPage.enterPassword(Password);
    }

}
