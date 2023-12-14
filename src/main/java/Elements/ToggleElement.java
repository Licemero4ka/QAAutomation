package Elements;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class ToggleElement {
    private SelenideElement title;
    private SelenideElement firstButton;
    private SelenideElement secondButton;
    private List<SelenideElement> buttons;

    public ToggleElement(SelenideElement element) {
        this.title = element.$x("//*[@class='nts-modal__modifier--title']");
        this.firstButton = element.$x("");
        this.secondButton = element.$x("");
        this.buttons = $$x("");
    }

    public ToggleElement clickButton(String text) {
        buttons.stream().filter(button -> button.getText().equals(text)).findFirst().get().click();
        return this;
    }

    ;

    public String getTitle() {
        return this.title.getText();
    }
}
