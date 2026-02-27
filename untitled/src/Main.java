public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");
        Point p = new Point();
        p.x=5F;
        p.y=7.5F;

        System.out.println(p.toSvg());
    }
}