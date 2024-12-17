package org.example.tests;

import org.example.core.BaseTest;
import org.example.page.MenuPage;
import org.junit.Test;

public class TestCasePageTest extends BaseTest {

    MenuPage menuPage =  new MenuPage();

    @Test
    public void testCasePageTest(){
        menuPage.acessaTelaTestCase();
    }

}
