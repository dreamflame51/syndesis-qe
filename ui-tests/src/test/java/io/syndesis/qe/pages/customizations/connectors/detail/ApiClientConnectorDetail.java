package io.syndesis.qe.pages.customizations.connectors.detail;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import io.syndesis.qe.pages.SyndesisPageObject;

public class ApiClientConnectorDetail extends SyndesisPageObject {

    private static final class Element {
        public static final By ROOT = By.cssSelector("syndesis-api-connector-detail");
    }

    @Override
    public SelenideElement getRootElement() {
        return $(Element.ROOT).should(exist);
    }

    @Override
    public boolean validate() {
        return getRootElement().exists();
    }

    public void edit(SelenideElement editableText) {
        editableText.shouldBe(visible).click();
    }

    public SelenideElement getEditablePropertyLabel(String propertyName) {
        return $(By.xpath("//label[text()='" + propertyName + "']")).shouldBe(visible);
    }

    public SelenideElement getTextToEditElement(String propertyName) {
        return getEditablePropertyLabel(propertyName).$(By.xpath("./following-sibling::*/descendant-or-self::span[@class='syn-form-row__input--editor']"));
    }

    public SelenideElement getTextEditor(String id) {
        return $(byId(id)).shouldBe(visible);
    }
}
