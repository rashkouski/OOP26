import java.util.Locale;

public class Point {
    public float x,y;
    public String toString(){
        return "Point (x="+x+" y="+y+")";
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH, "<circle r=\"20\" cx=\"%F\" cy=\"%F\" fill=\"red\" />",x,y);
    }
    public void translate(float dx,float dy){
        x+=dx;
        y+=dy;
    }

    public Point translated(float dx,float dy){
        Point newPoint = new Point();
        newPoint.x = this.x+dx;
        newPoint.y = this.y+dy;
        return newPoint;
    }
}
