public class Solution2 {

    public int removeElementInplace(int[] arr, int val) {

        int k = 0; // позиция куда положить следующий норм элемент

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[k] = arr[i];
                k++;
            }

        }

        return k; // нью длина массива
    }

}