package exercise2;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class test {
	public static void main(String args[]) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
        String file = System.getProperty("user.dir") + "\\src\\main\\java\\color.json";
        Color[] colors = mapper.readValue(new File(file), Color[].class);
        System.out.println(colors);

	}

}
