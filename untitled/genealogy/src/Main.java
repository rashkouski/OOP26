import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            List<Person> people = Person.fromCsv("family.csv");
            System.out.println(people);
        } catch (IOException e){
            System.err.println("Blad dostempu do pliku" + e.getMessage());
        } catch (NegativeLifespan e) {
            throw new RuntimeException(e);
        }
    }
    }
