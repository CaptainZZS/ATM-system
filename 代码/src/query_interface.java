import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class query_interface extends JFrame{
    public static  JTextArea textArea;
    public static  JScrollPane scrollPane;
    private static JLabel label1,label2,label3;
    private static JButton backButton,exitButton;
//    static String bankcard_get = "622821 2299030127370";
    static String bankcard_get = Operation_interface.bankcard_get;
    public query_interface(){
        super();
        setTitle("查询界面");
        setBounds(400,50,700,800);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql1 = "select name from message1 where bank_card = ?";
        String str1 = template.queryForObject(sql1, String.class, bankcard_get);
        String sql2 = "select balance from message1 where bank_card = ?";
        String str2 = template.queryForObject(sql2, String.class, bankcard_get);
        String sql4 = "select id from message1 where bank_card = ?";
        String str4 = template.queryForObject(sql4, String.class, bankcard_get);
        String sql5 = "select transfer,amount,type,Collection,datatime from message2 where number = ? ";
        List<Map<String, Object>> list = template.queryForList(sql5,str4);
        String text = "";
        for (Map<String, Object> stringObjectMap : list) {
            String text_first = "";
            for (Object v : stringObjectMap.values()) {
                text_first += v + "  ";
            }
            text += text_first + "\n";
        }

        label1 = new JLabel();
        label1.setForeground(new Color(17, 76, 255));
        label1.setFont(new Font("黑体",Font.BOLD,30));
        label1.setText("用户："+str1);
        label1.setBounds(120,10,1000,100);
        getContentPane().add(label1);

        label2 = new JLabel();
        label2.setForeground(new Color(17, 76, 255));
        label2.setFont(new Font("黑体",Font.BOLD,30));
        label2.setText("银行卡号："+bankcard_get);
        label2.setBounds(120,40,1000,100);
        getContentPane().add(label2);

        label3 = new JLabel();
        label3.setForeground(new Color(17, 76, 255));
        label3.setFont(new Font("黑体",Font.BOLD,30));
        label3.setText("账户余额："+str2);
        label3.setBounds(120,70,1000,100);
        getContentPane().add(label3);

        textArea = new JTextArea(10, 15);
        textArea.setTabSize(4);
        textArea.setFont(new Font("黑体", Font.BOLD, 24));
        textArea.setLineWrap(true);// 激活自动换行功能
        textArea.setWrapStyleWord(true);// 激活断行不断字功能
        textArea.setBackground(Color.green);
        textArea.setText(text);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20,150,650,500);
        getContentPane().add(scrollPane);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(150,650,150,50);
        getContentPane().add(backButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(400,650,150,50);
        getContentPane().add(exitButton);

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

    }

    public static void main(String[] args) {
        query_interface query_interface = new query_interface();
        query_interface.setVisible(true);
    }
}
