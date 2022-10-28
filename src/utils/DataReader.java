import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {
    public static List <HashMap<String,String>> data;


    public static List<HashMap<String,String>> getJsonDataToMap(String filePath) {

        try {

            //Reading data as string
           String jsonContent= FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

            ObjectMapper mapper = new ObjectMapper();

            data = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
