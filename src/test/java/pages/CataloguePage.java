package pages;

import org.openqa.selenium.By;

public class CataloguePage extends BasePage{
    private By inputSearch = By.name("search");
    private By btnSearch = By.xpath("//*[@id=\"search\"]/span/button");
    private By btnAddToCart = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
    private By alert = By.className("alert-success");

    public void escribirEnBuscador(String text) {
        this.sendText(text, inputSearch);
    }
    public void buscar() {
        this.clickear(btnSearch);
    }
    public void agregarProductoAlCarrito() {
        this.clickear(btnAddToCart);
    }
    public String obtenerTextoAlerta() {
        return this.getText(alert);
    }
}
