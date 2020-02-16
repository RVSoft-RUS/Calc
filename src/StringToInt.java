public class StringToInt {
    public int toInt(String str) throws Exception {
            return toArabic(str);
    }

    public static int toArabic(String number) throws Exception {
        if (number.length() == 0) return 0;
        if (number.startsWith("X")) return 10 + toArabic(number.substring(1));
        if (number.startsWith("IX")) return 9 + toArabic(number.substring(2));
        if (number.startsWith("V")) return 5 + toArabic(number.substring(1));
        if (number.startsWith("IV")) return 4 + toArabic(number.substring(2));
        if (number.startsWith("I")) return 1 + toArabic(number.substring(1));
        throw new Exception("Неизвестные символы!"); //Неизвестные символы - ошибка
    }
}
