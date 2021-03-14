package helper;

import com.google.common.io.Resources;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Timestamp;

public class Helper {

    public static JSONObject readJsonFile(String jsonFileName) throws IOException {

        URL jsonFile = Resources.getResource(jsonFileName+".json");
        String json = Resources.toString(jsonFile, Charset.defaultCharset());
        JSONObject jsonObject = new JSONObject( json );
        return jsonObject;

    }

    public static Long createId(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long id = timestamp.getTime();
        return id;
    }

}
