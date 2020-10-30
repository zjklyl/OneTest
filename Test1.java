package OneDay;

/**
 * @Description
 * @Author ZJK
 * @Date 2020/10/30 21:34
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入A点坐标:");
        double Ax = sc.nextDouble();
        double Ay = sc.nextDouble();
        Node A = new Node(Ax,Ay);
        System.out.println("请输入B点坐标:");
        double Bx = sc.nextDouble();
        double By = sc.nextDouble();
        Node B = new Node(Bx,By);
        System.out.println("请输入C点坐标:");
        double Cx = sc.nextDouble();
        double Cy = sc.nextDouble();
        Node C = new Node(Cx,Cy);
        System.out.println("请输入D点坐标:");
        double Dx = sc.nextDouble();
        double Dy = sc.nextDouble();
        Node D = new Node(Dx,Dy);
        System.out.println("请输入E点坐标:");
        double Ex = sc.nextDouble();
        double Ey = sc.nextDouble();
        Node E = new Node(Ex,Ey);

        Node[] n = {A,B,C,D};
        double[] XArr = { Ax, Bx, Cx, Dx };
        double[] YArr = { Ay, By, Cy, Dy };

        //存放（E点垂直于x轴的线与四边形的边的焦点）的集合
        List<Double> l = new ArrayList<Double>();

        for(int i=0;i<XArr.length;i++) {
            int j = i+1;

            if(j == XArr.length) {
                j = 0;
            }
            if((Ex <= XArr[i] && Ex >= XArr[j]) || (Ex >= XArr[i] && Ex <= XArr[j])) {
                l.add(Test1.equation(n[i],n[j],Ex));
            }
        }
        //判断是否在四边形内部
        for(int i=0;i<l.size();i++) {
            int j = i+1;
            if(j == l.size()+1) {
                break;
            }
            //说明E点垂直于x轴的线ABCD某个点相交
            if(l.size() == 1) {
                System.out.println("E点在四边形外");
                break;
            }
            if((Ey>l.get(i) && Ey<l.get(j)) || (Ey>l.get(j) && Ey<l.get(i))) {
                System.out.println("E点存在于四边形内");
                break;
            }
            else {
                System.out.println("E点在四边形外");
                break;
            }
        }
    }

    // 求出两点之间的线方程与E点垂直于x轴方程的焦点y
    public static double equation(Node n1, Node n2,double Ex) {
        double k = (n1.getY() - n2.getY())/(n1.getX() - n2.getX());
        double b = n1.getY() - k * n1.getX();
        double y = k * Ex + b;
        System.out.println("k:"+k+" b:"+b+" y:"+y);
        return y;
    }
    //判断是否存在于四边形的值域中
//    public static boolean exist(double XYarr[], double Exy) {
//        double arr[] = XYarr;
//        int j;
//        double temp;
//        double k = Exy;
//        //用冒泡排序对数组排序，方便比较边界大小
//        boolean flag = true;//发生了交换就为true, 没发生就为false，第一次判断时必须标志位true。
//        while (flag){
//            flag=false;//每次开始排序前，都设置flag为未排序过
//            for(j=1; j<k; j++){
//                if(arr[j-1] > arr[j]){//前面的数字大于后面的数字就交换
//                    //交换a[j-1]和a[j]
//                    temp = arr[j-1];
//                    arr[j-1] = arr[j];
//                    arr[j]=temp;
//                    //表示交换过数据;
//                    flag = true;
//                }
//            }
//            k--;//减小一次排序的尾边界
//        }
//        System.out.println("排序完毕");
//        int g =arr.length;
//        while (g-- != 0){
//            System.out.println(arr[g]);
//        }
//        if(Exy > arr[0] && Exy < arr[3])
//            return true;
//        else
//            return false;
//	}
}
class Node{
    private double x;
    private double y;
    public Node() {}
    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Node [x=" + x + ", y=" + y + "]";
    }

}
