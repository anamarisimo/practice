package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    HashMap<Character, List<Position>> seenDigits = new HashMap<>();
    public boolean isValidSudoku(char[][] board)
    {

        for(int i=0; i< board.length; i++)
        {
            for(int j=0; j< board[i].length; j++)
            {
                if(!isDigit(board[i][j]))
                    continue;
                else if(isDigitPositionValid(i,j,board[i][j]))
                {
                    addEntryToSeenDigits(i,j,board[i][j]);
                }
                else
                    return false;
            }
        }
        return true;
    }

    private boolean isDigit(char chr)
    {
        return chr >='0' && chr <= '9';
    }

    private boolean isDigitPositionValid(int row, int col, char digit)
    {
        List<Position> digitSeenPositions = seenDigits.get(digit);
        if(digitSeenPositions == null)
            return true;

        boolean isValidRow = isInRowUnique(row, digit, digitSeenPositions);
        boolean isValidCol = isInColUnique(col, digit, digitSeenPositions);
        boolean isValidSubbox = isInSubboxUnique(row, col, digit, digitSeenPositions);

        return isValidRow && isValidCol && isValidSubbox;
    }

    private boolean isInRowUnique(int row, char digit, List<Position> digitSeenPositions)
    {
        for(Position pos: digitSeenPositions)
        {
            if(pos.getRow() == row)
                return false;
        }
        return true;
    }

    private boolean isInColUnique(int col, char digit, List<Position> digitSeenPositions)
    {
        for(Position pos: digitSeenPositions)
        {
            if(pos.getCol() == col)
                return false;
        }
        return true;
    }

    private boolean isInSubboxUnique(int row, int col, char digit, List<Position> digitSeenPositions)
    {
        for(Position pos: digitSeenPositions)
        {
            if(isSameSubboxRow(row, pos.getRow()) && isSameSubboxCol(col, pos.getCol()))
                return false;
        }
        return true;
    }

    private boolean isSameSubboxRow(int row, int existingRow)
    {
        boolean bothInFirstSubboxRows = row>=0 && row<=2 && existingRow>=0 && existingRow <=2;
        boolean bothInSecondSubboxRows = row>=3 && row<=5 && existingRow>=3 && existingRow <=5;
        boolean bothInThirdSubboxRows = row>=6 && row<=8 && existingRow>=6 && existingRow <=8;
        return bothInFirstSubboxRows || bothInSecondSubboxRows || bothInThirdSubboxRows;
    }

    private boolean isSameSubboxCol(int col, int existingCol)
    {
        boolean bothInFirstSubboxCols = col>=0 && col<=2 && existingCol>=0 && existingCol <=2;
        boolean bothInSecondSubboxCols = col>=3 && col<=5 && existingCol>=3 && existingCol <=5;
        boolean bothInThirdSubboxCols = col>=6 && col<=8 && existingCol>=6 && existingCol <=8;
        return bothInFirstSubboxCols || bothInSecondSubboxCols || bothInThirdSubboxCols;
    }

    private void addEntryToSeenDigits(int row, int col, char digit)
    {
        List<Position> digitSeenPositions = seenDigits.get(digit);
        if(digitSeenPositions == null)
        {
            List<Position> value = new ArrayList<Position>();
            value.add(new Position(row, col));
            seenDigits.put(digit, value);
        }
        else
            digitSeenPositions.add(new Position(row, col));

    }
}

class Position
{
    int _row;
    int _col;
    public Position(int row, int col)
    {
        _row = row;
        _col=col;
    }
    public int getRow()
    {
        return _row;
    }

    public int getCol()
    {
        return _col;
    }


}
