package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import pages.BasePage;
import pages.RegisterPage;
import reports.ExtentFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrearCuenta {
    public RegisterPage registerPage;
    public static ExtentReports extent;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/reporte_test_registro.html");

    @BeforeAll
    public static void setupDriver() {
        BasePage.setupChromeDriver();
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

    @BeforeEach
    public void setupRegisterPage() throws InterruptedException {
        registerPage = new RegisterPage();
        registerPage.url("http://opencart.abstracta.us/index.php?route=common/home");
    }

    @AfterEach
    public void closeRegistePge() throws InterruptedException {
        registerPage.close();
    }

    @Test
    @Tag("register")
    public void crearCuenta() {
        ExtentTest test = extent.createTest("Registro exitoso");

        registerPage.toRegister();
        test.log(Status.PASS, "Ingresar a página de registro");

        registerPage.escribirFirstName("Damian");
        registerPage.escribirLastName("Damonte");
        registerPage.escribirEmail("damian5@gmail.com");
        registerPage.escribirTelephone("12345678");
        registerPage.escribirPassword("123456789");
        registerPage.escribirConfirmarPassword("123456789");
        test.log(Status.PASS, "Completar información de registro");

        registerPage.clickNoNewsletter();
        test.log(Status.PASS, "Seleccionar no newsletters");

        registerPage.clickAgreePolicy();
        test.log(Status.PASS, "Aceptar políticas");

        registerPage.clickContinue();
        test.log(Status.PASS, "Realizar registro");

        String successfulMessage = registerPage.getContent();

        if(successfulMessage.equals("Congratulations! Your new account has been successfully created!")) {
            test.log(Status.PASS, "Registro exitoso");
        } else {
            test.log(Status.FAIL, "Registro fallido");
        }

        assertEquals(
                "Congratulations! Your new account has been successfully created!",
                successfulMessage
        );
    }
}
