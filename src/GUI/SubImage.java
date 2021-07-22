package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SubImage extends JLabel {
    BufferedImage img;
    ImageIcon[] imgSet; 
    int numberOfImage;
    public SubImage(){

    }

    public SubImage(BufferedImage[] imgSet){
        int numberOfImage = imgSet.length;
        this.imgSet = new ImageIcon[numberOfImage];
        for(int i=0;i<numberOfImage-1;i++)
            this.imgSet[i] = new ImageIcon(imgSet[i]);
        //this.imgSet = imgSet;
    }

    public void SetImage(int index){
            setBackground(Color.red);
            this.setIcon(imgSet[index]);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.img,0,0,this.getWidth(),this.getHeight(),null);
        //System.out.println("ve lai xong");
    }

}

