package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SingOut present --->logout
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }

    @Test
    public void loginSuccess() {
        logger.info("Start test with name `loginSuccess`");
        logger.info("Test data ---> email: 'mara@gmail.com' & password : 'Mmar123456$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
//        Assert.assertEquals();
//        Assert.assertTrue();
//        Assert.assertNotEquals();
//        Assert.assertFalse();

    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data ---> email: 'mara@gmail.com' & password : 'Mmar123456$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data ---> email: 'maragmail.com' & password : 'Mmar123456$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maragmail.com", "Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginWrongPassword(){
        logger.info("Test data ---> email: 'mara@gmail.com' & password : 'Mmar123' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com", "Mmar123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");



    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data ---> email: 'luck@gmail.com' & password : 'Lluk123456$' ");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("luck@gmail.com", "Lluk123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }


}