import java.util.Arrays;
import java.util.Locale;

public class Polygon {
    private Point[] points;
    public Polygon(Point[] points){
        this.points = new Point[points.length];
        for(int i=0; i<points.length;i++){
            this.points[i]=new Point(points[i]);

        }
    }
    public Polygon(Polygon p){
        this(p.points);
    }

    public String toString(){
        return "Polygon(points="+ Arrays.toString(points)+")";
    }

    public String toSvg() {
        String pointstring = "";
        for (Point point : points) {
            pointstring += point.getx() + "," + point.gety() + " ";
        }

        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" stle=\"fill:time:stroke:perple:stroke-width=\"%s\"");
    }
        public BoundingBox boundingBox() {
            if (points.length == 0) {
                return new BoundingBox(0, 0, 0, 0);
            }
            float minX = points[0].getx();
            float maxX = points[0].getx();
            float minY = points[0].gety();
            float maxY = points[0].gety();
            for(Point p: points){
                if(p.getx()==minX) minX=p.getx();
                if(p.getx() == maxX) maxX=p.getx();
                if(p.getx() == minY) maxY=p.gety();
                if(p.getx() == maxY) maxY=p.gety();
            }
            return new BoundingBox(minX,minY,maxX-minX,maxY-minY);
        }
}
