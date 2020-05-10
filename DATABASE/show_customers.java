//this code is for showing the customers list 

package rapid.rentals;
import net.proteanit.sql.DbUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class show_customers extends javax.swing.JFrame {

    /**
     * Creates new form show_customers
     */
    public show_customers() {
        initComponents();
        DisplayTable();
    }

    private void DisplayTable(){
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","01234");
           String loginTable="SELECT * FROM login.login_info" ;
           PreparedStatement psmt=conn.prepareStatement(loginTable);
           ResultSet rs=psmt.executeQuery();
           login_table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
