package Math;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(0,0,1,1);
        Rectangle rectangle2 = new Rectangle(1,1,2,2);
        Rectangle rectangle3 = new Rectangle(3,0,4,1);
        testRectangles(new Rectangle[]{rectangle1, rectangle2, rectangle3});

        rectangle1 = new Rectangle(0,0,1,1);
        rectangle2 = new Rectangle(0,1,1,2);
        rectangle3 = new Rectangle(1,0,2,1);
        testRectangles(new Rectangle[]{rectangle1, rectangle2, rectangle3});

        rectangle1 = new Rectangle(0,0,5,5);
        rectangle2 = new Rectangle(0,0,4,4);
        rectangle3 = new Rectangle(1,1,4,4);
        Rectangle rectangle4 = new Rectangle(1,1,4,4);
        testRectangles(new Rectangle[]{rectangle1, rectangle2, rectangle3, rectangle4});

        rectangle1 = new Rectangle(0,0,10,8);
        rectangle2 = new Rectangle(1,2,6,7);
        rectangle3 = new Rectangle(2,3,5,6);
        rectangle4 = new Rectangle(3,4,4,5);
        Rectangle rectangle5 = new Rectangle(8,1,9,2);
        testRectangles(new Rectangle[]{rectangle1, rectangle2, rectangle3, rectangle4, rectangle5});
    }

    public static void testRectangles(Rectangle[] rectangles)
    {
        RectanglePointSearcher rectanglePointSearcher = new RectanglePointSearcher();
        rectanglePointSearcher.printNMinus1CommonPointCoords(rectangles);
    }
}
