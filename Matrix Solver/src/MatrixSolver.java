import java.util.Scanner;

public class MatrixSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows of the matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns of the matrix: ");
        int cols = scanner.nextInt();

        double[][] data = new double[rows][cols];

        System.out.println("Enter the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = scanner.nextDouble();
            }
        }

        Matrix matrix = new Matrix(data);

        System.out.println("Select operation: ");
        System.out.println("1. Transpose");
        System.out.println("2. Multiply by another matrix");
        System.out.println("3. Multiply by a scalar");
        System.out.println("4. Add another matrix");
        System.out.println("5. Subtract another matrix");
        System.out.println("6. Inverse");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Matrix transposed = matrix.transpose();
                transposed.print();
                break;
            case 2:
                System.out.print("Enter the number of rows of the second matrix: ");
                int rows2 = scanner.nextInt();
                System.out.print("Enter the number of columns of the second matrix: ");
                int cols2 = scanner.nextInt();

                double[][] data2 = new double[rows2][cols2];

                System.out.println("Enter the second matrix:");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        data2[i][j] = scanner.nextDouble();
                    }
                }

                Matrix matrix2 = new Matrix(data2);
                Matrix result = matrix.multiply(matrix2);
                result.print();
                break;
            case 3:
                System.out.print("Enter the scalar value: ");
                double scalar = scanner.nextDouble();
                Matrix scalarResult = matrix.multiply(scalar);
                scalarResult.print();
                break;
            case 4:
                System.out.print("Enter the number of rows of the second matrix: ");
                rows2 = scanner.nextInt();
                System.out.print("Enter the number of columns of the second matrix: ");
                cols2 = scanner.nextInt();

                data2 = new double[rows2][cols2];

                System.out.println("Enter the second matrix:");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        data2[i][j] = scanner.nextDouble();
                    }
                }

                matrix2 = new Matrix(data2);
                result = matrix.add(matrix2);
                result.print();
                break;
            case 5:
                System.out.print("Enter the number of rows of the second matrix: ");
                rows2 = scanner.nextInt();
                System.out.print("Enter the number of columns of the second matrix: ");
                cols2 = scanner.nextInt();

                data2 = new double[rows2][cols2];

                System.out.println("Enter the second matrix:");
                for (int i = 0; i < rows2; i++) {
                    for (int j = 0; j < cols2; j++) {
                        data2[i][j] = scanner.nextDouble();
                    }
                }

                matrix2 = new Matrix(data2);
                result = matrix.subtract(matrix2);
                result.print();
                break;
            case 6:
                if (rows != cols) {
                    System.out.println("Only square matrices have inverses.");
                } else {
                    Matrix inverse = matrix.inverse();
                    inverse.print();
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
