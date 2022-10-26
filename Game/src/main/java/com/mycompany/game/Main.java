package com.mycompany.game;

import javax.swing.JFrame;

public class Main extends JFrame      {
    
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setTitle("Adventure Time");
        window.setSize(1080,720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        Gamepanel gamepanel = new Gamepanel();
        window.add(gamepanel);
        window.pack();
        window.setLocationRelativeTo(null);
        
       
        gamepanel.startGameThead();
         window.setVisible(true);
    }
}
   