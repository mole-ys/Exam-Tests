package sort;

import exam.LRUCache;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: ys
 * @Date: 2023/3/7 - 03 - 07 - 15:32
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        //quickSort(nums, 0, nums.length - 1);
        //mergeSort(nums, 0, nums.length - 1);
        //selectSort(nums);
        //insertSort(nums);
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }


    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int pos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < min){
                    min = nums[j];
                    pos = j;
                }
            }
            swap(nums, i, pos);
        }
    }

    public static void bubbleSort(int[] nums){
        for (int i = nums.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if(nums[j] < nums[j - 1]){
                    swap(nums, j, j - 1);
                }
            }
        }
    }
    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        random(nums, left, right);
        int pivot = nums[left];
        boolean compareLeft = false;
        int L = left;int R = right;
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

    public static void random(int[] nums, int left, int right){
        Random random = new Random();
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, left, i);
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
}
