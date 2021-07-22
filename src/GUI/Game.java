package GUI;

import data.userData;
import source.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Game implements ActionListener {
    static boardgui board; //= new boardgui(3);
    static Image guideImg; 
    static JLabel guidLabel = new JLabel(); 
    static JFrame frame = new JFrame("Puzzle");
    JPanel SelectPanel; 
    JScrollPane scrollPane = new JScrollPane();
    JRadioButton level3;
    JRadioButton level5;
    JRadioButton level7;
    JButton recordButton = new JButton("Record"); 
    JButton savedButton = new JButton("Save"); 
    JButton resetButton = new JButton("Reset"); // nut reset
    JButton ImageSelect = new JButton("Select");
    Timer timer = new Timer(200,new updateStepCount());
    static JLabel StepCounter = new JLabel();

    static boolean allowedToSave;
    static JTextField userName = new JTextField(15);

    public Game(){
        timer.start();
        Init();
    }

    void Init(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        scrollPane.setPreferredSize(new Dimension(200,500));
        SelectPanel = new JPanel();
        SelectPanel.setPreferredSize(new Dimension(200,800));
        SelectPanel.setBackground(Color.green);


        ImageSelect.setFocusable(false);
        level3 = new JRadioButton("Level 3");level3.setFocusable(false);level3.addActionListener(this);
        level5 = new JRadioButton("Level 5");level5.setFocusable(false);level5.addActionListener(this);
        level7 = new JRadioButton("Level 7");level7.setFocusable(false);level7.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(level3);
        group.add(level5);
        group.add(level7);


        SelectPanel.add(level3);
        SelectPanel.add(level5);
        SelectPanel.add(level7);


        DrawGuideImage(3);


        StepCounter.setPreferredSize(new Dimension(150,150));
        StepCounter.setHorizontalAlignment(SwingConstants.CENTER);
        StepCounter.setFont(new Font("MV Boli",Font.PLAIN,45));

        JLabel remind = new JLabel("Name");
        remind.setPreferredSize(new Dimension(150,10));
        remind.setHorizontalAlignment(SwingConstants.CENTER);
        remind.setFont(new Font("MV Boli",Font.PLAIN,15));
        //remind.


        ImageSelect.addActionListener(new ImageChoser());

        SelectPanel.add(guidLabel);
        recordButton.addActionListener(new invokeRecord());
        savedButton.addActionListener(new saveRecordOnClick());
        SelectPanel.add(recordButton); recordButton.setFocusable(false);
        SelectPanel.add(StepCounter);
        SelectPanel.add(remind);
        SelectPanel.add(userName);
        SelectPanel.add(savedButton);savedButton.setFocusable(false);
        SelectPanel.add(ImageSelect);

        frame.add(BorderLayout.CENTER,board);scrollPane.setViewportView(SelectPanel);
        frame.add(BorderLayout.EAST,scrollPane);
        frame.pack();
        frame.setVisible(true);
    }


    static void SetUpGuideImage(JFrame frame,boardgui board){
        guideImg = board.getImage();
        int Width = new ImageIcon(guideImg).getIconWidth();
        int Height = new ImageIcon(guideImg).getIconHeight();
        float WidthRatio = (float)Width/200;
        int NewWidth = (int)(Width/WidthRatio);
        int NewHeight = (int)(Height/WidthRatio);
        guideImg = guideImg.getScaledInstance(NewWidth,NewHeight,Image.SCALE_DEFAULT);
        guidLabel.setPreferredSize(new Dimension(NewWidth,NewHeight));
        guidLabel.setIcon(new ImageIcon(guideImg));
        frame.add(BorderLayout.CENTER,board);
        frame.pack();
        frame.setVisible(true);
    }
    void DrawGuideImage(int level){
        board = new boardgui(level);
        guideImg = board.getImage();
        SetUpGuideImage(frame,board);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == level3)
     {   if(board!=null)
            {
                frame.remove(board);
                allowedToSave = true;
            }
         DrawGuideImage(3);
     }
     else if(e.getSource() == level5)
        {
            if(board!=null)
            {
                allowedToSave = true;
                frame.remove(board);
            }
            DrawGuideImage(5);
        }
    else if(e.getSource() == level7)
    {
        if(board!=null) {
            frame.remove(board);
            allowedToSave = true;
        }
        DrawGuideImage(7);
    }
}

 static class invokeRecord implements ActionListener{

     @Override
     public void actionPerformed(ActionEvent e) {
         Record.getRecord();
     }
 }

 static class updateStepCount implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e) {
         StepCounter.setText(String.valueOf(Board.getStepCount()));
     }
 }

 static class saveRecordOnClick implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e) {
         if(board.isSolve() && allowedToSave)
         {
             String str = userName.getText();
             int score = Board.getStepCount();
             userData.SaveRecord(str,score);
             JOptionPane.showMessageDialog(null,"Save complete !\n"+"Step: "+score,"Info",JOptionPane.PLAIN_MESSAGE);
             //setFocusable(false);
             allowedToSave = false;
         }

     }
 }

 static class ImageChoser implements ActionListener{

     @Override
     public void actionPerformed(ActionEvent e) {
         JFileChooser ChoseImage = new JFileChooser();
            ChoseImage.setCurrentDirectory(new File("G:\\SmallGame"));
            ChoseImage.showOpenDialog(null);
            frame.remove(board);
            board = new boardgui(ChoseImage.getSelectedFile().getAbsolutePath(),board.GetLevel());
            SetUpGuideImage(frame,board);
     }
 }
}
