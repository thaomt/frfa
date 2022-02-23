package ThaoMT8_Assigment_Day06.ex3;
import java.util.Scanner;
import java.util.Stack;

public class Exercise3 {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		for(int i=1;i<=7;i++) stack.push(i);
		Scanner scanner= new Scanner(System.in);
		while(true) {
			System.out.println("==================================================\r\n"
					+ " Stack Operations Menu\r\n"
					+ "==================================================\r\n"
					+ "1. Add items\r\n"
					+ "2. Delete items\r\n"
					+ "3. Show the number of items\r\n"
					+ "4. Show min and max items\r\n"
					+ "5. Find an item\r\n"
					+ "6. Print all items\r\n"
					+ "7. Exit");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			switch(choice){
			case 1: 
				System.out.println("Enter element want to add: ");
				stack.push(scanner.nextInt());
				System.out.println("Enter element want to add: ");
				stack.push(scanner.nextInt());
				break;
			case 2: 
				System.out.println("Delete element: ");
				stack.pop();
				break;
			case 3: 
				System.out.println("Number element: "+ stack.size());
				break;
			case 4: 
				System.out.println("Show min and max: ");
				int max=stack.get(0);
				int min=stack.get(0);
				for(int i=1;i<stack.size();i++) {
					max = Math.max(max, stack.get(i));
					min= Math.min(min, stack.get(i));
				}
				System.out.println("Max: "+max + " Min: "+min);
				break;
			case 5: 
				System.out.println("Enter element want to find: ");
				int element=scanner.nextInt();
				int elementFind=stack.search(element);
				System.out.println("Position of "+element+": "+elementFind );
				break;
			case 6: 
				System.out.println("Print all element: "+stack);
				break;
			default: 
				System.out.println("Exit"); 
				return ;

			}
			if(choice==7) {
				break;
			}
			
		}
	}
	
	

}
