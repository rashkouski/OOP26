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

        list.add("ala");
        list.add("ma");
        list.add("kota");
        list.addFirst("Mala");

        System.out.println("Element pod indeksem 1:"+ list.get(1));
        System.out.println("Rozmiar listy: "+ list.size());

        for (String s : list){
            System.out.println(s);
        }
        list.stream().sorted().forEach(System.out::println);

        while(list.size()>0){
            System.out.println("Usuwam :"+ list.removeLast());
        }
    }

}