
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.*;

public class Knap_Home extends JFrame {
    private int num;
    private int capacity;
    private JPanel panel1;
    private JPanel panel11;
    private JPanel panel11Left;
    private JLabel ansJLabel;
    private JLabel findJLabel;
    private Validation obj;
    private KnapSackFractional knapFra;
    private boolean flag;
    private boolean checkFractinal[];
    private JButton billButton;
    private String invoice[][];
    private double profitAnswer=0.0;
    private JTextField array[];
    private JRadioButton rbtns[];

    public Knap_Home(int num, int capacity) {
        String textFields[] = new String[num];
        this.num = num;
        this.capacity = capacity;
        obj = new Validation();
        System.out.println(textFields.length);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon homeImage = new ImageIcon("C:\\Users\\yadav\\OneDrive\\Desktop\\JAVA PROJECTS\\KnapSackProjet\\img\\back.jpeg");
        setIconImage(homeImage.getImage());
        Image i2 = homeImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        // TODO: Panel 11 info =data=================
        panel11 = new JPanel();
        panel11.setBounds(200, 50, 1050, 90);
        panel11.setLayout(null);
        panel11.setBackground(Color.black);
        JLabel head = new JLabel("Welcome to Bharat Transportation");
        head.setForeground(Color.WHITE);
        head.setFont(new java.awt.Font("Segoe UI", 1, 24));
        head.setBounds(350, 0, 500, 50);
        add(panel11);
        // TODO: Line Pannel=============
        JPanel line1 = new JPanel();
        line1.setBounds(0, 45, 1050, 5);
        panel11.add(line1);
        //
        JLabel heading_item = new JLabel("Enter Details of Product ");
        heading_item.setForeground(Color.WHITE);
        heading_item.setFont(new java.awt.Font("Segoe UI", 1, 20));
        heading_item.setBounds(350, 50, 500, 40);
        panel11.add(head);
        panel11.add(heading_item);
        // TODO: Left Top panel -1 =======
        JPanel leftTop = new JPanel();
        leftTop.setBounds(200, 140, 100, 40);
        leftTop.setBackground(Color.black);
        JLabel srnLabel = new JLabel("S. No ");
        // srnLabel.setBounds(250,190,100,40);
        srnLabel.setFont(new java.awt.Font("Segoe UI", 1, 18));
        srnLabel.setForeground(Color.white);
        srnLabel.setAlignmentY(45);
        ;
        add(leftTop);
        leftTop.add(srnLabel);
        // TODO panel 1 -left side============
        panel11Left = new JPanel();
        panel11Left.setBounds(200, 180, 100, 450);
        panel11Left.setLayout(null);
        panel11Left.setBackground(Color.black);

        JPanel line2 = new JPanel();
        line2.setBounds(0, 45, 100, 5);
        JLabel[] labels = new JLabel[num];
        for (int i = 0; i < num; i++) {
            labels[i] = new JLabel("    " + (i + 1) + ".");
            labels[i].setAlignmentY(CENTER_ALIGNMENT);
            labels[i].setForeground(Color.WHITE);
            labels[i].setFont(new java.awt.Font("Segoe UI", 1, 18));
            panel11Left.add(labels[i]);
        }
        add(panel11Left);
        // panel11Left.add(line2);
        panel11Left.setLayout(new GridLayout(0, 1));
        panel11Left.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        // TODO: Panel -1 upper part===
        JPanel upperPart = new JPanel();
        upperPart.setBounds(300, 140, 950, 40);
        upperPart.setLayout(null);
        upperPart.setBackground(Color.blue);
        add(upperPart);
        upperPart.setLayout(new GridLayout(0, 5));
        String content[] = { "Product Name", "Weight/Unit", "Profit/Unit", "Quantity", "Fractional" };
        JLabel[] conlabels = new JLabel[5];
        for (int i = 0; i < 5; i++) {
            conlabels[i] = new JLabel("     " + content[i]);
            // conlabels[i].setBounds(860, 125, 200, 50);
            conlabels[i].setForeground(Color.WHITE);
            conlabels[i].setFont(new java.awt.Font("Segoe UI", 1, 18));
            upperPart.add(conlabels[i]);

        }

        // TODO: Panel - 1 info=======
        panel1 = new JPanel();
        panel1.setBounds(300, 180, 750, 450);
        panel1.setLayout(null);
        panel1.setBackground(Color.black);
        add(panel1);
        panel1.setLayout(new GridLayout(0, 4, 0, 3));
        array = new JTextField[4 * num];
        for (int i = 0; i < 4 * num; i++) {
            array[i] = new JTextField("");
            array[i].setFont(new java.awt.Font("Segoe UI", 1, 16));
            array[i].setHorizontalAlignment(JTextField.CENTER);
            panel1.add(array[i]);
        }
        // TODO: Panel -1 right part having fractional=======
        JPanel rightJPanel = new JPanel();
        rightJPanel.setBounds(1050, 180, 200, 450);
        rightJPanel.setBackground(Color.black);
        add(rightJPanel);
        rightJPanel.setLayout(new GridLayout(0, 1, 0, 3));
        rbtns = new JRadioButton[num];
        int i = 0;
        for (; i < num; i++) {
            rbtns[i] = new JRadioButton("Yes");
            rbtns[i].setFont(new java.awt.Font("Segoe UI", 1, 16));
            rbtns[i].setHorizontalAlignment(JRadioButton.CENTER);
            rbtns[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            rightJPanel.add(rbtns[i]);
        }
        for (int j = 0; j < num; j++) {
            rbtns[j].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    JRadioButton tempbtn = (JRadioButton) evt.getSource();
                    if (tempbtn.isSelected()) {
                        tempbtn.setText("No");
                    } else {
                        tempbtn.setText("Yes");
                    }
                }

            });
        }
        // TODO: === Components of Panel 1=============

        JPanel line11 = new JPanel();
        line11.setBounds(0, 55, 1000, 8);
        // TODO: Last label and submit btn=========
        JPanel lastJPanel = new JPanel();
        lastJPanel.setBounds(200, 630, 1050, 40);
        findJLabel = new JLabel("Caculate the Maximum Profit : ");
        findJLabel.setFont(new java.awt.Font("Segoe UI", 1, 20));
        findJLabel.setBounds(0, 0, 300, 40);
        lastJPanel.setBackground(Color.black);
        findJLabel.setForeground(Color.white);
        ansJLabel = new JLabel("₹ 0.00");
        ansJLabel.setFont(new java.awt.Font("Segoe UI", 1, 20));
        ansJLabel.setForeground(Color.ORANGE);
        JButton SubmitBtn = new JButton("Submit");
        SubmitBtn.setBounds(600, 670, 300, 45);
        SubmitBtn.setBackground(Color.blue);
        SubmitBtn.setForeground(Color.white);
        SubmitBtn.setFont(new java.awt.Font("Segoe UI", 3, 18));
        SubmitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubmitBtn.setMargin(new java.awt.Insets(2, 17, 3, 17));
        billButton = new JButton("Generate Invoice");
        billButton.setBounds(950, 670, 300, 45);
        billButton.setBackground(Color.black);
        billButton.setForeground(Color.orange);
        billButton.setFont(new java.awt.Font("Segoe UI", 3, 19));
        billButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        billButton.setMargin(new java.awt.Insets(2, 17, 3, 17));
        add(billButton);
        billButton.setVisible(false);
        // add(SubmitBtn);
        SubmitBtn.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // add(billButton);

                jButton1ActionPerformed(evt);
            }
        });
        add(lastJPanel);
        lastJPanel.add(SubmitBtn);
        lastJPanel.add(findJLabel);
        lastJPanel.add(ansJLabel);
        add(SubmitBtn);
        JPanel panel2 = new JPanel();
        panel2.add(image);
        add(panel2);

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        checkFractinal = new boolean[num];
        for (int i = 0; i < num; i++) {
            checkFractinal[i] = rbtns[i].isSelected();
        }
        int fractionalSize = sizeOffractionalProduct(checkFractinal);
        String fracTotalString[][] = new String[fractionalSize][4];
        String NonfracTotalString[][] = new String[num - fractionalSize][4];
        String fracPname[] = new String[fractionalSize];
        int fracpweight[] = new int[fractionalSize];
        int fracprofit[] = new int[fractionalSize];
        int fracquantity[] = new int[fractionalSize];

        String totalString[] = new String[4 * num];
        String pname[] = new String[num - fractionalSize];
        int pweight[] = new int[num - fractionalSize];
        int profit[] = new int[num - fractionalSize];
        int quantity[] = new int[num - fractionalSize];

        int index = 0, indexX = 0, indexelse = 0, indexFornonFract = 0;
        for (int i = 0; i < num; i++) {
            // boolean value ke liye hai

            if (checkFractinal[i] == true) {
                int temp = 4 * i;
                for (; temp < 4 * (i + 1);) {
                    fracTotalString[indexX][index++] = array[temp].getText();
                    if (index >= 4) {
                        index = 0;
                    }
                    temp++;
                }
                indexX++;
                if (temp >= 4 * num)
                    break;

            } else {
                int temp1 = 4 * i;
                for (; temp1 < 4 * (i + 1);) {
                    NonfracTotalString[indexFornonFract][indexelse++] = array[temp1].getText();

                    if (indexelse >= 4) {
                        indexelse = 0;
                    }
                    temp1++;
                }
                indexFornonFract++;
                if (temp1 >= 4 * num)
                    break;
            }

        }
        String content[] = { "Product Name", "Weight", "Profit", "Quantity" };
        System.out.println("fractional part answer: ");
        for (int i = 0; i < fracTotalString.length; i++) {
            for (int j = 0; j < fracTotalString[i].length; j++) {
                System.out.println(content[j] + "-> " + fracTotalString[i][j]);
            }

        }
        System.out.println("Non fractional part answer: ");
        for (int i = 0; i < (num - fractionalSize); i++) {
            for (int j = 0; j < (NonfracTotalString[i].length); j++) {
                // System.out.println("Data : " + i + "--" + NonfracTotalString[i][j]);
                System.out.println(content[j] + "-> " + NonfracTotalString[i][j]);
            }

        }
        flag = false;
        for (int i = 0; i < 4 * num; i++) {
            totalString[i] = array[i].getText();
        }
        if (obj.checkBlankField(totalString)) {
            flag = true;
            JOptionPane.showMessageDialog(panel1, "Fill all the Boxes.. ", "Transport Bot",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                for (int i = 0; i < fractionalSize; i++) {
                    fracPname[i] = fracTotalString[i][0];
                    fracpweight[i] = Integer.parseInt(fracTotalString[i][1]);
                    fracprofit[i] = Integer.parseInt(fracTotalString[i][2]);
                    fracquantity[i] = Integer.parseInt(fracTotalString[i][3]);
                }
                for (int i = 0; i < num - fractionalSize; i++) {
                    pname[i] = NonfracTotalString[i][0];
                    pweight[i] = Integer.parseInt(NonfracTotalString[i][1]);
                    profit[i] = Integer.parseInt(NonfracTotalString[i][2]);
                    quantity[i] = Integer.parseInt(NonfracTotalString[i][3]);
                }
            } catch (Exception e) {
                // this.e=new Exception(e);
                flag = true;
                JOptionPane.showMessageDialog(panel1, "Weight and Profit must be numeric", "Transport Bot",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!flag) {
            int totalWeight[] = calculateTotal(quantity, pweight);
            int totalProfit[] = calculateTotal(quantity, profit);
            // int answer = knapSack(capacity, pweight, profit);
            if (totalProfit.length > 0) {

                // }
                int answer = knapSack(capacity, totalWeight, totalProfit);
                System.out.println(
                        "Remaining capacity from 0/1 knapsack= "
                                + remainingCapacity(answer, capacity, pweight, profit));
                knapFra = new KnapSackFractional();
                int totalWeightFract[] = calculateTotal(fracquantity, fracpweight);
                int totalProfitFract[] = calculateTotal(fracquantity, fracprofit);
                // knapFra.SortProfit(fracPname, fracpweight, fracprofit);
                knapFra.SortProfit(fracPname, totalWeightFract, totalProfitFract);
                double ans = knapFra.findCost(totalProfitFract, totalWeightFract, fracPname,
                        remainingCapacity(answer, capacity, totalWeight, totalProfit));
                System.out.println("Fractional part answer: " + profitAnswer);
                // ans += answer;
                profitAnswer=ans+answer;
                // ansJLabel.setText("₹ " + Double.toString(ans));
                ansJLabel.setText("₹ " + profitAnswer);
                int ff[] = findIndex(answer, capacity, pweight, profit);
                invoice = new String[ff.length][6];
                for (int i = 0; i < ff.length; i++) {
                    invoice[i][0]=""+(i+1);
                    invoice[i][1] = pname[ff[i]];
                    invoice[i][2] = Integer.toString(pweight[ff[i]]);
                    invoice[i][3] = Integer.toString(profit[ff[i]]);
                    invoice[i][4]= "" +quantity[ff[i]];
                    invoice[i][5]="No";
                    System.out.println(
                            "Name: ==>" + pname[ff[i]] + "Profit ==> " + profit[ff[i]] + "Weight==> " + pweight[ff[i]]);
                    // System.out.println("index place -> "+ff[i]);
                }
                for (int i = 0; i < invoice.length; i++) {
                    for (int j = 0; j < invoice[i].length; j++) {
                        System.out.println("check : " + invoice[i][j]);
                    }
                }
            } else {
                knapFra = new KnapSackFractional();
                int totalWeightFract[] = calculateTotal(fracquantity, fracpweight);
                int totalProfitFract[] = calculateTotal(fracquantity, fracprofit);
                 double ans = knapFra.findCost(totalProfitFract, totalWeightFract, fracPname,capacity);
                System.out.println("Fractional part answer: " + ans);
               
                // ansJLabel.setText("₹ " + Double.toString(ans));
                profitAnswer+=ans;
                ansJLabel.setText("₹ " + profitAnswer);

            }
            int decision=JOptionPane.showConfirmDialog(rootPane, "Generate Bill", "Transport Bot", JOptionPane.OK_CANCEL_OPTION);
            System.out.println("Generate bill + "+decision);
            if(decision==0){ 
                int numrows=invoice.length;

              new Bill(numrows-1, invoice).setVisible(true);;
            }

        }
        
        billButton.setVisible(true);

        // TODO add your handling code here:
    }

    private int[] calculateTotal(int qty[], int profit_weight[]) {
        int ans[] = new int[profit_weight.length];
        for (int i = 0; i < profit_weight.length; i++) {
            ans[i] = qty[i] * profit_weight[i];
        }
        return ans;
    }

    private void GenerateBill() {

    }

    private void fillData(String totalString[], String pname[], int pweight[], int profit[], int qty) {
        for (int f = 0; f < checkFractinal.length; f++) {

            if (checkFractinal[f]) {
                for (int i = 0; i < 3 * qty; i++) {
                    totalString[i] = array[i].getText();
                }
                if (obj.checkBlankField(totalString)) {
                    flag = true;
                    JOptionPane.showMessageDialog(panel1, "Fill all the Boxes ", "Transport Bot",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    try {
                        int temp = 0;
                        int index1 = 0, index2 = 0, index3 = 0;
                        // for (int i = 0; i < 3 * qty; i++) {
                        if (temp == 0) {
                            pname[index1] = array[f].getText();
                            index1++;
                        } else if (temp == 1) {
                            pweight[index2] = Integer.parseInt(array[f].getText());
                            index2++;

                        } else if (temp == 2) {
                            profit[index3] = Integer.parseInt(array[f].getText());
                            index3++;
                            temp = 0;
                            continue;
                        }
                        temp++;
                        // }
                    } catch (Exception e) {
                        // this.e=new Exception(e);
                        flag = true;
                        JOptionPane.showMessageDialog(panel1, "Weight and Profit must be numeric", "Transport Bot",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

    }

    private int sizeOffractionalProduct(boolean arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                sum++;
            }
        }
        return sum;
    }

    public static int remainingCapacity(int ans, int capacity, int pweight[], int profit[]) {
        int remainCap = 0;
        int tempSum = 0;
        for (int i = 0; i < pweight.length; i++) {
            tempSum += profit[i];
            remainCap += pweight[i];
            if (tempSum == ans) {
                // return remainCap;

                return (capacity - remainCap);
            }

        }
        return capacity;
    }

    public static int getSizeForIndex(int ans, int capacity, int pweight[], int profit[]) {
        int size = 0;
        int remainCap = 0;
        int tempSum = 0;
        for (int i = 0; i < pweight.length; i++) {
            tempSum += profit[i];
            remainCap += pweight[i];
            size++;
            if (tempSum == ans) {
                // return remainCap;

                return size;
            }

        }
        return size;
    }

    public static int[] findIndex(int ans, int capacity, int pweight[], int profit[]) {
        // int remainCap = 0;
        int tempSum = 0;
        int index[] = new int[getSizeForIndex(ans, capacity, pweight, profit)];
        for (int i = 0; i < pweight.length; i++) {
            tempSum += profit[i];
            // remainCap += pweight[i];
            index[i] = i;
            if (tempSum == ans) {
                // return remainCap;
                return index;
            }

        }

        return index;

    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void dispTwoarray(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int j = 0; j < arr2.length; j++) {
            System.out.print(arr2[j] + " ");
        }
    }

    public static void dispTable(int arr[][], int m, int n) {
        for (int l = 0; l <= 6 * m; l++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.print("  |");
            System.out.println();
        }
        for (int l = 0; l <= 6 * m; l++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static int knapSack(int weightBag, int weiProduct[], int profit[]) {
        // if (checkDuplicateItem(weiProduct)) {
        // System.out.println("Duplicate Weight found");
        // return 0;
        // }
        // firstly Sort the product weights
        // Rearrange the product price
        // weiProduct[weiProduct.length+1]=0;
        // profit[profit.length+1]=0;
        int n = weiProduct.length;
        for (int round = 0; round < n - 1; round++) {
            int minIndex = round;
            for (int i = round + 1; i < n; i++) {
                if (weiProduct[i] < weiProduct[minIndex]) {
                    minIndex = i;
                }
            }
            swap(weiProduct, minIndex, round);
            swap(profit, minIndex, round);
        }
        System.out.println("Displaying profits A/C to weight:");
        dispTwoarray(weiProduct, profit);
        System.out.println();
        int Table[][] = new int[n + 1][weightBag + 1];
        // for(int i=0;i<n;i++){
        // System.out.println(profit[i]);
        // }
        // int sum=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weightBag; j++) {
                if (weiProduct[i - 1] <= j) {
                    if (profit[i - 1] + Table[i - 1][j - weiProduct[i - 1]] < Table[i - 1][j])
                        // if(Table[i-1][j]>profit[i-1]){
                        Table[i][j] = Table[i - 1][j];
                    else {
                        Table[i][j] = profit[i - 1] + Table[i - 1][j - weiProduct[i - 1]];
                        // capacity=capacity-weiProduct[i-1];
                    }
                } else {
                    Table[i][j] = Table[i - 1][j];
                }

            }
        }
        System.out.println("\nDisplaying Table");
        dispTable(Table, n + 1, weightBag + 1);
        // System.out.println("Remaining capacity is : "+capacity);

        return Table[n][weightBag];
    }

    public static boolean checkDuplicateItem(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
                if (arr[i] <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Knap_Home ob = new Knap_Home(3, 600);
        ob.setSize(1920, 1080);
        // ob.setLayout(null);
        ob.setVisible(true);
        // String a="aman";

    }
}
