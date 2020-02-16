import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class Calc {
    private static String [] myOperators = {"+", "-", "*", "/"};
    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 101; i++) {
//            IntToString ITS = new IntToString(i);
//            System.out.println(i + " : " + ITS.toString());
//            exit(1);
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int position=0; //номер позиции оператора
        String oper = ""; //Действие {"+", "-", "*", "/"}
        for (String c:myOperators
             ) {
            if (s.contains(c)) {
                if (oper != "") {
                    //Если уже был один из операторов
                    throw new Exception("Два оператора в выражении!"); //Два оператора в выражении - ошибка
                }
                position = s.indexOf(c);
                oper = c;
            }
        }

        if (oper == "") {
            //Если нет ни одного из операторов
            throw new Exception("Ни одного оператора в выражении!"); //Ни одного оператора в выражении - ошибка
        }

        String s1 = s.substring(0,position).trim();
        String s2 = s.substring(position + 1).trim();

        System.out.println(calculate(s1,s2,oper));
        br.close();
    }

    private static String calculate(String s1, String s2, String operator) throws Exception {
        int i1 = 0, i2 = 0;
        int result;
        boolean isArabic = false;
        try {
            i1 = Integer.parseInt(s1);
            i2 = Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            try {
                StringToInt STI = new StringToInt();
                i1 = STI.toInt(s1);
                i2 = STI.toInt(s2);
                isArabic = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                exit(1);
            }
        }

        if (i1 > 10 || i2 > 10 || i1 < 1 || i2 < 1) {
            throw new Exception("Обрабатываем числа от 1 до 10!"); //Вне диапазона - ошибка
        }
        switch (operator) {
            case "+":
                result = i1 + i2;
                break;
            case "-":
                result = i1 - i2;
                break;
            case "*":
                result = i1 * i2;
                break;
            default:
                result = i1 / i2;
        }
        if (isArabic) {
            IntToString ITS = new IntToString(result);
            return ITS.toString();
        } else {
            return String.valueOf(result);
        }

    }
}
