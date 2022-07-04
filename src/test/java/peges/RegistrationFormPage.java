package peges;

import com.codeborne.selenide.SelenideElement;
import peges.components.CalendarComponent;
import peges.components.ResultTableComponent;
import peges.components.UploadFileComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    UploadFileComponent uploadFileComponent = new UploadFileComponent();
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            addressInput = $("#currentAddress"),
            stateField = $("#state"),
            stateInput = $("#stateCity-wrapper"),
            cityFild = $("#city"),
            cityFildInput = $("#stateCity-wrapper"),
            submitPress = $("#submit"),
            closePress = $("#closeLargeModal");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String value) {
        subjectInput.sendKeys(value);
        subjectInput.pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadFileComponent.uploadPicture(value);
        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateField.click();
        stateInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityFild.click();
        cityFildInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage pressSubmit() {
        submitPress.click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        resultTableComponent.checkResult(key, value);
        return this;
    }

    public RegistrationFormPage pressClose() {
        closePress.click();
        return this;
    }
}