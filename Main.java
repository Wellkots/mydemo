import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение ");
        System.out.println(calc(""));
    }
    static boolean arabic_number = true;
    static String calc(String input) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabic = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        Scanner scanner = new Scanner(System.in);
        String[] operand = scanner.nextLine().split(" ");
        if (operand.length<=2){
            try{
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Строка не является математической операцией. Попытайтесь снова.");;
                operand = scanner.nextLine().split(" ");
            }
        }
        if (operand.length>3){
            try{
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *). Попытайтесь снова.");;
                operand = scanner.nextLine().split(" ");
            }
        }
        char operation = operand[1].charAt(0);
        List<String> Listroman = new ArrayList<>(Arrays.asList(roman));
        List<String> Listarabic = new ArrayList<>(Arrays.asList(arabic));
        if ((Listarabic.contains(operand[0])) && Listarabic.contains(operand[2])) {
            int n1 = Integer.parseInt(operand[0]);
            int n2 = Integer.parseInt(operand[2]);
            int calc2 = calc1(n1, n2, operation);
            input = Integer.toString(calc2);
        }
        else if ((Listroman.contains(operand[0])) && Listroman.contains(operand[2])){
            arabic_number = false;
                int n1 = romanToNumber(operand[0]);
                int n2 = romanToNumber(operand[2]);
                int calc1 = calc1(n1, n2, operation);
                input = numberToRoman(calc1);
        }
        else if ((Listroman.contains(operand[0])) && Listarabic.contains(operand[2]) || (Listarabic.contains(operand[0])) && Listroman.contains(operand[2])) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Используются одновременно 2 системы исчисления");
            }
        }else{
            System.out.println("Введите число от 0 до 10 или до X. Попытайтесь снова");
        }
         return input;
    }
    static int calc1(int n1, int n2, char operation) throws IllegalArgumentException{
        int result = 0;
                switch (operation) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                try {
                    result = n1 / n2;
                } catch (Exception e) {
                    System.out.println("На 0 делить нельзя");
                }
                default:
                    throw new IllegalArgumentException("Неверный знак операции");
                }
        return result;
    }
    private static int romanToNumber(String roman) {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
                        }
        return 0;
        }
    private static String numberToRoman(int num){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
       try{ return roman[num];
    } catch (Exception e) {
           System.out.println("В римской системе нет отрицательных чисел");;
       }
        return "";
    }
}




