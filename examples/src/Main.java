import com.canbaylan.searchAlgorithm.Search;
import com.canbaylan.sortAlgorithm.Sort;

public class Main {
    public static void main(String[] args) {
        Search search = new Search();
        Sort sort = new Sort();
        int[] arr = {1,2,5,3,11,66,44};
        sort.quickSort(arr,0,arr.length-1);
        for(int i:arr)
            System.out.print(i+",");
    }

}