package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Массивы и JSON
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        long time = System.currentTimeMillis();
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                "    \"algorithm\": \"SelectSort\",\n" +
                "    \"values\": [\n" +
                "        7,\n" +
                "        2,\n" +
                "        3,\n" +
                "        4,\n" +
                "        1\n" +
                "    ]\n" +
                "}";
        try {
            int[] jsonsorted = JsonRead.jsread(json);
            time = System.currentTimeMillis() - time;
            JsonObj obj = new JsonObj();
            obj.setTime(time);
            obj.setValues(jsonsorted);
            String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(result);
        } catch (JsonProcessingException exception){
            JsonException e = new JsonException();
            e.setErrorMessage("Array is null");
            String result = mapper.writeValueAsString(e);
            System.out.println(result);
        }
    }
}
