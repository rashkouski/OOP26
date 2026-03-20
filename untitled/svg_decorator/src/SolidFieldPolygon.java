public class SolidFieldPolygon extends Polygon {
    private String color;

    public SolidFieldPolygon(Vec2[] points, String color){
        super(points);
        this.color=color;
    }

    public String toSvg(){
        return super.toSvg().replace("/>", String.format("fill=\"%s\" />", color));
    }
}
