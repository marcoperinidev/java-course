import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel("this is a test");

    HashMap<String,String> loginInfo = new HashMap<String,String>();
    LoginPage(HashMap<String,String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

    }
}
