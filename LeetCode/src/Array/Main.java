package Array;

public class Main {
    public static void main(String[] args) {
        //testIsUnique();
        testLengthLastWord();
    }

    private static void testLengthLastWord() {
        LengthLastWord len = new LengthLastWord();
        System.out.println(len.lengthOfLastWord(" i "));
    }

    private static void testIsUnique() {
        AllCharactersUniqueInString uniqueChecker = new AllCharactersUniqueInString();
        String input = "fabcde";
        System.out.println(input);
        System.out.println(uniqueChecker.hasAllCharsUnique(input));
        System.out.println(input);
        System.out.println("abcded");
        System.out.println(uniqueChecker.hasAllCharsUnique("abcded"));
    }

    private static void testNextPermutation() {
        NextPermutation perm = new NextPermutation();
        int[] input = new int[]{3, 4, 1, 4, 3, 3};
        perm.nextPermutation(input);
        for (int j : input) {
            System.out.print(j);
            System.out.print(" ");
        }
    }
}
