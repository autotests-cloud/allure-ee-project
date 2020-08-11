package cloud.autotests.tests;

import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static cloud.autotests.helpers.AttachmentsHelper.*;
import static cloud.autotests.helpers.DriverHelper.*;
import static cloud.autotests.helpers.EnvironmentHelper.*;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    public static String
            DEFAULT_LOGIN = "Alex",
            DEFAULT_PASSWORD = "12345";

    @BeforeAll
    @Step("Tests setup")
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        configureSelenide();
    }

    @AfterEach
    @Step("Attachments")
    public void afterEach(){
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
//        attachNetwork(); // todo
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn) attachVideo(sessionId); // in browserstack video url generates after driver close

        closeWebDriver();
    }
}
