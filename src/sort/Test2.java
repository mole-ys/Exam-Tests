package sort;

import java.security.Key;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: ys
 * @Date: 2023/3/15 - 03 - 15 - 18:57
 */
public class Test2 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,3,0,9,1,2,2};
        //quickSort(nums, 0, nums.length - 1);
        //insertSort(nums);
        //bubbleSort();
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(){
        int[] nums = {3,2,1,3,0,9,1,2,2};
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            flag = false;
            for (int j = 1; j < nums.length - i; j++) {
                if(nums[j - 1] > nums[j]){
                    swap(nums, j - 1, j);
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = nums[left];
        int L = left; int R = right;
        boolean compareLeft = false;
        while (left < right){
            if(!compareLeft){
                if(nums[right] < pivot){
                    nums[left] = nums[right];
                    left++;
                    compareLeft = true;
                }else{
                    right--;
                }
            }else{
                if(nums[left] > pivot){
                    nums[right] = nums[left];
                    right--;
                    compareLeft = false;
                }else {
                    left++;
                }
            }
        }
        nums[left] = pivot;
        quickSort(nums, L, left - 1);
        quickSort(nums, left + 1, R);
    }

    public static void insertSort(int[] nums){
        int val;
        for (int i = 0; i < nums.length - 1; i++) {
            val = nums[i + 1];
            int j = i;
            for (; j >= 0; j--) {
                if(nums[j] > val){
                    nums[j + 1] = nums[j];
                }else{
                    break;
                }
            }
            nums[j + 1] = val;
        }
    }

    public static void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1];
        int count = 0;
        int L = left;int R = mid + 1;
        while (L <= mid && R <= right){
            if(nums[L] <= nums[R]){
                tmp[count++] = nums[L++];
            }else {
                tmp[count++] = nums[R++];
            }
        }
        while (L <= mid){
            tmp[count++] = nums[L++];
        }
        while (R <= right){
            tmp[count++] = nums[R++];
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[left + i] = tmp[i];
        }
    }

    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void heapSort(int[] nums){
        for (int i = nums.length - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    public static void heapify(int[] nums, int n, int i){
        int lson = 2 * i + 1;
        int rson = 2 * i + 2;
        int large = i;
        if(lson < n && nums[lson] > nums[large]){
            large = lson;
            //swap(nums, i, lson);
        }
        if(rson < n && nums[rson] > nums[large]){
            large = rson;
        }
        if(large != i){
            swap(nums, i, large);
            heapify(nums, n, large);
        }

    }
}
