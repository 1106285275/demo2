package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class StackDemo {
	
	@Test
	public void testDemo(){
		
		int currNum=0;//当前的操作数
		int plusNum=0;//之前的和
		int multiNum=1;//之前的乘积
		int lastOpeaIndex=-1;//最后一个操作符的索引
		
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		if(line !=null && line.length()>0){
			for(int i=0;i<line.length();i++){
				if(line.charAt(i)=='*' || line.charAt(i)=='+'){
					currNum = new Integer(line.substring(lastOpeaIndex+1,i));
					lastOpeaIndex=i;
					multiNum*=currNum;
					if(line.charAt(i)=='*'){
						System.out.println(plusNum+multiNum);
					}
					if(line.charAt(i)=='+'){
						plusNum+=multiNum;
						multiNum = 1;
						System.out.println(plusNum);
					}
					
				}
			}
		}
		currNum = new Integer(line.substring(lastOpeaIndex+1));
		multiNum*=currNum;
		if(lastOpeaIndex!=-1){
			System.out.println(plusNum+multiNum);
		}else{
			System.out.println(currNum);
		}
		
	}
	
	@Test
	public void test2(){
		System.out.println("矩阵的行列数:");
		Scanner sc = new Scanner(System.in);
		Integer num = new Integer(sc.nextLine());
		int a[][] = new int[num][num];
		int currNum=1;
		int timers=0;
		if(num>0){
			timers=num%2 ==0?num/2:num/2+1;
		}
		for(int i=0;i<timers;i++){
			//从左到右
			for(int j=i;j<num-i;j++){
				a[i][j] = currNum++;
			}
			//从上到下
			for(int k=i+1;k<num-i;k++){
				a[k][num-i-1] = currNum++;
			}
			//从右到左
			for(int m=num-i-2;m>=i;m--){
				a[num-i-1][m]=currNum++;
			}
			//从下到上
			for(int n=num-i-2;n>i;n--){
				a[n][i]=currNum++;
			}
		}
		// 输出数组
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void testDemo52(){
		String strIn = "";
		System.out.print("请输入矩阵的行列数:");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(input);
		try {
			strIn = buff.readLine();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		int int1 = Integer.parseInt(strIn);
		int n = int1;
		System.out.println("这是行列数为" + n + "的螺线型数组:");
		int intA = 1; // 初始化
		int[][] array = new int[n][n];
		int intB;
		if (n % 2 != 0) {
			intB = n / 2 + 1; // 奇数时i循环次数
		} else
			intB = n / 2; // 偶数时i循环次数
		for (int i = 0; i < intB; i++) { // 从外到里循环
			// 从左到右横的开始
			for (int j = i; j < n - i; j++) {
				array[i][j] = intA;
				intA++;
			}
			// 从上到下纵
			for (int k = i + 1; k < n - i; k++) {
				array[k][n - i - 1] = intA;
				intA++;
			}
			// 从右到左横
			for (int l = n - i - 2; l >= i; l--) {
				array[n - i - 1][l] = intA;
				intA++;
			}
			// 从下到上纵
			for (int m = n - i - 2; m > i; m--) {
				array[m][i] = intA;
				intA++;
			}
		}
		// 输出数组
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	
	}
	
	public static void main(String[] args) {
		//输入字符串
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		//之前乘法的乘积
		int multiNum = 1;
		//当前的操作数
		int currentNum = 0;
		//最后一个+号左面的值
		int plusNum = 0;
		//最后一次操作数的位置
		int lastOperIndex = -1;
		
		if(line!=null && line.length()>0){
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(line.charAt(i)=='+'||line.charAt(i)=='*'){
					currentNum = new Integer(line.substring(lastOperIndex+1, i));
					lastOperIndex = i;
					multiNum*=currentNum;
					
					if(line.charAt(i)=='+'){
						//如果为+，将multiNum的值计入加法，置空
						plusNum += multiNum;
						multiNum = 1;
						System.out.println(plusNum);
					}
					
					//如果为*操作，输出当前结果,继续循环
					if(line.charAt(i)=='*'){						
						System.out.println(multiNum+plusNum);
					}

				}
			}
			currentNum =  new Integer(line.substring(lastOperIndex+1));
			multiNum *= currentNum;
			if (lastOperIndex!=-1) {
				System.out.println(multiNum + plusNum);
			}else{
				System.out.println(currentNum);
			}
		}
	}
	
	

}

