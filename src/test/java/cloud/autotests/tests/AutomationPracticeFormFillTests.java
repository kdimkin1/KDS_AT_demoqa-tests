package cloud.autotests.tests;

import cloud.autotests.helpers.AllureAttachments;
import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class AutomationPracticeFormFillTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWebDriver();
    }


    @Test
    @Description("AutomationPracticeFormFillTests")
    @DisplayName("AutomationPracticeFormFillTests(demoqa.com).")
    void apfSuccessFillTest() {
        step("Открыть https://demoqa.com/automation-practice-form", () -> {

            open("/automation-practice-form");
            $(".main-header").shouldHave(text("Practice Form"));

        });

        step("Заполнить поле First Name(Anton)", () -> {
            $("#firstName").setValue("Anton");
        });

        step("Заполнить поле Last Name (Gorodetskiy)", () -> {
            $("#lastName").setValue("Gorodetskiy");
        });

        step("Заполнить поле Email (Anton.Gorodetskiy@mail.com)", () -> {
            $("#userEmail").setValue("Anton.Gorodetskiy@mail.com");
        });

        step("Заполнить поле Gender (Male)", () -> {
            $(byText("Male")).click();
        });

        step("Заполнить поле Mobile (9296112233)", () -> {
            $("#userNumber").setValue("9296112233");
        });

        step("Заполнить поле Date of Birth (19 Aug 1982)", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1982");
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__day--019").click();
        });

        step("Заполнить поле Subject (Social Studies, Accounting)", () -> {
            $("div.subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3").click();
            $("#subjectsInput").setValue("Social Studies").pressEnter();
            $("#subjectsInput").setValue("Accounting").pressEnter();
        });

        step("Заполнить чекбокс Hobbies (Sports, Music)", () -> {
            $(byText("Sports")).click();
            $(byText("Music")).click();
        });

        step("Добавить картинку Picture (AntonG.jpg)", () -> {
            File file = new File("src/test/resources/AntonG.jpg");
            //#uploadPicture
            $("#uploadPicture").uploadFile(file);
        });

        step("Заполнить поле Current Address (Karnal Bus Stand)", () -> {
            $("#currentAddress").setValue("Karnal Bus Stand");
        });

        step("Заполнить поле State(Haryana)", () -> {
            // скрыть блок рекламы, если есть
            if ($("#close-fixedban > img").exists() == true) {
                $("#close-fixedban > img").click();
            }
            //#state > div > div.css-1wy0on6 > div > svg
            $("#state").click();
            $(byText("Haryana")).click();
        });

        step("Заполнить поле City (Karnal)", () -> {
            //#city > div > div.css-1wy0on6 > div > svg
            $("#city").click();
            $(byText("Karnal")).click();
        });

        step("Отправить форму (Submit)", () -> {
            $("#submit").click();
        });

        step("Проверить успешную отправку (содержание формы ответа).", () -> {
            step("// todo: just add selenium action");
            //body > div.fade.modal.show > div > div > div.modal-header
            $(".modal-header").shouldHave(text("Thanks for submitting the form"));
            //body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody
            $(".table").shouldHave(
                    text("Anton Gorodetskiy"),
                    text("Anton.Gorodetskiy@mail.com"),
                    text("Male"),
                    text("9296112233"),
                    text("19 August,1982"),
                    text("Social Studies, Accounting"),
                    text("Sports, Music"),
                    text("AntonG.jpg"),
                    text("Karnal Bus Stand"),
                    text("Haryana Karnal"));
        });
        step("Закрыть форму (Close)", () -> {
            // #closeLargeModal
            $("#closeLargeModal").click();
        });


    }

    @Test
    @Description("AutomationPracticeFormFillTests(Unsuccess)")
    @DisplayName("Unsuccess_AutomationPracticeFormFillTests(demoqa.com).")
    void apfUnsuccessFillTest() {
        step("Открыть https://demoqa.com/automation-practice-form", () -> {

            open("/automation-practice-form");
            $(".main-header").shouldHave(text("Practice Form"));

        });

        step("Заполнить поле First Name(Anton)", () -> {
            $("#firstName").setValue("Anton");
        });

        step("Заполнить поле Last Name (Gorodetskiy)", () -> {
            $("#lastName").setValue("Gorodetskiy");
        });

        step("Заполнить поле Email (Anton.Gorodetskiy@mail.com)", () -> {
            $("#userEmail").setValue("Anton.Gorodetskiy@mail.com");
        });

        step("Заполнить поле Gender (Male)", () -> {
            $(byText("Male")).click();
        });

        step("Заполнить поле Mobile (9296112233)", () -> {
            $("#userNumber").setValue("9296112233");
        });

        step("Заполнить поле Date of Birth (19 Aug 1982)", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1982");
            $(".react-datepicker__month-select").selectOption("August");
            $(".react-datepicker__day--019").click();
        });

        step("Заполнить поле Subject (Social Studies, Accounting)", () -> {
            $("div.subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3").click();
            $("#subjectsInput").setValue("Social Studies").pressEnter();
            $("#subjectsInput").setValue("Accounting").pressEnter();
        });

        step("Заполнить чекбокс Hobbies (Sports, Music)", () -> {
            $(byText("Sports")).click();
            $(byText("Music")).click();
        });

        step("Добавить картинку Picture (AntonG.jpg)", () -> {
            File file = new File("src/test/resources/AntonG.jpg");
            //#uploadPicture
            $("#uploadPicture").uploadFile(file);
        });

        step("Заполнить поле Current Address (Karnal Bus Stand)", () -> {
            $("#currentAddress").setValue("Karnal Bus Stand");
        });

        step("Заполнить поле State(Haryana)", () -> {
            // скрыть блок рекламы, если есть
            if ($("#close-fixedban > img").exists() == true) {
                $("#close-fixedban > img").click();
            }
            //#state > div > div.css-1wy0on6 > div > svg
            $("#state").click();
            $(byText("Haryana")).click();
        });

        step("Заполнить поле City (Karnal)", () -> {
            //#city > div > div.css-1wy0on6 > div > svg
            $("#city").click();
            $(byText("Karnal")).click();
        });

        step("Отправить форму (Submit)", () -> {
            $("#submit").click();
        });
        step("Проверить успешную отправку (содержание формы ответа).", () -> {
            //body > div.fade.modal.show > div > div > div.modal-header
            $(".modal-header").shouldHave(text("Thanks for submitting the form"));
            //body > div.fade.modal.show > div > div > div.modal-body > div > table > tbody
            $(".table").shouldHave(
                    text("Fedor Gorodetskiy"),
                    text("Anton.Gorodetskiy@mail.com"),
                    text("Male"),
                    text("9296112233"),
                    text("19 August,1982"),
                    text("Social Studies, Accounting"),
                    text("Sports, Music"),
                    text("AntonG.jpg"),
                    text("Karnal Bus Stand"),
                    text("Haryana Karnal"));
        });
        step("Закрыть форму (Close)", () -> {
            // #closeLargeModal
            $("#closeLargeModal").click();
        });


    }


    @Test
    @Description("Page title should have header text")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://demoqa.com/automation-practice-form'", () ->
            open("/automation-practice-form"));
        step("Page title should have text 'ToolsQA'", () -> {
            String expectedTitle = "ToolsQA";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Page console log should not have errors")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://demoqa.com/automation-practice-form'", () ->
            open("/automation-practice-form"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}