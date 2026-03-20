public class ShaneDecorator implements Shane {
    protected Shane decoratedShane;
    public ShaneDecorator(Shane decoratedShane){
        this.decoratedShane=decoratedShane;
    }
    public BoundingBox boundingBox(){
        return decoratedShane.boundingBox();
    }
    public Shane toSvg(){
        return decoratedShane.toSvg();
    }
}
