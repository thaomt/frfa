import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import basic_Medium_Assigment.Assignment401.ex1.t1;

public class printCheck {
	public int Count(int [] array,int a,int x) {
		int temp = 0;
	    for(int i = 0; i<a; i++)
	        if(array[i]==x)
	            temp++;
	    return temp;
 	   
    }
	public void Count(int array[],  int a) {
	    int temp1, temp = Count(array,a,array[0]), index = 0;
	    int maxCover=Count(array,a,array[0]);
        for(int i=1;i<a;i++) {
        	maxCover = Math.max(maxCover,Count(array,a,array[i] ));	
        }
        for(int i=0;i<a;i++) {
        	if(maxCover==Count(array,a,array[i])) {
        		index=i;
        		break;
        	}
        }
        
//	    for(int i = 1; i<a; i++){
//	        temp1 = Count(array,a,array[i]);
//	        if(temp<temp1){
//	            temp = temp1;
//	            index = i;
//	        }
//	    }
	    //array[index];
	    System.out.print("phan tu thu "+index+" co so lan xuat hien nhieu nhat la "+ maxCover);
	}
 
    public static void main(String [] args) {
    	int a,b;
    	System.out.println("nhap so phan tu: ");
    	Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        printCheck printcheck=new printCheck();
        int array[] = new int[a];
        for (int i = 0; i < a; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            array[i] = scanner.nextInt();
        }
        printcheck.Count(array, a);
       /* List<String> multiple = new ArrayList<String>();
        
        for(int i=0;i<a;i++) {
            multiple.add(i,String.valueOf(array[i]));	
        }
        Set<String> setA = new HashSet<String>();
        setA.addAll(multiple);
        System.out.println(multiple);
        System.out.println(setA);
        //int dem[] = new int[a];
        int dem=0;
        List<Integer> man = new ArrayList<Integer>();
        for(int i=0;i<setA.size();i++) {
        	for(int j=0;j<a;j++) {
        		if(setA.toString().charAt(i)==multiple.toString().charAt(j)) {
            		dem++; 
            	}
        	}
        	man.add(i,dem); 
        	dem=0;
        }
        int maxCover=man.get(0);
        for(int i=1;i<man.size();i++) {
        	maxCover = Math.max(maxCover, man.get(i));
        	System.out.println(man.get(i));
        }
       // System.out.println(maxCover);
        * 
        */
       
    }
    /*
     * cach khac
     * public static void main(String args[]) {
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
     */
    
	 

}
