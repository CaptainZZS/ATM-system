import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning7 extends JFrame {
    private static JFrame jf;
    private static JLabel jl;
    private static JButton exitButton;
    private static JButton backButton;
    public Warning7(){
        jf=new JFrame("Warning");
        jf.setVisible(true);
        jf.setBounds(150,100,1200,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl=new JLabel();
        jf.add(jl);
        final JLabel label = new JLabel();
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("",Font.BOLD,40));
        label.setText("取款成功！");
        label.setBounds(480,150,1000,100);
        jl.add(label);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(500,450,150,100);
        jl.add(backButton);



        ActionListener backButton_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jf.dispose();
            }
        };
        backButton.addActionListener(backButton_ls);



    }

    public static void main(String[] args) {
        Warning7 pe = new Warning7();
        pe.setVisible(true);


    }
}

