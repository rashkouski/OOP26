public class AmbiguousPersonException extends Exception{
    private final Person persone1;
    private final Person persone2;
    public AmbiguousPersonException(Person persone1,Person persone2){
        this.persone1=persone1;
        this.persone2=persone2;
    }
    public String getMessage(){
        return String.format("Konflikt nazw: %s sv %s", persone1,persone2);
    }
}
