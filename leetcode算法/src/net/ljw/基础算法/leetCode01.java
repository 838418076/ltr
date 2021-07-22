package net.ljw.基础算法;


import java.util.Arrays;

/**
 * @author LIJW
 * @date 2021/7/10 8:52 下午
 * 删除排序数组中的重复项
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class leetCode01 {


    /**
     * 直接就可以想到的思路：
     * 利用双指针 - -
     * 如果右指针指向的值等于左指针指向的值，左指针不动。
     * 如果右指针指向的值不等于左指针指向的值，那么左指针往右移一步，然后再把右指针指向的值赋给左指针。
     */
    public int removeDuplicates(int[] A){
        if (A == null || A.length == 0){
            return 0;
        }

        int left = 0;
        for (int rigth = 1; rigth < A.length; rigth++) {
            if (A[left] != A[rigth]){
                A[++left] = A[rigth];
            }
        }

        return ++left;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        int sum = new leetCode01().removeDuplicates(a);

        /**
         * 创建一个新数组来存放不需要删除的数据
         */
        int[] b = new int[sum];
        for (int i = 0; i < sum; i++) {
            b[i] = a[i];
        }
        System.out.println(Arrays.toString(b)+"新数组的长度为:"+sum);
    }
}
