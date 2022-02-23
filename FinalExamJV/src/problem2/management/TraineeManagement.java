package problem2.management;
import java.sql.SQLException;
import java.util.Scanner;

import problem2.dao.TraineeDao;
import problem2.entities.Trainee;

public class TraineeManagement {
	public static void main(String args[]) throws SQLException  {
		Scanner scanner=new Scanner(System.in);
		TraineeDao traineeDAO=new TraineeDao();
		Trainee trainee = new Trainee();
		trainee.setTrainee_id(1);
		trainee.setAccount("003");
		trainee.setFull_name("mai  thao");
		trainee.setPhone_number("12340");
		trainee.setGender(0);
		//trainee.setBirth_date(new java.sql.Date(System.currentTimeMillis()));
		trainee.setGpa("1.40");
		trainee.setStatus("active");
		while(true) {
			System.out.println("======== FA System ========\r\n"
					+ "1. Create Trainee\r\n"
					+ "2. Update Trainee\r\n"
					+ "3. Remove a specific Trainee\r\n"
					+ "4. Report incompleted training\r\n"
					+ "5. List excellent trainees\r\n"
					+ "6. Exit\r\n"
					+ "Your choice:");
			int choice = scanner.nextInt();
			switch(choice){
			case 1: 
				System.out.println("----------Create Trainee -----");				
				System.out.println("Enter account:");
				String account=scanner.next();
				trainee.setAccount(account);
				System.out.println("Enter name: ");
				String name=scanner.next();
				trainee.setFull_name(name);	
				traineeDAO.save(trainee);
				break;
			case 2: 
				System.out.println("------------- Update Trainee ------");		
				System.out.println("Enter account: ");
				String account1=scanner.next();
				trainee.setAccount(account1);
				traineeDAO.update(trainee);		
				break;
			case 3: 
				System.out.println("------------ Remove Trainee --------");
				System.out.println("Enter account: ");
				String account2=scanner.next();
				trainee.setAccount(account2);
				traineeDAO.remove(trainee);		
				break;
			case 4: 
				System.out.println("Report incompleted training:");
				trainee=traineeDAO.findIncompletedTrainee();
				System.out.println(trainee);
				break;
			case 5:
				System.out.println("List excellent trainees");
				trainee=traineeDAO.findExcellentTrainee();
				System.out.println(trainee);
				break;
			default: 
				System.out.println("Exit"); 

			}
			if(choice==6) {
				break;
			}
			
		}
		
		
	}
	

}
