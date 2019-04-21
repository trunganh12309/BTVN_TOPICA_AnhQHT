import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 10000; i++){
            test.add(random.nextInt(10000));
        }
        System.out.print("Day so la: ");
        test.forEach(p -> System.out.print(p+" "));

        Optional<Integer> min = test.stream().min(Comparator.comparing(integer -> integer));

        System.out.println("\nMin la: "+min.get());

        Optional<Integer> max = test.stream().max(Comparator.comparing(integer -> integer));

        System.out.println("Max la: "+max.get());

        Optional<Integer> sum = test.stream().reduce((a,b) -> a+b);

        System.out.println("Tong la: "+sum.get());

        long evenNumberCount = test.stream().filter(x -> x%2==0).count();

        System.out.println("So so chan la: "+evenNumberCount);

        long oddNumberCount = test.stream().filter(x -> x%2!=0).count();
        System.out.println("So so le la: "+oddNumberCount);

        System.out.print("Cac so chan la: ");
        test.stream().filter(x -> x%2==0).forEach(e -> System.out.print(e+ " "));

        Optional<Integer> squaredSum = test.parallelStream().map(a -> a*a).reduce((a,b) -> a+b);
        System.out.println("\nTong binh phuong cac so la: "+squaredSum.get());
    }
}
