import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class RadixSort implements Sorting<BigInteger> {

    @Override
    public void sort(List<BigInteger> nums) {

        for (int pos = 19; pos >= 0; pos--) {

            List<List<BigInteger>> buckets = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }

            for (BigInteger num : nums) {
                String s = num.toString();

                int digit = s.charAt(pos) - '0';

                buckets.get(digit).add(num);
            }

            nums.clear();

            for (int i = 0; i < 10; i++) {
                nums.addAll(buckets.get(i));
            }
        }
    }
}