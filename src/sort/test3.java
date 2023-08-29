package sort;

import java.util.Arrays;

/**
 * @Auther: ys
 * @Date: 2023/4/28 - 04 - 28 - 20:18
 */
public class test3 {
    public static void main(String[] args) {
        int[] nums = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        //quickSort(nums, 0, nums.length - 1);
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = nums[left];
        int L = left;int R = right;
        boolean compareLeft = false;
        while(left < right){
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

    public static void heapSort(int[] nums){
        create(nums);
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - 1 - i);
            heapify(nums, nums.length - 1 - i, 0);
        }
    }


    public static void create(int[] nums){
        for (int i = nums.length; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
    }

    public static void heapify(int[] nums, int len, int pos){
        int largest = pos;
        int lson = 2 * pos + 1;
        int rson = 2 * pos + 2;
        if(lson < len && nums[lson] > nums[largest]){
            largest = lson;
        }
        if(rson < len && nums[rson] > nums[largest]){
            largest = rson;
        }
        if(largest != pos){
            swap(nums, largest, pos);
            heapify(nums, len, largest);//这边出错
        }
    }

    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
