import java.util.Arrays;
class SortAnArray {
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei){
            return;
        }

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];

        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= ei){
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[si + x] = temp[x];
        }
    }
    public static void main(String[] args) {
     int[] arr = {6, 3, 9, 5, 2, 8};
     mergeSort(arr, 0, arr.length - 1);
     System.out.println(Arrays.toString(arr));
    }
}