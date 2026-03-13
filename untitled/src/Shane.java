public abstract class Shane {
    protected Style style;

    public Shane(Style style){
        this.style=style;
    }

    public abstract String toSvg();
}
