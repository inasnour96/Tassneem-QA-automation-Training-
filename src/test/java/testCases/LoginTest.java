package testCases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GitHub_SignIn_page;
public class LoginTest extends BaseTestCase {

    @Test(dataProvider = "credentials")

    //parameters from dataProviders
    public void VerifyLoginCredentials(String testCase,String nameEmail, String password) {


        //for all test cases
        driver.get(githubLink);
        GitHub_SignIn_page GitHub_SignIn_Page = new GitHub_SignIn_page(driver);//create obj from login page
        GitHub_SignIn_Page.enterNameEmail(nameEmail);
        GitHub_SignIn_Page.enterPassword(password);
        GitHub_SignIn_Page.clickSignInButton();

        // 1- redirect to the home page in TC001
        if (testCase.equalsIgnoreCase("TC001")) {
            Assert.assertTrue(driver.getCurrentUrl().equals("https://github.com/"));
            System.out.println("Test Case 1 Passed");
        }


        // 2- get the massage from the alert and compare with what expected in TC002
        else if(testCase.equalsIgnoreCase("TC002") ) {
            String errorMessageAlert = driver.findElement(By.className("js-flash-alert")).getText();
            Assert.assertEquals(errorMessageAlert, "Incorrect username or password.");
            System.out.println("Test Case 2 Passed");

        }

        // 3- get the massage from the alert and compare with what expected in TC003
        else if(testCase.equalsIgnoreCase("TC003") ) {
            String errorMessageAlert = driver.findElement(By.className("js-flash-alert")).getText();
            Assert.assertEquals(errorMessageAlert, "Incorrect username or password.");
            System.out.println("Test Case 3 Passed");

        }


        // 4- empty fields
        else if(testCase.equalsIgnoreCase("TC004") ) {

            String errorMessageLogin = driver.findElement(By.id("login_field")).getAttribute("validationMessage");
            String errorMessagePassword = driver.findElement(By.id("password")).getAttribute("validationMessage");

            // Assert both error messages simultaneously
            Assert.assertEquals(errorMessageLogin, "Please fill out this field.");
            Assert.assertEquals(errorMessagePassword, "Please fill out this field.");

            System.out.println("Test Case 4 Passed");
        }

           }
}
