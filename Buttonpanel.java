/**
*@Project: ${Calculator}
*@Author: Shouxing Li
*@Student_id:1612350208
*@Date: ${2017/11/23}
*/
package com.car.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;



@SuppressWarnings("serial")
class Buttonpanel extends JPanel{//按钮面板
	String str1 = "0";// 操作数1，为了程序的安全，初值一定设置，这里我们设置为0。 
	String str2 = "0";// 操作数2 
	String signal = "+";// 运算符
	String result = "";// 运算结果
	String result3 = "";//M的寄存空间

	// 以下k1至k2为状态开关
	int k1 = 1;// 开关1用于选择输入方向，将要写入str1或str2
	int k2 = 1;// 开关2用于记录符号键的次数，如果 k2>1 说明进行的是 2+3-9+8 这样的多符号运算
	int k3 = 1;// 开关3用于标识 str1 是否可以被清0 ，等于1时可以，不等于1时不能被清0
	int k4 = 1;// 开关4用于标识 str2 是否可以被清0
	int k5 = 1;// 开关5用于控制小数点可否被录入，等于1时可以，不为1时，输入的小数点被丢掉
	int k6 = 1;// 开关6用于控制百分号可否被录入，等于1时可以，不为1时，输入的百分号被丢掉
	public Buttonpanel(){
		
		setLayout(new GridLayout(5,5,5,5));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 5));
		Listener listener = new Listener();
		Listener_clear listener_clear = new Listener_clear();
		Listener_signal listener_signal=new Listener_signal();
		Listener_xiaos listener_xiaos=new Listener_xiaos();
		Listener_dy listener_dy=new Listener_dy();
		Listener_ce listener_ce=new Listener_ce();
		Listener_percent listener_percent = new Listener_percent();
		Listener_m listener_m=new Listener_m();
		addButton("M", listener_m);
		addButton("CE", listener_ce);
		addButton("C", listener_clear);
		addButton("/", listener_signal);
		
		addButton("7",listener);	
		addButton("8",listener);	
		addButton("9",listener);	
		addButton("*", listener_signal);
		
		addButton("4",listener);	
		addButton("5",listener);	
		addButton("6",listener);	
		addButton("-", listener_signal);
		
		addButton("1",listener);
		addButton("2",listener);
		addButton("3",listener);	
		addButton("+", listener_signal);
		
		addButton(".",listener_xiaos);
		addButton("0",listener);	
		addButton("%", listener_percent);
		addButton("=", listener_dy);	
		
	}
	public  void addButton(String label,ActionListener listener) {
		JButton jButton=new JButton(label);
		jButton.setPreferredSize(new Dimension(90, 50));//设置按钮大小
		jButton.setContentAreaFilled(false);//按钮设置为透明
		jButton.setBorder(BorderFactory.createRaisedBevelBorder());//按钮凸起
		jButton.setFont(new Font("SansSerif",1,30));
		jButton.setBackground(Color.blue);
		jButton.addActionListener(listener);
		if (label =="+"||label =="-"||label =="*"||label =="/"||label =="CE"||label =="C"||label =="M"||label =="="){
			jButton.setForeground(Color.red);
			}
		else{
			jButton.setForeground(Color.blue);
			}
		this.add(jButton);
	}	
	class Listener implements ActionListener  {// 输入数字的处理
		public void actionPerformed(ActionEvent e) {
			String ss = ((JButton) e.getSource()).getText();

			if (k1 == 1) {//可以写入str1或str2
				if (k3 == 1) {//str1可以被清零
					str1 = "";//str1清零
					k5 = 1;//可以录入小数点
				}
				str1 = str1 + ss;//str1赋值
				k3 = k3 + 1;//str1不可 被清零
				Mypanel.jTextArea.setText(str1);//文本框显示str1
				}
			else if (k1 == 2) {//写入str2
				if (k4 == 1) {//str2可以被清零
					str2 = "";//str2清零
					k5 = 1; //可以录入小数点
				}
				str2 = str2 + ss;//str2赋值
				k4 = k4 + 1;//str1不可 被清零
				Mypanel.jTextArea.setText(str2);//文本框显示str2
			}

		}
	}
	class Listener_clear  implements ActionListener {// 清除键的逻辑（Clear）
		public void actionPerformed(ActionEvent e) {

			k5 = 1;
			k2 = 1;
			k1 = 1;
			k3 = 1;
			k4 = 1;
			k6 = 1;
			str1 = "0";
			str2 = "0";
			signal = "";
			result = "0";
			result3 = "0";
			Mypanel.jTextArea.setText(result);
		}
	}

	class Listener_signal implements ActionListener {// 输入的运算符号的处理
		public void actionPerformed(ActionEvent e) {
			String ss2 = ((JButton) e.getSource()).getText();

			if (k2 == 1) {// 开关 k1 为 1 时向数 1 写输入值，为2时向数2写输入值。
				k1 = 2;
				k3 = 1;
				k5 = 1;
				k6 = 1;
				signal = ss2;
				k2 = k2 + 1;// 按符号键的次数
				Mypanel.jTextArea.setText(signal);
			} 
			else {
					new Cal();
					str1 = result;
					// 开关 k1 为 1 时，向数 1 写值，为2时向数2写
					k1 = 2;
					k5 = 1;//可以写入小数点
					k4 = 1;//str2可以清零
					k6 = 1;
					signal = ss2;
				
				k2 = k2 + 1;

			}

		}
	}
	class Listener_xiaos  implements ActionListener {// 小数点的处理
		public void actionPerformed(ActionEvent e) {		
			if (k5 == 1) {
				String ss2 = ((JButton) e.getSource()).getText();
				if (k1 == 1) {
					if (k3 == 1) {
						str1 = "";
						// 还原开关k5状态
						k5 = 1; 
					}
					str1 = str1 + ss2;

					k3 = k3 + 1;

	                // 显示结果
					Mypanel.jTextArea.setText(str1);

				} else if (k1 == 2) {
					if (k4 == 1) {
						str2 = "";
						// 还原开关k5的状态
						k5 = 1;
					}
					str2 = str2 + ss2;

					k4 = k4 + 1;

					Mypanel.jTextArea.setText(str2);
				}
			}
			
			

			k5 +=1;
			
		}
	}
	class Listener_percent implements ActionListener{//百分号的逻辑
		public void actionPerformed(ActionEvent e) {

			if (k6 == 1) {
				@SuppressWarnings("unused")
				String ss2 = ((JButton) e.getSource()).getText();
				if (k1 == 1) {
					if (k3 == 1) {
						str1 = "";
						// 还原开关k5状态
						k5 = 1; 
					}
					double st1;
					st1 =Double.valueOf(str1).doubleValue();
					st1=st1*0.01;
					str1=String.valueOf(st1);
					k3 = k3 + 1;

	                // 显示结果
					Mypanel.jTextArea.setText(str1);
					

				} else if (k1 == 2) {
					if (k4 == 1) {
						str2 = "";
						// 还原开关k5的状态
						k5 = 1;
					}
					double st2;
					st2 =Double.valueOf(str2).doubleValue();
					st2=st2*0.01;
					str2=String.valueOf(st2);

					k4 = k4 + 1;

					Mypanel.jTextArea.setText(str2);
					
				}
			}

			k6 = k6 + 1;
			k5 = k5 + 1;
		}

	}
	class Listener_m  implements ActionListener{//M的逻辑
		public void actionPerformed(ActionEvent e) {
			
			 
			 if (k1 == 1) {
				 str1 = result3;
				 k1+=1;
				 k3 = k3 + 1;//str1不可 被清零
					Mypanel.jTextArea.setText(str1);//文本框显示str1
					}
				
			 if (k1 == 2) {
				
				 str2 = result3;
				 k4 = k4 + 1;//str1不可 被清零
					Mypanel.jTextArea.setText(str2);//文本框显示str2
			 	}
		}}

	class Listener_dy implements ActionListener {// 等于键的逻辑
		public void actionPerformed(ActionEvent e) {
			new Cal();
			
			// 还原各个开关的状态
			k1 = 1; 
			k2 = 1;
			k3 = 1;
			k4 = 1;
			k6 = 1;

			str1 = result; 
		}
	}
	class Listener_ce implements ActionListener{//ce的逻辑
		public void actionPerformed(ActionEvent e) {

			if (k3!=1) {
				str1="0";
				Mypanel.jTextArea.setText(str1);
				k1 = 1;
				k3 = 1;
				
			}
			else if (k4!=1) {
				str2="0";
				Mypanel.jTextArea.setText(str2);
				k1 = 2;
				k4 = 1;
			}
		}
		
	}
	class  Cal {//逻辑运算
		{
			
		double a2;// 操作数1
		double b2;// 操作数2
		String c = signal;// 运算符
		double result2 = 0;// 运算结果
		
		if (c.equals("")) {
			Mypanel.jTextArea.setText("Please input operator");
		}
		else {
	        // 手动处理小数点的问题
			if (str1.equals("."))
				str1 = "0.0";
			if (str2.equals("."))
				str2 = "0.0";
			if (str1.equals("%"))
				str1 = "0.0";
			if (str2.equals("%"))
				str2 = "0.0";
			a2 = Double.valueOf(str1).doubleValue();
			b2 = Double.valueOf(str2).doubleValue();

			if (c.equals("+")) {
				result2 = a2 + b2;
				
			}
			if (c.equals("-")) {
				result2 = a2 - b2;
			}
			
			if (c.equals("*")) {
				BigDecimal m1 = new BigDecimal(Double.toString(a2));
			        BigDecimal m2 = new BigDecimal(Double.toString(b2));
			        result2 = m1.multiply(m2).doubleValue();
			}
			if (c.equals("/")) {
				if (b2 == 0) {
					result2 = 0;
				} 
				else{
					result2 = a2 / b2;
				}
			}
			
			
		}
		if (k6 !=1 ) {
			int dou =(int) (result2*100);
			
			result=((String.valueOf(dou))+"%");
		}
		else if(k5!=1){
			result = ((new Double(result2)).toString());
		}
		else {
			int dou =(int)result2;
			result=(String.valueOf(dou));
		}
		result3=result;
		Mypanel.jTextArea.setText(result);
	}}

}
	 
	
