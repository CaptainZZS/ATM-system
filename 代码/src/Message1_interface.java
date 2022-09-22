import javafx.scene.control.TextField;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;

//实现接口ActionListener
public class Message1_interface extends JFrame{
    JPanel jpanel;
    public static  JTextArea textArea;
    public static  JScrollPane scrollPane;
    JButton jb1, jb2, jb3,backButton,exitButton,newLogin_Button;

    public Message1_interface() {
        super();
        setTitle("信息一");
        setBounds(300,100,1000,700);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql1 = "select * from message1";
        List<Map<String, Object>> list = template.queryForList(sql1);
        String text = "";
        for (Map<String, Object> stringObjectMap : list) {
            String text_first = "";
            for (Object v : stringObjectMap.values()) {
                text_first += v + "  ";
            }
            text += text_first + "\n";
        }


        textArea = new JTextArea(10, 15);
        textArea.setTabSize(4);
        textArea.setFont(new Font("黑体", Font.BOLD, 24));
        textArea.setLineWrap(true);// 激活自动换行功能
        textArea.setWrapStyleWord(true);// 激活断行不断字功能
        textArea.setBackground(Color.pink);
        textArea.setText(text);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0,0,1000,300);
        getContentPane().add(scrollPane);

        jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(1, 3));
        jb1 = new JButton("复制");
        jb1.setFont(new Font("",Font.BOLD,40));
        jb2 = new JButton("粘贴");
        jb2.setFont(new Font("",Font.BOLD,40));
        jb3 = new JButton("剪切");
        jb3.setFont(new Font("",Font.BOLD,40));
        jpanel.add(jb1);
        jpanel.add(jb2);
        jpanel.add(jb3);
        jpanel.setBounds(0,300,1000,50);
        getContentPane().add(jpanel);

        newLogin_Button = new JButton();
        newLogin_Button.setFont(new Font("",Font.BOLD,40));
        newLogin_Button.setText("新登录");
        newLogin_Button.setBounds(80,450,175,50);
        getContentPane().add(newLogin_Button);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(425,450,150,50);
        getContentPane().add(backButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(755,450,150,50);
        getContentPane().add(exitButton);

        ActionListener newLogin_Button_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login_interface login_interface = new Login_interface();
                login_interface.setVisible(true);
            }
        };newLogin_Button.addActionListener(newLogin_Button_ls);

        ActionListener backButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };backButton.addActionListener(backButton_ls);

        ActionListener exitButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };exitButton.addActionListener(exitButton_ls);

        ActionListener jb1_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        };jb1.addActionListener(jb1_ls);

        ActionListener jb2_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        };jb2.addActionListener(jb2_ls);

        ActionListener jb3_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        };jb3.addActionListener(jb3_ls);
    }


    public static void main(String[] args) {
        Message1_interface message1_interface = new Message1_interface();
        message1_interface.setVisible(true);
    }
}