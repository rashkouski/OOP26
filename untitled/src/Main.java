public class Main {
    public static void main(String[] args){
        System.out.println("Hello World");
        Point p = new Point();
        p.x=5F;
        p.y=7.5F;

        p.translate(2,-5);
        System.out.println(p);
        Point p2 = p.translated(-30,-0.5F);
        System.out.println(p2);

        Segment s = new Segment();
        s.p=p;
        s.q=p2;
        System.out.println(s.length());

        Point p3 = new Point();
        p3.x=12;
        p3.y=7;

        Point p4 = new Point();
        p4.x=8;
        p4.y=15;
        Segment s2 = new Segment();
        s2.q=p3;
        s2.p=p4;

        Point p5 = new Point();
        p5.x=11;
        p5.y=3;

        Point p6 = new Point();
        p6.x=23;
        p6.y=5;
        Segment s3 = new Segment();
        s3.q=p5;
        s3.p=p6;

        Segment[] segments = new Segment[3];
        segments[0]=s;
        segments[1]=s2;
        segments[2]=s3;

        Segment wynik = findmax(segments);
        System.out.println(wynik.p);
    }
    public static Segment findmax(Segment[] segments){
        Segment maxSeg = segments[0];
        for(Segment s:segments){
            if(s.length()> maxSeg.length()) maxSeg=s;
        }
        return maxSeg;
    }
}