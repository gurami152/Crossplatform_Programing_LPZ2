package com.company;

public class Main {

    public static void main(String[] args) {
	    double[] A = {0.0,0.0,1.0};
        double[] B = {1.0,0.0,0.0};
        double[] resultVector = new double[3];
        // скалярное произведение векторов
        double resultScalar= A[0]*B[0]+A[1]*B[1]+A[2]*B[2];
        System.out.println(resultScalar);
        // векторное произведение векторов
        resultVector[0] =A[1]*B[2]-A[2]*B[1];
        resultVector[1] =A[2]*B[0]-A[0]*B[2];
        resultVector[2] =A[0]*B[1]-A[1]*B[0];
        for (double number:resultVector
             ) {
            System.out.print(number);
            System.out.print(",");
        }
    }
}
