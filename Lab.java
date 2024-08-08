import java.lang.Exception;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
class Lab{
    public static void main(String[] args){
        new MyFrame();      
  
    }
}
interface Operations{
    float withdrawAmount(float amount,float withdraw);
    float depositAmount(float amount, float deposit);

}
class Account implements Operations{
    
    @Override
    public float depositAmount(float amount,float deposit) {
        amount+=deposit;

        return amount;
    }

    @Override
    public float withdrawAmount(float amount,float withdraw) {
        try{
            if (withdraw>amount){
                throw new Exception("Insufficient Balance");
            }
            amount-=withdraw;
            
        }catch(Exception e){
            withdrawAmount(amount,withdraw);
        }
        finally{
          
			
            return amount;

        }
    
       
    }



}
class MyFrame extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JLabel lable = new JLabel();
    JLabel lableUser = new JLabel();
    JLabel lablePass = new JLabel();
    JPasswordField password = new JPasswordField();

    JTextField username = new JTextField();

    JButton button = new JButton("Submit");
    ImageIcon image=new ImageIcon("ic_task_completed.png");
    Border border=BorderFactory.createLineBorder(new Color(234,122,65),3);
    MyFrame(){
        panel.setBackground(Color.BLUE);
        panel.setSize(100, 100);
        //headline
        lable.setText("Welcome to SIB");
        lable.setForeground( Color.WHITE);
        lable.setOpaque(true);
        lable.setVerticalTextPosition(JLabel.CENTER);
        lable.setHorizontalTextPosition(JLabel.CENTER);
        lable.setBounds(50,50,200,200);
        lable.setBorder(border);
        lable.setOpaque(true);
        lable.setVerticalAlignment(JLabel.CENTER);
        lable.setHorizontalAlignment(JLabel.CENTER);
        lable.setBounds(0 ,0,100,100);
        lable.setFont(new Font("Monospaced",Font.BOLD,28));
        lable.setBackground(Color.DARK_GRAY);

        //username
        lableUser.setText("Enter your user name:");
        lableUser.setForeground(Color.black);
        lableUser.setFont(new Font("Monospaced",Font.PLAIN,18));
        username.setPreferredSize(new Dimension(30,10));
        //password
        lablePass.setText("Enter Password:");
        lablePass.setForeground(Color.black);
        lablePass.setFont(new Font("Monospaced",Font.PLAIN,18));
        password.setPreferredSize(new Dimension(30,10));
        
        //submit
        button.addActionListener(this);
        
        

        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        this.setTitle("ATM Interface");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
       // this.setResizable(false);
        this.setIconImage(image.getImage());
        this.setLayout(new GridLayout(10,10));
        //this.add(panel);
        this.add(lable);
        this.add(lableUser);
        this.add(username);
        this.add(lablePass);
        this.add(password);

        this.add(button);
        //this.pack();

    }
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==button){
            String user =username.getText();
            String pass=String.valueOf(password.getPassword());
            if (user.equals("Anurag") && pass.equals("123456")){
                new Options();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid login info","Error",JOptionPane.WARNING_MESSAGE);
            }
            

        }
        
    }
    

}
class Options extends JFrame implements ActionListener{
    float balance=0;

    JPanel panel = new JPanel();
    JLabel lable = new JLabel();
    JLabel lableUser = new JLabel();

    JButton choice1 = new JButton("Check Balance");
    JButton choice2 = new JButton("Deposit Amount");
    JButton choice3 = new JButton("Withdraw Amount");



    ImageIcon image=new ImageIcon("ic_task_completed.png");
    Border border=BorderFactory.createLineBorder(new Color(234,122,65),3);
    Options(){
        
        panel.setBackground(Color.BLUE);
        panel.setSize(100, 100);
        //headline
        lable.setText("Welcome to SIB");
        lable.setForeground( Color.WHITE);
        lable.setOpaque(true);
        lable.setVerticalTextPosition(JLabel.CENTER);
        lable.setHorizontalTextPosition(JLabel.CENTER);
        lable.setBounds(50,50,200,200);
        lable.setBorder(border);
        lable.setOpaque(true);
        lable.setVerticalAlignment(JLabel.CENTER);
        lable.setHorizontalAlignment(JLabel.CENTER);
        lable.setBounds(0 ,0,100,100);
        lable.setFont(new Font("Monospaced",Font.BOLD,28));
        lable.setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        this.setTitle("ATM Interface");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
       // this.setResizable(false);
        this.setIconImage(image.getImage());
        this.setLayout(new GridLayout(10,10));
        

        //Operation choice
        lableUser.setText("Choose operation you want to perfirm:");
        lableUser.setForeground(Color.black);
        lableUser.setFont(new Font("Monospaced",Font.BOLD,18));
        choice1.addActionListener(this);
        choice2.addActionListener(this);
        choice3.addActionListener(this);

        

        this.add(lable);
        this.add(lableUser);
        this.add(choice1);
        this.add(choice2);

        this.add(choice3);


    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==choice1){
            JOptionPane.showMessageDialog(null,"Avialable Balance = Rs."+ balance,"Inquiry",JOptionPane.PLAIN_MESSAGE);

            
            

        }
        if(e.getSource()==choice2){
            new Choice2(balance);
            this.dispose();
            

        }
        if(e.getSource()==choice3){
            new Choice3(balance);
            this.dispose();
            

        }
        
    }


}

