public class IntToString {
    int myInt;

    public IntToString(int value) {
        myInt = value;
    }

    @Override
    public String toString() {
        int num = myInt;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num == 49 || num == 99) {
                sb.append("I");
                num += 1;
            }
            if (num >= 100) {
                sb.append("C");
                num -= 100;
                continue;
            }
            if (num >= 90) {
                sb.append("XC");
                num -= 90;
                continue;
            }
            if (num >= 50) {
                sb.append("L");
                num -= 50;
                continue;
            }
            if (num >= 40) {
                sb.append("XL");
                num -= 40;
                continue;
            }
            if (num >= 10) {
                sb.append("X");
                num -= 10;
                continue;
            }
            if (num >= 9) {
                sb.append("IX");
                num -= 9;
                continue;
            }

            if (num >= 5) {
                sb.append("V");
                num -= 5;
                continue;
            }
            if (num >= 4) {
                sb.append("IV");
                num -= 4;
                continue;
            }
            if (num >= 1) {
                sb.append("I");
                num -= 1;
            }

        }
        return sb.toString();
    }
}