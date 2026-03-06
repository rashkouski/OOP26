import java.util.Arrays;
import java.util.Locale;

public class Polygon {
    private Point[] points;
    public Polygon(Point[] points){
        this.points = points;
    }
    public String toString(){
        return "Polygon(points="+ Arrays.toString(points)+")";
    }

    public String toSvg(){
        String pointstring = "";
        for(Point point: points){
            pointstring+=point.getx()+","+point.gety()+" ";
        }

        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" stle=\"fill:time:stroke:perple:stroke-width=\"%s\"");
    }
}
