import java.util.Scanner;

// основний клас програми
public class Main {

    // метод для створення нової валюти
    public static Currency newCurrency(String name, float usdValue){
        Currency currency = new Currency();
        currency.name = name;
        currency.usdValue = usdValue;
        return currency;
    }

    public static void main(String[] args) {
        // Вводимо значення актуального курсу валют в USD
        Currency cur0 = newCurrency("UAH", 36.92F);
        Currency cur1 = newCurrency("EUR", 1.01F);
        Currency cur2 = newCurrency("GBP", 0.88F);

        // Обираємо курс валют для конвертації за допомогою консольного вводу
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть валюту для конвертації в USD 1 - UAH, 2 - EUR, 3 - GBP:");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.println("Введіть суму для конвертації:");
        float value = Float.parseFloat(scanner.nextLine());

        // Опрацьовуємо вибір курсу валют USD
        // і викликаємо процесор із правильними параметрами
        if (choice == 1)
            Processor.process(cur0, value);
        else if (choice == 2)
            Processor.process(cur1, value);
        else
            Processor.process(cur2, value);
    }
}