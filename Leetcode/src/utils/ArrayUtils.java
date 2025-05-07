package utils;

public class ArrayUtils {


    public static  int[] createArrayOne(String str) {
        str = str.substring(1, str.length() - 1);
        String[] split = str.split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) array[i] = Integer.parseInt(split[i]);
        return array;
    }

    public static  int[][] createArrayTwo(String str) {
        str = str.substring(1, str.length() - 2);
        String[] split = str.split("],");
        int[][] array = new int[split.length][];
        for (int i = 0; i < split.length; i++) array[i] = createArrayOne(split[i] + "]");
        return array;
    }

}
