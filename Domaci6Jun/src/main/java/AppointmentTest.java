import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void BeforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test(priority = 1)
    public void verifyMakeAppointmentButtonWorks(){
        loginPage.clickMakeAppointmentButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test(priority = 2)
    public void verifyUserLoginWorks(){
        loginPage.enterUsername("John Doe");
        loginPage.enterPassword("ThisIsNotAPassword");
        loginPage.clickLoginButton();
        Assert.assertTrue(appointmentPage.isFormPresented());
    }

    @Test(priority = 3)
    public void verifyMakeAppointmentWorks(){
        appointmentPage.selectFacility();
        appointmentPage.checkApplyFoHospitalReadmission();
        appointmentPage.chooseMedicareRadioButton();
        appointmentPage.enterVisitDate("22/07/2022");
        appointmentPage.enterComment("This is comment.");
        appointmentPage.clickBookAppointmentButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
    }

    @Test(priority = 4)
    public void verifySummaryPage(){
        Assert.assertEquals(summaryPage.facilityText(), "Tokyo CURA Healthcare Center");
        Assert.assertEquals(summaryPage.applyForHospitalReadmissionText(), "Yes");
        Assert.assertEquals(summaryPage.healthcareProgramText(), "Medicare");
        Assert.assertEquals(summaryPage.visitDateText(), "22/07/2022");
        Assert.assertEquals(summaryPage.commentText(), "This is comment.");
    }

}
