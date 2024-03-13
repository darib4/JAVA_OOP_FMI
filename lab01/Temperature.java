import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

    //a)
        System.out.printf("Enter fahrenheit: ");
        double fahrenheit = input.nextDouble();
        double celsius = 5.0 / 9.0 * (fahrenheit - 32);

        //1st variant
        System.out.printf("Celsius: %.2f", celsius);

        //2nd variant
        String message = String.format("Celsius: %.2f", celsius);
        System.out.println(message);

        //3rd variant
        String message = FMT."Celsius %.2f\{celsius}";
        System.out.println(message);

    //b)
//        System.out.printf("Enter celsius: ");
//        double celsius = input.nextDouble();
//        double fahrenheit = 9.0 / 5.0 * celsius + 32;
//
//
//        String message = FMT."Celsius %.2f\{fahrenheit}";
//        System.out.println(message);

    }
}
