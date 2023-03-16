package Array;

public class RotateImage {
    public void rotate(int[][] matrix)
    {
        int i=0;
        int j=0;
        int maxCol = matrix.length-2;
        int colIter = 0;
        while(i<matrix.length/2)
        {
            colIter = j;
            while(colIter <= maxCol)
            {
                rotate4Cells(i,colIter,matrix);
                colIter++;
            }
            maxCol--;
            i++;
            j++;
        }
    }

    private void rotate4Cells(int i, int j, int[][] matrix)
    {
        int currentLine = i;
        int currentCol = j;
        int newLine = currentCol;
        int newCol =  matrix.length-currentLine-1;
        int currentValue = matrix[currentLine][currentCol];
        int nextValue = matrix[newLine][newCol];

        for(int x=0; x<4;x++)
        {
            matrix[newLine][newCol] = currentValue;
            currentLine = newLine;
            currentCol = newCol;
            newLine = currentCol;
            newCol = matrix.length-currentLine-1;
            currentValue = nextValue;
            nextValue = matrix[newLine][newCol];
        }
    }

    //Alternativa - TRANSPUSA + REVERSE
    /*
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
     */
}
