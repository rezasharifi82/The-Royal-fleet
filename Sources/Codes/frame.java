import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class frame implements ActionListener  {

  JFrame my;
  ImageIcon image = new ImageIcon("mainpage.jpg");
    ImageIcon image1 = new ImageIcon("frameicon.jpg");
    ImageIcon sIcon = new ImageIcon("start.png");

    JButton start = new JButton();
    JLabel main_photo = new JLabel();
    JLabel text = new JLabel();
    JLabel sign = new JLabel();
    Font font, sizedFont, font1, sized;

    JButton Single_plyer=new JButton("Single Player");
  public frame() {
    start.setBounds(100, 320, 330, 120);
    start.setIcon(sIcon);
    start.addActionListener(this);
    sign.setText("Dev:Sharifi.Mohammadreza");
    try {
      //Returned font is of pt size 1
      font = Font.createFont(Font.TRUETYPE_FONT, new File("reza.ttf"));
      sizedFont = font.deriveFont(74f);
      text.setFont(sizedFont);
      font1 = Font.createFont(Font.TRUETYPE_FONT, new File("f1.ttf"));
      sized = font1.deriveFont(50f);
      sign.setFont(sized);
    } catch (IOException | FontFormatException e) {}

    text.setOpaque(true);
    text.setBackground(new Color(223, 223, 223));
    text.setText(" The Royal Fleet");
    //////////////////////////////////////////////////////
    
////////////////////////
    text.setForeground(new Color(85, 4, 4));
    text.setBounds(30, 30, 510, 140);
    sign.setBounds(30, 610, 510, 140);
    sign.setForeground(new Color(6, 13, 110));

    main_photo.setIcon(image);
    main_photo.add(text);
    main_photo.add(sign);
    my = new JFrame("The Royal Fleet");
    my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    my.setSize(1300, 800);
    my.setResizable(false);
    my.setIconImage(image1.getImage());
    my.setVisible(true);
    my.add(start);
    my.add(main_photo);
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==start){
      new menu();
      my.dispose();
      


    
    }
  }


}
