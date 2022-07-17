package com.liang.data.leetcode.hash;

import java.util.HashSet;

/**
 * @author liangyt
 * 模拟行走机器人
 *
机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：

-2 ：向左转 90 度
-1 ：向右转 90 度
1 <= x <= 9 ：向前移动 x 个单位长度
在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。

机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。

返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 * @create 2022-06-26 21:22
 */
public class robotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        //存储北东南西四个方向，机器人走一步的坐标变化，顺时针顺序存储
        int[] dx = {0 , 1 , 0 , -1};
        int[] dy = {1 , 0 , -1 , 0};

        //初始化坐标
        int x = 0; int y = 0;  int di = 0;
        //set集合作为对障碍物位置的存储，判断行动是否受阻
        //二维数组转一维
        HashSet<Long> obstacleSet  = new HashSet<>();
        for (int[] obstacle : obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }
        int ans = 0;
        for (int command : commands) {
            if (command == -2){
                //左转一次相当于右转三次
                di = (di + 3) % 4;
            }else if (command == -1){
                //右转一次
                di = (di + 1) % 4;

            }else {
                //计算下一步的坐标
                for (int k = 0; k < command; k++) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                //计算此处下一步移动点是否是障碍物，不是则计算最大欧式距离的平方
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)){
                        x = nx;
                        y = ny;
                        ans = Math.max(ans,x*x + y*y);
                    }
                    
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        robotSim robotSim = new robotSim();
        int[] commands ={4,-1,4,-2,4}; int[][] obstacles ={{2,4}};
        int i = robotSim.robotSim(commands, obstacles);
        System.out.println(i);
    }
}
