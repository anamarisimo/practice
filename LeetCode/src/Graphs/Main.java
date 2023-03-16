package Graphs;

public class Main {

    public static void main(String[] args) {
        testTownJudge();
    }

    private static void testTownJudge(){
        TownJudge tJ = new TownJudge();
        int result1 = tJ.findJudge(2, new int[][]{{1,2}});
        int result2 = tJ.findJudge(3, new int[][]{{1,3},{2,3}});
        int result3 = tJ.findJudge(3, new int[][]{{1,3},{2,3},{3,1}});

        if(result1 == 2 && result2==3 && result3==-1)
            System.out.println("results correct");
        else
            System.out.println("results incorrect");
    }
}