class Choice1 extends JFrame{
    JPanel panel = new JPanel();
    JLabel lable = new JLabel();
    JLabel lableUser = new JLabel();

    Border border=BorderFactory.createLineBorder(new Color(234,122,65),3);
    Choice1(float balance){
        panel.setBackground(Color.BLUE);
        panel.setSize(100, 100);
        //headline
        lable.setText("Welcome to SIB");
        lable.setForeground( Color.WHITE);
        lable.setOpaque(true);
        lable.setVerticalTextPosition(JLabel.CENTER);
        lable.setHorizontalTextPosition(JLabel.CENTER);
        lable.setBounds(50,50,200,200);
        lable.setBorder(border);
        lable.setOpaque(true);
        lable.setVerticalAlignment(JLabel.CENTER);
        lable.setHorizontalAlignment(JLabel.CENTER);
        lable.setBounds(0 ,0,100,100);
        lable.setFont(new Font("Monospaced",Font.BOLD,28));
        lable.setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        this.setTitle("ATM Interface");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
       // this.setResizable(false);
        this.setLayout(new GridLayout(10,10));
        this.add(lable);


            
        
    }

}
class Choice2 extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JLabel lable = new JLabel();
    JLabel lableUser = new JLabel();
    JTextField deposit = new JTextField();
    JButton button = new JButton("Deposit");
    Account ac = new Account();
    Border border=BorderFactory.createLineBorder(new Color(234,122,65),3);
    float balance=0;
    Choice2(float balance){
        
        panel.setBackground(Color.BLUE);
        panel.setSize(100, 100);
        //headline
        lable.setText("Welcome to SIB");
        lable.setForeground( Color.WHITE);
        lable.setOpaque(true);
        lable.setVerticalTextPosition(JLabel.CENTER);
        lable.setHorizontalTextPosition(JLabel.CENTER);
        lable.setBounds(50,50,200,200);
        lable.setBorder(border);
        lable.setOpaque(true);
        lable.setVerticalAlignment(JLabel.CENTER);
        lable.setHorizontalAlignment(JLabel.CENTER);
        lable.setBounds(0 ,0,100,100);
        lable.setFont(new Font("Monospaced",Font.BOLD,28));
        lable.setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        this.setTitle("ATM Interface");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
       // this.setResizable(false);

       lableUser.setText("Enter your user name:");
       lableUser.setForeground(Color.black);
       lableUser.setFont(new Font("Monospaced",Font.PLAIN,18));
       deposit.setPreferredSize(new Dimension(30,10));
        button.addActionListener(this);
        this.setLayout(new GridLayout(10,10));
        this.add(lable);
        this.add(deposit);
        this.add(button);     
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            Float amount=Float.valueOf(deposit.getText());
            JOptionPane.showMessageDialog(null,"Avialable Balance = Rs."+ String.valueOf(ac.depositAmount(balance,amount)),"Deposit",JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            new Options();

        }
        
    }

}
class Choice3 extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    JLabel lable = new JLabel();
    JLabel lableUser = new JLabel();
    JTextField take = new JTextField();
    JButton button = new JButton("Withdraw");
    Account ac=new Account();
	
    float balance=100000;

    Border border=BorderFactory.createLineBorder(new Color(234,122,65),3);
    Choice3(float balance){
        panel.setBackground(Color.BLUE);
        panel.setSize(100, 100);
        //headline
        lable.setText("Welcome to SIB");
        lable.setForeground( Color.WHITE);
        lable.setOpaque(true);
        lable.setVerticalTextPosition(JLabel.CENTER);
        lable.setHorizontalTextPosition(JLabel.CENTER);
        lable.setBounds(50,50,200,200);
        lable.setBorder(border);
        lable.setOpaque(true);
        lable.setVerticalAlignment(JLabel.CENTER);
        lable.setHorizontalAlignment(JLabel.CENTER);
        lable.setBounds(0 ,0,100,100);
        lable.setFont(new Font("Monospaced",Font.BOLD,28));
        lable.setBackground(Color.DARK_GRAY);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.CYAN);
        this.setTitle("ATM Interface");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 1000);
       // this.setResizable(false);
        this.setLayout(new GridLayout(10,10));
        
       lableUser.setText("Enter your user name:");
       lableUser.setForeground(Color.black);
       lableUser.setFont(new Font("Monospaced",Font.PLAIN,18));
       take.setPreferredSize(new Dimension(30,10));
        button.addActionListener(this);
        this.setLayout(new GridLayout(10,10));
        this.add(lable);
        this.add(take);
        this.add(button);
        


            
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            float draw= Float.valueOf(take.getText());
            JOptionPane.showMessageDialog(null,"Avialable Balance = Rs."+ String.valueOf(ac.withdrawAmount(balance,draw)),"title",JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            new Options();

        }
        
    }

}

