private void addActionPerformed(java.awt.event.ActionEvent evt) {                                    
         String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String password = "01234";
 
         String cn=car_name_txt.getText();
        String cap=capacity_txt.getText();
        String br=brand_txt.getText();
        String eng=engine_txt.getText();
        String fue=fuel_txt.getText();
        String mod=model_txt.getText();
 
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
 
            String sql = "insert into car_info (car_name,capacity,Brand,engine,fuel,model)" + " values (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
 
            statement.setString(1, cn);
              statement.setString(2, cap);
               statement.setString(3, br);
                statement.setString(4, eng);
                 statement.setString(5, fue);
                  statement.setString(6, mod);
 
            int row = statement.executeUpdate();
            if (row > 0) {
              
                JOptionPane.showMessageDialog(null,"car added");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }          
