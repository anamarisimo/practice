package Math;

class Rectangle
{
    public Rectangle(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public Rectangle(OverlapInterval x, OverlapInterval y)
    {
        x1 = x.start;
        x2 = x.end;
        y1 = y.start;
        y2 = y.end;
    }
    public int x1;
    public int x2;
    public int y1;
    public int y2;
}

class OverlapInterval
{
    public int start;
    public int end;
}

public class RectanglePointSearcher {
    private Rectangle findOverlapAscendingScanNMinus1(Rectangle[] rectangles)
    {
        Rectangle current = rectangles[0];
        boolean skippedOneRectangle = false;
        for (int i=1;i<rectangles.length ;i++ ) {
            Rectangle overlapResult = getOverlapArea(current, rectangles[i]);
            if(overlapResult == null)
            {
                if(skippedOneRectangle)
                {
                    Rectangle potentiallyCorrectOverlap = getOverlapArea(current, rectangles[2]);
                    if(i==3 && potentiallyCorrectOverlap!=null)
                    {
                        current = potentiallyCorrectOverlap;
                    }
                    else
                        return null;
                }

                else
                {
                    skippedOneRectangle = true;
                    continue;
                }

            }
            current = getOverlapArea(current, rectangles[i]);
        }
        return current;
    }

    private Rectangle findOverlapDescendingScanNMinus1(Rectangle[] rectangles)
    {
        boolean skippedOneRectangle = false;
        Rectangle current = rectangles[rectangles.length-1];
        for (int i=rectangles.length-2;i>=0 ;i--)
        {
            Rectangle overlapResult = getOverlapArea(current, rectangles[i]);
            if(overlapResult == null)
            {
                if(skippedOneRectangle)
                {
                    return null;
                }
                else
                {
                    skippedOneRectangle = true;
                    continue;
                }

            }
            current = getOverlapArea(current, rectangles[i]);
    }
        return current;
    }

    public void printNMinus1CommonPointCoords(Rectangle[] rectangles)
    {
        Rectangle commonOverlapNMinusOne = findOverlapAscendingScanNMinus1(rectangles);
        if(commonOverlapNMinusOne == null)
            commonOverlapNMinusOne = findOverlapDescendingScanNMinus1(rectangles);

        if(commonOverlapNMinusOne == null)
            System.out.println("no solution");
        else
            System.out.println(commonOverlapNMinusOne.x1 + " " + commonOverlapNMinusOne.y1);
        }

    public Rectangle getOverlapArea(Rectangle rectangle1, Rectangle rectangle2)
    {
        OverlapInterval xOverlap = getXAxisOverlap(rectangle1.x1, rectangle1.x2, rectangle2.x1, rectangle2.x2);
        OverlapInterval yOverlap = getYAxisOverlap(rectangle1.y1, rectangle1.y2, rectangle2.y1, rectangle2.y2);
        if(xOverlap!=null && yOverlap!=null)
            return new Rectangle(xOverlap, yOverlap);
        else
            return null;
    }

    private OverlapInterval getYAxisOverlap(int y1rect1, int y2rect1, int y1rect2, int y2rect2)
    {
        OverlapInterval result = new OverlapInterval();
        if(y1rect1 <= y2rect2 && y2rect2 <=y2rect1)
        {
            result.start = Math.max(y1rect1, y1rect2);
            result.end = y2rect2;
            return result;
        }
        else if(y1rect2 <= y2rect1 && y2rect1 <= y2rect2)
        {
            result.start = Math.max(y1rect2, y1rect1);
            result.end = y2rect1;
            return result;
        }
        return null;
    }

    private OverlapInterval getXAxisOverlap(int x1rect1, int x2rect1, int x1rect2, int x2rect2)
    {
        OverlapInterval result = new OverlapInterval();
        if(x1rect1 <= x2rect2 && x2rect2 <=x2rect1)
        {
            result.start = Math.max(x1rect1, x1rect2);
            result.end = x2rect2;
            return result;
        }
        else if(x1rect2 <= x2rect1 && x2rect1 <= x2rect2)
        {
            result.start = Math.max(x1rect2, x1rect1);
            result.end = x2rect1;
            return result;
        }
        else
            return null;
    }

}
