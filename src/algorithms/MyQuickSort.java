package algorithms;

public class MyQuickSort {
    public static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int mid = partition(a, left, right);
        quickSort(a, left, mid - 1);
        quickSort(a, mid + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[left];// 取区间一(left)为pivot,left空
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];// 取right填left,right空
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];// 取left填right,left空
            a[left] = pivot;// pivot回填
        }
        return left;
    }
}
