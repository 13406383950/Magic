/**
*@Project: ${Calculator}
*@Author: Shouxing Li
*@Student_id:1612350208
*@Date: ${2017/11/23}
*/
package com.car.java;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
@SuppressWarnings("serial")//��������
class MyFrame extends JFrame{//������
	public MyFrame(){
		setTitle("������");
		setSize(800, 600);
		setLocationRelativeTo(null);
		add(new Mypanel());//������
		setResizable(false);//���岻�ܵ�����С
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int val = 
					      JOptionPane.showConfirmDialog(MyFrame.this, "�뿪��?");
					    if(val==JOptionPane.YES_OPTION){
					      System.exit(0);//������ǰJava����
					    }
			}
		});
		setVisible(true);
		pack();//���ݼ�������������С
	}
 }
