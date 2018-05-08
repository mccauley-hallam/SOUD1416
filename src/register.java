import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class register extends javax.swing.JFrame {

    // Database details
    static final String DB_URL = "jdbc:derby://localhost/db_main";
    static final String USER = "db_admin";
    static final String PASS = "zAfevq4I1Fpy";
    
    DefaultListModel listModel = new DefaultListModel();
    
    // List Listener Store
    String selection, selectionFix;
    
    // Pass check variables
    Integer count = 0, num1, num2, num3, num4, pullPassword, passStudent, passStore
            , passW, statusCheck, opCheck = 0;
    String studentID = "", temp = "";
    
    // Time
    String currentTime;
    SimpleDateFormat format;
    Integer holdTime;
    
    // Class start
    Integer classStart = 1200;
    
    // Time store
    Integer intTimeIn, intTimeOut;
    
    // Main Init & List Listener
    public register() 
    {
        initComponents();

        earlylate();
        
        b1.setVisible(false); b2.setVisible(false); b3.setVisible(false); b4.setVisible(false); b5.setVisible(false); b6.setVisible(false); 
        b7.setVisible(false); b8.setVisible(false); b9.setVisible(false); b0.setVisible(false); 
        lDig1.setVisible(false); lDig2.setVisible(false); lDig3.setVisible(false); lDig4.setVisible(false); 
        bDel.setVisible(false); bConfirm.setVisible(false); lblTime.setVisible(false);
        
        listStudents.setModel(listModel);
        
        // Listener for list, updates labels according to what the user has pressed.
        listStudents.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent evt) 
            {
                // Checks if the value is changing (user selected another value)
                if (!evt.getValueIsAdjusting()) 
                {        
                    // Gets current selection
                    selection = listStudents.getSelectedValue().toString();
                    
                    // Error fixing
                    if(selection.contains("In"))
                    {
                        // Removes ' | Signed In', eg '1111 | Signed In' > '111'
                        selectionFix = selection.replace(" | Signed In", "");
                    }
                    else
                    {
                        // Removes ' | Signed Out', eg '1111 | Signed Out' > '111'
                        selectionFix = selection.replace(" | Signed Out", "");
                    }
                    
                    // Update details
                    lblStudentID.setText("ID | " + selectionFix);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listStatus = new javax.swing.JScrollPane();
        listStudents = new javax.swing.JList<>();
        btnSignOut = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        btnSelectClass = new javax.swing.JButton();
        lblStudentID = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        lblStartTime = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        selectedClass = new javax.swing.JComboBox<>();
        lDig1 = new javax.swing.JLabel();
        lDig3 = new javax.swing.JLabel();
        lDig2 = new javax.swing.JLabel();
        lDig4 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        bConfirm = new javax.swing.JButton();
        bDel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listStudents.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listStatus.setViewportView(listStudents);

        btnSignOut.setText("Sign Out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        btnSignIn.setText("Sign In");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        btnSelectClass.setText("Enter");
        btnSelectClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectClassActionPerformed(evt);
            }
        });

        lblStudentID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblStudentID.setText("ID | ");

        lblClass.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblClass.setText("Class |");

        lblStartTime.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblStartTime.setText("Starts |");

        lblStatus.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblStatus.setText("Status |");
        lblStatus.setToolTipText("");

        selectedClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOUD1416" }));

        lDig1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lDig1.setText("-");

        lDig3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lDig3.setText("-");

        lDig2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lDig2.setText("-");

        lDig4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lDig4.setText("-");

        b1.setText("1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setText("2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setText("3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b0.setText("0");
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });

        b4.setText("4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setText("5");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setText("6");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b8.setText("8");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b7.setText("7");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b9.setText("9");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        bConfirm.setText("Confirm");
        bConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmActionPerformed(evt);
            }
        });

        bDel.setText("Del");
        bDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelActionPerformed(evt);
            }
        });

        jButton1.setText("Admin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTime.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStudentID)
                            .addComponent(lblClass)
                            .addComponent(lblStartTime)
                            .addComponent(lblStatus)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectedClass, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSelectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bDel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lDig1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(lDig2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lDig3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTime)
                                    .addComponent(lDig4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSelectClass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectedClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStudentID)
                            .addComponent(lblTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStartTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStatus)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lDig1)
                            .addComponent(lDig3)
                            .addComponent(lDig2)
                            .addComponent(lDig4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b0, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bDel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Function for pulling the current time
    public void earlylate()
    {
        currentTime = new SimpleDateFormat("HHmm").format(new Date());
	format = new SimpleDateFormat("HHmm");
                
        System.out.println("currentTime = " + currentTime);
    }
    
    // Function for pulling items to the list view
    public void pullItems()
    {
        listModel.clear();
        
        lblTime.setVisible(true);
        lblTime.setText("Time | " + currentTime);
        
        holdTime = Integer.parseInt(currentTime.toString());
        
        /* Work out if the student is too early to sign in, prevents them signing in in advance /
        if(classStart - holdTime > 30)
        {
            btnSignOut.setVisible(false); btnSignIn.setVisible(false);
            
            // Alert Message
            JOptionPane.showMessageDialog(null,"You are too early to sign in, "
                    + "you have a 30 minute window to sign in before your class starts.", "", JOptionPane.INFORMATION_MESSAGE);
        }*/

        // Calculations for early/late
        if(holdTime < classStart)
        {
            lblTime.setText("Time | " + currentTime + " (early)");
        }
        else
        {
            lblTime.setText("Time | " + currentTime + " (late)");
        }
        
        // Connector setup
        java.sql.Connection conn = null;
        Statement stmt1 = null;
        
        // Listener hook
        String userInput = selectedClass.getSelectedItem().toString();
        
        // Class selection
        if(userInput.equalsIgnoreCase("soud1416"))
        {
            lblClass.setText("Class | SOUD1416"); // Class Set
            lblStartTime.setText("Starts | 12:00 - 14:00"); // Time of class
            
            try
            {
                // Initialize Driver
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                // Connection Info
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt1 = conn.createStatement();

                // Query
                String sql1 = "SELECT * FROM tbl_class_soud1416";
                
                ResultSet result1 = stmt1.executeQuery(sql1);
                
                // Pull results
                while(result1.next())
                {
                    // Pull student number and status
                    Integer studentNumber = result1.getInt("studentNumber");
                    String status = result1.getString("status");
                    
                    // Add previous values to a list
                    listModel.addElement(studentNumber + " | " + status);
                }
                // Close connection, statement etc
                result1.close();
                stmt1.close();
                conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    // Pull Items to List
    private void btnSelectClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectClassActionPerformed
        pullItems();
    }//GEN-LAST:event_btnSelectClassActionPerformed

    // 1
    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if(count == 0)
        {
            num1 = 1;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 1;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 1;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 1;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b1ActionPerformed

    // 2
    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        if(count == 0)
        {
            num1 = 2;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 2;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 2;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 2;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b2ActionPerformed

    // 3
    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        if(count == 0)
        {
            num1 = 3;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 3;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 3;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 3;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b3ActionPerformed

    // 4
    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        if(count == 0)
        {
            num1 = 4;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 4;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 4;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 4;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b4ActionPerformed

    // 5
    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        if(count == 0)
        {
            num1 = 5;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 5;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 5;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 5;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b5ActionPerformed

    // 6
    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        if(count == 0)
        {
            num1 = 6;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 6;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 6;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 6;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b6ActionPerformed

    // 7
    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        if(count == 0)
        {
            num1 = 7;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 7;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 7;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 7;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b7ActionPerformed

    // 8
    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        if(count == 0)
        {
            num1 = 8;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 8;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 8;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 8;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b8ActionPerformed

    // 9
    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        if(count == 0)
        {
            num1 = 9;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 9;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 9;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 9;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b9ActionPerformed

    // 0
    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        if(count == 0)
        {
            num1 = 0;
            lDig1.setText("*");
            count++;
        }
        else if(count == 1)
        {
            num2 = 0;
            lDig2.setText("*");
            count++;
        }
        else if(count == 2)
        {
            num3 = 0;
            lDig3.setText("*");
            count++;
        }
        else if(count == 3)
        {
            num4 = 0;
            lDig4.setText("*");
        }
    }//GEN-LAST:event_b0ActionPerformed

    // Delete Digit
    private void bDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelActionPerformed
        if(count == 1)
        {
            count--;
            lDig1.setText("-");
        }
        else if(count == 2)
        {
            count--;
            lDig2.setText("-");
        }
        else if(count == 3)
        {
            count--;
            lDig3.setText("-");
            num3 = null;
        }
        else if(count == 4)
        {
            count--;
            lDig4.setText("-");
            num4 = null;
        }
    }//GEN-LAST:event_bDelActionPerformed

    // Confirm Password
    private void bConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmActionPerformed
        // Connector Setup
        java.sql.Connection conn = null;
        Statement stmt1 = null;
                
        // Sign In
        if(opCheck == 1)
        {
            try
            {                
                // Initialize Driver
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                // Connection Info
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt1 = conn.createStatement();
                
                // Query
                String sql1 = "SELECT * FROM tbl_class_soud1416 WHERE studentNumber = " + selectionFix + "";
                System.out.println("Initial Pull - " + sql1);
                
                ResultSet result1 = stmt1.executeQuery(sql1);

                // Pull Results
                while(result1.next())
                {
                    // Pull users password, store locally for later comparison
                    passStore = result1.getInt("password");
                    System.out.println("Stored - " + passStore);
                }
            // Close connection, statement etc
            result1.close();
            stmt1.close();
            conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
            catch(Exception e)
            {   
                e.printStackTrace();
            }

            // Conversions
            temp = num1.toString() + num2.toString() + num3.toString() + num4.toString();
            passW = Integer.parseInt(temp);
            System.out.println("Entered Password - " + temp); // Show Password

            System.out.println("Stored ID - " + selectionFix.toString()); // Show Student ID

            /*
                .compareTo will output a value of -1, 0 or 1. Guide below...
                -1: Int 1 < Int 2
                0: Int 1 = Int 2
                1: Int 1 > Int 2
            */
            
            Integer check = passStore.compareTo(passW);
            System.out.println("Output of check - " + check);

            if(check == 0) // passStore == passW
            {
                try
                {
                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    stmt1 = conn.createStatement();
                    
                    String sql1 = "SELECT * FROM tbl_class_soud1416 WHERE studentNumber = " + selectionFix.toString() + " AND password = "
                            + passStore.toString() + "";
                    System.out.println(sql1);

                    String sql2 = "UPDATE tbl_class_soud1416 " + "SET status = ? WHERE studentNumber = ? AND password = ?";
                    String sql4 = "UPDATE tbl_class_soud1416 " + "SET timeIn = ? WHERE studentNumber = ? AND password = ?";
                                        
                    PreparedStatement ps = conn.prepareStatement(sql2);
                    ps.setString(1, "Signed In");
                    ps.setInt(2, Integer.parseInt(selectionFix));
                    ps.setInt(3, passW);
                    ps.executeUpdate();
                    ps.close();
                    System.out.println("Update 1 - " + sql2);
                    
                    PreparedStatement ps2 = conn.prepareStatement(sql4);
                    ps2.setInt(1, holdTime);
                    ps2.setInt(2, Integer.parseInt(selectionFix));
                    ps2.setInt(3, passW);
                    ps2.executeUpdate();
                    ps2.close();
                    System.out.println("Update 2 - " + sql4);
                    
                    ResultSet result1 = stmt1.executeQuery(sql1);

                    System.out.println("Going to result set");
                    
                    while(result1.next())
                    {
                        // Pull status & password
                        String pullStatus = result1.getString("status");
                        pullPassword = result1.getInt("password");
                        System.out.println("Query Pull - " + pullStatus + " " + pullPassword);
                    }
                    pullItems();
                    result1.close();
                    stmt1.close();
                    conn.close();
                }
                catch(SQLException se)
                {
                    se.printStackTrace();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("Student Signed In");
                
                b1.setVisible(false); b2.setVisible(false); b3.setVisible(false); b4.setVisible(false); b5.setVisible(false); b6.setVisible(false); 
                b7.setVisible(false); b8.setVisible(false); b9.setVisible(false); b0.setVisible(false); 
                lDig1.setVisible(false); lDig2.setVisible(false); lDig3.setVisible(false); lDig4.setVisible(false); 
                bDel.setVisible(false); bConfirm.setVisible(false); 
                
                //Success Message
                JOptionPane.showMessageDialog(null,"You have been signed in", "Success: Signed In", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(check != 0) // passStore != passW
            {
                // Reset Entries
                num1 = 0; num2 = 0; num3 = 0; num4 = 0; count = 0;
                lDig1.setText("-"); lDig2.setText("-"); lDig3.setText("-"); lDig4.setText("-"); 

                // Error Message
                JOptionPane.showMessageDialog(null,"Please try again", "Error: Wrong Password", JOptionPane.WARNING_MESSAGE);
            }
        }
        // Sign Out
        else if (opCheck == 2)
        {
            try
            {                
                // Initialize Driver
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                // Connection Info
                conn = DriverManager.getConnection(DB_URL,USER,PASS);
                stmt1 = conn.createStatement();
                
                // Query
                String sql1 = "SELECT * FROM tbl_class_soud1416 WHERE studentNumber = " + selectionFix + "";
                System.out.println("Initial Pull - " + sql1);
                
                ResultSet result1 = stmt1.executeQuery(sql1);

                // Pull Results
                while(result1.next())
                {
                    // Pull users password, store locally for later comparison
                    passStore = result1.getInt("password");
                    System.out.println("Stored - " + passStore);
                }
            // Close connection, statement etc
            result1.close();
            stmt1.close();
            conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
            catch(Exception e)
            {   
                e.printStackTrace();
            }

            // Conversions
            temp = num1.toString() + num2.toString() + num3.toString() + num4.toString();
            passW = Integer.parseInt(temp);
            System.out.println("Entered Password - " + temp); // Show Password

            System.out.println("Stored ID - " + selectionFix.toString()); // Show Student ID

            /*
                .compareTo will output a value of -1, 0 or 1. Guide below...
                -1: Int 1 < Int 2
                0: Int 1 = Int 2
                1: Int 1 > Int 2
            */
            
            Integer check = passStore.compareTo(passW);
            System.out.println("Output of check - " + check);

            // Begin status update, password checking
            if(check == 0) // passStore == passW
            {
                try
                {
                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    stmt1 = conn.createStatement();
                    
                    //String sql1 = "SELECT * FROM tbl_class_soud1416 WHERE studentNumber = " + selectionFix + " AND password = " + passStore + "";
                    //System.out.println("- " + sql1);

                    String sql2 = "UPDATE tbl_class_soud1416 " + "SET status = ? WHERE studentNumber = ? AND password = ?";
                    String sql4 = "UPDATE tbl_class_soud1416 " + "SET timeOut = ? WHERE studentNumber = ? AND password = ?";
                    
                    String sql3 = "SELECT * FROM tbl_class_soud1416";
                    
                    PreparedStatement ps = conn.prepareStatement(sql2);
                    ps.setString(1, "Signed Out");
                    ps.setInt(2, Integer.parseInt(selectionFix));
                    ps.setInt(3, passW);
                    ps.executeUpdate();
                    ps.close();
                    System.out.println("Update 1 - " + sql2);
                    
                    PreparedStatement ps2 = conn.prepareStatement(sql4);
                    ps2.setInt(1, holdTime);
                    ps2.setInt(2, Integer.parseInt(selectionFix));
                    ps2.setInt(3, passW);
                    ps2.executeUpdate();
                    ps2.close();
                    System.out.println("Update 2 - " + sql4);
                    
                    ResultSet result1 = stmt1.executeQuery(sql3);
                    
                    while(result1.next())
                    {
                        Integer studentNumber = result1.getInt("studentNumber");
                        String status = result1.getString("status");
                        
                        listModel.addElement(studentNumber + " | " + status);
                    }
                    pullItems();
                    result1.close();
                    stmt1.close();
                    conn.close();
                }
                catch(SQLException se)
                {
                    se.printStackTrace();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("Student Signed Out");
                
                b1.setVisible(false); b2.setVisible(false); b3.setVisible(false); b4.setVisible(false); b5.setVisible(false); b6.setVisible(false); 
                b7.setVisible(false); b8.setVisible(false); b9.setVisible(false); b0.setVisible(false); 
                lDig1.setVisible(false); lDig2.setVisible(false); lDig3.setVisible(false); lDig4.setVisible(false); 
                bDel.setVisible(false); bConfirm.setVisible(false); 
                
                //Success Message
                JOptionPane.showMessageDialog(null,"You have been signed out", "Success: Signed Out", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(check != 0) // passStore != passW
            {
                // Reset Entries
                num1 = 0; num2 = 0; num3 = 0; num4 = 0; count = 0;
                lDig1.setText("-"); lDig2.setText("-"); lDig3.setText("-"); lDig4.setText("-"); 

                // Error Message
                JOptionPane.showMessageDialog(null,"Please try again", "Error: Wrong Password", JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Something went wrong! Please try again.", "Unexpected Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bConfirmActionPerformed

    // Sign In
    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        opCheck = 1;
        System.out.println(opCheck);
        
        b1.setVisible(true); b2.setVisible(true); b3.setVisible(true); b4.setVisible(true); b5.setVisible(true); b6.setVisible(true); 
        b7.setVisible(true); b8.setVisible(true); b9.setVisible(true); b0.setVisible(true); 
        lDig1.setVisible(true); lDig2.setVisible(true); lDig3.setVisible(true); lDig4.setVisible(true); 
        bDel.setVisible(true); bConfirm.setVisible(true); 
    }//GEN-LAST:event_btnSignInActionPerformed

    // Sign Out
    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        opCheck = 2;
        System.out.println(opCheck);
        
        b1.setVisible(true); b2.setVisible(true); b3.setVisible(true); b4.setVisible(true); b5.setVisible(true); b6.setVisible(true); 
        b7.setVisible(true); b8.setVisible(true); b9.setVisible(true); b0.setVisible(true); 
        lDig1.setVisible(true); lDig2.setVisible(true); lDig3.setVisible(true); lDig4.setVisible(true); 
        bDel.setVisible(true); bConfirm.setVisible(true); 
    }//GEN-LAST:event_btnSignOutActionPerformed

    // Admin Panel
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new admin().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b0;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton bConfirm;
    private javax.swing.JButton bDel;
    private javax.swing.JButton btnSelectClass;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lDig1;
    private javax.swing.JLabel lDig2;
    private javax.swing.JLabel lDig3;
    private javax.swing.JLabel lDig4;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblStartTime;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblTime;
    private javax.swing.JScrollPane listStatus;
    private javax.swing.JList<String> listStudents;
    private javax.swing.JComboBox<String> selectedClass;
    // End of variables declaration//GEN-END:variables
}
