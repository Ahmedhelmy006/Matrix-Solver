public class GaussianElimination {

    public static void gaussianEliminate(Matrix matrix) {
        int n = matrix.getRows();
        for (int pivot = 0; pivot < n; pivot++) {
            int max = pivot;
            for (int i = pivot + 1; i < n; i++) {
                if (Math.abs(matrix.get(i, pivot)) > Math.abs(matrix.get(max, pivot))) {
                    max = i;
                }
            }

            for (int j = 0; j < 2 * n; j++) {
                double temp = matrix.get(pivot, j);
                matrix.set(pivot, j, matrix.get(max, j));
                matrix.set(max, j, temp);
            }

            for (int i = pivot + 1; i < n; i++) {
                double alpha = matrix.get(i, pivot) / matrix.get(pivot, pivot);
                for (int j = pivot; j < 2 * n; j++) {
                    matrix.set(i, j, matrix.get(i, j) - alpha * matrix.get(pivot, j));
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                double alpha = matrix.get(i, j);
                for (int k = 0; k < 2 * n; k++) {
                    matrix.set(i, k, matrix.get(i, k) - alpha * matrix.get(j, k));
                }
            }
            double alpha = matrix.get(i, i);
            for (int k = 0; k < 2 * n; k++) {
                matrix.set(i, k, matrix.get(i, k) / alpha);
            }
        }
    }
}
