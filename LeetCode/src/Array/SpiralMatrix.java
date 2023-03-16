package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> res = new ArrayList<Integer>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while(res.size() < rows * columns)
        {
            for(int col = left; col <= right; col++)
            {
                res.add(matrix[up][col]);
            }

            for(int line = up+1; line <= down; line++)
            {
                res.add(matrix[line][right]);
            }
            if (up != down) {
                for(int col = right-1; col >= left; col--)
                {
                    res.add(matrix[down][col]);
                }
            }
            if (left != right){
                for(int line = down - 1; line > up; line--)
                {
                    res.add(matrix[line][left]);

                }}


            up++;
            right--;
            down--;
            left++;
        }

        return res;

    }
}
