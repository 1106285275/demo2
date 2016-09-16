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
		
		int currNum=0;//��ǰ�Ĳ�����
		int plusNum=0;//֮ǰ�ĺ�
		int multiNum=1;//֮ǰ�ĳ˻�
		int lastOpeaIndex=-1;//���һ��������������
		
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
		System.out.println("�����������:");
		Scanner sc = new Scanner(System.in);
		Integer num = new Integer(sc.nextLine());
		int a[][] = new int[num][num];
		int currNum=1;
		int timers=0;
		if(num>0){
			timers=num%2 ==0?num/2:num/2+1;
		}
		for(int i=0;i<timers;i++){
			//������
			for(int j=i;j<num-i;j++){
				a[i][j] = currNum++;
			}
			//���ϵ���
			for(int k=i+1;k<num-i;k++){
				a[k][num-i-1] = currNum++;
			}
			//���ҵ���
			for(int m=num-i-2;m>=i;m--){
				a[num-i-1][m]=currNum++;
			}
			//���µ���
			for(int n=num-i-2;n>i;n--){
				a[n][i]=currNum++;
			}
		}
		// �������
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
		System.out.print("����������������:");
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(input);
		try {
			strIn = buff.readLine();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		int int1 = Integer.parseInt(strIn);
		int n = int1;
		System.out.println("����������Ϊ" + n + "������������:");
		int intA = 1; // ��ʼ��
		int[][] array = new int[n][n];
		int intB;
		if (n % 2 != 0) {
			intB = n / 2 + 1; // ����ʱiѭ������
		} else
			intB = n / 2; // ż��ʱiѭ������
		for (int i = 0; i < intB; i++) { // ���⵽��ѭ��
			// �����Һ�Ŀ�ʼ
			for (int j = i; j < n - i; j++) {
				array[i][j] = intA;
				intA++;
			}
			// ���ϵ�����
			for (int k = i + 1; k < n - i; k++) {
				array[k][n - i - 1] = intA;
				intA++;
			}
			// ���ҵ����
			for (int l = n - i - 2; l >= i; l--) {
				array[n - i - 1][l] = intA;
				intA++;
			}
			// ���µ�����
			for (int m = n - i - 2; m > i; m--) {
				array[m][i] = intA;
				intA++;
			}
		}
		// �������
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	
	}
	
	public static void main(String[] args) {
		//�����ַ���
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		//֮ǰ�˷��ĳ˻�
		int multiNum = 1;
		//��ǰ�Ĳ�����
		int currentNum = 0;
		//���һ��+�������ֵ
		int plusNum = 0;
		//���һ�β�������λ��
		int lastOperIndex = -1;
		
		if(line!=null && line.length()>0){
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(line.charAt(i)=='+'||line.charAt(i)=='*'){
					currentNum = new Integer(line.substring(lastOperIndex+1, i));
					lastOperIndex = i;
					multiNum*=currentNum;
					
					if(line.charAt(i)=='+'){
						//���Ϊ+����multiNum��ֵ����ӷ����ÿ�
						plusNum += multiNum;
						multiNum = 1;
						System.out.println(plusNum);
					}
					
					//���Ϊ*�����������ǰ���,����ѭ��
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

