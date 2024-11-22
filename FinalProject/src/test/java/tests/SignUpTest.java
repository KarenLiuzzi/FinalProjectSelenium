package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.Json;
import pages.HomePage;
import pages.SignUp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignUpTest extends BaseTest {

    //TC: BM-T149
    @Test
    public void testConfirmationMessageDisplayedOnSuccessfulRegistration() throws IOException {
        FormData data = JsonDataProvider.getData();

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        SignUp signUp = new SignUp(driver);
        signUp.setFirstName(data.getFirstName());
        signUp.setLastName(data.getLastName());
        signUp.setAddress(data.getAddress());
        signUp.setCity(data.getCity());
        signUp.setState(data.getState());
        signUp.setZipCode(data.getZipCode());
        signUp.setPhone(data.getPhone());
        signUp.setSsn(data.getSsn());
        signUp.setUserName(data.getUsername());
        signUp.setPassword(data.getPassword());
        signUp.setConfirmPassword(data.getPassword());
        HomePage homepage = signUp.clickRegisterWithAllValidData();

        assertEquals("Welcome " + data.getUsername(), homepage.getUserName());
        assertEquals("Your account was created successfully. You are now logged in.", homepage.getSuccessfulMessage());
        assertEquals("https://parabank.parasoft.com/parabank/register.htm", driver.getCurrentUrl());

    }

    //TC: BM-T150
    @Test
    public void testAllRequiredFieldsDisplayedInSignUp() {

        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        SignUp signUp = new SignUp(driver);
        List<String> labelsRegisterForm = signUp.getLabelRegisterFormLocator();
        List<String> labelsExcepted = Arrays.asList(
                "First Name:", "Last Name:", "Address:",
                "City:", "State:", "Zip Code:", "Phone #:",
                "SSN:", "Username:", "Password:", "Confirm:"
        );
        List<WebElement> fieldsRegisterForm = signUp.getFieldsRegisterFormLocator();

        assertEquals(labelsExcepted, labelsRegisterForm, "The returned registration form labels do not match the expected labels.");
        assertEquals(labelsExcepted.size(), labelsRegisterForm.size(), "The number of labels in the registration form returned does not match the expected number of labels.");
        assertEquals(labelsExcepted.size(), fieldsRegisterForm.size(), "The number of fields in the registration form returned does not match the number of fields expected.");

    }
}