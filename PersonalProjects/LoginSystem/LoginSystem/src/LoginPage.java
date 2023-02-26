import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();

    JLabel userIDLabel = new JLabel("UserID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel messageLabel = new JLabel();


    HashMap<String,String> loginInfo = new HashMap<String,String>();
    LoginPage(HashMap<String,String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal;

        JFrame.setDefaultLookAndFeelDecorated(false);
        frame.setTitle("Login Page");

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(100,250,350,30);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setBackground(new Color(14, 92, 187));
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setEnabled(false);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(52,53,65,100));
        frame.setContentPane(contentPane);


        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.getContentPane().setBackground(new Color(195,196,201));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);


        //listener userID and PasswordField
        DocumentListener myDocumentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }
        };
        userIDField.getDocument().addDocumentListener(myDocumentListener);
        userPasswordField.getDocument().addDocumentListener(myDocumentListener);

    }

    //check updateButtonState
    private void updateButtonState() {
        loginButton.setEnabled(!userIDField.getText().isEmpty() && userPasswordField.getPassword().length != 0);


        userIDField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()== KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        userPasswordField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        userIDField.addActionListener(this);
        userPasswordField.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            messageLabel.setText("");
        }

        if(e.getSource() == loginButton) {
            login();
        }
    }

    private void login() {
        String userID = userIDField.getText();
        String password = String.valueOf(userPasswordField.getPassword());

        if(userID.isEmpty() || password.isEmpty()) {
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Fill in all the fields");
            return;
        }

        if(loginInfo.containsKey(userID)) {
            if(loginInfo.get(userID).equals(password)) {
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Login successful");
                frame.dispose();
                WelcomePage welcomePage = new WelcomePage(userID);
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("User or password wrong");
            }
        }
        else {
            messageLabel.setForeground(Color.red);
            messageLabel.setText("User or password wrong");
        }
    }
}
