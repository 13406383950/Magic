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
class Buttonpanel extends JPanel{//��ť���
	String str1 = "0";// ������1��Ϊ�˳���İ�ȫ����ֵһ�����ã�������������Ϊ0�� 
	String str2 = "0";// ������2 
	String signal = "+";// �����
	String result = "";// ������
	String result3 = "";//M�ļĴ�ռ�

	// ����k1��k2Ϊ״̬����
	int k1 = 1;// ����1����ѡ�����뷽�򣬽�Ҫд��str1��str2
	int k2 = 1;// ����2���ڼ�¼���ż��Ĵ�������� k2>1 ˵�����е��� 2+3-9+8 �����Ķ��������
	int k3 = 1;// ����3���ڱ�ʶ str1 �Ƿ���Ա���0 ������1ʱ���ԣ�������1ʱ���ܱ���0
	int k4 = 1;// ����4���ڱ�ʶ str2 �Ƿ���Ա���0
	int k5 = 1;// ����5���ڿ���С����ɷ�¼�룬����1ʱ���ԣ���Ϊ1ʱ�������С���㱻����
	int k6 = 1;// ����6���ڿ��ưٷֺſɷ�¼�룬����1ʱ���ԣ���Ϊ1ʱ������İٷֺű�����
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
		jButton.setPreferredSize(new Dimension(90, 50));//���ð�ť��С
		jButton.setContentAreaFilled(false);//��ť����Ϊ͸��
		jButton.setBorder(BorderFactory.createRaisedBevelBorder());//��ť͹��
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
	class Listener implements ActionListener  {// �������ֵĴ���
		public void actionPerformed(ActionEvent e) {
			String ss = ((JButton) e.getSource()).getText();

			if (k1 == 1) {//����д��str1��str2
				if (k3 == 1) {//str1���Ա�����
					str1 = "";//str1����
					k5 = 1;//����¼��С����
				}
				str1 = str1 + ss;//str1��ֵ
				k3 = k3 + 1;//str1���� ������
				Mypanel.jTextArea.setText(str1);//�ı�����ʾstr1
				}
			else if (k1 == 2) {//д��str2
				if (k4 == 1) {//str2���Ա�����
					str2 = "";//str2����
					k5 = 1; //����¼��С����
				}
				str2 = str2 + ss;//str2��ֵ
				k4 = k4 + 1;//str1���� ������
				Mypanel.jTextArea.setText(str2);//�ı�����ʾstr2
			}

		}
	}
	class Listener_clear  implements ActionListener {// ��������߼���Clear��
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

	class Listener_signal implements ActionListener {// �����������ŵĴ���
		public void actionPerformed(ActionEvent e) {
			String ss2 = ((JButton) e.getSource()).getText();

			if (k2 == 1) {// ���� k1 Ϊ 1 ʱ���� 1 д����ֵ��Ϊ2ʱ����2д����ֵ��
				k1 = 2;
				k3 = 1;
				k5 = 1;
				k6 = 1;
				signal = ss2;
				k2 = k2 + 1;// �����ż��Ĵ���
				Mypanel.jTextArea.setText(signal);
			} 
			else {
					new Cal();
					str1 = result;
					// ���� k1 Ϊ 1 ʱ������ 1 дֵ��Ϊ2ʱ����2д
					k1 = 2;
					k5 = 1;//����д��С����
					k4 = 1;//str2��������
					k6 = 1;
					signal = ss2;
				
				k2 = k2 + 1;

			}

		}
	}
	class Listener_xiaos  implements ActionListener {// С����Ĵ���
		public void actionPerformed(ActionEvent e) {		
			if (k5 == 1) {
				String ss2 = ((JButton) e.getSource()).getText();
				if (k1 == 1) {
					if (k3 == 1) {
						str1 = "";
						// ��ԭ����k5״̬
						k5 = 1; 
					}
					str1 = str1 + ss2;

					k3 = k3 + 1;

	                // ��ʾ���
					Mypanel.jTextArea.setText(str1);

				} else if (k1 == 2) {
					if (k4 == 1) {
						str2 = "";
						// ��ԭ����k5��״̬
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
	class Listener_percent implements ActionListener{//�ٷֺŵ��߼�
		public void actionPerformed(ActionEvent e) {

			if (k6 == 1) {
				@SuppressWarnings("unused")
				String ss2 = ((JButton) e.getSource()).getText();
				if (k1 == 1) {
					if (k3 == 1) {
						str1 = "";
						// ��ԭ����k5״̬
						k5 = 1; 
					}
					double st1;
					st1 =Double.valueOf(str1).doubleValue();
					st1=st1*0.01;
					str1=String.valueOf(st1);
					k3 = k3 + 1;

	                // ��ʾ���
					Mypanel.jTextArea.setText(str1);
					

				} else if (k1 == 2) {
					if (k4 == 1) {
						str2 = "";
						// ��ԭ����k5��״̬
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
	class Listener_m  implements ActionListener{//M���߼�
		public void actionPerformed(ActionEvent e) {
			
			 
			 if (k1 == 1) {
				 str1 = result3;
				 k1+=1;
				 k3 = k3 + 1;//str1���� ������
					Mypanel.jTextArea.setText(str1);//�ı�����ʾstr1
					}
				
			 if (k1 == 2) {
				
				 str2 = result3;
				 k4 = k4 + 1;//str1���� ������
					Mypanel.jTextArea.setText(str2);//�ı�����ʾstr2
			 	}
		}}

	class Listener_dy implements ActionListener {// ���ڼ����߼�
		public void actionPerformed(ActionEvent e) {
			new Cal();
			
			// ��ԭ�������ص�״̬
			k1 = 1; 
			k2 = 1;
			k3 = 1;
			k4 = 1;
			k6 = 1;

			str1 = result; 
		}
	}
	class Listener_ce implements ActionListener{//ce���߼�
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
	class  Cal {//�߼�����
		{
			
		double a2;// ������1
		double b2;// ������2
		String c = signal;// �����
		double result2 = 0;// ������
		
		if (c.equals("")) {
			Mypanel.jTextArea.setText("Please input operator");
		}
		else {
	        // �ֶ�����С���������
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
	 
	
