
package rapid_rentals;
import javax.swing.JOptionPane;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerLogin extends javax.swing.JFrame {

    /**
     * Creates new form CustomerLogin
     */
   /**
   **/
    public CustomerLogin() {
       
        initComponents();
    }

    private void LOGIN_jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGIN_jToggleButton1ActionPerformed
        String pass1=PASSWORD_TEXT.getText();
         String name1 =NAME_TEXT.getText();
        
        try
        {
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login",
                        "root", "01234");
            PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select name, password from login_info where name=? and password=?");
                   st.setString(1,name1);
                   st.setString(2,pass1);
                  
            
           
            ResultSet rs=st.executeQuery();
            if(rs.next())
            {
                CustomerShow_BookCar obj=new CustomerShow_BookCar();
                obj.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Login Failed.Please Try Again");
                dispose();
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
