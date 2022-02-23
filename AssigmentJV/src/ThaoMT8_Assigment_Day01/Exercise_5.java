package ThaoMT8_Assigment_Day01;
import java.util.Scanner;

/*
  Write a Java program to takes the user for a distance (in meters) and the time was taken (as three numbers: 
  hours, minutes, seconds), and display the speed, in meters per second, kilometers per hour and miles per 
  hour (hint: 1 mile = 1609 meters).
 */
public class Exercise_5 {
	public void speed() {
		double distance;
		double hours;
		double seconds;
		double minutes;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input distance in meters:");
		distance=scanner.nextInt();
		System.out.println("Input hour:");
		hours=scanner.nextInt();
		System.out.println("Input minutes:");
		minutes=scanner.nextInt();
		System.out.println("Input seconds:");
		seconds=scanner.nextInt();
		double time;
		time=hours*3600+minutes*60+seconds;
		System.out.printf("Your speed in meters/second is: %.8f ",(distance/time));
		System.out.println();
		System.out.printf("Your speed in km/h is: %.8f ",(distance*0.001*3600)/time);
		System.out.println();
		double miles=distance/1609;
		System.out.printf("Your speed in miles/h is: %.8f ",(miles*3600)/time);
	}
	public static void main(String [] args) {
		Exercise_5 exercise_5=new Exercise_5();
		exercise_5.speed();
	
	}
}
