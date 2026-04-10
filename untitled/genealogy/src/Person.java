import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.Arrays.stream;

public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Set<Person> children = new HashSet<>();
    private LocalDate death;

    public Person(LocalDate death) {
        this.death = death;
    }

    public Person(String firstName, String lastName, LocalDate birthday,LocalDate death) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.birthday = birthday;
        this.death=death;
    }
    public Person(String firstName, String lastName, LocalDate birthday){
        this(firstName,lastName,birthday,null);
    }

    public boolean adopt(Person child){
        if(child== this) return false;
        return children.add(child);
    }
    public Person getYoungeastChild(){
       /* Iterator<Person> iter = this.children.iterator();
        Person now = iter.next();
        Person youngest = now;
        while(true){
            if(youngest.birthday.compareTo(now.birthday)<0){
                youngest=now;
            }
            try{
                iter.next();
            } catch (NoSuchElementException e){
                break;
            }
        }*/
        if(this.children.isEmpty()) return null;
        Person youngest = children.iterator().next();
        for(Person person : children){
            if(youngest.compareTo(person)>0){
                youngest=person;
            }
        }
        return youngest;
    }
    public List<Person> getChildren(){
        /*List<Person> result = new ArrayList<>();
        result.addAll(children);

        result.sort(Person::compareTo);
        return result;
        */
        return children.stream().sorted().toList();
    }
    public static Person fromCsvLine(String line){
        String[] columns = line.split(",", -1);
        String fullName = columns[0];
        String[] name = fullName.split(" ");
        String fname = name[0];
        String lname = name[1];
        String birth = columns[1];
        String death = columns[2];
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdate = LocalDate.parse(birth,formater);
        LocalDate deathdate = null;
        if(!death.isEmpty()){
            deathdate= LocalDate.parse(birth,formater);
        }
        return new Person(fname,lname,birthdate,deathdate);
    }
    public static List<Person> fromCsv(String path) throws IOException {
        List<Person> people = new ArrayList<>();
        BufferedReader file = new BufferedReader(new FileReader(path));
        file.readLine();
        String line;
        while((line = file.readLine())!= null){
            people.add(fromCsvLine(line));
        }
        file.close();
        return people;
    }
    public String name(){
        return String.format("%s %s", firstName,lastName);
    }
    public int compareTo(Person other){
        return this.birthday.compareTo(other.birthday);
    }

    public String toString(){
        return "Person ("+"FirstName=" + firstName + '\'' + " lastName='" + lastName + '\'' + " birthday='" + birthday + " death="+ death+ '\'' + " children=" + children+')';
    }
}
