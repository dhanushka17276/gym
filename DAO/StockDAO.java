/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.DAO;

import com.intvaria.connections.DBConnection;
import com.intvaria.entity.Category;
import com.intvaria.entity.Item;
import com.intvaria.entity.Stock;
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
public class StockDAO {
    
    Connection con;
    UserDAO userDAO=new UserDAO();
    // save stock ---------------------------------------------------
    public boolean saveCategory(Category category){
        
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        try {
            
            sql="insert into category (name) values (?)";
            ps=con.prepareStatement(sql);
            if(category.getName()!=null){
                ps.setString(1, category.getName());
            ps.executeUpdate();
            return true; 
            }else{
                return false;
            }
           
            
        } catch (SQLException e) {
            System.out.println("error on save category "+e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    //get all categories -------------------------------
    
    public List<Category> getAllCategories(){
        con=DBConnection.connect();
        Statement st;
        ResultSet rs;
        String sql;
        List<Category> catList=new ArrayList<>();
        Category cat=null;
        try {
            sql="select * from category order by name asc";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                cat=new Category();
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                catList.add(cat);
            }
        } catch (Exception e) {
            System.out.println("error on get all category "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return  catList;
    }
    
    // update category -------------------
    public boolean updateCategory(Category category){
         con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        try {
            sql="update category set name=? where id=?";
            ps=con.prepareStatement(sql);
            if(category!=null){
                ps.setString(1, category.getName());
                ps.setInt(2, category.getId());
            ps.executeUpdate();
            return true; 
            }else{
                return false;
            }
           
            
        } catch (SQLException e) {
            System.out.println("error on update category "+e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Category getCategoryByName(String name){
        con=DBConnection.connect();
        Category category=new Category();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql;
        try {
            sql="select * from category where name=?";{
            ps=con.prepareStatement(sql);
            ps.setString(1, name);
            rs=ps.executeQuery();
            if(rs.next()){
                category.setName(rs.getString("name"));
                category.setId(rs.getInt("id"));
            }
        }
        } catch (SQLException e) {
            System.out.println("error on get category by name "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return category;
    }
    
    public boolean deleteCategory(String name){
       con=DBConnection.connect();
        PreparedStatement ps;
        
        
        try {
            
           
            
          
             String sql="delete from category where name=?";
            ps=con.prepareCall(sql);
            ps.setString(1, name);
            ps.executeUpdate();
            return true;
            
           
        } catch (SQLException e) {
            System.out.println("category delete failed "+e);
            return false;
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    // items ------------------------------------------------------------------------
    
    public boolean saveItem(Item item){
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        
        try {
            sql="insert into item (name	,description,price,category,status,image) values (?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, item.getName());
             ps.setString(2, item.getDescription());
             ps.setDouble(3, item.getPrice());
             ps.setString(4, item.getCategory());
             ps.setBoolean(5, item.isStatus());
             ps.setBytes(6, item.getImage());
             ps.executeUpdate();
               List<User> userList=userDAO.getAllUsersByType("coach");
               con=DBConnection.connect();
             boolean isSuccess=saveStock(getLastItem().getId(), con,userList);
             if(isSuccess==true){
                   return true;
             }else{
                   return false;
             }
           
        } catch (SQLException e) {
            System.out.println("error on save item  "+e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
     public boolean updateItem(Item item){
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        
        try {
            sql="update item set name=?,description=?,price=?,category=?,status=?,image=? where id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, item.getName());
             ps.setString(2, item.getDescription());
             ps.setDouble(3, item.getPrice());
             ps.setString(4, item.getCategory());
             ps.setBoolean(5, item.isStatus());
             ps.setBytes(6, item.getImage());
             ps.setInt(7, item.getId());
             ps.executeUpdate();
               return true;
           
        } catch (SQLException e) {
            System.out.println("error on update item  "+e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public List<Item> getAllItems(){
         List<Item> itemList=new ArrayList<>();
         con=DBConnection.connect();
         String sql;
         Statement st;
         ResultSet rs;
         Item item=null;
         
         try {
            sql="select * from item order by name asc";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                item=new Item();
                item.setCategory(rs.getString("category"));
                item.setDescription(rs.getString("description"));
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setStock(rs.getInt("stock"));
                itemList.add(item);
            }
        } catch (SQLException e) {
             System.out.println("error on get all items "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         return itemList;
    }
    
    
    
    public Item getItemById(int itemId){
        
         con=DBConnection.connect();
         String sql;
         PreparedStatement ps;
         ResultSet rs;
         Item item=new Item();
         
         try {
            sql="select * from item where id=?";
           ps=con.prepareStatement(sql);
           ps.setInt(1, itemId);
            rs=ps.executeQuery();
            while(rs.next()){
                item=new Item();
                item.setCategory(rs.getString("category"));
                item.setDescription(rs.getString("description"));
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setStock(rs.getInt("stock"));
                item.setImage(rs.getBytes("image"));
                item.setStatus(rs.getBoolean("status"));
               
            }
        } catch (SQLException e) {
             System.out.println("error on get all items "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         return item;
    }
    
    
        public Item getLastItem(){
         List<Item> itemList=new ArrayList<>();
         con=DBConnection.connect();
         String sql;
         Statement st;
         ResultSet rs;
         Item item=null;
         
         try {
            sql="select * from item order by id desc";
            st=con.createStatement();
            rs=st.executeQuery(sql);
           
            if(rs.next()){
                item=new Item();
                item.setCategory(rs.getString("category"));
                item.setDescription(rs.getString("description"));
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                item.setStock(rs.getInt("stock"));
               
            }
        } catch (SQLException e) {
             System.out.println("error on get last item  "+e);
        }
         
         return item;
    }
    
    public List<Item> searchItems(int type,String keyword,int user){
         List<Item> itemList=new ArrayList<>();
         con=DBConnection.connect();
         String sql;
         PreparedStatement ps;
         ResultSet rs;
         Item item=null;
         String category;
         String name;
         Stock stock=null;
         UserDAO userDao=new UserDAO();
         List<User> userList=userDao.getAllUsersByType("coach");
         
        switch (type) {
            case 0:
                name="";
                category="";
                break;
            case 1:
                name=keyword;
                category="";
                break;
            default:
                category=keyword;
                name="";
                break;
        }
         
         try {
             
            
                 sql="select * from item where category like ? and name like ? order by name asc";
                 ps=con.prepareStatement(sql);
                 ps.setString(1, category+"%");
                 ps.setString(2, name+"%");
            
                 User currentUser=null;
                 int userIndex=0;
                 
                 if(userDao.getLoggedUserDetails().getUserType().equals("admin")){
                    if(user!=0){
                       for(int j = 0; j < userList.size() ; j++){
                    
                         if(j==(user-1)){
                             currentUser=userList.get(j);
                         }
                         userIndex=userIndex+1;
                     
                 }
                 } 
                 }else{
                    currentUser=userDao.getLoggedUserDetails();
                 }
                 
               
                 con=DBConnection.connect();
                 
             
            rs=ps.executeQuery();
            while(rs.next()){
                item=new Item();
                item.setCategory(rs.getString("category"));
                item.setDescription(rs.getString("description"));
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setPrice(rs.getDouble("price"));
                if(currentUser!=null){
                    
                    stock=getStockByUserIdAndItemId(currentUser.getUserId(),rs.getInt("id") , con);
                    item.setStock(stock.getQty());
                
                }else{
                     item.setStock(rs.getInt("stock"));
                }
               
              
                itemList.add(item);
            }
        } catch (SQLException e) {
             System.out.println("error on serach  items "+e);
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
         
         return itemList;
    }
    
    // stock ---------------------------------------------------------
    
    public Stock getStockByUserIdAndItemId(Long userId,int itemId,Connection con){
        String sql;
        PreparedStatement ps;
        ResultSet rs;
        Stock stock=null;
        
        try {
            sql="select * from stock where user_id=? and item_id=?";
            ps=con.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.setInt(2, itemId);
            rs=ps.executeQuery();
            if(rs.next()){
              stock=new Stock();
              stock.setItemId(rs.getInt("stock_id"));
              stock.setUser_id(rs.getLong("user_id"));
              stock.setQty(rs.getInt("qty"));
              
            }
        } catch (SQLException e) {
            System.out.println("error on get stock by user id" +e);
        }
        
        return stock;
    }
    
    public boolean saveStock(int itemId,Connection con, List<User> userList){
        
     
       PreparedStatement ps;
       String sql;
       Long userId;
       
        try {
             sql="insert into stock (item_id,qty,user_id) values (?,?,?)";
             
            if(userList.size()>0 ){
                for(int i=0;i<userList.size();i++){
                    ps=con.prepareStatement(sql);
                    ps.setInt(1, itemId);
                    ps.setInt(2, 0);
                    userId=userList.get(i).getUserId();
                    ps.setLong(3, userId);
                    ps.executeUpdate();
                    ps=null;
                }
            }
            
            return true;
          
        } catch (SQLException e) {
            
            System.out.println("error on save stock "+e);
            return false;
        }
    }
    
    public boolean updateStock(int itemId,int userId,int qty){
        
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
        List<User> userList=userDAO.getAllUsersByType("coach");
        User user;
        if(userDAO.getLoggedUserDetails().getUserType().equals("admin")){
                user=userList.get(userId-1);
        }else{
                user=userDAO.getLoggedUserDetails();
        }
     
       
        
        try {
            sql="update stock set qty=qty+? where item_id=? and user_id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setInt(2, itemId);
            ps.setLong(3, user.getUserId());
            ps.executeUpdate();
            boolean isSuccess=updateMainStock(itemId,qty);
            if(isSuccess==true){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("error on update stock");
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
     public boolean updateStockByUserId(int itemId,Long userId,int qty){
        
        con=DBConnection.connect();
        PreparedStatement ps;
        String sql;
       
        
        
       
        
        try {
            sql="update stock set qty=qty-? where item_id=? and user_id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, qty);
            ps.setInt(2, itemId);
            ps.setLong(3, userId);
            ps.executeUpdate();
            boolean isSuccess=updateMainStockInSale(itemId,qty);
            if(isSuccess==true){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("error on update stock by user id" +e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public boolean updateMainStock(int itemId,int qty){
          
       
        PreparedStatement ps;
        String sql;
        Item item=getItemById(itemId);
         con=DBConnection.connect();
        try {
            sql="update item set stock=? where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, item.getStock()+qty);
            ps.setInt(2, itemId);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("error on update main stock "+e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
      public boolean updateMainStockInSale(int itemId,int qty){
          
       
        PreparedStatement ps;
        String sql;
        Item item=getItemById(itemId);
         con=DBConnection.connect();
        try {
            sql="update item set stock=? where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, item.getStock()-qty);
            ps.setInt(2, itemId);
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("error on update main stock "+e);
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
