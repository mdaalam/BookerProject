import common.api.Base;

import java.util.Random;

/**
 * Created by mdalam on 1/8/16.
 */
public class BookerBase extends Base {

    public static String randomNumber = "" + new Random().nextInt((1000 - 100) + 1) + 1;

    public void logInFacebook() {
        typeByCss("#email", "md_a_alam@yahoo.com");
        typeByCss("#pass", "selenium123");
        clickByXpath(".//*[@id='u_0_0']");
    }
}
