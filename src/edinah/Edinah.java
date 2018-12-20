/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edinah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author support
 */
public class Edinah {
    Connection con = null;
    PreparedStatement psmt = null;
    ResultSet rs;
    String name = "";
    String mobile = "";
    
    String query = "select destination_addr as mobile , CONCAT(firstname,\" \", surname) as name from tUSER WHERE max_total<100 ";

    public Edinah() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbSMS?useSSL=false","mysql","mysql123");
            psmt= con.prepareStatement(query);
            rs = psmt.executeQuery();
            
            while(rs.next()){
                name = rs.getString("name");
                mobile = rs.getString("mobile");
                
                System.out.println(mobile + "\tDear " + name + " Your Balance is below 100 SMS\t MSpace");
            }
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        System.exit(0);
        //System.out.println("0702042137\t Dear Edinah, Test Print\t MSpace");
        //System.exit(0);
    }

    
    public static void main(String[] args) {
        new Edinah();
    }
    
}
