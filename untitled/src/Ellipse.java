import java.util.Locale;

public class Ellipse extends Shane {
    private Point center;
    private float px,py;
    public Ellipse(Point center, float px,float py,Style style){
        super(style);
        this.center=center;
        this.px=px;
        this.py=py;
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH, "%f %f %f %f", px,py,center.getx(),center.gety(),style.toSvg());
    }
}
