package Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {
   static ExtentSparkReporter reporter;
   static ExtentReports extent;

    public static ExtentReports getReportObject()
    {

        if (extent==null) {
            String path = System.getProperty("user.dir") + "/src/reports/RegressionReport.html";
            System.out.println("Path is: " + path);

            //Configuring Report
            reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Web Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            //Attaching reporter
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Abhishek Verma");
            return extent;
        }
        else {
            return extent;
        }
        
    }
}
