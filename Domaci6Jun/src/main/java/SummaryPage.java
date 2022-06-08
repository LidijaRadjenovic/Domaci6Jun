import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{

    private By facility = By.id("facility");
    private By applyForHospitalReadmission = By.id("hospital_readmission");
    private By healthcareProgram = By.id("program");
    private By visitDate = By.id("visit_date");
    private By comment = By.id("comment");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacility() {
        return facility;
    }

    public By getApplyForHospitalReadmission() {
        return applyForHospitalReadmission;
    }

    public By getHealthcareProgram() {
        return healthcareProgram;
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getComment() {
        return comment;
    }

    public String facilityText(){
        return getDriver().findElement(facility).getText();
    }

    public String applyForHospitalReadmissionText(){
        return getDriver().findElement(applyForHospitalReadmission).getText();
    }

    public String healthcareProgramText(){
        return getDriver().findElement(healthcareProgram).getText();
    }

    public String visitDateText(){
        return getDriver().findElement(visitDate).getText();
    }

    public String commentText(){
        return getDriver().findElement(comment).getText();
    }
}
