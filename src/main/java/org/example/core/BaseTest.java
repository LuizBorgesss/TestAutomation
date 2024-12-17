package org.example.core;
import org.junit.After;
import org.junit.Before;

import static org.example.core.DriverFactory.getDriver;
import static org.example.core.DriverFactory.killDriver;

public class BaseTest {

    @Before
    public void acessarSite(){
        getDriver().get("https://automationexercise.com/");
    }

    @After
    public void finaliza(){
        killDriver();
    }

}
