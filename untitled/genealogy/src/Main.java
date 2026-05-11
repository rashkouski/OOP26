import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        CustomList<String> list = new CustomList<>();

        list.addLast("ala");
        list.addLast("ma");
        list.addLast("kota");

        list.addFirst("Mala");

        System.out.println(list.getFirst());
        System.out.println(list.removeLast());
    }

}