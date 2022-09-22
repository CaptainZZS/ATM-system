import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Deposit_interface extends JFrame{
    static String bankcard_get = Operation_interface.bankcard_get;
//    static String bankcard_get = "622821 2299030127370";
    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static TextField label5;
    private static JButton depositButton;
    private static JButton backButton;
    private static JButton exitButton;
    public Deposit_interface(){
        super();
        System.out.println(bankcard_get);
        setTitle("存款界面");
        setBounds(500,50,600,800);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql1 = "select name from message1 where bank_card = ?";
        String str1 = template.queryForObject(sql1, String.class, bankcard_get);
        String sql2 = "select balance from message1 where bank_card = ?";
        String str2 = template.queryForObject(sql2, String.class, bankcard_get);
        String sql4 = "select id from message1 where bank_card = ?";
        String str4 = template.queryForObject(sql4, String.class, bankcard_get);

        label1 = new JLabel();
        label1.setForeground(new Color(17, 76, 255));
        label1.setFont(new Font("黑体",Font.BOLD,30));
        label1.setText("用户："+str1);
        label1.setBounds(50,10,1000,100);
        getContentPane().add(label1);

        label2 = new JLabel();
        label2.setForeground(new Color(17, 76, 255));
        label2.setFont(new Font("黑体",Font.BOLD,30));
        label2.setText("银行卡号："+bankcard_get);
        label2.setBounds(50,40,1000,100);
        getContentPane().add(label2);

        label3 = new JLabel();
        label3.setForeground(new Color(17, 76, 255));
        label3.setFont(new Font("黑体",Font.BOLD,30));
        label3.setText("账户余额："+str2);
        label3.setBounds(50,70,1000,100);
        getContentPane().add(label3);

        label4 = new JLabel();
        label4.setForeground(new Color(17, 76, 255));
        label4.setFont(new Font("黑体",Font.BOLD,30));
        label4.setText("请在下方输入存款金额");
        label4.setBounds(120,150,1000,50);
        getContentPane().add(label4);

        label5 = new TextField();
        label5.setFont(new Font("",Font.BOLD,40));
        label5.setBounds(110,250,350,50);
        getContentPane().add(label5);

        depositButton = new JButton();
        depositButton.setFont(new Font("",Font.BOLD,40));
        depositButton.setText("存款");
        depositButton.setBounds(210,400,150,50);
        getContentPane().add(depositButton);

        backButton = new JButton();
        backButton.setFont(new Font("",Font.BOLD,40));
        backButton.setText("返回");
        backButton.setBounds(210,500,150,50);
        getContentPane().add(backButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(210,600,150,50);
        getContentPane().add(exitButton);

        ActionListener depositButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String money_str = label5.getText();
                Double balance = Double.valueOf(str2.toString());
                Double money = Double.valueOf(money_str.toString());
                Integer id = Integer.valueOf(str4.toString());
                if (money < 0){
                    Warning4 warning4 = new Warning4();
                    label5.setText("");
                }else{
                    Double new_balance =  balance + money;
                    String sql3 = "update message1 set balance = ? where bank_card = ?";
                    int update = template.update(sql3, new_balance, bankcard_get);
                    if (update == 1){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String ly_time = sdf.format(new java.util.Date());
                        String sql4 =  "insert into message2(number,transfer,amount,type,Collection,datatime) value (?,?,?,?,?,?)";
                        Object args[] = {id,str1,money,"+",str1,ly_time};
                        int flag1 = template.update(sql4,args);
                        Deposit_interface deposit_interface = new Deposit_interface();
                        deposit_interface.setVisible(true);
                        dispose();
                        Warning5 warning5 = new Warning5();


                    }else{
                        Warning6 warning6 = new Warning6();
                        label5.setText("");
                    }
                }
            }
        };depositButton.addActionListener(depositButton_ls);

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
        Deposit_interface deposit_interface = new Deposit_interface();
        deposit_interface.setVisible(true);

    }
}
