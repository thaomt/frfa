package exercise_3;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProviders {
	@Test(dataProvider = "getData")
	public void testDataProviderWithJson(Object color, Object value) {
		System.out.println("color " + color);
		System.out.println("value " + value);
	}

	@DataProvider
	public Object[][] getData() throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode master = mapper.readTree(new File("..\\ThaoMT8_Assignmnet_Day01\\src\\color.json"));

		Object[][] data = new Object[master.size()][2];
		for (int i = 0; i < master.size(); i++) {
			data[i][0] = master.get(i).get("color");
			data[i][1] = master.get(i).get("value");
		}

		return data;
	}

}
