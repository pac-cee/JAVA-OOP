import java.util.ArrayList;
import java.util.List;

public class WildcardDemo {
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("B");

        System.out.print("Integer List: ");
        printList(intList);
        System.out.print("String List: ");
        printList(strList);
    }
}
