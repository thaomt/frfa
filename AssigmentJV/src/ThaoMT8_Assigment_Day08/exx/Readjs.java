//package ThaoMT8_Assigment_Day08.exx;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class Readjs {
//	public static void main(String args[]) throws JsonProcessingException, IOException{
//		ObjectMapper mapper = new ObjectMapper();
//		final String file="mn.json";
////		File f=new File("mn.json");
////		JsonNode master=mapper.readTree(f);
////		JsonNode jobs=master.get("jobs");
////		System.out.println(jobs);
//		writeNode(mapper,file);
//		extractNode(mapper,file);
//		
//	}
//	public static void extractNode(ObjectMapper mapper,String file) {
//		try {
//			Jobs jobs=mapper.readValue(new File(file), Jobs.class);
//			System.out.println(jobs);
//		}catch(IOException ex) {
//			ex.printStackTrace();
//		}
//	}
//	public static void writeNode(ObjectMapper mapper, String file) {
//		Jobs staff = createJobs();
//
//		try {
//			mapper.writeValue(new FileOutputStream(file), staff);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	private static Jobs createJobs() {
//
//		Jobs jobs = new Jobs();
//		jobs.setEmployer("1");
//		jobs.setTitle("2");
//		jobs.setDescription("hello");
//		jobs.duration.setEnd("2");
//		jobs.duration.setStart("1");
//
//		return jobs;
//
//	}
//
//}
