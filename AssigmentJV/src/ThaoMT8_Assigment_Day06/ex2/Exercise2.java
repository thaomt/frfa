package ThaoMT8_Assigment_Day06.ex2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 Write an application that stores the integer numbers between 1 (included) and 64 (included) in an array 
 and prints them in a reverse order. 
 */
public class Exercise2 {
	public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> alist){
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = alist.size() - 1; i >= 0; i--) {
            revArrayList.add(alist.get(i));
        }
        return revArrayList;
    }

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=1;i<=64;i++) {
			list.add(i);
		}
		System.out.println("Array original: \n"+list);
//		Collections.reverse(list);
		list = reverseArrayList(list);
        System.out.print("\nElements after reversing:");
        System.out.println("Array in a reverse order: \n"+list);;
		

	}

}
