/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.DAO;

import com.intvaria.connections.DBConnection;
import com.intvaria.entity.PackageDetails;
import com.intvaria.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dhanushka
 */
public class PackageDAO {
    
    Connection con=null;
    
    public boolean savePackage(PackageDetails packageDetails ){
        
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        
        try {
            sql="insert into package (name,valid_months,price) values (?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, packageDetails.getName());
            ps.setInt(2, packageDetails.getValidTime());
            ps.setDouble(3, packageDetails.getPrice());
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("package save failed "+e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public List<PackageDetails> getAllPackages(){
        con=DBConnection.connect();
        List<PackageDetails> packageList=new ArrayList<>();
        PackageDetails pack=null;
        Statement st;
        ResultSet rs;
        String sql;
        
        try {
            sql="select * from package";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                pack=new PackageDetails();
                pack.setName(rs.getString("name"));
                pack.setPackageId(rs.getInt("package_id"));
                pack.setPrice(rs.getDouble("price"));
                pack.setValidTime(rs.getInt("valid_months"));
                packageList.add(pack);
            }
        } catch (SQLException e) {
            System.out.println("error on get all packaged "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
       return packageList;
    }
    
    public boolean updatePackage(PackageDetails packDetails){
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        
        try {
            sql="update package set name=? , valid_months =? , price=? where package_id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, packDetails.getName());
            ps.setInt(2, packDetails.getValidTime());
            ps.setDouble(3, packDetails.getPrice());
            ps.setInt(4, packDetails.getPackageId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
        System.out.println("package update failed "+e);
        return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }
    
     public boolean deletePackage(int id){
        
        con=DBConnection.connect();
        PreparedStatement ps;
        
        
        try {
           
             String sql="delete from package where package_id=?";
            ps=con.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
            
           
        } catch (SQLException e) {
            System.out.println("package delete failed "+e);
            return false;
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
   
     
     public PackageDetails getPackegeByName(String name){
         
         con=DBConnection.connect();
         PreparedStatement ps;
         ResultSet rs;
         String sql;
         PackageDetails pck=new PackageDetails();

         try {
             sql="select * from package where name=?";
             ps=con.prepareStatement(sql);
             ps.setString(1, name);
             rs=ps.executeQuery();
             if(rs.next()){
                 pck.setName(rs.getString("name"));
                 pck.setPackageId(rs.getInt("package_id"));
                 pck.setPrice(rs.getDouble("price"));
                 pck.setValidTime(rs.getInt("valid_months"));
             }
             
         } catch (SQLException e) {
             System.out.println("error on get package by name "+e);
         }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         return pck;
         
     }
     
     
     
      public PackageDetails getPackegeById(int id){
         
         con=DBConnection.connect();
         PreparedStatement ps;
         ResultSet rs;
         String sql;
         PackageDetails pck=new PackageDetails();

         try {
             sql="select * from package where package_id=?";
             ps=con.prepareStatement(sql);
             ps.setInt(1, id);
             rs=ps.executeQuery();
             if(rs.next()){
                 pck.setName(rs.getString("name"));
                 pck.setPackageId(rs.getInt("package_id"));
                 pck.setPrice(rs.getDouble("price"));
                 pck.setValidTime(rs.getInt("valid_months"));
             }
             
         } catch (SQLException e) {
             System.out.println("error on get package by name "+e);
         }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         return pck;
         
     }
    
}
