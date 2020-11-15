package com.udacity.jwdnd.spring_security_basics;

import com.udacity.jwdnd.spring_security_basics.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChatPage {
    @FindBy(id="messageText")
    private WebElement textField;

    @FindBy(id="submitMessage")
    private WebElement submitButton;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendChatMessage(String text) {
        this.textField.sendKeys(text);
        this.submitButton.click();
    }

    public ChatMessage getFirstMessage() {
        ChatMessage result = new ChatMessage();
        result.setMessageText(firstMessageText.getText());
        result.setUsername(getFirstMessage().getUsername());
        return result;
    }
}
