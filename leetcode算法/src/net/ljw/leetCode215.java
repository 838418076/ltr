package net.ljw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LIJW
 * @date 2021/4/10 10:00 下午
 *
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class leetCode215 {

    public static int findKthLargest(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int temp;
        //冒泡
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                 temp = 0;
                if (nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
         int sum = 1;

        //输出排序后的数组
        System.out.println(Arrays.toString(nums));

        //按照大小放到数组中
        for (int length = nums.length; length > 0; length--) {
            map.put(sum++,nums[length-1]);
        }
        return map.get(k);
    }

    public static void main(String[] args) {
        int kthLargest = findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(kthLargest);

    }

}
