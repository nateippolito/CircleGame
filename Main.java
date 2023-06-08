import javax.swing.*;
import java.io.*;
public class Main
{
public static void main(String[] args)
{
  int w = 500;
	int h = 500;
		
JFrame frame = new JFrame("Circle Game - Project by Nate Ippolito");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().add(new Panel(w,h));
frame.pack();
frame.setVisible(true);
frame.setResizable(true);
}
}
