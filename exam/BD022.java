package exam;

/**
 * author: cshuo
 * date: 2017/4/27
 * version: 1.0
 * description:
 */
import java.util.ArrayList;
import java.util.Scanner;

class Point {
    String type;
    int x;
    int y;
    int z;
    public Point(String type,int x,int y,int z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class BD022{
    public static double area(Point a,Point b,Point c) {
        double area = -1;
        double[] side = new double[3];//记录边长
        side[0] = Math.sqrt(Math.pow(a.x - b.x,2)
                + Math.pow(a.y - b.y,2) + Math.pow(a.z - b.z,2));
        side[1] = Math.sqrt(Math.pow(a.x - c.x,2)
                + Math.pow(a.y - c.y,2) + Math.pow(a.z - c.z,2));
        side[2] = Math.sqrt(Math.pow(b.x - c.x,2)
                + Math.pow(b.y - c.y,2) + Math.pow(b.z - c.z,2));
        //不能构成三角形
        if(side[0] + side[1] <= side[2] || side[0] + side[2] <= side[1]
                || side[1] + side[2] <= side[0]) {
            return area;
        }
        //海伦公式
        double p = (side[0] + side[1] + side[2]) / 2;
        area = Math.sqrt(p * (p - side[0]) * (p - side[1]) * (p - side[2]));

        return area;
    }

    public static double getMax(ArrayList<Point> points) {
        double area = -1;
        int size = points.size();
        for(int i = 0;i < size;i++) {
            for(int j = i + 1;j < size;j++) {
                for(int k = j + 1;k < size;k++) {
                    double temp =area(points.get(i),points.get(j),points.get(k));
                    if(temp > area)
                        area = temp;
                }
            }
        }
        return area;
    }

    public static double getResult(Point[] points) {
        double area = -1;
        //Point[] pointR = new Point[];
        ArrayList<Point> pointR = new ArrayList<Point>();
        ArrayList<Point> pointG = new ArrayList<Point>();
        ArrayList<Point> pointB = new ArrayList<Point>();
        for(Point point : points) {
            if(point.type.equals("R"))
                pointR.add(point);
            else if(point.type.equals("G"))
                pointG.add(point);
            else if(point.type.equals("B"))
                pointB.add(point);
        }
        if(pointR.size() >= 3) {
            double temp = getMax(pointR);
            if(temp > area)
                area = temp;
        }
        if(pointG.size() >= 3) {
            double temp = getMax(pointG);
            if(temp > area)
                area = temp;
        }
        if(pointB.size() >= 3) {
            double temp = getMax(pointB);
            if(temp > area)
                area = temp;
        }
        if(pointR.size() >= 1 && pointG.size() >= 1 && pointB.size() >= 1) {
            for(int i = 0;i < pointR.size();i++) {
                for(int j = 0;j < pointG.size();j++) {
                    for(int k = 0;k < pointB.size();k++) {
                        double temp =area(pointR.get(i),pointG.get(j),pointB.get(k));
                        if(temp > area)
                            area = temp;
                    }
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int number = in.nextInt();
            Point[] points = new Point[number];
            for(int i = 0;i < number;i++) {
                String type = in.next();
                int x = in.nextInt();
                int y = in.nextInt();
                int z = in.nextInt();
                points[i] = new Point(type,x,y,z);
            }
            System.out.println(String.format("%.5f",getResult(points)));
        }

    }

}