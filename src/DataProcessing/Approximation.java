package DataProcessing;

import java.util.Arrays;

import org.apache.commons.math3.complex.Complex;

import matlabfunctions.Matlab;
import matlabfunctions.SVTools;

public class Approximation {

	
	public static Complex test1 = new Complex(12, 2);
	public static Complex test2 = new Complex(12, 2);
	public static Complex test3 = new Complex(12, 2);
	public static double[] polstellenReal = new double[10];
	public static double[] polstellenImag;
	public Complex[] Polstellen;

	public double[] yIst;
	public double[] t;

	//	public Complex[] res = new Complex[10];

	private static PlotData plotData = new PlotData();

	public Approximation() {
		/*polstellenReal[0] = test1.getReal();
		polstellenReal[1] = test2.getReal();
		polstellenReal[2] = test3.getReal();
		
		double[] Awert = Awert(3, polstellenReal);
		for (int i = 0; i < 3; i++) {
			System.out.println(Awert[i]);
		}*/

	}

	public static Object[] Awert(int Ordnung, Complex[] polstellenReal) {
		double[] x0 = new double[Ordnung+1];
		int k = 0;
		switch (Ordnung) {
			case 1:
				x0[0] = 0.5;
				x0[1] = polstellenReal[0].getReal();
				k = 4;
			case 2:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 4;
				break;
			case 3:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 4;
				break;
			case 4:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 5;
				break;
			case 5:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 6;
				break;
			case 6:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 7;
				break;
			case 7:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 8;
				break;
			case 8:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 8;
				break;
			case 9:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 9;
				break;
			case 10:
				x0[0] = 0.5;
				for (int i = 1; i <= polstellenReal.length; i++) {
					x0[i] = polstellenReal[i - 1].getReal();
				}
				k = 10;
				break;
		}

		return new Object[] { x0, k };
	}

