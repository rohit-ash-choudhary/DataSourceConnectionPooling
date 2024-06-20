package com.sp.maim;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionPoolApp {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&allowPublicKeyRetrieval=true";
        String dbUsername = "root";
        String dbPassword = "Rooh@#2001";
        HikariConfig hconfig=new HikariConfig();
        hconfig.setJdbcUrl(dbUrl);
        hconfig.setUsername(dbUsername);
        hconfig.setPassword(dbPassword);
        hconfig.setMaximumPoolSize(19);

        HikariDataSource dataSource=new HikariDataSource();

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
