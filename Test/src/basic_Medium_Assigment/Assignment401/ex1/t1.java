package basic_Medium_Assigment.Assignment401.ex1;

import java.util.Scanner;

public class t1 { 
	public static void main(String args[]) {
		t1 t1=new t1();
		int n;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();
		}
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(1, t1.check(a,a[i],n));
		}
		for(int i=0;i<n;i++) {
			if(max==t1.check(a,a[i],n)) {
				System.out.println("so xuat hien nhieu nhat: "+a[i]);
				break;
			}
		}
	
		
	}
	public int check(int arr[],int a,int n) {
		int sum=0;
		for(int i=0;i<n;i++) {
			if(arr[i]==a) {
				sum++;
			}
		}
		return sum;
	}
	


}
