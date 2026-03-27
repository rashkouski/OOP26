import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Mike", "Tson", LocalDate.of(1966,5,18)));
        people.add(new Person("Snape", "Stelenski", LocalDate.of(2000,5,18)));
        people.add(new Person("Turk", "Apache", LocalDate.of(1945,5,18)));
        System.out.println(people);
        Person parent = people.get(0);
        Person child = people.get(1);
        System.out.println(parent.getYoungeastChild());
        System.out.println(parent.getChildren());


    }
    }
