package com.company;

import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Mean Absolute Deviation Calculator");
        System.out.println("Type 'done' to finish");
        System.out.print("Number of values in data set: ");
        int length = Integer.parseInt(scn.nextLine());

        //Allows for 10,000 data values:
        double[] values = new double[length];

        int i = 0;

        while (i < length) {
            int counter = i + 1;
            System.out.print("Value [" + counter + "]: ");
            String input = scn.nextLine();
            values[i] = Double.parseDouble(input);
            i++;
        }

        calculateMAD(values);
    }

    private static void calculateMAD(double[] x) {

        //We first need to calculate the mean:
        int length = x.length;
        double total = 0;
        int i = 0;

        while (i < length) {
            total = total + x[i];
            i++;
        }

        double average = total / length;

        System.out.println("Total: " + total);
        System.out.println("Average: " + average);

        //Now we need to calculate the difference from each data value from the mean:
        double[] differences = new double[length];
        int j = 0;

        while (j < length) {
            double difference = abs(x[j] - average);
            differences[j] = difference;
            j++;
        }

        //Finally, we need to average the differences to get the mean absolute deviation:
        double total_2 = 0;
        int k = 0;

        while (k < length) {
            total_2 = total_2 + differences[k];
            k++;
        }

        double MAD = total_2 / length;
        System.out.println("MAD: " + MAD);
    }
}