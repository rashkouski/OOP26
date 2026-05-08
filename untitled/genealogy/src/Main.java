import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, NegativeLifespan {
        String path = "/home/student/Pulpit/rep_OOP26/OOP26/untitled/family.csv"; // Przykładowa ścieżka
        System.out.println("Szukam pliku w: " + System.getProperty("user.dir"));
        // Funkcja zmieniająca kolor na żółty (do testów)
        Function<String, String> toYellow = line -> line + ",yellow";

        // --- TEST DLA ZADANIA 6 (Osoby zmarłe) ---
        // Warunek: osoba jest zmarła
        Predicate<Person> isDead = p -> p.getDeath() != null;

        System.out.println("Przetwarzanie tylko osób zmarłych (Zadanie 6):");
        List<Person> deadProcessed = Person.fromCsv(path, toYellow, isDead);
        deadProcessed.forEach(System.out::println);


        // --- TEST DLA ZADANIA 7 (Najstarsza żyjąca osoba) ---
        // Najpierw musimy wiedzieć, kto jest najstarszy, aby stworzyć warunek
        List<Person> allPeople = Person.fromCsv(path, line -> line, p -> true);
        Person oldestLiving = Person.getOldestLivingPerson(allPeople);

        // Warunek: osoba jest tą konkretną najstarszą żyjącą osobą
        Predicate<Person> isOldestLiving = p -> oldestLiving != null &&
                p.name().equals(oldestLiving.name()) &&
                p.getBirthday().equals(oldestLiving.getBirthday());

        System.out.println("\nPrzetwarzanie tylko najstarszej żyjącej osoby (Zadanie 7):");
        List<Person> oldestProcessed = Person.fromCsv(path, toYellow, isOldestLiving);
        oldestProcessed.forEach(System.out::println);
    }
}