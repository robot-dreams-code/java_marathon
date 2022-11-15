// клас Processor для обрахунку курсу валют
public class Processor {
    public static void process(Currency cur, float value) {
        System.out.println(value + " " + cur.name + " = " + value / cur.usdValue + " USD");
        System.out.println(value + " USD = " + cur.usdValue * value + " " + cur.name);
        }
    }
