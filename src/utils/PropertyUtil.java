import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {

    private static Properties prop;


    public static void loadProperty() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/resources/GlobalConfig.properties");
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to load property file");
        }
    }

    public static String getProperty(String property) {
        loadProperty();
        return prop.getProperty(property);
    }

}
