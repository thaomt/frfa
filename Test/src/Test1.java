import java.util.Scanner;

public class Test1 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.println("n: ");
		n = scanner.nextInt();
		int a[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		int m;
		System.out.println("m: ");
		m = scanner.nextInt();
		int b[] = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}
		int s = 0;
		for (int i = 0; i < m; i++) {
			b[i]--;

		}
		// 3 2 1 0
		// 0 1 2 3

		for(int i=0;i<m;i++) {
			int t=i;
			if(t<m-1) {
				t=t+1;
				s+=a[b[i]][b[t]];
			}
		}
		System.out.println(s);

	}

}
