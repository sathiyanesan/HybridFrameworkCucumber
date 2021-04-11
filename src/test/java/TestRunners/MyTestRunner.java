package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "D:\\selenium java workspace\\HybridCucumberFramework\\src\\test\\resources\\AppFeatures\\AccountsPage.feature",//path of the feature file
 glue={"StepDefinitions" , "AppHooks"}, //step definition package name , Hooks package name
 plugin = {"pretty" ,  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
 
 // , publish = true
 )


public class MyTestRunner {

}
