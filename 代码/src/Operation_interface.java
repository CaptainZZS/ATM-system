import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operation_interface extends JFrame {
    static String bankcard_get = Login_interface.textField.getText();
//    static String bankcard_get = "622821 2299030127370";
    private static JLabel label;
    private static JButton depositButton;
    private static JButton queryButton;
    private static JButton withdraw_moneyButton;
    private static JButton transfer_accountsButton;
    private static JButton Change_passwordButton;
    private static JButton exitButton;
    public Operation_interface(){
        super();
        System.out.println(bankcard_get);
        setTitle("操作界面");
        setBounds(500,50,500,800);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel();
        label.setForeground(new Color(17, 76, 255));
        label.setFont(new Font("黑体",Font.BOLD,50));
        label.setText("业务选择");
        label.setBounds(150,10,1000,100);
        getContentPane().add(label);

        depositButton = new JButton();
        depositButton.setFont(new Font("",Font.BOLD,40));
        depositButton.setText("存款");
        depositButton.setBounds(150,100,200,100);
        getContentPane().add(depositButton);

        queryButton = new JButton();
        queryButton.setFont(new Font("",Font.BOLD,40));
        queryButton.setText("查询");
        queryButton.setBounds(150,200,200,100);
        getContentPane().add(queryButton);

        withdraw_moneyButton = new JButton();
        withdraw_moneyButton.setFont(new Font("",Font.BOLD,40));
        withdraw_moneyButton.setText("取款");
        withdraw_moneyButton.setBounds(150,300,200,100);
        getContentPane().add(withdraw_moneyButton);

        transfer_accountsButton = new JButton();
        transfer_accountsButton.setFont(new Font("",Font.BOLD,40));
        transfer_accountsButton.setText("转账");
        transfer_accountsButton.setBounds(150,400,200,100);
        getContentPane().add(transfer_accountsButton);

        Change_passwordButton = new JButton();
        Change_passwordButton.setFont(new Font("",Font.BOLD,40));
        Change_passwordButton.setText("修改密码");
        Change_passwordButton.setBounds(150,500,200,100);
        getContentPane().add(Change_passwordButton);

        exitButton = new JButton();
        exitButton.setFont(new Font("",Font.BOLD,40));
        exitButton.setText("退出");
        exitButton.setBounds(150,600,200,100);
        getContentPane().add(exitButton);

        ActionListener depositButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit_interface deposit_interface = new Deposit_interface();
                deposit_interface.setVisible(true);

            }
        };depositButton.addActionListener(depositButton_ls);

        ActionListener queryButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                query_interface query_interface = new query_interface();
                query_interface.setVisible(true);
            }
        };queryButton.addActionListener(queryButton_ls);

        ActionListener withdraw_moneyButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw_money_interface withdraw_money_interface = new withdraw_money_interface();
                withdraw_money_interface.setVisible(true);
            }
        };withdraw_moneyButton.addActionListener(withdraw_moneyButton_ls);

        ActionListener transfer_accountsButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transfer_accounts_interface transfer_accounts_interface = new transfer_accounts_interface();
                transfer_accounts_interface.setVisible(true);
            }
        };transfer_accountsButton.addActionListener(transfer_accountsButton_ls);

        ActionListener Change_passwordButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Change_password_interface change_password_interface = new Change_password_interface();
                change_password_interface.setVisible(true);
            }
        };Change_passwordButton.addActionListener(Change_passwordButton_ls);

        ActionListener exitButton_ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };exitButton.addActionListener(exitButton_ls);
}



    public static void main(String[] args) {
        Operation_interface operation_interface = new Operation_interface();
        operation_interface.setVisible(true);

    }
}
