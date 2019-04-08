public class Main {

    public static class Employee implements Comparable<Employee>{
        private int id;
        private String name;
        private int age;
        private int salary;

        public Employee(int id, String name, int age, int salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        //Ta co the dinh nghia cach so sanh 2 doi tuong Employee
        //Cu the o day la so sanh tien luong
        @Override
        public int compareTo(Employee o) {
            return this.salary - o.salary;
        }
    }

    public static void main(String[] args) {
        Employee a = new Employee(1, "Nguyen Van A", 20, 10);
        Employee b = new Employee(2, "Nguyen Van B", 22, 20);
        if(a.compareTo(b) == 0){
            System.out.println("Lương anh a bằng lương anh b");
        } else if (a.compareTo(b) > 0){
            System.out.println("Lương anh a cao hơn lương anh b");
        } else if (a.compareTo(b) < 0){
            System.out.println("Lương anh a thấp hơn lương anh b");
        }

    }
}
