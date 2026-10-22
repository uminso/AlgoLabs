import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов: ");
        int N = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < N; i++) {
            nums.add(scanner.nextInt());
        }

        Sorting<Integer> sorter = new InsertionSort();
        sorter.sort(nums);

        System.out.println("Отсортированный список: " + nums);

        scanner.close();

    }

}
