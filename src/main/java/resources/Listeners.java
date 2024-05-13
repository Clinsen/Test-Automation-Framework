package resources;

import base.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {
    public Listeners() throws IOException {
        super();
    }

    public void onTestFailure(ITestResult result){
        try{
            takeScreenShot(result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
