import java.util.ArrayList;

public class orderArray {

    public static ArrayList<Integer> miArrayList(ArrayList<Integer> list) {
        ArrayList<Integer> cloned = new ArrayList<>();
        cloned.addAll(list);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (Integer integer : cloned) {
            if (integer < min) {
                min = integer;
            }
            if (integer > max) {
                max = integer;
            }
        }
        ArrayList<Integer> minMax = new ArrayList<>();
        minMax.add(min);
        minMax.add(max);
        return minMax;
    }

    public static void main(String[] args) {
        ArrayList<Integer> orderlist = new ArrayList<>();
        orderlist.add(-1);
        orderlist.add(-2);
        orderlist.add(-1);
        orderlist.add(-2);

        System.out.println(miArrayList(orderlist));
    }
}
