/**
*@Project: ${Calculator}
*@Author: Shouxing Li
*@Student_id:1612350208
*@Date: ${2017/11/23}
*/
package com.car.java;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
class Mypanel extends JPanel{//系统的主面板
	public static JTextArea jTextArea=new JTextArea(1,10); 
	public Mypanel(){
		setLayout(new BorderLayout());		
		jTextArea.setFont(new Font("SansSerif", Font.PLAIN, 50));
		Buttonpanel btnpanel=new Buttonpanel();
		add(jTextArea, BorderLayout.NORTH);
		add(btnpanel,BorderLayout.CENTER);
	}
}
