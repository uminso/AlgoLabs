import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {

        if (students == null || students.size() < 2) {
            return;
        }

        Comparator<Student> ageComparator =
                (a, b) -> Integer.compare(a.getAge(), b.getAge());

        mergeSort(students, 0, students.size() - 1, ageComparator);

        Comparator<Student> nameComparator =
                (a, b) -> a.getName().compareTo(b.getName());

        mergeSort(students, 0, students.size() - 1, nameComparator);
    }

    private void mergeSort(
            List<Student> students,
            int left,
            int right,
            Comparator<Student> comparator) {

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(students, left, middle, comparator);
        mergeSort(students, middle + 1, right, comparator);
        merge(students, left, middle, right, comparator);
    }

    private void merge(
            List<Student> students,
            int left,
            int middle,
            int right,
            Comparator<Student> comparator) {

        List<Student> temp = new ArrayList<>();

        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {

            if (comparator.compare(students.get(i), students.get(j)) <= 0) {
                temp.add(students.get(i));
                i++;
            } else {
                temp.add(students.get(j));
                j++;
            }
        }

        while (i <= middle) {
            temp.add(students.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(students.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            students.set(left + k, temp.get(k));
        }
    }

}
