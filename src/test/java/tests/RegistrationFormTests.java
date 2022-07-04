package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormTests extends TestBase {
    @Test
    void successfulTest() {
        String firstName = "Alex";
        String lastName = "Egorov";
        String email = "alex@egorov.com";
        String gender = "Other";
        String number = "1231231230";
        String day = "30";
        String month = "July";
        String year = "2008";
        String subject = "Maths";
        String hobby = "Sports";
        String address = "Street 1";
        String file = "summer.jpeg";
        String state = "NCR";
        String city = "Delhi";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setDateOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture("img/" + file)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pressSubmit()
                .checkTitleResult()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", file)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city)
                .pressClose();
    }
}