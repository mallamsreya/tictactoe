
package tictactoe.game;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TictactoeGame implements ActionListener{
        Random random=new Random();
        JFrame frame;
        JPanel titlepanel=new JPanel();
        JPanel buttonpanel=new JPanel();
        JLabel txt=new JLabel();
        JButton[] buttons=new JButton[9];
        boolean player1_turn;
        
        TictactoeGame(){
            frame=new JFrame();
            frame.setSize(500,500);
            frame.setLocation(380,80);
            frame.getContentPane().setBackground(new Color(50,50,50));
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);
            
            txt.setBackground(new Color(25,25,25));
            txt.setForeground(new Color(25,255,0));
            txt.setFont(new Font("Ink Free",Font.BOLD,75));
            txt.setHorizontalAlignment(JLabel.CENTER);
            txt.setText("Tic-Tac-Toe");
            txt.setOpaque(true);
            
            titlepanel.setLayout(new BorderLayout());
            titlepanel.setBounds(0,0,500,120);
            
            buttonpanel.setLayout(new GridLayout(3,3));
            buttonpanel.setBackground(new Color(150,150,150));
            
            for(int i=0;i<9;i++){
                buttons[i]=new JButton();
                buttonpanel.add(buttons[i]);
                buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
                buttons[i].setFocusable(false);
                buttons[i].addActionListener(this);
                
                        
                
            }
            
            
            titlepanel.add(txt);
            frame.add(titlepanel,BorderLayout.NORTH);
            frame.add(buttonpanel);
            
            firstTurn();
            
            
            
        }
        @Override
        public void actionPerformed(ActionEvent ae){
            for(int i=0;i<9;i++){
                if(ae.getSource()==buttons[i]){
                    if(player1_turn){
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(255,0,0));
                            buttons[i].setText("X");
                            player1_turn=false;
                            txt.setText("O turn");
                            check();
                            
                        }
                    }else{
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(0,0,255));
                            buttons[i].setText("O");
                            player1_turn=true;
                            txt.setText("X turn");
                            check();
                            
                        }
                        
                    }
                    
                }
            }
            
        }
        public void firstTurn(){
            try{
                Thread.sleep(2000);
            }
            catch(Exception e){
                e.printStackTrace();
                
            }
            if(random.nextInt(2)==0){
                player1_turn=true;
                txt.setText("X turn");
            }
            else{
                player1_turn=false;
                txt.setText("O turn");
            }
            
        }
        public void check(){
            if((buttons[0].getText()=="X")&&(buttons[1].getText()=="X")
                    &&(buttons[2].getText()=="X")){
                xwins(0,1,2);
                
            }if((buttons[3].getText()=="X")&&(buttons[4].getText()=="X")
                    &&(buttons[5].getText()=="X")){
                xwins(3,4,5);
                
            }
            if((buttons[6].getText()=="X")&&(buttons[7].getText()=="X")
                    &&(buttons[8].getText()=="X")){
                xwins(6,7,8);
                
            }
            if((buttons[0].getText()=="X")&&(buttons[3].getText()=="X")
                    &&(buttons[6].getText()=="X")){
                xwins(0,3,6);
                
            }if((buttons[1].getText()=="X")&&(buttons[4].getText()=="X")
                    &&(buttons[7].getText()=="X")){
                xwins(1,4,7);
                
            }if((buttons[2].getText()=="X")&&(buttons[5].getText()=="X")
                    &&(buttons[8].getText()=="X")){
                xwins(2,5,8);
                
            }if((buttons[0].getText()=="X")&&(buttons[4].getText()=="X")
                    &&(buttons[8].getText()=="X")){
                xwins(0,4,8);
                
            }if((buttons[2].getText()=="X")&&(buttons[4].getText()=="X")
                    &&(buttons[6].getText()=="X")){
                xwins(2,4,6);
                
            }
            if((buttons[0].getText()=="O")&&(buttons[1].getText()=="O")
                    &&(buttons[2].getText()=="O")){
                ywins(0,1,2);
                
            }if((buttons[3].getText()=="O")&&(buttons[4].getText()=="O")
                    &&(buttons[5].getText()=="O")){
                ywins(3,4,5);
                
            }
            if((buttons[6].getText()=="O")&&(buttons[7].getText()=="O")
                    &&(buttons[8].getText()=="O")){
                ywins(6,7,8);
                
            }
            if((buttons[0].getText()=="O")&&(buttons[3].getText()=="O")
                    &&(buttons[6].getText()=="O")){
                ywins(0,3,6);
                
            }if((buttons[1].getText()=="O")&&(buttons[4].getText()=="O")
                    &&(buttons[7].getText()=="O")){
                ywins(1,4,7);
                
            }if((buttons[2].getText()=="O")&&(buttons[5].getText()=="O")
                    &&(buttons[8].getText()=="O")){
                ywins(2,5,8);
                
            }if((buttons[0].getText()=="O")&&(buttons[4].getText()=="O")
                    &&(buttons[8].getText()=="O")){
                ywins(0,4,8);
                
            }if((buttons[2].getText()=="O")&&(buttons[4].getText()=="O")
                    &&(buttons[6].getText()=="O")){
                ywins(2,4,6);
                
            }
            
    }
        public void xwins(int a,int b,int c){
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);
            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            txt.setText("X wins");
        }
        public void ywins(int a,int b,int c){
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);
            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            txt.setText("O wins");
        }
        public static void main(String[] args){
            new TictactoeGame();
        }
   
    
}
