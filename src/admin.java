import javax.swing.DefaultListModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class admin extends javax.swing.JFrame {

    // Database details
    static final String DB_URL = "jdbc:derby://localhost/db_main";
    static final String USER = "db_admin";
    static final String PASS = "zAfevq4I1Fpy";
    
    // List Listener Store
    String selection, selectionFix;
    
    // Pass store
    String admPass;
    
    DefaultListModel listModel = new DefaultListModel();
    
    public admin() 
    {
        initComponents();
        
        listStudents.setVisible(false); btnEnter.setVisible(false); selectedClass.setVisible(false); lblStudentID.setVisible(false); lblClass.setVisible(false);
        btnSignIn.setVisible(false); btnSignOut.setVisible(false);
        
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
        
        // Connector setup
        java.sql.Connection conn = null;
        Statement stmt1 = null;
        
        try
        {
            // Initialize Driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            // Connection Info
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt1 = conn.createStatement();

            // Query
            String sql1 = "SELECT password FROM TBL_USERS WHERE username = 'admin'";
            
            ResultSet result1 = stmt1.executeQuery(sql1);
                
            // Pull results
            while(result1.next())
            {
                String pullPass = result1.getString("PASSWORD");
                admPass = pullPass;
            }
            System.out.println("DB Pull - " + admPass);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectedClass = new javax.swing.JComboBox<>();
        btnEnter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listStudents = new javax.swing.JList<>();
        lblStudentID = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        enteredPass = new javax.swing.JPasswordField();
        btnSignOut = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectedClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOUD1416" }));

        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        listStudents.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listStudents);

        lblStudentID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblStudentID.setText("ID | ");

        lblClass.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblClass.setText("Class | ");

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectedClass, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnter))
                    .addComponent(lblStudentID)
                    .addComponent(lblClass)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enteredPass, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirm)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectedClass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStudentID)
                        .addGap(26, 26, 26)
                        .addComponent(lblClass)
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(btnSignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirm)
                            .addComponent(enteredPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Pull Students
    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        listModel.clear();
        
        // Connector setup
        java.sql.Connection conn = null;
        Statement stmt1 = null;
                
        // Listener hook
        String userInput = selectedClass.getSelectedItem().toString();
        
        // Class selection
        if(userInput.equalsIgnoreCase("soud1416"))
        {
            lblClass.setText("Class | SOUD1416"); // Class Set
            
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
    }//GEN-LAST:event_btnEnterActionPerformed

    // Confirm Password
    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        char []passChars = enteredPass.getPassword();
        String passString = new String(passChars);
        System.out.println("passChars - " + passChars);
        System.out.println("passString - " + passString);
        
        if(!passString.equals(admPass))
        {
            enteredPass.setText("");
            
            System.out.println(passChars + " = " + admPass);
            
            // Error Message
            JOptionPane.showMessageDialog(null,"Please try again", "Error: Wrong Password", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            enteredPass.setVisible(false); btnConfirm.setVisible(false);
            listStudents.setVisible(true); btnEnter.setVisible(true); selectedClass.setVisible(true); lblStudentID.setVisible(true); lblClass.setVisible(true);
            btnSignIn.setVisible(true); btnSignOut.setVisible(true);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    // Sign Student In
    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        // Connector setup
        java.sql.Connection conn = null;
        Statement stmt1 = null;
           
        try
        {
            // Initialize Driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            // Connection Info
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt1 = conn.createStatement();

            // Query
            String sql1 = "UPDATE tbl_class_soud1416 " + "SET status = ? WHERE studentNumber = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, "Signed In");
            ps.setString(2, selectionFix);
            ps.executeUpdate();
            ps.close();
            
            // Close connection, statement etc
            stmt1.close();
            conn.close();
            
            // Alert Message
            JOptionPane.showMessageDialog(null,"Student " + selectionFix + " signed in.", "Success: Student Signed In", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    // Sign Student Out
    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // Connector setup
        java.sql.Connection conn = null;
        Statement stmt1 = null;
           
        try
        {
            // Initialize Driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            // Connection Info
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt1 = conn.createStatement();

            // Query
            String sql1 = "UPDATE tbl_class_soud1416 " + "SET status = ? WHERE studentNumber = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, "Signed Out");
            ps.setString(2, selectionFix);
            ps.executeUpdate();
            ps.close();
            
            // Close connection, statement etc
            stmt1.close();
            conn.close();
            
            // Alert Message
            JOptionPane.showMessageDialog(null,"Student " + selectionFix + " signed out.", "Success: Student Signed Out", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSignOutActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JPasswordField enteredPass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JList<String> listStudents;
    private javax.swing.JComboBox<String> selectedClass;
    // End of variables declaration//GEN-END:variables
}
