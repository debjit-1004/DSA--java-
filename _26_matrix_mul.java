//_26_matrix_mul

import java.util.Scanner;

public class _26_matrix_mul {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for the first matrix:");
        int[][] matrix1 = inputMatrix(scanner);

        System.out.println("Enter details for the second matrix:");
        int[][] matrix2 = inputMatrix(scanner);

        try {
            System.out.println("Resultant Matrix:");
            int[][] result = multiplyMatrix(matrix1, matrix2);
            printMatrix(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to input a matrix
    public static int[][] inputMatrix(Scanner scanner) {
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Element [%d][%d]: ", i + 1, j + 1);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Method to multiply two matrices
    public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }

        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}