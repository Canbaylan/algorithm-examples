import com.canbaylan.searchAlgorithm.Search;

public class Main {
    public static void main(String[] args) {
        Search search = new Search();
        int[] arr = {1,2,5,6,11,44};
        System.out.println(search.binarySearch(arr,3));
    }
}