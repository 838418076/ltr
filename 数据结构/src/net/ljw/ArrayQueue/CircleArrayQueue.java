package net.ljw.ArrayQueue;

import java.util.Scanner;

/**
 * @author LIJW
 * @date 2021/4/19 5:39 下午
 * 数组模拟环形队列
 */
public class CircleArrayQueue {


    public static void main(String[] args) {
        System.out.println(0%3);
        System.out.println(1%3); //0       1
        System.out.println(2%3);  //1  头  2
        System.out.println(3%3);  //2      0
        System.out.println(5%3);
        //创建一个队列
        CircleArray queue = new CircleArray(3);
        char key  = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查队列头的数据");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
//                        int res = queue.headQueue();
//                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~~~");
    }




}


class CircleArray{

    private int maxSize;  //表示数组队最大容量

    private int front;  //队列头

    private int rear;   //队列尾

    private int[] arr;  //该数组用存放数据，模拟队列


    /**
     * 创建队列的构造器
     */
    public CircleArray(int arrMaxSize){
        this.maxSize = arrMaxSize;
        //创建数组
        this.arr = new int[arrMaxSize];
    }


    /**
     * 判断队列是否满
     */
    public boolean isFull(){
        //如果下一个位置取模等于front（头元素）则满
        //当输入最后一个时，会判断为满
        return (rear+1)%maxSize == front;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     * 添加数据到队列
     */
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移,得到下一个rear，这里必须考虑取模
        rear = (rear+1)%maxSize;
    }

    /**
     * 获取队列的数据 ，出队列
     */
    public int getQueue(){
        //判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //需要分析出front是指向队列的第一个元素
        //1。先把front对应的值保留到一个临时变量
        //2。将front后移，考虑取模
        //3。将临时保存到变量返回
        System.out.println(front);
        int value = arr[front];
        //获取下一个数
        front = (front+1)%maxSize;
        return value;
    }

    /**
     * 显示队列到所有数据
     */
    public void showQueue(){

        //遍历
        if (isEmpty()){
            System.out.println("队列空到，没有数据");
            return;
        }

        //从front开始遍历，遍历多个元素
        for (int i = front;i<front+size();i++){
            System.out.println(size());
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    /**
     * 求当前队列到有效数据的个数
     * @return
     */
    private int size() {
       //arr[1]=2
        //arr[2]=3
        //front=1 rear=3  因为rear为的时候，在存完后都想后移动一位
        return (rear +maxSize-front)%maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("队列空的，没有数据");
        }
        return arr[front];
    }
}