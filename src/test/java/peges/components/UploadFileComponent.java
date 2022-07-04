package peges.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UploadFileComponent {
    SelenideElement uploadPicture = $("#uploadPicture");

    public void uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
    }
}