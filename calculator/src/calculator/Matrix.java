package calculator;

import java.text.DecimalFormat;

public class Matrix {

	public static void matrixS(double[] row1, double[] row2, double[] row3) {

		SolveTheMatrix(row1, row2, row3);
	}

	public static void SolveTheMatrix(double[] row1, double[] row2, double[] row3) {

		infinity(row1, row2, row3);
		errorCheck(row1, row2, row3);
		double temp = 0;

		if (row1[0] == 0 && row2[0] != 0) {
			for (int t = 0; t < row1.length; t++) {
				temp = row1[t];
				row1[t] = row2[t];
				row2[t] = temp;
			}
			System.out.println("R1 <--> R2");
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);

		} else if (row1[0] == 0 && row3[0] != 0) {
			for (int t = 0; t < row1.length; t++) {
				temp = row1[t];
				row1[t] = row3[t];
				row3[t] = temp;
			}
			System.out.println("R1 <--> R3");
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		} else if (row1[0] != 0) {

			for (int t = row2.length - 1; t > row2.length - row2.length - 1; t--) {

				row1[t] /= row1[0];
			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}
		if (row2[0] != 0) {

			for (int t = row2.length - 1; t > row2.length - row2.length - 1; t--) {

				row2[t] = row2[t] - (row2[0] * row1[t]);

			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}
		if (row3[0] != 0) {

			for (int t = row3.length - 1; t > row3.length - row3.length - 1; t--) {

				row3[t] = row3[t] - (row3[0] * row1[t]);

			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}
		if (row2[1] != 0 || row2[1] != 1) {
			for (int t = row3.length - 1; t > row3.length - row3.length - 1; t--) {
				row2[t] /= row2[1];
			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}

		if (row1[1] != 0) {
			for (int t = row3.length - 1; t > row3.length - row3.length - 1; t--) {

				row1[t] = row1[t] - (row1[1] * row2[t]);
			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}

		if (row3[1] != 0 && row2[1] != 0) {

			for (int t = row2.length - 1; t > row2.length - row2.length - 1; t--) {

				row3[t] = row3[t] - (row3[1] * row2[t]);

			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		} else {
			for (int t = 0; t < row1.length; t++) {
				temp = row3[t];
				row3[t] = row2[t];
				row2[t] = temp;
			}
			System.out.println("R3 <--> R2");
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}

		if (row3[2] != 0) {

			for (int t = row2.length - 1; t > row2.length - row2.length - 1; t--) {

				row3[t] /= row3[2];
			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}
		
		if (row2[2] != 0) {
			for (int t = row3.length - 1; t > row3.length - row3.length - 1; t--) {

				row2[t] = row2[t] - (row2[2] * row3[t]);
			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}
		
		if (row1[2] != 0) {
			for (int t = row3.length - 1; t > row3.length - row3.length - 1; t--) {

				row1[t] = row1[t] - (row1[2] * row3[t]);
			}
			infinity(row1, row2, row3);
			matrixsPaint(row1, row2, row3);
		}

	}

	public static void infinity(double[] row1, double[] row2, double[] row3) {

		double temp;
		if (row1[0] == 0 && row1[1] == 0 && row1[2] == 0 && row1[3] == 0) {
			for (int t = 0; t < row1.length; t++) {
				temp = row3[t];
				row3[t] = row1[t];
				row1[t] = temp;
			}
			System.out.println("R3 <--> R1");
			matrixsPaint(row1, row2, row3);
			System.out.println("Infinity in row 3\n");
			System.exit(1);
		}

		if (row2[0] == 0 && row2[1] == 0 && row2[2] == 0 && row2[3] == 0) {

			for (int t = 0; t < row1.length; t++) {
				temp = row3[t];
				row3[t] = row2[t];
				row2[t] = temp;
			}
			System.out.println("R3 <--> R2");
			matrixsPaint(row1, row2, row3);
			System.out.println("Infinity in row 3\n");
			System.exit(1);
		}

		if (row3[0] == 0 && row3[1] == 0 && row3[2] == 0 && row3[3] == 0) {
			matrixsPaint(row1, row2, row3);
			System.out.println("Infinity in row 3\n");
			System.exit(1);
		}
	}

	public static void errorCheck(double[] row1, double[] row2, double[] row3) {

		int counter1 = 0, counter2 = 0, counter3 = 0;

		for (int i = 0; i < row1.length; i++) {

			if (row1[i] == 0 && row1[row1.length - 1] != 0) {
				counter1++;

				if (counter1 == 3) {
					System.out.println("Mathematical contradiction in row number 1");
					System.exit(1);
				}
			}
			if (row2[i] == 0 && row2[row2.length - 1] != 0) {
				counter2++;

				if (counter2 == 3) {
					System.out.println("Mathematical contradiction in row number 2");
					System.exit(1);
				}
			}
			if (row3[i] == 0 && row3[row3.length - 1] != 0) {
				counter3++;

				if (counter3 == 3) {
					System.out.println("Mathematical contradiction in row number 3");
					System.exit(1);
				}
			}
		}

	}

	public static void zeroCheck(double[] row1, double[] row2, double[] row3) {

		for (int i = 0; i < row1.length; i++) {

			if (row1[i] == -0.0) {
				row1[i] = 0.0;
			}
			if (row2[i] == -0.0) {
				row2[i] = 0.0;
			}
			if (row3[i] == -0.0) {
				row3[i] = 0.0;
			}

		}

	}

	public static void matrixsPaint(double[] row1, double[] row2, double[] row3) {

		errorCheck(row1, row2, row3);
		zeroCheck(row1, row2, row3);
		DecimalFormat df = new DecimalFormat("#");
		DecimalFormat df2 = new DecimalFormat("#.##");

		int num;

		System.out.print("| ");
		for (int i = 0; i < row1.length; i++) {

			num = (int) Math.ceil(row1[i]);
			if (row1[i] - num == 0) {
				System.out.print(df.format(row1[i]) + " ");
			} else {
				System.out.print(df2.format(row1[i]) + " ");
			}
		}
		System.out.println("| ");

		System.out.print("| ");
		for (int i = 0; i < row1.length; i++) {

			num = (int) Math.ceil(row2[i]);
			if (row2[i] - num == 0) {
				System.out.print(df.format(row2[i]) + " ");
			} else {
				System.out.print(df2.format(row2[i]) + " ");
			}
		}
		System.out.println("| ");

		System.out.print("| ");
		for (int i = 0; i < row1.length; i++) {

			num = (int) Math.ceil(row3[i]);
			if (row3[i] - num == 0) {
				System.out.print(df.format(row3[i]) + " ");
			} else {
				System.out.print(df2.format(row3[i]) + " ");
			}
		}
		System.out.println("|\n\n ");
	}

}
