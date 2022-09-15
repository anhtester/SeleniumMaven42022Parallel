package anhtester.com.testcases;

import anhtester.com.common.BaseTest;
import org.testng.annotations.Test;

public class LoginHRMTest extends BaseTest {

    @Test
    public void testLoginHRM() {
        getLoginHRMPage().login();
    }

}
