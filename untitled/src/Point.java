import java.util.Locale;

public class Point {
    public float x,y;
    public String toString(){
        return "Point (x="+x+" y="+y+")";
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH, "<circle r=\"20\" cx=\"%F\" cy=\"%F\" fill=\"red\" />",x,y);
    }
}
