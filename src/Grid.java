import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JPanel;


public class Grid extends JPanel {
 Integer size;
 Cell[][] cells;


 public Grid() {
   setPreferredSize(new Dimension(720, 720));
  
   this.size = 20;
   this.cells = new Cell[size][size];


 }


 @Override
 public void paint(Graphics g) {
   g.setColor(java.awt.Color.BLACK);
   g.drawRect(10, 10, 700, 700);


   int x = size;
   while(x-->0){
     int y= size;
     while(y-->0){
       this.cells[x][y] = new Cell(10+(35*x), 10+(35*y));
       this.cells[x][y].paint(g);
     }
   }
  
 }


 }

