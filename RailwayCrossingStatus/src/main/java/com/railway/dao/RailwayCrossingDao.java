package com.railway.dao;
import java.sql.*;
import java.util.ArrayList;
import com.railway.bean.RailwayCrossingBean;
import com.railway.bean.RegisterBean;
public class RailwayCrossingDao {
public static Connection con=getCon();
public static PreparedStatement ps;
public static ResultSet rs;
public static Connection getCon()
{
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Password@12");

}
catch(ClassNotFoundException cnf)
{

}
catch(SQLException sql)
{

}
return con;
}


public static String register(RegisterBean rb)
{
int i=0;
try
{
ps=con.prepareStatement("insert into register values(?,?,?)");
ps.setString(1,rb.getName());
ps.setString(2, rb.getEmail());
ps.setString(3, rb.getPassword());
i=ps.executeUpdate();
if(i==1)
{
return "SUCCESS";
}
else
{
return "FAIL";
}
}
catch(SQLException sql)
{

}
return null;

}



public static String checkLogin(String email,String pass)
{
try
{
ps=con.prepareStatement("select * from register where email=? and password=?");
ps.setString(1, email);
ps.setString(2, pass);
rs=ps.executeQuery();
if(rs.next())
{
return "Valid";
}
else
{
return "Invalid";
}
}
catch(SQLException sql)
{

}
return null;
}











public static ArrayList<RailwayCrossingBean> selectAll()
{
ArrayList<RailwayCrossingBean> al=new ArrayList<RailwayCrossingBean>();
try
{
ps=con.prepareStatement("select * from railwaycrossing");
rs=ps.executeQuery();
while(rs.next())
{
RailwayCrossingBean rcb=new RailwayCrossingBean();
rcb.setName(rs.getString(1));
rcb.setAddress(rs.getString(2));
rcb.setLandmark(rs.getString(3));
rcb.setTrainschedules(rs.getString(4));
rcb.setPersonincharges(rs.getString(5));
rcb.setStatus(rs.getString(6));
al.add(rcb);

}
}
catch(SQLException sql)
{
}
return al;
}







public static int deleteByName(String name)
{
System.out.println("Under Dao "+name);
int i=0;
try{
ps=con.prepareStatement("delete from railwaycrossing where name=?");
ps.setString(1, name);
i=ps.executeUpdate();
}
catch(SQLException sql)
{
System.out.println(sql);
}
return 1;
}



public static int updateByName(RailwayCrossingBean rcb)
{
  int i = 0;
   try {
    ps = con.prepareStatement(
      "UPDATE railwaycrossing SET address=?, landmark=?, trainschedules=?, personincharge=?, status=? WHERE name=?"

    );
    ps.setString(1, rcb.getAddress());
    ps.setString(2, rcb.getLandmark());
    ps.setString(3, rcb.getTrainschedules());
    ps.setString(4, rcb.getPersonincharges());
    ps.setString(5, rcb.getStatus());
    ps.setString(6, rcb.getName());
    i = ps.executeUpdate();
  } 
   catch (SQLException sql) 
   {
    System.out.println(sql);
  }
  return i;
}



public static int AddByName(RailwayCrossingBean rcb) 
{
  int i = 0;
  try {
    ps = con.prepareStatement(
      "insert into railwaycrossing values(?,?,?,?,?,?)"

    );
    ps.setString(1, rcb.getName());
    ps.setString(2, rcb.getAddress());
    ps.setString(3, rcb.getLandmark());
    ps.setString(4, rcb.getTrainschedules());
    ps.setString(5, rcb.getPersonincharges());
    ps.setString(6, rcb.getStatus());
    i = ps.executeUpdate();
  } 
  catch (SQLException sql) 
  {
    System.out.println(sql);
  }

  return i;
}



public static ArrayList<RailwayCrossingBean> searchByName(String name) 
{
  ArrayList<RailwayCrossingBean> list = new ArrayList<>();
  try {
    PreparedStatement ps = con.prepareStatement("SELECT * FROM railwaycrossing WHERE name LIKE ?" );
    ps.setString(1, "%" + name + "%"); 
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      RailwayCrossingBean rcb = new RailwayCrossingBean();
      rcb.setName(rs.getString("name"));
      rcb.setAddress(rs.getString("address"));
      rcb.setLandmark(rs.getString("landmark"));
      rcb.setTrainschedules(rs.getString("trainschedules"));
      rcb.setPersonincharges(rs.getString("personincharge"));
      rcb.setStatus(rs.getString("status"));
      list.add(rcb);
    }

  } 
  catch (SQLException e)
  {
    e.printStackTrace();
  }
   return list;

}


public static RailwayCrossingBean selectByName(String name) {
RailwayCrossingBean rcb = null;
try {
PreparedStatement ps = con.prepareStatement("SELECT * FROM railwaycrossing WHERE name = ?");
ps.setString(1, name);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
rcb = new RailwayCrossingBean();
rcb.setName(rs.getString("name"));
rcb.setAddress(rs.getString("address"));
rcb.setLandmark(rs.getString("landmark"));
rcb.setTrainschedules(rs.getString("trainschedules"));
rcb.setPersonincharges(rs.getString("personincharge")); // DB column
rcb.setStatus(rs.getString("status"));
}
rs.close();
ps.close();
} 
catch (SQLException e)
{
e.printStackTrace();
}
return rcb;
}
}