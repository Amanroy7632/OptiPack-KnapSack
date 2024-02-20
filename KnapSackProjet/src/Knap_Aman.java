import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
public class Knap_Aman extends JFrame {
    private JTextField jTextField_name;
    private JTextField jTextField_phone;
    private JLabel cusId;
    private JTextField jTextField_qty;
    private JTextField capacityField;
    private JPanel panel1;
    private Validation obj;
    private JComboBox country;
    private JLabel timeLabel;
    Random ran = new Random();
    long digit = Math.abs((ran.nextLong() % 9000L) + 1000L);

    Knap_Aman() {
        obj = new Validation();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon homeImage = new ImageIcon("C:\\Users\\yadav\\OneDrive\\Desktop\\JAVA PROJECTS\\KnapSackProjet\\img\\back.jpeg");
        setIconImage(homeImage.getImage());
        Image i2 = homeImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        // TODO: Panel 1 data=================
        panel1 = new JPanel();
        panel1.setBounds(350, 100, 800, 600);
        // panel1.setBackground(Color.black);

        // TODO: === Components of Panel 1=============

        JLabel head = new JLabel("Welcome to Bharat Transportation");
        head.setForeground(Color.WHITE);
        head.setFont(new java.awt.Font("Segoe UI", 1, 24));
        head.setBounds(200, 0, 500, 50);
        JButton cross=new JButton("X");
        cross.setFont(new java.awt.Font("Segoe UI", 1, 24));
        cross.setBounds(750, 0, 50, 50);
        cross.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cross.setBorder(null);
        cross.setBackground(Color.BLACK);
        cross.setForeground(Color.red);
        cross.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
               int choice= JOptionPane.showConfirmDialog(null ,"Are you sure", "Bot", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("Choice= "+choice);
               if(choice==0){
                System.exit(0);
               }
            }
        });
        JPanel line1 = new JPanel();
        line1.setBounds(0, 55, 800, 10);
        panel1.setLayout(null);
        panel1.setBackground(Color.black);
        JLabel detailHead = new JLabel("Enter Customer Details... ");
        JLabel nameLabel = new JLabel("Name :");
        // JList
        String course[] = { "+91", "+92", "+93" };
        country = new JComboBox<>(course);
        country.setBounds(225, 190, 55, 35);
        country.setFont(new java.awt.Font("Segoe UI", 1, 18));
        country.setBackground(Color.white);
        // panel1.add(country);
        // country.addActionListener(cbBranch);
        JLabel phoneLabel = new JLabel("Phone No : ");
        JLabel idLabel = new JLabel("Customer ID : ");
        detailHead.setBounds(50, 70, 300, 50);
        detailHead.setForeground(Color.WHITE);
        detailHead.setFont(new java.awt.Font("Segoe UI", 1, 20));
        // ---------------------------------------
        nameLabel.setBounds(55, 125, 200, 50);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        phoneLabel.setBounds(55, 185, 200, 50);
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        idLabel.setBounds(55, 245, 200, 50);
        idLabel.setForeground(Color.WHITE);
        idLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField_name = new JTextField();
        jTextField_name.setBounds(225, 130, 250, 35);
        jTextField_name.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField_phone = new JTextField();
        jTextField_phone.setBounds(225, 190, 250, 35);
        jTextField_phone.setFont(new java.awt.Font("Segoe UI", 1, 18));
        cusId = new JLabel("CUST0" + digit);
        // jTextField_id = new JTextField();
        cusId.setBounds(225, 250, 250, 35);
        cusId.setFont(new java.awt.Font("Segoe UI", 1, 18));
        cusId.setForeground(Color.WHITE);
        jTextField_qty = new JTextField();
        JPanel line2 = new JPanel();
        line2.setBounds(0, 305, 800, 10);
        ImageIcon userImg = new ImageIcon("C:\\Users\\yadav\\OneDrive\\Desktop\\JAVA PROJECTS\\KnapSackProjet\\src\\images\\user.png");
        Image userImage1 = userImg.getImage().getScaledInstance(165, 155, Image.SCALE_DEFAULT);
        ImageIcon userImage2 = new ImageIcon(userImage1);
        JLabel userImageLabel = new JLabel(userImage2);
        userImageLabel.setBounds(545, 130, 165, 155);
        // ToDO: After Second half code=============
        JLabel qtyLabel = new JLabel("Enter Total Number of Products :");
        qtyLabel.setBounds(55, 335, 300, 40);
        qtyLabel.setForeground(Color.WHITE);
        qtyLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jTextField_qty.setBounds(365, 340, 200, 35);
        jTextField_qty.setFont(new java.awt.Font("Segoe UI", 1, 20));
        JLabel capJLabel = new JLabel("Enter Capacity of Container Unit : ");
        capJLabel.setBounds(55, 380, 300, 40);
        capJLabel.setFont(new Font("Segoe UI", 1, 18));
        capJLabel.setForeground(Color.white);
        capacityField = new JTextField();
        capacityField.setBounds(365, 380, 200, 35);
        capacityField.setFont(new Font("Segoe UI", 1, 20));
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Times new roman", Font.BOLD, 17));
        timeLabel.setBounds(560, 70, 200, 40);
        timeLabel.setForeground(Color.white);

        JButton SubmitBtn = new JButton("Submit");
        SubmitBtn.setBounds(200, 495, 370, 45);
        SubmitBtn.setBackground(Color.blue);
        // SubmitBtn.setBackground(new java.awt.Color(0, 0, 255));
        SubmitBtn.setForeground(Color.white);
        // SubmitBtn.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        SubmitBtn.setFont(new java.awt.Font("Segoe UI", 3, 18));
        SubmitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubmitBtn.setMargin(new java.awt.Insets(2, 17, 3, 17));
        SubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        JPanel panel2 = new JPanel();
        panel2.add(image);

        add(head);
        add(panel1);
        add(panel2);
        panel1.add(head);
        panel1.add(cross);
        panel1.add(line1);
        panel1.add(detailHead);
        panel1.add(timeLabel);
        panel1.add(nameLabel);
        panel1.add(phoneLabel);
        panel1.add(idLabel);
        panel1.add(jTextField_name);
        panel1.add(jTextField_phone);
        panel1.add(cusId);
        panel1.add(line2);
        panel1.add(userImageLabel);
        panel1.add(qtyLabel);
        panel1.add(jTextField_qty);
        panel1.add(capJLabel);
        panel1.add(capacityField);

        panel1.add(SubmitBtn);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDateTime();
            }
        });
        timer.start();

    }

    private void updateDateTime() {
        // Get the current time and date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy ,  hh:mm:ss a");
        String dateTime = sdf.format(new Date());

        // Update the label with the current time and date
        timeLabel.setText(dateTime);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String name = jTextField_name.getText();
        String phone = jTextField_phone.getText();
        String Cid = cusId.getText();
        String qty = jTextField_qty.getText();
        if (name.isBlank() || phone.isEmpty() || Cid.isBlank() || jTextField_qty.getText().isBlank()
                || capacityField.getText().isBlank()) {
            JOptionPane.showMessageDialog(panel1, "Fill the form completly", "Transport Bot",
                    JOptionPane.ERROR_MESSAGE);
        } else if (obj.CheckSepcialChars(name) || obj.containsDigit(name)) {
            JOptionPane.showMessageDialog(panel1, "Namecontains Special charcaters", "Transport Bot",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!obj.containsDigit(phone) || obj.CheckSepcialChars(phone) || obj.checkPhoneNumber(phone)) {
            JOptionPane.showMessageDialog(panel1, "Invalid Phone Number ", "Transport Bot",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!obj.containsDigit(qty) || obj.CheckSepcialChars(qty)) {
            JOptionPane.showMessageDialog(panel1, "Invalid Quantity ", "Transport Bot",
                    JOptionPane.ERROR_MESSAGE);
        } else if (!obj.containsDigit(capacityField.getText()) || obj.CheckSepcialChars(capacityField.getText())) {
            JOptionPane.showMessageDialog(panel1, "Invalid Capacity ", "Transport Bot",
                    JOptionPane.ERROR_MESSAGE);
        } else if ((Integer.parseInt(jTextField_qty.getText())) <= 0
                || Integer.parseInt(jTextField_qty.getText()) > 15) {
            JOptionPane.showMessageDialog(panel1, "Quantity must be in range of 1- 15", "Transport Bot",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            // class.forName( "jdbc:mysql://localhost:3306/knapsack");
            String url = "jdbc:mysql://localhost:3306/knapsack"; // Replace 'mydatabase' with your database name
            String username = "root"; // Replace with your MySQL username
            String password = "aman7632@"; // Replace with your MySQL password
            // String databaseName = "Knapsack";
            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                if (connection != null) {
                    
                    // String insertQuery = "INSERT INTO your_table_name (name, age) VALUES ('" + name + "', " + age + ")";
                    int num = Integer.parseInt(jTextField_qty.getText());
                    int capacity = Integer.parseInt(capacityField.getText());
                    Statement statement = connection.createStatement();
                    String queryString = "INSERT INTO knapsack.CUSTOMER (name,phone,ID,quantity,capacity) VALUES('"+name+"','"+phone+"','"+Cid+"','"+num+"','"+capacity+"')";
                    statement.executeUpdate(queryString);
                    connection.close();
                    System.out.println(name + "\n" + phone + "\n" + Cid);
                    JOptionPane.showMessageDialog(panel1, "Welcome " + name+"User Inserted Successfully", "© Transport Bot",
                            JOptionPane.PLAIN_MESSAGE);
                    Knap_Home obj = new Knap_Home(num, capacity);
                    obj.setSize(1920, 1080);
                    obj.setVisible(true);
                    dispose();
                }
            } catch (Exception e) {
                // System.out.println(e);
                JOptionPane.showMessageDialog(panel1, "Something went wrong " + e.getMessage(), "© Transport Bot",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        // TODO add your handling code here:
    }

    public static void main(String[] args) {
        Knap_Aman ob = new Knap_Aman();
        ob.setSize(1920, 1080);
        ob.setVisible(true);
    }
}
