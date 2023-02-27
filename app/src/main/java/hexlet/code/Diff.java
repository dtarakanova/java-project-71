package hexlet.code;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


public class Diff {
    public static Map<String, Object> getData1 (String filepath1) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    //mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
   Map<String, Object> jsonToMap= mapper.readValue(filepath1, new TypeReference<>() { });
   return jsonToMap;
}
}

