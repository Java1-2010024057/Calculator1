package Calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame implements ActionListener
{
	private Container con;
	private FlowLayout fl = new FlowLayout();
	private JButton back,clear;
	private JButton[] n, f;
	private Box totalbox;
	private JTextField resultField,resultField2;
	private String op, oper;
	
	public Calculator()
	{
		super("Calculator");
		this.init();
		this.setSize(480,270);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void init()
	{
		con = this.getContentPane();
		con.setLayout(fl);
		con.setBackground(Color.BLACK);
		// 결과창
		JPanel resultPanel = new JPanel();
		resultField = new JTextField(40);
		resultField.setBackground(Color.black);
		resultField.setHorizontalAlignment(JTextField.RIGHT);
		resultField.setEnabled(false);
		resultField.setForeground(Color.red);
		
		resultField2 = new JTextField(40);
		resultField2.setBackground(Color.black);
		resultField2.setHorizontalAlignment(JTextField.RIGHT);
		resultField2.setEnabled(false);
		resultField2.setForeground(Color.red);
		
		JPanel resultPanelLine = new JPanel(new BorderLayout());
		resultPanelLine.setBackground(Color.black);
		resultPanelLine.add(resultField,BorderLayout.SOUTH);
		resultPanelLine.add(resultField2,BorderLayout.NORTH);
		//백스페이스
		
		back=new JButton("Backspace");
		clear=new JButton("C");
		JPanel erasePanel = new JPanel();
		back.setForeground(Color.lightGray);
		back.setBackground(Color.black);
		clear.setForeground(Color.lightGray);
		clear.setBackground(Color.black);
		erasePanel.setBackground(Color.black);
		erasePanel.setLayout(new GridLayout(0,2,5,0));
		erasePanel.add(back);
  
		erasePanel.add(clear);
   
		JPanel erasePanelLine = new JPanel(new BorderLayout());
		erasePanelLine.add(erasePanel,BorderLayout.CENTER);
  	
		//버튼
  
		n=new JButton[10];
		f=new JButton[10];
		n[0]=new JButton("0");
		n[1]=new JButton("1");
		n[2]=new JButton("2");
		n[3]=new JButton("3");
		n[4]=new JButton("4");
		n[5]=new JButton("5");
		n[6]=new JButton("6");
		n[7]=new JButton("7");
		n[8]=new JButton("8");
		n[9]=new JButton("9");
		f[0]=new JButton("+/-");
		f[1]=new JButton(".");
		f[2]=new JButton("+");
		f[3]=new JButton("=");
		f[4]=new JButton("-");
		f[5]=new JButton("sqrt");
		f[6]=new JButton("*");
		f[7]=new JButton("x^2");
		f[8]=new JButton("/");
		f[9]=new JButton("1/X");
		back.addActionListener(this);
		clear.addActionListener(this);
		for (int i=0; i<10; i++)
		{
			n[i].addActionListener(this);
			f[i].addActionListener(this);
			n[i].setForeground(Color.LIGHT_GRAY);
			f[i].setForeground(Color.LIGHT_GRAY);
			n[i].setBackground(Color.black);
			f[i].setBackground(Color.black);
		}

		JPanel calc1Panel = new JPanel();
		calc1Panel.setBackground(Color.black);
		calc1Panel.setLayout(new GridLayout(0,5,5,0));
		calc1Panel.add(n[7]);
		calc1Panel.add(n[8]);
		calc1Panel.add(n[9]);
		calc1Panel.add(f[8]);
		calc1Panel.add(f[9]);
  
		JPanel calc2Panel = new JPanel();
		calc2Panel.setBackground(Color.black);
		calc2Panel.setLayout(new GridLayout(0,5,5,0));
		calc2Panel.add(n[4]);
		calc2Panel.add(n[5]);
		calc2Panel.add(n[6]);
		calc2Panel.add(f[6]);
		calc2Panel.add(f[7]);
    
    
		JPanel calc3Panel = new JPanel();
		calc3Panel.setBackground(Color.black);
		calc3Panel.setLayout(new GridLayout(0,5,5,0));
		calc3Panel.add(n[1]);
		calc3Panel.add(n[2]);
		calc3Panel.add(n[3]);
		calc3Panel.add(f[4]);
		calc3Panel.add(f[5]);
  
		JPanel calc4Panel = new JPanel();
		calc4Panel.setBackground(Color.black);
		calc4Panel.setLayout(new GridLayout(0,5,5,0));
		calc4Panel.add(f[0]);
		calc4Panel.add(n[0]);
		calc4Panel.add(f[1]);
		calc4Panel.add(f[2]);
		calc4Panel.add(f[3]);
  
		JPanel calcPanelLine = new JPanel(new GridLayout(4,0,0,5));
		calcPanelLine.setBackground(Color.black);
		calcPanelLine.add(calc1Panel);
		calcPanelLine.add(calc2Panel);
		calcPanelLine.add(calc3Panel);
		calcPanelLine.add(calc4Panel);
  
  
		totalbox = Box.createVerticalBox();
		totalbox.add(resultPanelLine);
		totalbox.add(Box.createVerticalStrut(3));
		totalbox.add(erasePanelLine);
		totalbox.add(Box.createVerticalStrut(3));
		totalbox.add(calcPanelLine);
		totalbox.add(Box.createVerticalStrut(3));
		con.add(totalbox);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		String ans = resultField.getText();
		String ans2 = resultField2.getText();
		double result;
		
		if(str =="0" || str =="1" || str == "2"|| str== "3" ||
				str == "4"|| str == "5" || str == "6" || str == "7"|| str == "8" || str == "9" || str =="."){
		 resultField.setText(ans + str);
		 resultField2.setText(ans2 + str);
		}
		if(str == "+" || str == "-" || str == "*" || str == "/")
		{
			oper = ans;
			op = str;
			resultField.setText("");
			resultField2.setText(ans2 + str);
		}
		if(str == "x^2"){
			resultField.setText(""+Double.parseDouble(ans)*Double.parseDouble(ans));
			resultField2.setText(ans2 + "^2");
		}
		if(str == "sqrt")
		{
			resultField.setText(""+Math.sqrt(Double.parseDouble(ans)));
			resultField2.setText(ans2 + "^1/2");
		}
		if(str == "1/X")
		{
			resultField.setText(""+1/(Double.parseDouble(ans)));
			resultField2.setText("1/(" + ans2 + ")");
		}
		if(str=="+/-")
		{
			resultField.setText(""+-1*(Double.parseDouble(ans)));
			resultField.setText("-1*("+ans2+")");
		}

		if(str=="=")
		{
			char c=op.charAt(0);
			switch(c)
			{
			case '+':
				result=Double.parseDouble(oper) + Double.parseDouble(ans);
				resultField.setText(""+result);
				
				break;
			case '-':
				result=Double.parseDouble(oper) - Double.parseDouble(ans);
				resultField.setText(""+result);
			
				break;
			case '*':
				result=Double.parseDouble(oper) * Double.parseDouble(ans);
				resultField.setText(""+result);
			
				break;
			case '/':
				result=Double.parseDouble(oper) / Double.parseDouble(ans);
				resultField.setText(""+result);

				break;
			}
		}
		
		if(str == "C")
		{
			resultField.setText("");
			resultField2.setText("");
		}
		
		if(str == "Backspace")
		{
			String temp=resultField.getText();
			temp=temp.substring(0,temp.length()-1);
			resultField.setText(temp);
			String temp2=resultField2.getText();
			temp2 = temp2.substring(0,temp2.length()-1);
			resultField2.setText(temp2);
			
		}

	}

	
		
	
	public static void main(String args[])
	{
		new Calculator();
	}
}