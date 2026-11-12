import java.util.List;
import java.util.Comparator;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {

        if (students.size() < 2) {
            return;
        }

        Student[] temp = new Student[students.size()];

        Comparator<Student> ageComparator =
                (a, b) -> Integer.compare(a.getAge(), b.getAge());

        mergeSort(students, temp, 0,
                students.size() - 1, ageComparator);

        Comparator<Student> nameComparator =
                (a, b) -> a.getName().compareTo(b.getName());

        mergeSort(students, temp, 0,
                students.size() - 1, nameComparator);
    }

    private void mergeSort(
            List<Student> students,
            Student[] temp,
            int left,
            int right,
            Comparator<Student> comparator) {

        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(students, temp, left, middle, comparator);
        mergeSort(students, temp, middle + 1, right, comparator);
        merge(students, temp, left, middle, right, comparator);
    }

    private void merge(
            List<Student> students,
            Student[] temp,
            int left,
            int middle,
            int right,
            Comparator<Student> comparator) {

        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {

            if (comparator.compare(
                    students.get(i),
                    students.get(j)) <= 0) {

                temp[k] = students.get(i);
                i++;

            } else {

                temp[k] = students.get(j);
                j++;
            }

            k++;
        }

        while (i <= middle) {
            temp[k] = students.get(i);
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = students.get(j);
            j++;
            k++;
        }

        for (int index = left; index <= right; index++) {
            students.set(index, temp[index]);
        }
    }
}
