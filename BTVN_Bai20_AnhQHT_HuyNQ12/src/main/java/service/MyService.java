package service;

public class MyService {
    public float[] calculate(int a, int b, int c){
        if(a == 0){
            if(b == 0){
                System.out.println("Day khong phai phuong trinh!!!");
                return null;
            } else {
                float x = (float) -c/b;
                return new float[]{x};
            }
        } else {
            float delta = b*b - 4*a*c;
            if(delta > 0){
                float x1 = (float) ((-b + Math.sqrt(delta))/(2*a));
                float x2 = (float) ((-b - Math.sqrt(delta))/(2*a));
                return new float[]{x1, x2};
            }else if (delta == 0){
                float x0 = (float) -b/2/a;
                return new float[]{x0};
            }else {
                return null;
            }
        }
    }
}
