package adt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    static Pattern tuplePattern = Pattern.compile("(\\d+(,\\d+)*)");

    public static int[][] strTo2DArray(String s) {
        List<int[]> list = new ArrayList<>();
        Matcher matcher = tuplePattern.matcher(s);
        while (matcher.find()) {
            String[] arr = matcher.group().split(",");
            int[] ints = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                ints[i] = Integer.parseInt(arr[i]);
            }
            list.add(ints);
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static String arrayToStr(int[][] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] item : array) {
            sb.append('[');
            for (int n : item) {
                sb.append(n).append(',');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(']').append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static int[] strToArray(String s) {
        s = s.substring(1, s.length()-1);
        String[] arr = s.split(",");
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i].trim());
        }
        return result;
    }

    public static boolean arrayEquals(int[][] a, int[][] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean listEqual(List<T> list, String expected) {
        StringBuilder sb = new StringBuilder("[");
        list.forEach(t->sb.append(t).append(","));
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString().equals(expected);
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d+(,\\d+)*)");
        String s = "[[1,2,3,4],[5,6,7,8],[9,10,11,12]]";
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
