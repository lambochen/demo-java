package cn.lambochen.demo.spock;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/10
 * @description TODO
 **/
public class BinarySearch {

    /**
     * 二分搜索的非递归版本： 在给定有序数组中查找给定的键值
     * 前提条件： 数组必须有序， 即满足： A[0] <= A[1] <= ... <= A[n-1]
     *
     * @param arr 给定有序数组
     * @param key 给定键值
     * @return 如果查找成功，则返回键值在数组中的下标位置，否则，返回 -1.
     */
    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) {
                high = mid - 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
