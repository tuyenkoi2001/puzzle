package GUI;

import data.userData;

import javax.swing.*;
import java.awt.*;

public class Record extends JFrame {
    static String[] topUser;
    static int exist = 0;
    private Record(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(150,200);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(5,1));

        topUser = userData.LoadRecord();
        for(int i=0;i< topUser.length;i++)
            this.add(new JLabel(topUser[i],0));
        exist++;
        this.setFocusable(false);
        //setAutoRequestFocus(true);
        this.setVisible(true);
    }
    public static void getRecord(){
           new Record();
    }
}
