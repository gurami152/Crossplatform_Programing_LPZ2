package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] Fibonachi = new int[20];
        Fibonachi[0]=0;
        Fibonachi[1]=1;
        System.out.print(Fibonachi[0]);
        System.out.print(",");
        System.out.print(Fibonachi[1]);
        System.out.print(",");
        for(int i=2;i<Fibonachi.length;i++){
            Fibonachi[i]=Fibonachi[i-1]+Fibonachi[i-2];
            System.out.print(Fibonachi[i]);
            System.out.print(",");
        }
    }
}
