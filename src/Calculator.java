import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String calc = calc(input);
        System.out.println(calc);
    }

    public static String calc(String input) throws Exception {
        int num1;
        int num2;
        String znak;
        boolean rimOrNot;
        String result;

        String[] word = input.split("[+\\-*/]");

        if (word.length != 2) {
            throw new Exception("������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
        }

        if (Rim.rimOrNot(word[0]) && Rim.rimOrNot(word[1])) {
            num1 = Rim.romanToInt(word[0]);
            num2 = Rim.romanToInt(word[1]);
            rimOrNot = true;
        } else if (!Rim.rimOrNot(word[0]) && !Rim.rimOrNot(word[1])) {
            num1 = Integer.parseInt(word[0]);
            num2 = Integer.parseInt(word[1]);
            rimOrNot = false;
        } else {
            throw new Exception("������������ ������������ ������ ������� ���������");
        }

        if (num1 > 10 || num2 > 10) {
            throw new Exception("����������� ������ ��������� �� ���� ����� �� 1 �� 10 ������������, �� �����");
        }

        int arab = calcs(num1, num2, matOper(input));

        if (rimOrNot) {
            if (arab <= 0) {
                throw new Exception("� ������� ������� ��� ������������� �����");
            }
            result = Rim.arabToRim(arab);
        } else {
            result = String.valueOf(arab);
        }
        return result;
    }
    static String matOper(String operand2) {
        if (operand2.contains("+")) return "+";
        else if (operand2.contains("-")) return "-";
        else if (operand2.contains("*")) return "*";
        else if (operand2.contains("/")) return "/";
        return operand2;
    }

    static int calcs(int num1, int num2, String oper) {
        switch (oper) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    public static void celoe (String input) throws Exception {
        char[] chars = input.toCharArray();

        for (char c : chars) {
            if (!Character.isDigit(c)) {
                throw new Exception("����������� ����� �������� ������ � ������ �������.");
            }
        }
    }
}

class Rim {
    static String[] arrRoman = new String[]

    {
            ":)", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII","XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI","XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV","LV", "LVI","LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
            "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV","LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX","XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    public static boolean rimOrNot(String str) {
        for (int i = 0; i < arrRoman.length; i++) {
            if (str.equals(arrRoman[i])) {
                return true;
            }
        }
        return false;
    }

    public static int romanToInt(String Rim) {
        for (int i = 0; i < arrRoman.length; i++) {
            if (Rim.equals(arrRoman[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String arabToRim(int arab) {
        return arrRoman[arab];
    }
}


