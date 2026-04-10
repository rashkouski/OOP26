public class NegativeLifespan extends Exception{
    public NegativeLifespan(Person person){
        super(person.negativeLifespanMessage());
    }
}
