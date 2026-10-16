public class Solution2 {

    public int removeElementInplace(int[] arr, int val) {

        if (arr == null || arr.length > 100 || val < 0 || val > 100) {
            return 0;
        }
        for (int x : arr) {
            if (x < 0 || x > 50) {
                return 0;
            }
        }

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