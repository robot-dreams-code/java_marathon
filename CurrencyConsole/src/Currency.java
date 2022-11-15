import java.util.Scanner;

// клас який описує валюту і її еквівалент в USD
public class Currency {
    String name;
    float usdValue;

    public void currencyOutput() {
        System.out.println("1 USD = " + usdValue + " " + name);
    }
    public void currencyInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву нової валюти:");
        name = String.format (scanner.nextLine());
        System.out.println("Введіть вартість 1 USD в " + name + ":");
        usdValue = Float.parseFloat(scanner.nextLine());
    }
}