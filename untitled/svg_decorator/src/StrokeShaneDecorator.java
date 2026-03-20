public class StrokeShaneDecorator extends ShaneDecorator{
    private final String color;
    private final double width;

    public StrokeShaneDecorator(Shane decoratedShane, String color, double width) {
        super(decoratedShane);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toSvg() {
        return this.decoratedShane.toSvg().replace(String.format(Locale.ENGLISH,));
    }
}
