import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppointmentPage extends BasePage{

    private By facility = By.id("combo_facility");
    private By applyFoHospitalReadmission = By.xpath("//*[@id=\"appointment\"]/div/div/form/div[2]/div/label");
    private By medicareRadioButton = By.id("radio_program_medicare");
    private By medicaidRadioButton = By.id("radio_program_medicaid");
    private By noneRadioButton = By.id("radio_program_none");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookAppointmentButton = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFacility() {
        return facility;
    }

    public By getApplyFoHospitalReadmission() {
        return applyFoHospitalReadmission;
    }

    public By getMedicareRadioButton() {
        return medicareRadioButton;
    }

    public By getMedicaidRadioButton() {
        return medicaidRadioButton;
    }

    public By getNoneRadioButton() {
        return noneRadioButton;
    }

    public By getVisitDate() {
        return visitDate;
    }

    public By getComment() {
        return comment;
    }

    public By getBookAppointmentButton() {
        return bookAppointmentButton;
    }

    public boolean isFormPresented(){
        List<WebElement> formElements = getDriver().findElements(By.className("form-group"));
        if(formElements.size()>0){
            return true;}
        else{
            return false;
        }
    }

    public void selectFacility(){
        Select selectFacility = new Select(getDriver().findElement(facility));
        selectFacility.selectByVisibleText("Tokyo CURA Healthcare Center");
    }

    public void checkApplyFoHospitalReadmission(){
        getDriver().findElement(applyFoHospitalReadmission).click();
    }

    public void chooseMedicareRadioButton(){
        getDriver().findElement(medicareRadioButton).click();
    }

    public void chooseMedicaidRadioButton(){
        getDriver().findElement(medicaidRadioButton).click();
    }

    public void chooseNoneRadioButton(){
        getDriver().findElement(noneRadioButton).click();
    }

    public void enterVisitDate(String date){
        getDriver().findElement(visitDate).sendKeys(date);
    }

    public void enterComment(String comment){
        getDriver().findElement(this.comment).sendKeys(comment);
    }

    public void clickBookAppointmentButton(){
        getDriver().findElement(bookAppointmentButton).click();
    }

}
