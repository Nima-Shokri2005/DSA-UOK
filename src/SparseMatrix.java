public class SparseMatrix {

    public SparseMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    private final int[][] matrix;
    private int[][] sparseMatrix;
    private int counter = 0;

    public int[][] sparseMatrix() {
        for (int[] i : matrix) {
            for (int j : i) {
                if (j != 0) {
                    counter++;
                }
            }
        }
        int[][] sparse = new int[3][counter + 1];
        sparse[0][0] = matrix.length;
        sparse[1][0] = matrix[0].length;
        sparse[2][0] = counter;
        int m = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    sparse[0][m] = i;
                    sparse[1][m] = j;
                    sparse[2][m] = matrix[i][j];
                    m++;
                }
            }
        }
        sparseMatrix = sparse;
        return sparse;
    }

    public void printSparseMatrix() {
        if (sparseMatrix == null) {
            sparseMatrix = sparseMatrix();
        }
        for (int[] i : sparseMatrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
