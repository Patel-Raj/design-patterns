package creational.abstractfactory.products;

public class LinearSearch implements Searcher {
    @Override
    public int search(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }
}
