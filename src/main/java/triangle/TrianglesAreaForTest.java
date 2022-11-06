package triangle;

public class TrianglesAreaForTest{

    public static void main( String[] args ) throws Exception {
        double a;

        a = triangleArea(5, 7, 8);
        System.out.println("A triangle with sides 3,3,3 has an area of:" + a);


    }

    public static double triangleArea( int a, int b, int c ) throws Exception {
            if (a <= 0 || b <= 0 || c <= 0 ) {
                throw new Exception("Side length < 0");// исключение для теста
        }

        double pp = (a + b + c) / 2.0;  // полупериметр
        return Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c)); // формула Герона
    }
}
