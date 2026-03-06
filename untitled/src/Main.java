public class Main {
    public static void main(String[] args) {

        Point p = new Point();




        Point p2 = new Point();
        p2.setx(2.6F);
        p2.sety(9F);
        System.out.println(p2);

        Segment s1 = new Segment(new Point(p),new Point(p2));
        System.out.println(s1);
        p.setx(100);
        System.out.println(s1);

    }
        public static Segment findmax (Segment[]segments){
            Segment maxSeg = segments[0];
            for (Segment s : segments) {
                if (s.length() > maxSeg.length()) maxSeg = s;
            }
            return maxSeg;
        }
}