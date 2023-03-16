package Stacks;

public class Main {

    public static void main(String[] args) {
        testValidParantheses();
    }

    private static void testValidParantheses(){
        String input1 = "{}()[]";
        String input2 = "{[{}([()])[]]}";
        String input3 = "[)]";
        ValidParantheses validator = new ValidParantheses();
        boolean result1 = validator.isValid(input1);
        boolean result2 = validator.isValid(input2);
        boolean result3 = validator.isValid(input3);

        if(result1 && result2 && !result3)
            System.out.println("results correct");
        else
            System.out.println("results incorrect");
    }
}
