import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class StepImplementation extends Throwable{

    @Step("access <url> in browser.")
    public void accessUrl(String url) {
        System.setProperty("selenide.browser", "Chrome");
        Selenide.open(url);
    }

    @Step("input <word> in <selector> element.")
    public void inputTextIn(String word, String selector) {
        Selenide.$(selector).val(word);
    }

    @Step("click <selector> element.")
    public void click(String selector) {
        Selenide.$(selector).click();
    }

    @Step("verify page shows <text> link.")
    public void verifyLinkByText(String text) {
        Selenide.$(Selectors.byLinkText(text)).is(Condition.exist);
    }
}
