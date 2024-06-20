package com.sp.maim;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.*;
import java.sql.*;
public class App1 {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true";
        String dbUsername = "root";
        String dbPassword = "Rooh@#2001";
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setURL(dbUrl);
        dataSource.setUser(dbUsername);
        dataSource.setPassword(dbPassword);

        try(Connection con=dataSource.getConnection();
            PreparedStatement pt=con.prepareStatement("insert into account values(?,?,?,?)");

                ){

            pt.setInt(1,1001);
            pt.setString(2,"Ashh");
            pt.setString(3,"Choud");
            pt.setInt(4, 9000);

            int count=pt.executeUpdate();
            if(count>0)
            {
                System.out.println("Inserted data Successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
