package task_two;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] score;

        System.out.print("Enter the number of subjects taken: ");

        int numberOfSubjects = scanner.nextInt();

        score = new double[numberOfSubjects];

        for (int i = 0; i < score.length; i++){
            System.out.println("Enter score " + (i + 1));
            double subjectScore = scanner.nextDouble();

            if (subjectScore < 0 || subjectScore > 100) {
                System.out.println("Invalid Score");
                throw new IllegalArgumentException();
            }
            score[i] = subjectScore;
        }

        double sum = 0;
        for (double x : score) {
            sum = sum + x;
        }

        double averagePercentage = (sum / numberOfSubjects);


        String grade;

        if (averagePercentage >= 70 && averagePercentage <= 100) {
            grade = "A";
        } else if (averagePercentage >=60 && averagePercentage <= 69) {
            grade = "B";
        } else if (averagePercentage >=50 && averagePercentage <= 59) {
            grade = "C";
        } else if (averagePercentage >=46 && averagePercentage <= 49) {
            grade = "D";
        } else if (averagePercentage >= 40 && averagePercentage <= 45) {
            grade = "E";
        } else {
            grade = "F";
        }

        System.out.printf("Total Marks: %.2f\n", sum);
        System.out.printf("Average Percentage: %.2f\n", averagePercentage);
        System.out.printf("Grade: %s", grade);


    }



}
