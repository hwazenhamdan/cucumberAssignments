package Assig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions2 {

    WebDriver driver;

    @Given("user goes to the {string}")
    public void user_goes_to_the(String URL) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Then("user waits for {int} seconds")
    public void user_waits_for_seconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String expected) {
        String actual = driver.getTitle();
        Assertions.assertTrue(actual.contains(expected),
                "Expected title: " + expected + "Actual title: " + actual);
    }

    @Then("closes the page")
    public void closes_the_page() {

        driver.quit();
    }

}
