package GUI;

import level.ImageLoader;
import source.Board;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class boardgui extends JPanel implements KeyListener {
    private static int BoardSize;
     int level;
     Board myboard;
     ImageLoader ImgLoad ;
     BufferedImage[] imgset;
     SubImage[] imgComp;
     BufferedImage ImageReference;

    private static int pointer;

    public boardgui(int level) {
        this.level = level;
        BoardSize = level * level;
        pointer = BoardSize - 1;
        this.myboard = new Board(level);
        this.ImgLoad = new ImageLoader(level);
        this.imgset = ImgLoad.GetSetOfImage();
        this.imgComp = new SubImage[BoardSize];
        ImageReference = this.ImgLoad.getImage();
        SetupBoard(level);
    }

    void SetupBoard(int level)
    {
        this.level = level;
        this.setLayout(new GridLayout(level,level));
        this.setPreferredSize(new Dimension(ImgLoad.getImage().getWidth(),ImgLoad.getImage().getHeight()));
        for(int i=0;i<BoardSize;i++)
        {
            imgComp[i] = new SubImage(imgset);
            imgComp[i].SetImage(myboard.getCell(i).getImageId());
            this.add(imgComp[i]);
        }
        this.setBackground(Color.cyan);
        this.addKeyListener(this);

    }

    //-----------------------------------------------------------------//

    public boardgui(String path,int level){
        this.level = level;
        this.ImgLoad = new ImageLoader(path,level);
        this.level = level;
        BoardSize = level * level;
        pointer = BoardSize - 1;
        this.myboard = new Board(level);
        this.imgset = ImgLoad.GetSetOfImage();
        this.imgComp = new SubImage[BoardSize];
        ImageReference = this.ImgLoad.getImage();
        SetupBoard(level);
    }



    public BufferedImage getImage(){
        return ImageReference;
    }

    public int GetLevel(){
        return this.level;
    }

    public void redraw(int index){
        imgComp[index].SetImage(myboard.getCell(index).getImageId());
    }

    boolean isSolve(){
        return myboard.isSolve();
    }

    void Congrat(){
        JOptionPane.showMessageDialog(null,"You are awsome!"+"Step: "+getStepCount(),"Info",JOptionPane.PLAIN_MESSAGE);
        setFocusable(false);
    }

    @Override
    public void addNotify() {
        super.addNotify();requestFocusInWindow();
        //requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {

        if(e.getKeyChar()=='w' && pointer-level>=0)
        {
            int t=pointer-level;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));
            redraw(pointer);
            pointer = t;
            redraw(t);
            if(isSolve()) {
            Congrat();
        }
        }

        else if(e.getKeyChar()=='s' && pointer+level<BoardSize)
        {
            int t=pointer+level;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));
            redraw(pointer);
            pointer = t;
            redraw(t);
            if(isSolve()) {
                Congrat();
            }
        }

        else if(e.getKeyChar()=='a' && (pointer+1)%level!=1)
        {
            int t=pointer-1;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));
            redraw(pointer);
            pointer = t;
            redraw(t);
            if(isSolve()) {
                Congrat();
            }
        }

        else if(e.getKeyChar()=='d' && (pointer+1)%level!=0)
        {
            int t=pointer+1;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));
            redraw(pointer);
            pointer = t;
            redraw(t);
            if(isSolve()) {
                Congrat();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP && pointer-level>=0)
        {
            int t=pointer-level;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));
            redraw(pointer);
            redraw(t);
            pointer = t;
            if(isSolve()) {
                Congrat();
            }
        }
            //redraw();


        else if(e.getKeyCode()==KeyEvent.VK_DOWN && pointer+level<BoardSize)
        {
            int t=pointer+level;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));redraw(pointer);redraw(t);
            pointer = t;
            if(isSolve()) {
                Congrat();
            }
        }

        else if(e.getKeyCode()==KeyEvent.VK_LEFT && (pointer+1)%level!=1)
        {
            int t=pointer-1;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));redraw(pointer);redraw(t);
            pointer = t;
            if(isSolve()) {
                Congrat();
            }
        }

        else if(e.getKeyCode()==KeyEvent.VK_RIGHT && (pointer+1)%level!=0)
        {
            int t=pointer+1;
            myboard.getCell(pointer).swapTo(myboard.getCell(t));redraw(pointer);redraw(t);
            pointer = t;
            if(isSolve()) {
                Congrat();
            }
        }
    }
    public static int getStepCount(){
        return Board.getStepCount();
    }
}
