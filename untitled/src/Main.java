public class Main {
    public static void main(String[] args) {
        Point[] points= new Point[5];
        points[0]=new Point(2.3F,5.6F);
        points[1]=new Point(10.5F,12.6F);
        points[2]=new Point(15.4F,74.2F);
        points[3]=new Point(72.4F,71.6F);
        points[4]=new Point(162.4F,51.3F);

        Polygon p1 = new Polygon(points);
        System.out.println(p1);

    }
        public static Segment findmax (Segment[]segments){
            Segment maxSeg = segments[0];
            for (Segment s : segments) {
                if (s.length() > maxSeg.length()) maxSeg = s;
            }
            return maxSeg;
        }
}