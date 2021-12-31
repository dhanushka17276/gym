/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.DAO;

import com.intvaria.connections.DBConnection;
import com.intvaria.entity.Attendant;
import com.intvaria.entity.Fianace;
import com.intvaria.entity.Member;
import com.intvaria.entity.Options;
import com.intvaria.entity.PackageDetails;
import com.intvaria.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dhanushka
 */
public class MemberDAO {
    
   private Connection con=null;
   private PackageDAO pckDao=new PackageDAO();
   
   public boolean saveMember(Member member,Options options,String packageName){
       
       con=DBConnection.connect();
       PreparedStatement ps;
       String sql = null;
       
       try {
           
           sql = "insert into members (membership_number,first_name,last_name,gender,birthday,nic,home_telephone,mobile,home_address,office_address,emerg_name,emerg_relation,emerg_contact,pro_image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           ps = con.prepareStatement(sql);
           ps.setLong(1, member.getMembership_number());
           ps.setString(2, member.getFirst_name());
           ps.setString(3, member.getLast_name());
           ps.setString(4, member.getGender());
           ps.setString(5, member.getBirthday());
           ps.setString(6, member.getNic());
           ps.setString(7, member.getHome_telephone());
           ps.setString(8, member.getMobile());
           ps.setString(9, member.getHome_address());
           ps.setString(10, member.getOffice_address());
           ps.setString(11, member.getEmerg_name());
           ps.setString(12, member.getEmerg_relation());
           ps.setString(13, member.getEmerg_contact());
           ps.setBytes(14, member.getProImage());
           ps.executeUpdate();
           
           boolean isOptionSaved=saveOptions(options, con);
           if(isOptionSaved==true){
               boolean isFinacnceSaved=saveFinanceDetails(member.getMembership_number(), con,packageName,"0");
               if(isFinacnceSaved==true){
                   return true; 
               }else{
               return false;
               }
               
           }else{
                return false;
           }
           
          
       } catch (SQLException e) {
           System.out.println("member save failed "+e);
           return false;
       }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
   }
       
       
       public Member getSingleMember(Long membosgipNumber){
           
           Member member=new Member();
           con=DBConnection.connect();
           PreparedStatement ps;
           ResultSet rs;
           String sql;
           Options option;
           try {
               sql="select * from members where membership_number=?";
               ps=con.prepareStatement(sql);
               ps.setLong(1, membosgipNumber);
               rs=ps.executeQuery();
               Fianace finance;
               PackageDetails pck;
               if(rs.next()){
                   member.setMembership_number(rs.getLong("membership_number"));
                   member.setFirst_name(rs.getString("first_name"));
                   member.setLast_name(rs.getString("last_name"));
                   member.setBirthday(rs.getString("birthday"));
                   member.setNic(rs.getString("nic"));
                   member.setGender(rs.getString("gender"));
                   member.setHome_telephone(rs.getString("home_telephone"));
                   member.setMobile(rs.getString("mobile"));
                   member.setHome_address(rs.getString("home_address"));
                   member.setOffice_address(rs.getString("office_address"));
                   member.setEmerg_contact(rs.getString("emerg_contact"));
                   member.setEmerg_name(rs.getString("emerg_name"));
                   member.setEmerg_relation(rs.getString("emerg_relation"));
                   member.setProImage(rs.getBytes("pro_image"));
                   member.setId(rs.getLong("id"));
                   finance=getFinacneByMembershipNumber(membosgipNumber);
                   member.setFinance(finance);
                   pck=pckDao.getPackegeById(finance.getPackageId());
                   member.setPack(pck);
                   if(getSingleOption(rs.getLong("membership_number"))!=null){
                          member.setOptions(getSingleOption(rs.getLong("membership_number")));
                   }
                
                   
               }
                      
           } catch (SQLException e) {
               System.out.println("error on get single member "+e);
               
           }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
           return member;
       
   }
       
       
       public boolean updateMember(Member member,Options options){
            
       PreparedStatement ps;
       String sql = null;
       Member ExistinMember=getSingleMember(member.getMembership_number());
        con=DBConnection.connect();
       try {
           
           sql = "update members set first_name=? ,last_name=? ,gender=? ,birthday=? ,nic = ? ,home_telephone =?,mobile=? ,home_address=? ,office_address=? ,emerg_name=? ,emerg_relation=? ,emerg_contact=? ,pro_image=? where membership_number=?";
           ps = con.prepareStatement(sql);
           ps.setLong(14, member.getMembership_number());
           ps.setString(1, member.getFirst_name());
           ps.setString(2, member.getLast_name());
           ps.setString(3, member.getGender());
           ps.setString(4, member.getBirthday());
           ps.setString(5, member.getNic());
           ps.setString(6, member.getHome_telephone());
           ps.setString(7, member.getMobile());
           ps.setString(8, member.getHome_address());
           ps.setString(9, member.getOffice_address());
           ps.setString(10, member.getEmerg_name());
           ps.setString(11, member.getEmerg_relation());
           ps.setString(12, member.getEmerg_contact());
           if(member.getProImage()==null){
                ps.setBytes(13, ExistinMember.getProImage());
           }else{
           ps.setBytes(13, member.getProImage());
           }
           
           ps.executeUpdate();
           
           boolean isOptionSaved=updateOptions(options, con);
           if(isOptionSaved==true){
               
                   return true; 
              
               
           }else{
                return false;
           }
           
          
       } catch (SQLException e) {
           System.out.println("member update failed "+e);
           return false;
       }finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }

       }
       
       public boolean saveOptions(Options options,Connection con){
           
           PreparedStatement ps;
           String sql;
           
           try {
               sql="insert into options (opt1,opt2,opt3,opt4,opt5,opt6,opt7,opt8,opt9,opt10,opt11,member_id ) values (?,?,?,?,?,?,?,?,?,?,?,?)";
               ps=con.prepareStatement(sql);
               ps.setString(1, options.getOpt1());
               ps.setString(2, options.getOpt2());
               ps.setString(3, options.getOpt3());
               ps.setString(4, options.getOpt4());
               ps.setString(5, options.getOpt5());
               ps.setString(6, options.getOpt6());
               ps.setString(7, options.getOpt7());
               ps.setString(8, options.getOpt8());
               ps.setString(9, options.getOpt9());
               ps.setString(10, options.getOpt10());
               ps.setString(11, options.getOpt11());
               ps.setLong(12, options.getMember_Id());
               
               ps.executeUpdate();
               
               return true;
               
           } catch (SQLException e) {
               System.out.println("error in save options "+e);
               
               return false;
           }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
       }
       
       public boolean updateOptions(Options options,Connection con){
           
           PreparedStatement ps;
           String sql;
           
           try {
               sql="update options set opt1=? ,opt2=?,opt3=?,opt4=?,opt5=?,opt6=?,opt7=?,opt8=?,opt9=?,opt10=?,opt11=? where member_id=?";
               ps=con.prepareStatement(sql);
               ps.setString(1, options.getOpt1());
               ps.setString(2, options.getOpt2());
               ps.setString(3, options.getOpt3());
               ps.setString(4, options.getOpt4());
               ps.setString(5, options.getOpt5());
               ps.setString(6, options.getOpt6());
               ps.setString(7, options.getOpt7());
               ps.setString(8, options.getOpt8());
               ps.setString(9, options.getOpt9());
               ps.setString(10, options.getOpt10());
               ps.setString(11, options.getOpt11());
               ps.setLong(12, options.getMember_Id());
               
               ps.executeUpdate();
               
               return true;
               
           } catch (SQLException e) {
               System.out.println("error in update options "+e);
               
               return false;
           }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
       }
       
       public Options getSingleOption(Long membershipNumber){
           Options option=new Options();
           con=DBConnection.connect();
           PreparedStatement ps;
           ResultSet rs;
           String sql;
           
           try {
               sql="select * from options where member_id=?";
               ps=con.prepareStatement(sql);
               ps.setLong(1, membershipNumber);
               rs=ps.executeQuery();
               if(rs.next()){
                   option.setOpt1(rs.getString("opt1"));
                   option.setOpt2(rs.getString("opt2"));
                   option.setOpt3(rs.getString("opt3"));
                   option.setOpt4(rs.getString("opt4"));
                   option.setOpt5(rs.getString("opt5"));
                   option.setOpt6(rs.getString("opt6"));
                   option.setOpt7(rs.getString("opt7"));
                   option.setOpt8(rs.getString("opt8"));
                   option.setOpt9(rs.getString("opt9"));
                   option.setOpt10(rs.getString("opt10"));
                   option.setOpt11(rs.getString("opt11"));
               }
               
           } catch (SQLException e) {
               System.out.println("error on get single option "+e);
           }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
           
           return option;
       }
       
       public boolean saveFinanceDetails(Long membershipNumber,Connection con,String name,String discount ){
           PreparedStatement ps;
           String sql;
           
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            
            LocalDateTime now = LocalDateTime.now();
             Date date = new Date();  
             String dateFormat= dtf.format(now);
              Date startDate=null;
              Fianace finace=null; 
             
              
     
             
           try {
               PackageDetails pck=pckDao.getPackegeByName(name);
               finace=getFinacneByMembershipNumber(membershipNumber);
               sql="insert into finance (membership_number,package_id,start_date,end_date,price,discount,status,date) values (?,?,?,?,?,?,?,?)";
              
                LocalDateTime endLocalDate=LocalDateTime.now().plusMonths(pck.getValidTime());
            Date endDate=null;
            Date issuedDate=null;
              String endDateFroamt=dtf.format(endLocalDate);
              String issuedDateFormat=dtf.format(now);
       
               try {
                   endDate=new SimpleDateFormat("yyyy-MM-dd").parse(endDateFroamt);
                   issuedDate=new SimpleDateFormat("yyyy-MM-dd").parse(issuedDateFormat); 
               } catch (ParseException ex) {
                   Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
               }
      
               if(pck.getName()!=null){
                     ps=con.prepareStatement(sql);
               ps.setLong(1, membershipNumber);
               ps.setInt(2, pck.getPackageId());
               ps.setDate(3, new java.sql.Date(date.getTime()));
               ps.setDate(4, new java.sql.Date(endDate.getTime()));
               ps.setDouble(5, pck.getPrice());
               ps.setDouble(6, Double.parseDouble(discount));
               ps.setBoolean(7, true);
               ps.setDate(8, new java.sql.Date(issuedDate.getTime()));
               ps.executeUpdate();
               
               if(finace.getId()!=null){
                   boolean isSaved=updateFinace(finace);
               if(isSaved==true){
                     return true;
               }else{
                     return false;
               }
               }else{
                   return true;
               }
               
             
               
               }else{
                   return false;
               }
             
               
               
           } catch (SQLException e) {
               System.out.println("error on save finacne "+e);
               return false;
           }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
           
       }
       
       
       public boolean updateFinace(Fianace finace){
           con=DBConnection.connect();
           PreparedStatement ps;
           String sql;
           
           try {
               sql="update finance set status=? where membership_number=?";
               ps=con.prepareStatement(sql);
               ps.setBoolean(1, false);
               ps.setLong(2, finace.getMembershipNumber());
               ps.executeUpdate();
               return true;
              
           } catch (SQLException e) {
               System.out.println("error on update finance "+e);
                return false;
           }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       }
       
          public List<Member> getAllmembers(){
        con=DBConnection.connect();
        Statement st;
        ResultSet rs;
        String sql;
        List memeberList=new ArrayList<Member>();
        Member member=null;
        Fianace finance=null;
        
        
        try {
            sql="select * from members";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                member=new Member();
                member.setMembership_number(rs.getLong("membership_number"));
                member.setNic(rs.getString("nic"));
                member.setFirst_name(rs.getString("first_name"));
                member.setLast_name(rs.getString("last_name"));
                member.setMobile(rs.getString("mobile"));
                member.setFinance(getFinacneByMembershipNumber(rs.getLong("membership_number")));
               memeberList.add(member);
            }
            
        } catch (SQLException e) {
            System.out.println("get all members failed "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return memeberList;
    }
          
          public Fianace getFinacneByMembershipNumber(Long memberId){
               
                con=DBConnection.connect();
       PreparedStatement ps;
        ResultSet rs;
        String sql;
         Fianace finance=new Fianace();
         Date endDate;
        
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
              try {
                  sql="select * from finance where membership_number=? and status=?";
                  ps=con.prepareStatement(sql);
                  ps.setLong(1, memberId);
                  ps.setBoolean(2, true);
                  rs=ps.executeQuery();
                 
                  if(rs.next()){
                       int result = 0 ;
                      finance.setMembershipNumber(rs.getLong("membership_number"));
                     
                      finance.setStartDate(rs.getDate("start_date"));
                      finance.setEndDate(rs.getDate("end_date"));
                      endDate= rs.getDate("end_date");
                     result= endDate.compareTo(new Date());
                      if(result>=0){
                           finance.setStatus(true);
                      }else{
                            finance.setStatus(false);
                      }
                      finance.setPackageId(rs.getInt("package_id"));
                  }
              } catch (Exception e) {
                  System.out.println("error on set singe finace "+e);
              }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return finance;
          }
          
          
            public List<Member> serachMember(int type, String keyword){
        
        con=DBConnection.connect();
        PreparedStatement ps = null;
        String sql = null;
        ResultSet rs;
        User user=null;
     Member   member;
     List<Member> memeberList=new ArrayList<>();
        
        try {
            
            if(type==1){
                sql="select * from members where membership_number = ?  ";
                 ps=con.prepareCall(sql);
                 ps.setDouble(1, Double.parseDouble(keyword));
            }else if(type==2){
                 sql="select * from members where nic like ?";
                  ps=con.prepareCall(sql);
                  ps.setString(1, keyword+"%");
                  
            }
            
           
           
                  rs=ps.executeQuery();
            
           while(rs.next()){
               member=new Member();
                member.setMembership_number(rs.getLong("membership_number"));
                member.setNic(rs.getString("nic"));
                member.setFirst_name(rs.getString("first_name"));
                member.setLast_name(rs.getString("last_name"));
                member.setMobile(rs.getString("mobile"));
                member.setFinance(getFinacneByMembershipNumber(rs.getLong("membership_number")));
               memeberList.add(member);
            }
           
           
        } catch (SQLException e) {
            System.out.println("serach  mmembers failed "+e);
        }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return memeberList;
    }
    
            public Fianace checkMemberFinance(Long membershipId){
                con=DBConnection.connect();
                PreparedStatement ps;
                String sql;
                Fianace finance=new Fianace();
                ResultSet rs;
                Date endDate;
                int result=0;
                try {
                    sql="select * from finance where membership_number=? order by id desc ";
                    ps=con.prepareStatement(sql);
                    ps.setLong(1, membershipId);
                    rs=ps.executeQuery();
                   rs.next();
                   finance.setId(rs.getLong("id"));
                   finance.setPackageId(rs.getInt("package_id"));
                   finance.setStartDate(rs.getDate("start_date"));
                   finance.setEndDate(rs.getDate("end_date"));
                  endDate= rs.getDate("end_date");
                     result= endDate.compareTo(new Date());
                      if(result>=0){
                           finance.setStatus(true);
                      }else{
                            finance.setStatus(false);
                      }
                   
                } catch (SQLException e) {
                    System.out.println("error on checkMemberFinance "+e); 
                }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
                
                return finance; 
                
            }
            
            
            
               
          public List<Fianace> searchFinance(int packId , Date fromDate , Date toDate){
               PackageDAO pckDao=new PackageDAO();
                con=DBConnection.connect();
       PreparedStatement ps;
        ResultSet rs;
        String sql;
        List<Fianace> financeList=new ArrayList<>();
                
         Fianace finance=null;
         Date endDate;
        
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
              try {
                  
                        if(fromDate==null && toDate==null){
                        if(packId==0){
                            sql="select * from finance order by date desc";
                              ps=con.prepareStatement(sql);
                        }else{
                               sql="select * from finance where package_id=? order by date desc";
                              ps=con.prepareStatement(sql);
                              ps.setInt(1, packId);
                        }
                    }else{
                         if(packId==0){
                              sql="select * from finance where date between ? and ? order by date desc";
                            
                            ps=con.prepareStatement(sql);
                            if(fromDate!=null)
                              ps.setDate(1, new java.sql.Date(fromDate.getTime()));  
                            
                              ps.setDate(2, new java.sql.Date(toDate.getTime()));
                              
                        }else{
                              sql="select * from finance where date between ? and ? and package_id=? order by date desc";
                           ;
                              ps=con.prepareStatement(sql);
                              if(fromDate!=null)
                              ps.setDate(1, new java.sql.Date(fromDate.getTime()));  
                            
                              ps.setDate(2, new java.sql.Date(toDate.getTime()));
                               ps.setLong(3, packId);
                        }
                    }
               
                  rs=ps.executeQuery();
                 
                  while(rs.next()){
                      finance=new Fianace();
                       int result = 0 ;
                      finance.setMembershipNumber(rs.getLong("membership_number"));
                     
                      finance.setStartDate(rs.getDate("start_date"));
                      finance.setEndDate(rs.getDate("end_date"));
                      endDate= rs.getDate("end_date");
                     result= endDate.compareTo(new Date());
                      if(result>=0){
                           finance.setStatus(true);
                      }else{
                            finance.setStatus(false);
                      }
                      finance.setPackageId(rs.getInt("package_id"));
                      finance.setPackageDetails(pckDao.getPackegeById(rs.getInt("package_id")));
                      finance.setPrice(rs.getDouble("price"));
                      finance.setDiscount(rs.getDouble("discount"));
                      finance.setDate(rs.getDate("date"));
                      financeList.add(finance);
                  }
              } catch (Exception e) {
                  System.out.println("error on search finance "+e);
              }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return financeList;
          }
            
          
            // attendance ------------------------------------------------------------------------------------------
            public boolean saveAttendance(Long membershipNumber,boolean status) throws ParseException{
               
                PreparedStatement ps;
                String sql;
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             LocalDateTime endLocalDate=LocalDateTime.now();
              String endDateFroamt=dtf.format(endLocalDate);
               Date endDate=null;
               Fianace fincae=null;
       endDate=new SimpleDateFormat("yyyy-MM-dd").parse(endDateFroamt);
                try {
                    if(getAttendenceByDate(endDate,membershipNumber).getId()==null){
                       
                         fincae=getFinacneByMembershipNumber(membershipNumber);
                           con=DBConnection.connect();
                        sql="insert into attendance (membership_number,date,status) values (?,?,?)";
                        ps=con.prepareStatement(sql);
                        ps.setLong(1, membershipNumber);
                        ps.setDate(2, new java.sql.Date(endDate.getTime()));
                        ps.setBoolean(3, fincae.isStatus());
                        ps.executeUpdate();
                        return true;
                    }else{
                        return true;
                    }
                } catch (SQLException | ParseException e) {
                    System.out.println("error on save attendance "+e);
                    return false;
                }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
              
                
            }
            
            public Attendant getAttendenceByDate(Date date,Long membershipId) throws ParseException{
                Attendant atnd=new Attendant();
                 con=DBConnection.connect();
                PreparedStatement ps;
                String sql;
                ResultSet rs;
                 
                try {
                    sql="select * from attendance where date=? and membership_number=?";
                    ps=con.prepareStatement(sql);
                    ps.setDate(1, new java.sql.Date(date.getTime()));
                    ps.setLong(2, membershipId);
                    rs=ps.executeQuery();
                    
                    if(rs.next()){
                        atnd.setId(rs.getLong("id"));
                        atnd.setMembershipNumber(rs.getLong("membership_number"));
                        atnd.setStatus(rs.getBoolean("status"));
                        atnd.setDate(rs.getDate("date"));
                    }
                } catch (SQLException e) {
                    System.out.println("error on getAttendenceByDate "+e);
                }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
                
                return atnd;
            }
            
            
                  public List<Attendant> getAttendence(Date fromDate,Date toDate,String membershipId) throws ParseException{
                Attendant atnd=null;
                PackageDAO pckDao=new PackageDAO();
                List<Attendant> attendanceList=new ArrayList<>();
               Fianace finance=null;
                 con=DBConnection.connect();
                PreparedStatement ps;
                String sql;
                ResultSet rs;
                 
                try {
                    if(fromDate==null && toDate==null){
                        if(membershipId.length()==0){
                            sql="select * from attendance order by date desc";
                              ps=con.prepareStatement(sql);
                        }else{
                            sql="select * from attendance where  membership_number=? order by date desc";
                              ps=con.prepareStatement(sql);
                              ps.setLong(1, Long.parseLong(membershipId));
                        }
                    }else{
                         if(membershipId.length()==0){
                            sql="select * from attendance where date between ? and ? order by date desc";
                            ps=con.prepareStatement(sql);
                            if(fromDate!=null)
                              ps.setDate(1, new java.sql.Date(fromDate.getTime()));  
                            
                              ps.setDate(2, new java.sql.Date(toDate.getTime()));
                              
                        }else{
                            sql="select * from attendance where date between ? and ? and membership_number=? order by date desc";
                              ps=con.prepareStatement(sql);
                              if(fromDate!=null)
                              ps.setDate(1, new java.sql.Date(fromDate.getTime()));  
                            
                              ps.setDate(2, new java.sql.Date(toDate.getTime()));
                               ps.setLong(3, Long.parseLong(membershipId));
                        }
                    }
                  
                   
                  ;
                    rs=ps.executeQuery();
                    
                    while(rs.next()){
                        atnd=new Attendant();
                        atnd.setId(rs.getLong("id"));
                        atnd.setMembershipNumber(rs.getLong("membership_number"));
                        atnd.setStatus(rs.getBoolean("status"));
                        atnd.setDate(rs.getDate("date"));
                        finance=getFinacneByMembershipNumber(rs.getLong("membership_number"));
                        atnd.setFinance(finance);
                        attendanceList.add(atnd);
                    }
                } catch (SQLException e) {
                    System.out.println("error on get attendance "+e);
                }finally {
            try {
                
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
                
                return attendanceList;
            }
             
            
}

