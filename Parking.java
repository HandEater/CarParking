package day11;

/*
    1.初始化停车场
    2.运行：开始后就不停了（循环）
    3.看一下有没有地方
    4.看一下车有没有已经在里面了（在的话就不给他进了）
    5.进车
    6.出车
    7.交钱
    8.刷新车位数量
 */

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import day09.Car;

public class Parking {

    static int i = 5;
    static Car[] Parking = new Car[i];
    static boolean isOut(String CarNo){
        Car c = new Car(CarNo);
        boolean b = false;
        for (int j = 0; j < Parking.length; j++){
            b = c.equals(Parking[j]);
            if (b){
                c = Parking[j];
                c.GetOut();
                System.out.println(c);
                Parking[j] = null;
                return true;

            }
        }

    return false;
    }


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("请选择你的操作：1.入场；2.出场；3.退出程序");
            int Action = s.nextInt();
            switch(Action){
                case 1:
                   if(i>0){
                       System.out.println("请输入你的车牌：");
                       String CarNo = s.next();
                       boolean check = false;
                       Car c = new Car(CarNo);
                       boolean b = false;
                       for (int j = 0; j < Parking.length; j++) {
                           b = c.equals(Parking[j]);
                           if (b) {
                               check = false;
                               break;
                           }
                       }
                       for (int j = 0; j < Parking.length && !b; j++){
                           if(Parking[j] == null) {
                               Parking[j] = c;
                               check = true;
                               break;
                           }
                       }
                       if(check){
                           i = i-1;
                           System.out.println(CarNo+"Successfully enter, good job");
                       }else{
                           System.out.println("OH, sth wrong happens.");
                       }

                       break;
                   }
                   else{
                       System.out.println("Already full, pls find another place");
                       break;
                   }

                case 2:
                    if(i>0 && i<=5){
                        System.out.println("Pls insert your CarNo:");
                        String CarNo = s.next();
                        boolean b = isOut(CarNo);
                        if(b){
                            i = i+1;
                            System.out.println("Successfully exit, see you next time");
                        }else{
                            System.out.println("OH, sth wrong happens.");
                        }
                    }

                    break;
                case 3:
                    if(i != 5){
                        System.out.println("Car is still inside, you can't do that.");
                        break;
                    }else{System.out.println(" ");
                    return;
                    }
                default:
                    System.out.println("wrong number");
                    break;
                }
            System.out.println(Arrays.toString(Parking));
            }

        }
    }

