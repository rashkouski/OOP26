public class Segment {
    public Point p,q;


    public float length(){
        return  (float) Math.hypot(p.getx()-q.getx(),p.gety()-q.gety());
    }
    public static Segment findmax (Segment[] segments){
        Segment maxS= segments[0];
        for(Segment s: segments){
            if(s.length()>maxS.length()) maxS=s;
        }
        return maxS;
    }
}
