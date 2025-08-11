package org.example.tests.ddt;

import org.example.utils.utilsExcel;
import org.testng.annotations.Test;

public class vwoLoginAPITTC {

    @Test(dataProvider = "getData",dataProviderClass = utilsExcel.class)
    public void testVWOLogin(String email,String password){

        System.out.println(email);
        System.out.println(password);
    }
}
