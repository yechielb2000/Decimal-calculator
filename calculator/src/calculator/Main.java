package calculator;

import java.util.Scanner;

public class Main extends functions {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		System.out.println("enter the number \n1. for Matrix in space 3\n");
		int numChoice = s.nextInt();
		
		switch (numChoice) {
			
		case 1:
			System.out.println("enter the values to the matrix like this example [a b c = d] ");
			
			double a = s.nextDouble(), b = s.nextDouble(), c = s.nextDouble(), d = s.nextDouble();
			double e = s.nextDouble(), f = s.nextDouble(), g = s.nextDouble(), h = s.nextDouble();
			double i = s.nextDouble(), j = s.nextDouble(), k = s.nextDouble(), l = s.nextDouble();

			double Row1[] = {a,b,c,d};
			double Row2[] = {e,f,g,h};
			double Row3[] = {i,j,k,l};
			
			matrixG(Row1, Row2, Row3);
			
			break;
			
		default:
			
			System.out.println("Sorry we didn't get this option");
			
			break;
		}
		
	}

}
