import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password_error2 extends JFrame {
    private static JFrame jf;
    private static JLabel jl;
    private static JButton exitButton;

    public Password_error2(){
        jf=new JFrame("Password_error");
        jf.setVisible(true);
        jf.setBounds(150,100,1200,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl=new JLabel();
        jf.add(jl);
        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("密码错误，请退出！");
        label.setBounds(400,150,1000,100);
        jl.add(label);



        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(500,450,150,100);
        jl.add(exitButton);



        ActionListener exitButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };

        exitButton.addActionListener(exitButton_ls);
    }

    public static void main(String[] args) {
        Password_error2 pe = new Password_error2();



    }
}

