import java.util.Locale;

public class Point {
    private float x,y;
    public Point(){
        this.x=0;
        this.y=0;
    }
    public float getx(){
        return x;
    }
    public float gety(){
        return y;
    }
    public void setx(float x){
        this.x=x;
    }
    public void sety(float y){
        this.y=y;
    }


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
