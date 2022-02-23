package exercise2;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSon {
	public static void main(String args[]) throws JsonProcessingException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		File f=new File("jobs.json");
//		JsonNode master=mapper.readTree(f);
//		JsonNode jobs=master.get("jobs");
//		System.out.println(jobs);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode master=mapper.readTree(new
		File("..\\Test_json\\src\\color.json"));
		
		Object[][] data = new Object[7][2];
		for(int i=0;i<master.size();i++) {
			data[i][0]=master.get(i).get("color");		
			data[i][1]=master.get(i).get("value");
		}
		
		
	}

}
