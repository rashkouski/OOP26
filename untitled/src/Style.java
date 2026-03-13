import java.util.Locale;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final Double strokeDidth;



    public Style(String fillColor, String strokeColor, Double strokeDidth){
        this.fillColor= fillColor;
        this.strokeColor= strokeColor;
        this.strokeDidth= strokeDidth;
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH,
                "fill:%s;stroke:%s;stroke-width:%f", fillColor, strokeColor,strokeDidth);
    }
}
