package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import pages.BasePage;
import pages.CataloguePage;
import reports.ExtentFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BuscarYAgregarProducto {
    public CataloguePage cataloguePage;
    public static ExtentReports extent;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/reporte_test_buscar_producto.html");

    @BeforeAll
    public static void setupDriver() {
        BasePage.setupChromeDriver();
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }
    @BeforeEach
    public void setupCataloguePage() throws InterruptedException {
        cataloguePage = new CataloguePage();
        cataloguePage.url("http://opencart.abstracta.us/index.php?route=common/home");
    }
    @AfterAll
    public static void reporte() {
        extent.flush();
    }
    @AfterEach
    public void closeRegistePge() throws InterruptedException {
        cataloguePage.close();
    }

    @Test
    @Tag("agregar-al-carrito")
    public void buscarYAgregarProducto() {
        ExtentTest test = extent.createTest("Buscar un producto y agregarlo al carrito");

        cataloguePage.escribirEnBuscador("iphone");
        test.log(Status.PASS, "Escribir en el buscador");

        cataloguePage.buscar();
        test.log(Status.PASS, "Buscar");

        cataloguePage.agregarProductoAlCarrito();
        test.log(Status.PASS, "Agregar producto al carrito");

        String textoAlerta = cataloguePage.obtenerTextoAlerta();

        if(textoAlerta.contains("Success: You have added iPhone to your shopping cart!")) {
            test.log(Status.PASS, "Mensaje de alerta correcto al agregar producto al carrito");
        }else {
            test.log(Status.FAIL, "Mensaje de alerta incorrecto al agregar producto al carrito");
        }

        assertTrue(textoAlerta.contains("Success: You have added iPhone to your shopping cart!"));
    }
}
