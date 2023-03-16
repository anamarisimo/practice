package PriorityQueue;

public class Main {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[1]);
        int[][] numbers = new int[n][n];
        int currentNr = 1;


            for(int colIncreaser = 0; colIncreaser<n; colIncreaser++)
            {
                for(int line = 0, colDecreaser = colIncreaser; line<=colIncreaser && colDecreaser>=0; line++, colDecreaser--)
                {
                    numbers[line][colDecreaser] = currentNr;
                    currentNr++;
                }
            }
            currentNr = n*n;
            for(int colDecreaser = n-1; colDecreaser > 0; colDecreaser--)
            {
                for(int line = n-1, colIncreaser  = colDecreaser; line>= colDecreaser && colIncreaser<n; line--, colIncreaser++)
                {
                    numbers[line][colIncreaser] = currentNr;
                    currentNr--;
                }
            }



        for(int line = 0; line < n; line++)
        {
            for(int col = 0; col < n; col++)
            {
                System.out.print(numbers[line][col]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    private static void testMeetingRooms2()
    {
        MeetingRooms2 mr = new MeetingRooms2();
        int result = mr.minMeetingRooms(new int[][] {{0,30}, {5,10}, {15,20}});
    }
}
