package tests;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonDataProvider {

    public static FormData getData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Deserialize
        return mapper.readValue(new File("src/test/resources/userSignUp.json"), FormData.class);
    }
}