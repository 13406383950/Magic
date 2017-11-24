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
@SuppressWarnings("serial")//消除警告
class MyFrame extends JFrame{//主窗口
	public MyFrame(){
		setTitle("计算器");
		setSize(800, 600);
		setLocationRelativeTo(null);
		add(new Mypanel());//添加面板
		setResizable(false);//窗体不能调整大小
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int val = 
					      JOptionPane.showConfirmDialog(MyFrame.this, "离开吗?");
					    if(val==JOptionPane.YES_OPTION){
					      System.exit(0);//结束当前Java进程
					    }
			}
		});
		setVisible(true);
		pack();//根据计算器面板调整大小
	}
 }
