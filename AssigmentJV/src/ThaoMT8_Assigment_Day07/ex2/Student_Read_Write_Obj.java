package ThaoMT8_Assigment_Day07.ex2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Student_Read_Write_Obj {
	Scanner scanner=new Scanner(System.in);
	public static void main(String args[]) {
		Student_Read_Write_Obj studentRead_Write=new Student_Read_Write_Obj();
		String first="Mai Thi";
		String last="Thao";
		String email="Thao@fsoft.com";
		Student student=new Student(first, last, email);
		studentRead_Write.outputOjectStudent(student);
		studentRead_Write.inputObjectStudent(Student.class);
		
	}
	public void outputOjectStudent(Object obj) {
		try(FileOutputStream fileOutputStream = new FileOutputStream("student.txt")){
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(obj);
			objectOutputStream.flush();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}	
	}
	public void inputObjectStudent(Class clas) {
		try(FileInputStream fileInputStream = new FileInputStream("student.txt")){
			ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
			try {
				Student student=(Student) objectInputStream.readObject();
				System.out.println(student);
			} catch (IOException|ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			objectInputStream.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}

}