	public static final Object[] schritt(double[] poles, double[] t, int Ordnung) {
		double[] B = new double[1];
		B[0] = poles[0];

		Complex[] A = new Complex[Ordnung];
		Complex p1 = new Complex(poles[1], poles[2]);
		Complex p2 = p1.conjugate();
		Complex p3;
		Complex p4;
		Complex p5;
		Complex p6;
		Complex p7;
		Complex p8;
		Complex p9;
		Complex p10;
		Complex[] A1 = new Complex[2];
		Complex[] A2 = new Complex[2];
		Complex[] A3 = new Complex[2];
		Complex[] A4 = new Complex[2];
		Complex[] A5 = new Complex[2];
		Complex[] A6 = new Complex[2];
		Complex[] A7 = new Complex[2];
		Complex[] A8 = new Complex[2];
		Complex[] A9 = new Complex[2];
		Complex[] A10 = new Complex[2];

		A1[0] = new Complex(1, 0);
		A1[1] = p1.multiply(-1);

		A2[0] = new Complex(1, 0);
		A2[1] = p2.multiply(-1);

		Complex[] AA = Matlab.conv(A1, A2);
		Complex[] AAA;
		Complex[] AAAA;
		Complex[] AAAAA;
		Complex[] AAAAAA;

		switch (Ordnung) {
			case 2:
				A = AA;
				break;
			case 3:
				p3 = new Complex(poles[3], 0);

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A = Matlab.conv(AA, A3);
				break;
			case 4:
				p3 = new Complex(poles[3], poles[4]);
				p4 = p3.conjugate();

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A4[0] = new Complex(1, 0);
				A4[1] = p4.multiply(-1);

				AAA = Matlab.conv(A3, A4);
				A = Matlab.conv(AA, AAA);
				break;
			case 5:
				p3 = new Complex(poles[3], poles[4]);
				p4 = p3.conjugate();
				p5 = new Complex(poles[4], 0);

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A4[0] = new Complex(1, 0);
				A4[1] = p4.multiply(-1);

				A5[0] = new Complex(1, 0);
				A5[1] = p5.multiply(-1);

				AAA = Matlab.conv(A3, A4);
				AAAA = Matlab.conv(AAA, AA);

				A = Matlab.conv(AAAA, A5);
				break;
			case 6:
				p3 = new Complex(poles[3], poles[4]);
				p4 = p3.conjugate();
				p5 = new Complex(poles[5], poles[6]);
				p6 = p5.conjugate();

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A4[0] = new Complex(1, 0);
				A4[1] = p4.multiply(-1);

				A5[0] = new Complex(1, 0);
				A5[1] = p5.multiply(-1);

				A6[0] = new Complex(1, 0);
				A6[1] = p6.multiply(-1);

				AAA = Matlab.conv(A3, A4);
				AAAA = Matlab.conv(A5, A6);
				A = Matlab.conv(AAAA, Matlab.conv(AA, AAA));

				break;
			case 7:
				p3 = new Complex(poles[3], poles[4]);
				p4 = p3.conjugate();
				p5 = new Complex(poles[5], poles[6]);
				p6 = p5.conjugate();
				p7 = new Complex(poles[6], 0);

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A4[0] = new Complex(1, 0);
				A4[1] = p4.multiply(-1);

				A5[0] = new Complex(1, 0);
				A5[1] = p5.multiply(-1);

				A6[0] = new Complex(1, 0);
				A6[1] = p6.multiply(-1);

				A7[0] = new Complex(1, 0);
				A7[1] = p7.multiply(-1);

				AAA = Matlab.conv(A3, A4);
				AAAA = Matlab.conv(A5, A6);

				A = Matlab.conv(Matlab.conv(AAAA, Matlab.conv(AA, AAA)), A7);
				break;
			case 8:
				p3 = new Complex(poles[3], poles[4]);
				p4 = p3.conjugate();
				p5 = new Complex(poles[5], poles[6]);
				p6 = p5.conjugate();
				p7 = new Complex(poles[7], poles[8]);
				p8 = p7.conjugate();

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A4[0] = new Complex(1, 0);
				A4[1] = p4.multiply(-1);

				A5[0] = new Complex(1, 0);
				A5[1] = p5.multiply(-1);

				A6[0] = new Complex(1, 0);
				A6[1] = p6.multiply(-1);

				A7[0] = new Complex(1, 0);
				A7[1] = p7.multiply(-1);

				A8[0] = new Complex(1, 0);
				A8[1] = p8.multiply(-1);

				AAA = Matlab.conv(A3, A4);
				AAAA = Matlab.conv(A5, A6);
				AAAAA = Matlab.conv(A7, A8);

				A = Matlab.conv(Matlab.conv(AA, AAA), Matlab.conv(AAAA, AAAAA));
				break;
			case 9:
				p3 = new Complex(poles[3], poles[4]);
				p4 = p3.conjugate();
				p5 = new Complex(poles[5], poles[6]);
				p6 = p5.conjugate();
				p7 = new Complex(poles[7], poles[8]);
				p8 = p7.conjugate();
				p9 = new Complex(poles[9], 0);

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A4[0] = new Complex(1, 0);
				A4[1] = p4.multiply(-1);

				A5[0] = new Complex(1, 0);
				A5[1] = p5.multiply(-1);

				A6[0] = new Complex(1, 0);
				A6[1] = p6.multiply(-1);

				A7[0] = new Complex(1, 0);
				A7[1] = p7.multiply(-1);

				A8[0] = new Complex(1, 0);
				A8[1] = p8.multiply(-1);

				A9[0] = new Complex(1, 0);
				A9[1] = p9.multiply(-1);

				AAA = Matlab.conv(A3, A4);
				AAAA = Matlab.conv(A5, A6);
				AAAAA = Matlab.conv(A7, A8);

				A = Matlab.conv(Matlab.conv(Matlab.conv(AA, AAA), Matlab.conv(AAAA, AAAAA)), A9);

				break;
			case 10:
				p3 = new Complex(poles[3], poles[4]);
				p4 = p3.conjugate();
				p5 = new Complex(poles[5], poles[6]);
				p6 = p5.conjugate();
				p7 = new Complex(poles[7], poles[8]);
				p8 = p7.conjugate();
				p9 = new Complex(poles[9], poles[10]);
				p10 = p9.conjugate();

				A3[0] = new Complex(1, 0);
				A3[1] = p3.multiply(-1);

				A4[0] = new Complex(1, 0);
				A4[1] = p4.multiply(-1);

				A5[0] = new Complex(1, 0);
				A5[1] = p5.multiply(-1);

				A6[0] = new Complex(1, 0);
				A6[1] = p6.multiply(-1);

				A7[0] = new Complex(1, 0);
				A7[1] = p7.multiply(-1);

				A8[0] = new Complex(1, 0);
				A8[1] = p8.multiply(-1);

				A9[0] = new Complex(1, 0);
				A9[1] = p9.multiply(-1);

				A10[0] = new Complex(1, 0);
				A10[1] = p10.multiply(-1);

				AAA = Matlab.conv(A3, A4);
				AAAA = Matlab.conv(A5, A6);
				AAAAA = Matlab.conv(A7, A8);
				AAAAAA = Matlab.conv(A9, A10);

				A = Matlab.conv(Matlab.conv(Matlab.conv(AA, AAA), Matlab.conv(AAAA, AAAAA)), AAAAAA);
				break;
		}

		double[] doubleA = new double[A.length];

		for (int i = 0; i < A.length; i++) {
			doubleA[i] = A[i].getReal();
		}

		Object[] ret = new Object[3];
		Object[] step = SVTools.step(B, doubleA, t);

		ret[0] = step[0];
		ret[1] = step[1];
		//ret = Arrays.copyOfRange(step, 0, 1);
		ret[2] = A;

		return ret;
	}

	//t, y_soll, x,N
	public static double errorFunction(double[] t, double[] y_soll, double[] poles, int order) {
		double error = 0;

		Object[] ret = Approximation.schritt(poles, t, order);

		double[] y_ist = (double[]) ret[0];
		double[] t1 = (double[]) ret[1];

		for (int i = 0; i < y_soll.length; i++) {
			error += Math.pow(y_soll[i] - y_ist[i], 2);
		}
		

		return error;
	}
}
