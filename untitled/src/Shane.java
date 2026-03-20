public abstract class Shane {
    protected Style style;

    public Shane(Style style){
        this.style=style;
    }
    //BoundingBox boundingBox();
    public abstract String toSvg();
}
