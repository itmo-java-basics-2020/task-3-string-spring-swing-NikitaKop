package ru.itmo.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0]
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[0];
        }
        int last = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; i--) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = last;
        return inputArray; //your code here
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения из двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }
        int max1 = 0, max2 = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max1) {
                max2 = max1;
                max1 = inputArray[i];
            }
            else if (inputArray[i] > max2) {
                max2 = inputArray[i];
            }
        }
        return max1 * max2; //your code here
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        char[] ch = input.toCharArray(); //преобразование строки в массив символов для возможности сравнения с символами
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 'A' || ch[i] == 'B' || ch[i] == 'a' || ch[i] == 'b') {
                count++;
            }
        }
        return count * 100 / ch.length; //your code here
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палидромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        char[] ch1 = input.toCharArray();
        char[] ch2 = new char[ch1.length];
        for (int i = ch1.length - 1, j = 0; i > -1; i--, j++) {
            ch2[j] = ch1[i];
        }
        if (Arrays.equals(ch1, ch2)) {
            return true;
        }
        return false; //your code here
    }

    /**
     * Напииште функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input == "") {
            return "";
        }
        char[] ch = input.toCharArray();
        int counter = 1;
        String res = "" + ch[0];
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[i - 1]) {
                counter++;
            }
            else {
                res += Integer.toString(counter);
                counter = 1;
                res += ch[i];
            }
        }
        res += Integer.toString(counter);
        return res; //your code here
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || two.length() == 0) {
            return false;
        }
        if (one.length() != two.length()) {
            return false;
        }
        int[] arr1 = new int[127];
        int[] arr2 = new int[127];
        char[] ch1 = one.toCharArray();
        char[] ch2 = two.toCharArray();
        for (int i = 0; i < 127; i++) {
            arr1[i] = 0;
            arr2[i] = 0;
        }
        for (int i = 0; i < ch1.length; i++) {
            arr1[(int) ch1[i]]++;
            arr2[(int) ch2[i]]++;
        }
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        return false;
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int[] arr = new int[127];
        for (int i = 0; i < 127; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            arr[(int) s.charAt(i)]++;
            if (arr[(int) s.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return new int[][]{{}, {}};
        }
        int[][] arr = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                arr[j][i] = m[i][j];
            }
        }
        return arr;
        //throw new UnsupportedOperationException(); // TODO solve
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }
        String sep = Character.toString(separator);
        String str = inputStrings[0];
        for (int i = 1; i < inputStrings.length; i++) {
            str = str.concat(sep);
            str = str.concat(inputStrings[i]);
        }
        return str; // TODO solve
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < inputStrings.length; i++) {
            if (inputStrings[i].startsWith(prefix)) {
                count++;
            }
        }
        return count; // TODO solve
    }
}
