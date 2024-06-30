public class Matrix {
    private final double[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public Matrix(double[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, double value) {
        data[row][col] = value;
    }

    public Matrix transpose() {
        Matrix transposed = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed.set(j, i, data[i][j]);
            }
        }
        return transposed;
    }

    public Matrix multiply(Matrix other) {
        if (cols != other.getRows()) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication");
        }
        Matrix result = new Matrix(rows, other.getCols());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i][k] * other.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, data[i][j] * scalar);
            }
        }
        return result;
    }

    public Matrix add(Matrix other) {
        if (rows != other.getRows() || cols != other.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions do not match for addition");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, data[i][j] + other.get(i, j));
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        if (rows != other.getRows() || cols != other.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions do not match for subtraction");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.set(i, j, data[i][j] - other.get(i, j));
            }
        }
        return result;
    }

    public Matrix inverse() {
        if (rows != cols) {
            throw new IllegalArgumentException("Only square matrices have inverses");
        }

        int n = rows;
        Matrix augmented = new Matrix(n, 2 * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmented.set(i, j, data[i][j]);
            }
            augmented.set(i, n + i, 1);
        }

        GaussianElimination.gaussianEliminate(augmented);

        Matrix inverse = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse.set(i, j, augmented.get(i, n + j));
            }
        }

        return inverse;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f ", data[i][j]);
            }
            System.out.println();
        }
    }
}
