/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.DAO;

import com.intvaria.connections.DBConnection;
import com.intvaria.entity.Item;
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
public class UserDAO {
    
    Connection con=null;
   
    public User getUserByUserName(String username){
        User user=null;
        con=DBConnection.connect();
        
        try {
            String sql="select * from user where username = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                user=new User();
                user.setUserId(rs.getLong("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setNic(rs.getString("nic"));
                user.setMobile(rs.getString("mobile_number"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("user_type"));
            }else{
                System.out.println("user not found");
            }
            
        } catch (SQLException e) {
            System.out.println("found error on getUserByUserName "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return user;
    }
    
    
    public User getUserById(Long id){
        User user=null;
        con=DBConnection.connect();
        
        try {
            String sql="select * from user where user_id = ?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                user=new User();
                user.setUserId(rs.getLong("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setNic(rs.getString("nic"));
                user.setMobile(rs.getString("mobile_number"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("user_type"));
            }else{
                System.out.println("user not found");
            }
            
        } catch (SQLException e) {
            System.out.println("found error on getUserByUserName "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return user;
    }
    
    
    public boolean updateLoginStaus(boolean status , Long userId){
        con=DBConnection.connect();
        String sql;
        PreparedStatement ps=null;
        
        try {
            sql="update user set login_status=? where user_id= ?";
            ps=con.prepareStatement(sql);
            ps.setBoolean(1, status);
            ps.setLong(2, userId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("login status not updated "+e );
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean saveUser(User user) {
         StockDAO stockDao=new StockDAO();
      List<Item> itemList=stockDao.getAllItems();
        con=DBConnection.connect();
        PreparedStatement ps=null;
        String sql=null;
      
        User lastUser;
        List<User> userList= new ArrayList<>();
        try {
            sql="insert into user (username,password,user_type,first_name,last_name,nic,mobile_number) values (?,?,?,?,?,?,?) ";
           ps= con.prepareStatement(sql);
            if(user!=null){
                
                  ps.setString(1, user.getUserName());
                  ps.setString(2, user.getPassword());
                  ps.setString(3, user.getUserType());
                  ps.setString(4, user.getFirstName());
                  ps.setString(5, user.getLastName());
                  ps.setString(6, user.getNic());
                  ps.setString(7, user.getMobile());
                  
                  ps.executeUpdate();
                  
                  if(itemList.size()>0){
                    lastUser=getLastUser();
                    con=DBConnection.connect();
                    userList.add(lastUser);
                    boolean isSaved;
                    
                    for(int i=0;i<itemList.size();i++){
                        stockDao.saveStock(itemList.get(i).getId(), con, userList);
                    }
                      
                  }
                  
                  
                  
                  return true;
            }else{
                return false;
            }
          
        } catch (SQLException e) {
            System.out.println("user not saved "+e);
            return false;
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
     }
    
    public boolean getLoggedUser(){
        User user=new User();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        con=DBConnection.connect();
        try {
            sql="select * from user where login_status=?";
            ps=con.prepareStatement(sql);
            ps.setBoolean(1, true);
            rs=ps.executeQuery();
            if(rs.next()){
                updateLoginStaus(false, rs.getLong("user_Id"));
                return true;
            }else{
               return true; 
            }
            
        } catch (SQLException e) {
            System.out.println("logut fail "+e);
            return false;
            
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }
    
     public User getLoggedUserDetails(){
        User user=new User();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        con=DBConnection.connect();
        try {
            sql="select * from user where login_status=?";
            ps=con.prepareStatement(sql);
            ps.setBoolean(1, true);
            rs=ps.executeQuery();
            if(rs.next()){
                user.setUserId(rs.getLong("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setNic(rs.getString("nic"));
                user.setMobile(rs.getString("mobile_number"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserType(rs.getString("user_type"));
            }
            
        } catch (SQLException e) {
            System.out.println("cant find user "+e);
           
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return user;
    }
    
    
    
    public List<User> getAllUsers(){
        con=DBConnection.connect();
        Statement st;
        ResultSet rs;
        String sql;
        ArrayList userList=new ArrayList<User>();
        User user=null;
        
        try {
            sql="select * from user order by first_name asc";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                user=new User();
                user.setUserName(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                 user.setLastName(rs.getString("last_name"));
                  user.setNic(rs.getString("nic"));
                   user.setMobile(rs.getString("mobile_number"));
                   user.setUserType(rs.getString("user_type"));
                   
                   userList.add(user);
            }
            
        } catch (SQLException e) {
            System.out.println("get all users failed "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return userList;
    }
   
      public User getLastUser(){
        con=DBConnection.connect();
        Statement st;
        ResultSet rs;
        String sql;
        ArrayList userList=new ArrayList<User>();
        User user=null;
        
        try {
            sql="select * from user order by user_id desc";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                user=new User();
                user.setUserName(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                 user.setLastName(rs.getString("last_name"));
                  user.setNic(rs.getString("nic"));
                   user.setMobile(rs.getString("mobile_number"));
                   user.setUserType(rs.getString("user_type"));
                   user.setUserId(rs.getLong("user_id"));
                   
                  
            }
            
        } catch (SQLException e) {
            System.out.println("get last user failed "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return user;
    }
    
    
     public List<User> getAllUsersByType(String type){
        con=DBConnection.connect();
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        ArrayList userList=new ArrayList<User>();
        User user=null;
        
        try {
            sql="select * from user where user_type=? order by first_name asc";
            ps=con.prepareStatement(sql);
            ps.setString(1, type);
            rs=ps.executeQuery();
            while(rs.next()){
                user=new User();
                user.setUserName(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                 user.setLastName(rs.getString("last_name"));
                  user.setNic(rs.getString("nic"));
                   user.setMobile(rs.getString("mobile_number"));
                   user.setUserType(rs.getString("user_type"));
                   user.setUserId(rs.getLong("user_id"));
                   
                   userList.add(user);
            }
            
        } catch (SQLException e) {
            System.out.println("get all users by type failed "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return userList;
    }
   
    
    
    public List<User> searchUser(int type, String keyword){
        List<User> userList=new ArrayList<>();
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql = null;
        ResultSet rs;
        User user=null;
        
        try {
            if(type==1){
                sql="select * from user where username like ?";
            }else if(type==2){
                 sql="select * from user where nic like ?";
            }
            
            ps=con.prepareCall(sql);
            ps.setString(1, keyword+"%");
            rs=ps.executeQuery();
            
           while(rs.next()){
                user=new User();
                user.setUserName(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                 user.setLastName(rs.getString("last_name"));
                  user.setNic(rs.getString("nic"));
                   user.setMobile(rs.getString("mobile_number"));
                   user.setUserType(rs.getString("user_type"));
                   
                   userList.add(user);
            }
           
           
        } catch (SQLException e) {
            System.out.println("serach  users failed "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return userList;
    }
    
    
    
            
                
    public boolean updateUser(User user) {
    
        con=DBConnection.connect();
        PreparedStatement ps=null;
        String sql=null;
        
        try {
            sql="update user set password=?,first_name=?,last_name=?,nic=?,mobile_number=? where username=? ";
           ps= con.prepareStatement(sql);
            if(user!=null){
                
                  
                  ps.setString(1, user.getPassword());
                 
                  ps.setString(2, user.getFirstName());
                  ps.setString(3, user.getLastName());
                  ps.setString(4, user.getNic());
                  ps.setString(5, user.getMobile());
                  ps.setString(6, user.getUserName());
                  
                  ps.executeUpdate();
                  
                  return true;
            }else{
                return false;
            }
          
        } catch (SQLException e) {
            System.out.println("user not updated "+e);
            return false;
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
     }
    
    public boolean deleteUser(String username){
        
        con=DBConnection.connect();
        PreparedStatement ps;
        User user=getUserByUserName(username);
        
        try {
            
           
            
            if(user.isLogin_status()){
                return false;
            }else{
             String sql="delete from user where username=?";
            ps=con.prepareCall(sql);
            ps.setString(1, username);
            ps.executeUpdate();
            return true;
            }
           
        } catch (SQLException e) {
            System.out.println("user delete failed "+e);
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
