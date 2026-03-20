public class SolidFieldShaneDecorator extends ShaneDecorator{
    private String color;

    public SolidFieldShaneDecorator(Shane decoratedShane, String color) {
        super(decoratedShane);
        this.color = color;
    }

    public Shane toSvg(){
        return super.toSvg().replace("/>", String.format("fill=\"%s\" />", color));
    }
}
