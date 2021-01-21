import java.util.*;
import java.sql.*;

class payroll
{
public static void main(String args[])
{
	
	int ch;
	Scanner s=new Scanner(System.in);
	while('1'=='1'){
	System.out.println("1.Add Employee");
	System.out.println("2.Update Basic Salary");
	System.out.println("3.Remove Employee");
	System.out.println("4.View Salary of Employee");
	ch=s.nextInt();
	switch(ch){
		case 1:
		insert();
		break;
		case 2:
		update();
		break;
		case 3:
		remove();
		break;
		case 4:
		insert();
		break;
		default:
		System.out.print("wrong choice.............!!!!!!!!!!!!!");
		break;
	}
	}
	}
static void insert()
{
	int id,bsal,deptno,ca,hr,ma,gsal,it=0,netsal;
String name;
Scanner s=new Scanner(System.in);
System.out.print("Employee ID :");
id=s.nextInt();
s.nextLine();
System.out.print("Employee Name :");
name=s.nextLine();
System.out.print("Employee Department No. :");
deptno=s.nextInt();
System.out.print("Employee Basic Salary :");
bsal=s.nextInt();

System.out.println("Id="+id);

System.out.println("Name="+name);

System.out.println("deptno="+deptno);

System.out.println("bsal="+bsal);


	if(bsal>=40000)
	{
		ca=(int)(bsal*0.40);
		ma=(int)(bsal*0.30);
		hr=(int)(bsal*0.10);
		System.out.println("Convienance allounce="+ca);
		System.out.println("Medical allounce="+ma);
		System.out.println("House Rent allounce="+hr);
	}
        else if(bsal>=30000)
	{
		ca=(int)(bsal*0.35);
		ma=(int)(bsal*0.25);
		hr=(int)(bsal*0.05);
		System.out.println("Convienance allounce="+ca);
		System.out.println("Medical allounce="+ma);
		System.out.println("House Rent allounce="+hr);
	}
	else
	{
		ca=3000;
		ma=2000;
		hr=1000;
		System.out.println("Convienance allounce="+ca);
		System.out.println("Medical allounce="+ma);
		System.out.println("House Rent allounce="+hr);
	}
	gsal=bsal+ca+ma+hr;
	System.out.println("Gross Salary="+gsal);
	
	if(gsal>=60000)
	{
	it=(int)(gsal*0.03);
	netsal=gsal-it;
	System.out.println("IT="+it);
	System.out.println("netsal="+netsal);
	}
	else if(gsal>=50000)
	{
	it=(int)(gsal*0.02);
	netsal=gsal-it;
	System.out.println("IT="+it);
	System.out.println("netsal="+netsal);
	}
	else
	{
	netsal=gsal;
	System.out.println("IT="+it);
	System.out.println("netsal="+netsal);
	}
try{
Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
//here sonoo is the database name, root is the username and root is the password
Statement stmt=con.createStatement();
PreparedStatement stmt1=con.prepareStatement("insert into emp(empid, name, deptno, bsal) values(?,?,?,?)");  
stmt1.setInt(1,id);
stmt1.setString(2,name);
stmt1.setInt(3,deptno);
stmt1.setInt(4,bsal);
PreparedStatement stmt2=con.prepareStatement("insert into salary( ca, ma, hr, gsal, it, netsal, empid) values(?,?,?,?,?,?,?)");  
stmt2.setInt(1,ca);
stmt2.setInt(2,ma);
stmt2.setInt(3,hr);
stmt2.setInt(4,gsal);
stmt2.setInt(5,it);
stmt2.setInt(6,netsal);
stmt2.setInt(7,id);
stmt1.executeUpdate();
stmt2.executeUpdate();  
  con.close();

}catch(Exception e){ System.out.println(e);}

}
static void update()
{
	int id,bsal,deptno,ca,hr,ma,gsal,it=0,netsal;
Scanner s=new Scanner(System.in);
System.out.print("Enter Employee ID :");
id=s.nextInt();
s.nextLine();
System.out.print("Enter Basic Salary to update :");
bsal=s.nextInt();


System.out.println("Id="+id);

System.out.println("bsal="+bsal);


	if(bsal>=40000)
	{
		ca=(int)(bsal*0.40);
		ma=(int)(bsal*0.30);
		hr=(int)(bsal*0.10);
		System.out.println("Convienance allounce="+ca);
		System.out.println("Medical allounce="+ma);
		System.out.println("House Rent allounce="+hr);
	}
        else if(bsal>=30000)
	{
		ca=(int)(bsal*0.35);
		ma=(int)(bsal*0.25);
		hr=(int)(bsal*0.05);
		System.out.println("Convienance allounce="+ca);
		System.out.println("Medical allounce="+ma);
		System.out.println("House Rent allounce="+hr);
	}
	else
	{
		ca=3000;
		ma=2000;
		hr=1000;
		System.out.println("Convienance allounce="+ca);
		System.out.println("Medical allounce="+ma);
		System.out.println("House Rent allounce="+hr);
	}
	gsal=bsal+ca+ma+hr;
	System.out.println("Gross Salary="+gsal);
	
	if(gsal>=60000)
	{
	it=(int)(gsal*0.03);
	netsal=gsal-it;
	System.out.println("IT="+it);
	System.out.println("netsal="+netsal);
	}
	else if(gsal>=50000)
	{
	it=(int)(gsal*0.02);
	netsal=gsal-it;
	System.out.println("IT="+it);
	System.out.println("netsal="+netsal);
	}
	else
	{
	netsal=gsal;
	System.out.println("IT="+it);
	System.out.println("netsal="+netsal);
	}
try{
Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
//here sonoo is the database name, root is the username and root is the password
   String sql="UPDATE emp SET bsal=? WHERE empid=?";

PreparedStatement stmt=con.prepareStatement(sql);

		stmt.setInt(1,bsal);
		stmt.setInt(2,id);				
      stmt.executeUpdate();
	  
String sql1="UPDATE salary SET ca = ?,ma=?,hr=?,gsal=?,it=?,netsal=? WHERE empid=?";

	  PreparedStatement stmt1=con.prepareStatement(sql1);
		stmt1.setInt(1,ca);
		stmt1.setInt(2,ma);
		stmt1.setInt(3,hr);
		stmt1.setInt(4,gsal);
		stmt1.setInt(5,it);
		stmt1.setInt(6,netsal);
		stmt1.setInt(7,id);	
      stmt1.executeUpdate();

  con.close();

}catch(Exception e){ System.out.println(e);}

}
static void remove()
{
	int id;
Scanner s=new Scanner(System.in);
System.out.print("Enter Employee ID :");
id=s.nextInt();
	
try{
Class.forName("com.mysql.jdbc.Driver");

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","");
//here sonoo is the database name, root is the username and root is the password
   Statement stmt = con.createStatement();
    String sql = "DELETE FROM emp " +
                   "WHERE empid = ?";  
				  
	  String sql1 = "DELETE FROM salary " +
                   "WHERE empid =?";
	 
		
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
 
            pstmt1.setInt(1, id);
            pstmt1.executeUpdate();
			PreparedStatement pstmt = con.prepareStatement(sql);
 
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
  con.close();

}catch(Exception e){ System.out.println(e);}


	  }
}
