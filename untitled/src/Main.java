public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");
        Point p = new Point();
        p.x=5F;
        p.y=7.5F;

        p.translate(20,-5);
        System.out.println(p);
        Point p2 = p.translated(-30,-0.5F);
        System.out.println(p2);

        Segment s = new Segment();
        s.p=p;
        s.q=p2;
        System.out.println(s.length());
    }

}