import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {
    // Mapowanie: "Imię Nazwisko" -> lista osób o tym samym imieniu i nazwisku
    private final Map<String, List<Person>> people = new HashMap<>();


    // Zamiast person.name() w klasie Family:

    public void add(Person... peopleToAdd) {
        for (Person person : peopleToAdd) {
            if (person == null) continue; // Zabezpieczenie przed nullami

            String key = person.name();

            // computeIfAbsent tworzy nową listę, jeśli klucza jeszcze nie ma
            this.people.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(person);

            // Sortowanie po każdym dodaniu (zapewnia porządek chronologiczny wg birthday)
            this.people.get(key).sort(Person::compareTo);
        }
    }

    public List<Person> get(String key) {
        // Zwracamy pustą listę zamiast null, aby uniknąć błędów u użytkownika klasy
        return people.getOrDefault(key, new ArrayList<>());
    }

    // Opcjonalnie: metoda do pobierania wszystkich osób w drzewie
    public List<Person> getAllPeople() {
        return people.values().stream()
                .flatMap(List::stream)
                .toList();
    }
}