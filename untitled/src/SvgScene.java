import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class SvgScene {
    private Shane[] shanes = new Shane[3];
    private int index =0;

    public void addShane(Shane p){
        shanes[index]=p;
        index++;
        if(index == 3) index=0;

    }
    public String toSvg(){
        StringBuilder polygonsString = new StringBuilder();
        for(Shane p: shanes){
            if(p!=null){
                polygonsString.append(p.toSvg()).append("\n");
            }
            polygonsString.append(p.toSvg()).append("\n");
        }
        return String.format(Locale.ENGLISH, "sdsdsd", polygonsString);
    }
/**/
    public void save(String path) throws IOException{
        FileWriter writer = new FileWriter(path);
        writer.write(toSvg());
        writer.close();
    }
}

