/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.DAO;

import com.intvaria.connections.DBConnection;
import com.intvaria.entity.Fianace;
import com.intvaria.entity.Item;
import com.intvaria.entity.Sale;
import com.intvaria.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dhanushka
 */
public class SaleDAO {
    
    Connection con;
    
    public boolean saveSale(Sale sale) throws ParseException{
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDateTime endLocalDate=LocalDateTime.now();
              String endDateFroamt=dtf.format(endLocalDate);
               Date date=null;
               StockDAO stockDAO=new StockDAO();
             
       date=new SimpleDateFormat("yyyy-MM-dd").parse(endDateFroamt);
        try {
            sql="insert into sale (item_id,qty,price,discount,user_id,date,status) values (?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setInt(1, sale.getItem_id());
            ps.setInt(2, sale.getQty());
            ps.setDouble(3, sale.getPrice());
            ps.setDouble(4, sale.getDiscount());
            ps.setLong(5, sale.getUser_id());
            ps.setDate(6, new java.sql.Date(date.getTime()));
            ps.setBoolean(7, false);
            ps.executeUpdate();
            int qty=sale.getQty();
            boolean isSaved=stockDAO.updateStockByUserId(sale.getItem_id(),sale.getUser_id() ,qty );
          
            if(isSaved==true){
               
                  return true;   
                
            }else{
                return false;
            }
           
        } catch (SQLException e) { 
            System.out.println("error on save sale "+e);
            return false;
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public List<Sale> getAllNotCheckedSales(){
        
       List<Sale> saleList=new ArrayList<>();
       UserDAO userDao=new UserDAO();
        StockDAO stockDao=new StockDAO();
       con=DBConnection.connect();
       PreparedStatement ps;
        ResultSet rs;
        String sql;
        User user=null;
        Item item=null;
        Sale sale=null;
        
        try {
            sql="select * from sale where status = ?  order by date desc";
            ps=con.prepareStatement(sql);
            ps.setBoolean(1, false);
            rs=ps.executeQuery();
            while(rs.next()){
                sale=new Sale();
                sale.setDate(rs.getDate("date"));
                sale.setQty(rs.getInt("qty"));
                sale.setPrice(rs.getDouble("price"));
                sale.setDiscount(rs.getDouble("discount"));
                user=userDao.getUserById(rs.getLong("user_id"));
                sale.setUser(user);
                item=stockDao.getItemById(rs.getInt("item_id"));
                sale.setItem(item);
                sale.setStatus(rs.getBoolean("status"));
                saleList.add(sale);
            }
            
        } catch (SQLException e) {
            System.out.println("error on get all unchecked sales "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return saleList;
        
    }
    
     public List<Sale> searchSales(int stock , int status ){
        
       List<Sale> saleList=new ArrayList<>();
       List<User> userList=new ArrayList<>();
       UserDAO userDao=new UserDAO();
        StockDAO stockDao=new StockDAO();
       con=DBConnection.connect();
       PreparedStatement ps;
       Long userId = null;
        ResultSet rs;
        String sql="";
        User user=null;
        Item item=null;
        Sale sale=null;
        boolean type = false;
        
        if(status==0){
            type=false;
        }else if(status==1){
            type= true;
        }
        
        try {
            userList=userDao.getAllUsersByType("coach");
            if(stock!=0){
                userId=userList.get(stock-1).getUserId();
            }
          if(stock==0){
                if(status==2){
                      sql="select * from sale order by date desc";
                       ps=con.prepareStatement(sql);
                }else{
                    sql="select * from sale where status = ?  order by date desc";
                     ps=con.prepareStatement(sql);
                      ps.setBoolean(1, type);
                }
            }else{
               if(status==2){
                     sql="select * from sale where user_id=? order by date desc";
                      ps=con.prepareStatement(sql);
                      ps.setLong(1, userId);
                }else{
                     sql="select * from sale where user_id=? and status=? order by date desc";
                      ps=con.prepareStatement(sql);
                      ps.setLong(1, userId);
                       ps.setBoolean(2, type);
                
                }  
            }
           
           
           
            rs=ps.executeQuery();
            while(rs.next()){
                sale=new Sale();
                sale.setDate(rs.getDate("date"));
                sale.setQty(rs.getInt("qty"));
                sale.setPrice(rs.getDouble("price"));
                sale.setDiscount(rs.getDouble("discount"));
                user=userDao.getUserById(rs.getLong("user_id"));
                sale.setUser(user);
                item=stockDao.getItemById(rs.getInt("item_id"));
                 sale.setStatus(rs.getBoolean("status"));
                sale.setItem(item);
                saleList.add(sale);
            }
            
        } catch (SQLException e) {
            System.out.println("error on search sales "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return saleList;
        
    }
     
     public boolean updateStatus(){
         con=DBConnection.connect();
         PreparedStatement ps;
         String sql;
         
         try {
             sql="update sale set status=? where status=?";
             ps=con.prepareCall(sql);
             ps.setBoolean(1, true);
             ps.setBoolean(2, false);
             ps.executeUpdate();
             return true;
             
         }catch (SQLException e) {
            System.out.println("error on get all uupdate status of sale "+e);
            return false;
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
     }
    
}
