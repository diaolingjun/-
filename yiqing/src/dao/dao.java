package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Info;
import utils.DBUtil;

public class dao {
       public List<Info> Query(String Date) {
           List<Info> infos=new ArrayList<>();
           Info info= null;
             ResultSet rs = null; 
           try {
               String sql="select * from info where Date=? " ;
               Object [] params= {Date};
               rs=DBUtil.executeQuery(sql, params);
               while(rs.next()) {
                   int Id=rs.getInt("Id");
                   String Province=rs.getString("Province");
                   String City=rs.getString("City");
                   String Confirmed_num=rs.getString("Confirmed_num");
                   String Yisi_num=rs.getString("Yisi_num");
                   String Cured_num=rs.getString("Cured_num");
                   String Dead_num=rs.getString("Dead_num");
                   String Code=rs.getString("Code");
                   info=new Info(Id,Date,Province,City,Confirmed_num,Yisi_num,Cured_num,Dead_num,Code);
                   infos.add(info);
               }
           }catch(SQLException e) {
               e.printStackTrace();
           }catch(Exception e) {
               e.printStackTrace();
           }finally {
               try {
                   //先开的后关，后开的先关
               if(rs!=null)rs.close();
               if(DBUtil.pstmt!=null)DBUtil.pstmt.close();
               if(DBUtil.connection !=null)DBUtil.connection.close();
               }catch(SQLException e) {
                   e.printStackTrace();
               }finally {
                   
               }
              
           }
           return infos;
       }
}

