package exercise2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJSon {
	public static void main(String args[]){
		ObjectMapper mapper = new ObjectMapper();
		final String file="jobs.json";
		writeNode(mapper,file);
		extractNode(mapper,file);
		
	}
	public static void extractNode(ObjectMapper mapper,String file) {
		try{
			//File files=new File(file);
			//Jobs job=mapper.readValue(files, Jobs.class);
			JsonNode master=mapper.readTree(new File(file));
			System.out.println(master);
			//System.out.println(mapper.writeValueAsString(job));
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}
	public static void writeNode(ObjectMapper mapper, String file) {
		ArrayList<Jobs> staff = createJobs();
		try {
			mapper.writeValue(new FileOutputStream(file), staff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static ArrayList<Jobs> createJobs() {
		Duration dura1=new Duration("2016-01-01 00:00:00","2016-02-28 00:00:00");
		Jobs jobs1 = new Jobs("ITHS",dura1,"Database teacher","Teacher for a Database course");
		Duration dura2=new Duration( "2016-06-01 00:00:00", "2016-12-31 00:00:00");
		Jobs jobs2 = new Jobs("GU",dura2,"Database teacher","Lecturer for an introductory Java course etc");
		Duration dura3=new Duration( "2017-01-01 00:00:00","2017-06-30 00:00:00");
		Jobs jobs3 = new Jobs("Yrgo",dura3,"Java teacher","Teacher for a Java course");
		ArrayList<Jobs> list=new ArrayList<>();
		list.add(jobs1);
		list.add(jobs2);
		list.add(jobs3);	
		return list;

	}

}

