import java.util.ArrayList;
import java.util.List;
public class student {

    public static void main(String[] args) {
        double[][] studentScores = {
                {90, 85, 75, 85, 95},
                {85, 60, 65, 95, 65},
                {75, 70, 80, 85, 90},
                {95, 70, 75, 80, 100},
                {75, 45, 80, 60, 70}    };
        String[] studentNames = {
                "Laasya",
                "Haritha",
                "Ajitha",
                "Charitha",
                "Pavani"           };
        List<List<Double>> assignmentScores = colsToRows(studentScores);
        int i = 0;
        for(double[] score : studentScores) {
            System.out.println(studentNames[i]);
            System.out.println("Highest score = " + max(score));
            System.out.println("Lowest score = " + min(score));
            System.out.println("Mean = " + mean(score) + " Grade:" + gradeLetter(mean(score)));
            System.out.println("Mean (lowest dropped) = " + meanLowDrop(score));
            System.out.println("-------------------------------------");
            i++;
        }
           }
    public static double max(double[] numbers) {
        double result = numbers[0];
        for (double number : numbers) {
            if (number > result) {
                result = number;
            }
        }
        return result;
    }
    public static double min(double[] numbers) {
        double result = numbers[0];
        for (double number : numbers) {
            if (number < result) {
                result = number;
            }
        }
        return result;
    }
    public static double mean(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static double meanLowDrop(double[] numbers) {
        double lowestGrade = min(numbers);
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return (sum - lowestGrade) / (numbers.length - 1);
    }
    public static char gradeLetter(double mean) {
        char result;
        if (mean >= 90) {
            result = 'A';
        } else if (mean >= 80) {
            result = 'B';
        } else if (mean >= 70) {
            result = 'C';
        } else if (mean >= 65) {
            result = 'D';
        } else {
            result = 'F';
        }
        return result;
    }
    public static List<List<Double>> colsToRows(double[][] studentGrades) {
        List<List<Double>> rows = new ArrayList<>();
        for (int i = 0; i < studentGrades.length; i++) {
            List<Double> temp = new ArrayList<>();
            for (double[] studentGrade : studentGrades) {
                temp.add(studentGrade[i]);
            }
            rows.add(temp);
        }
        return rows;
    }
}
