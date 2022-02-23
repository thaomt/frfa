package exercise_1;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		//Customer
        Customer customer = new Customer("Mai Thi Thao");
        customer.setMember(true);
        customer.setMemberType("Gold");
        System.out.println("Infomation of customer:");
        System.out.println(customer);       
        //Visit
        Visit visit = new Visit(customer.getName(),new Date());        
        visit.setProductExpense(101);        
        visit.setServiceExpense(276);
        visit.setCusCustomer(customer);
        System.out.println(visit);
        //Console
        System.out.println("Total bill of " + visit.getName() + " : " + visit.getTotalExpense()+" $");


	}

}
