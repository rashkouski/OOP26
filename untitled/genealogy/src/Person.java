import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final Set<Person> children = new HashSet<>();
    private final LocalDate death;

    public Person(String firstName, String lastName, LocalDate birthday, LocalDate death) throws NegativeLifespan {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.death = death;

        if (this.death != null && this.birthday.isAfter(this.death)) {
            throw new NegativeLifespan(this);
        }
    }
    public String name() {
        return String.format("%s %s", firstName, lastName);
    }

    public Person(String firstName, String lastName, LocalDate birthday) throws NegativeLifespan {
        this(firstName, lastName, birthday, null);
    }

    // Gettery (przydatne do raportowania błędów i wyświetlania danych)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthday() { return birthday; }
    public LocalDate getDeath() { return death; }

    public boolean adopt(Person child) {
        if (child == null || child == this) return false;
        return children.add(child);
    }

    public Person getYoungeastChild() {
        return children.stream()
                .max(Comparator.comparing(p -> p.birthday))
                .orElse(null);
    }

    public List<Person> getChildren() {
        return children.stream().sorted().toList();
    }

    public static Person fromCsvLine(String line) throws NegativeLifespan {
        String[] columns = line.split(",", -1);
        String[] nameParts = columns[0].trim().split("\\s+");

        String fname = nameParts.length > 0 ? nameParts[0] : "Nieznane";
        String lname = nameParts.length > 1 ? nameParts[1] : "";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdate = LocalDate.parse(columns[1].trim(), formatter);

        LocalDate deathdate = null;
        if (columns.length > 2 && !columns[2].isBlank()) {
            deathdate = LocalDate.parse(columns[2].trim(), formatter);
        }

        return new Person(fname, lname, birthdate, deathdate);
    }

    public static List<Person> fromCsv(String path) throws IOException, NegativeLifespan {
        List<Person> people = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            file.readLine(); // Pomiń nagłówek
            String line;
            while ((line = file.readLine()) != null) {
                if (!line.isBlank()) {
                    people.add(fromCsvLine(line));
                }
            }
        }
        return people;
    }

    public long lifespan() {
        LocalDate end = (death == null) ? LocalDate.now() : death;
        return ChronoUnit.DAYS.between(birthday, end);
    }

    // Poprawiona metoda getDeadPeople
    public static List<Person> getDeadPeople(List<Person> people) {
        return people.stream()
                .filter(p -> p.death != null)
                .sorted(Comparator.comparingLong(Person::lifespan).reversed())
                .toList(); // Teraz poprawnie domknięte
    }

    public String negativeLifespanMessage() {
        return String.format("Osoba %s %s ma datę śmierci %s wcześniejszą niż data urodzenia %s",
                this.firstName, this.lastName, this.death, this.birthday);
    }

    @Override
    public int compareTo(Person other) {
        return this.birthday.compareTo(other.birthday);
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s %s', birth=%s, death=%s, childrenCount=%d}",
                firstName, lastName, birthday, death, children.size());
    }
}