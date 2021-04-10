package module_mainmenu;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui_pages.HomePage;

public class MainMenuTest {
    HomePage objHomePage;


    @BeforeClass
    public void setupClass(){
        objHomePage = new HomePage();

    }


    @Test
    public void mainMenuContents(){
        Assert.assertEquals(objHomePage.checkMainMenuSize(),8);
    }
}
