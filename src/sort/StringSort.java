package sort;

/**
 * @Auther: ys
 * @Date: 2023/5/16 - 05 - 16 - 16:42
 */
public class StringSort {
    public static void main(String[] args) {
        sort("djwaionglncvawi");
    }

    public static void sort(String str){
        char[] chars = str.toCharArray();
        quickSort(chars, 0, chars.length - 1);
        //bubbleSort(chars);
        System.out.println(chars);
    }

    public static void quickSort(char[] chars, int left, int right){
        if(left >= right){
            return;
        }
        char pivot = chars[left];
        boolean isLeft = false;
        int L = left; int R = right;
        while(left < right){
            if(!isLeft){
                if(chars[right] < pivot){
                    chars[left] = chars[right];
                    isLeft = true;
                    left++;
                }else{
                    right--;
                }
            }else{
                if(chars[left] > pivot){
                    chars[right] = chars[left];
                    isLeft = false;
                    right--;
                }else{
                    left++;
                }
            }
        }
        chars[left] = pivot;
        quickSort(chars, L, left - 1);
        quickSort(chars, left + 1, R);
    }

    public static void bubbleSort(char[] chars){
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < chars.length - i; j++) {
                if(chars[j - 1] > chars[j]){
                    char tmp = chars[j];
                    chars[j] = chars[j - 1];
                    chars[j - 1] = tmp;
                }
            }
        }
    }
}
