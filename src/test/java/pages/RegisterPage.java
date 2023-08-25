package pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage{
    private By myAccountDropDown = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    private By btnRegister = By.linkText("Register");
    private By inputFirstName = By.id("input-firstname");
    private By inputLastName = By.id("input-lastname");
    private By inputEmail = By.id("input-email");
    private By inputTelephone = By.id("input-telephone");
    private By inputPassword = By.id("input-password");
    private By inputRepeatPassword = By.id("input-confirm");
    private By inputNoNewsletter = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
    private By inputAgreePolicy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
    private By inputContinue = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    private By contentSuccessfulRegister = By.cssSelector("div#content p");

    public void toRegister() {
        this.clickear(myAccountDropDown);
        this.clickear(btnRegister);
    }

    public void escribirFirstName(String firstName) {
        this.sendText(firstName, inputFirstName);
    }

    public void escribirLastName(String lastName) {
        this.sendText(lastName, inputLastName);
    }

    public void escribirEmail(String email) {
        this.sendText(email, inputEmail);
    }

    public void escribirTelephone(String telephone) {
        this.sendText(telephone, inputTelephone);
    }

    public void escribirPassword(String password) {
        this.sendText(password, inputPassword);
    }

    public void escribirConfirmarPassword(String confirmarPassword) {
        this.sendText(confirmarPassword, inputRepeatPassword);
    }

    public void clickNoNewsletter() {
        this.clickear(inputNoNewsletter);
    }

    public void clickAgreePolicy() {
        this.clickear(inputAgreePolicy);
    }

    public void clickContinue() {
        this.clickear(inputContinue);
    }

    public String getContent() {
        return this.getText(contentSuccessfulRegister);
    }
}
