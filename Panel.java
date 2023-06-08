import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
public class Panel extends JPanel{
  private int w,h;
  public Color ab;
  //timer stuff
Color myColor=new Color(0,0,0);
  Timer timer;
  // int delay = 1000; //milliseconds
  boolean menu = true;
  boolean play = false;
  boolean end=false;
  ;
  JLabel menuScreen=new JLabel("Circle Clicking Game");
  JLabel menuScreen2=new JLabel("By Nate Ippolito");
  JLabel menuScreen3=new JLabel("Press anywhere to start!");
  JLabel endScreen=new JLabel("");
  int x,y;
  int counter;
  public Panel(int w, int h){
    this.w=w;
    this.h=h;
    this.setPreferredSize(new Dimension(w,h));
    this.setBackground(Color.white);
    
    this.addMouseListener(new PointListener());
    timer = new Timer(1000, new taskPerformer());
    x=0;
    y=0;
    if(menu==true){
       Box box = Box.createVerticalBox();
      endScreen.setFont(new Font("", Font.PLAIN, 20));
add(endScreen);
add(box);
  menuScreen.setFont(new Font("", Font.PLAIN, 20));
      menuScreen2.setFont(new Font("", Font.PLAIN, 20));
      menuScreen3.setFont(new Font("", Font.PLAIN, 20));
      box.setLocation(20,20);
box.add(menuScreen);
      
      box.add(menuScreen2);
      
      box.add(menuScreen3);
    }
    genPts();
  }
  
   public void paintComponent(Graphics g)
  {
    
super.paintComponent(g);

    if(menu==false){
      menuScreen.setVisible(false);
      menuScreen2.setVisible(false);
      menuScreen3.setVisible(false);
    }
    if(end!=true&&menu==false){
    g.setColor(myColor);
    g.fillOval(x,y,30,30);
      
      this.add(menuScreen2);
      this.add(menuScreen3);
    }
    repaint();
  }
  public void genPts(){
    Random rand=new Random();
         x=rand.nextInt(470);
         y=rand.nextInt(470);
  }
  public void ranCol(){
     Random rand=new Random();
    int col1=rand.nextInt(255);
    int col2=rand.nextInt(255);
    int col3=rand.nextInt(255);
    
    myColor=new Color(col1,col2,col3);
  }
  private class PointListener implements MouseListener{
    public void mouseClicked(MouseEvent e){
    if(menu==true&&e.getPoint().getX()>0&&e.getPoint().getY()>0){
      menu=false;
      play=true;
      timer.start();
    }
        
    
      

      if(e.getPoint().getX()>x&&e.getPoint().getX()<x+30){
        
        if(e.getPoint().getY()>y&&e.getPoint().getY()<y+30){
        ranCol();
        genPts();
        counter++;}
      }
  }
    public void mouseReleased(MouseEvent e){
    
  }
  public void mousePressed(MouseEvent e){
    
  }
    public void mouseEntered(MouseEvent e){
      
    }
    public void mouseExited(MouseEvent e){
      
    }
  }
  public class taskPerformer implements  ActionListener {
    public int time=0;
      public void actionPerformed(ActionEvent evt) {
        time++;
          System.out.println(time);

        if(time==30){
          timer.stop();
          play=false;
          end=true;
          if(end==true){
            endScreen.setText("Game over. You clicked "+counter+" circles.");
            endScreen.setVisible(true);
      
    }
        }
      }
  };
  
}
