package org.r_d;

// клас Processor для обрахунку курсу валют
public class Processor {

    public static Currency newCurrency(String name, float usdValue){
        Currency currency = new Currency();
        currency.name = name;
        currency.usdValue = usdValue;
        return currency;
    }

    public static String calculateCurrency(Currency cur, float value) {
        return (value + " " + cur.name + " = " + value / cur.usdValue + " USD \n" + value + " USD = " + cur.usdValue * value + " " + cur.name);
        }

    public static Currency processCur(int choice) {
        Currency cur0 = newCurrency("UAH", 36.92F);
        Currency cur1 = newCurrency("EUR", 1.01F);
        Currency cur2 = newCurrency("GBP", 0.88F);

            // Опрацьовуємо вибір курсу валют USD
            if (choice == 1)
                return cur0;
            else if (choice == 2)
            return cur1;
            else if (choice == 3)
                return cur2;
            else
                return null;
    }
}
