package sort;

import java.util.Arrays;

/**
 * @Auther: ys
 * @Date: 2023/3/21 - 03 - 21 - 18:12
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void heapSort(int[] nums){
        for (int i = (nums.length - 1 - 1) / 2; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }
    // n:数组长度 i:将维护节点的下标
    public static void heapify(int[] nums, int n, int i){
        int largest = i;
        int lson = i * 2 + 1;
        int rson = i * 2 + 2;
        if(lson < n && nums[largest] < nums[lson]){
            largest = lson;
        }
        if(rson < n && nums[largest] < nums[rson]){
            largest = rson;
        }
        if(largest != i){
            swap(nums, largest, i);
            heapify(nums, n, largest);
        }
    }
    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
