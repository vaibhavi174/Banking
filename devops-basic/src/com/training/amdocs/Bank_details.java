package com.training.amdocs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Random;


public class Bank_details {
	
		public static void main(String[] args) throws SQLException {
			Scanner s=new Scanner(System.in);
			try {
	   		 Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@//localhost:1521/orcl.iiht.tech";

				String userName = "scott";

				String password = "tiger";

				Connection con= DriverManager.getConnection(url,userName,password);
				//Statement st=con.createStatement();
				if(con!=null) {
					System.out.println("connected");
				}
				else
				{
					System.out.println("connection failed");
				}
				System.out.println(" How many accounts need to be created: ");
				int n=s.nextInt();
	            int user_choice=2;
				
				do
				{
					System.out.println();
					System.out.println(" 1. Open a new account ");
					System.out.println(" 2. Deposit money ");
					System.out.println(" 3. Withdraw Money ");
					System.out.println(" 4. Balance inquiry ");
					System.out.println(" 5. Exit");
					System.out.println();
					System.out.println(" Enter your choice ");
					user_choice=s.nextInt();
					switch(user_choice) {
					       case 1:
					    	   System.out.println(" Enter your name: ");
					    	   String cn=s.next();
					    	   System.out.println(" Enter opening balance amount: ");
					    	   double d=s.nextDouble();
					    	   System.out.println(" Enter your phone number ");
					    	   String ph=s.next();
					    	   System.out.println(" Enter your address ");
					    	   String ca=s.next();
					    	   System.out.println(" Enter your Email-Id ");
					    	   String ce=s.next();
					    	   Random rnd=new Random();
								String num="20022" +rnd.nextInt(99);
								int accountNum=Integer.parseInt(num);
					             if(con !=null) {
								    	
								    PreparedStatement ps;
									ps=con.prepareStatement("insert into Bank_details values(?,?,?,?,?,?)");
								    ps.setInt(1, accountNum);
									ps.setString(2, cn);
									ps.setDouble(3, d);
									ps.setString(4, ph);
									ps.setString(5, ca);
									ps.setString(6,ce);
									int i=ps.executeUpdate();
									if (i==1)
										System.out.println(" Registration Successfull  and the account number is "+accountNum);
									else
									  System.out.println(" Registration Failed ");
								    }				    	  
					    	    break;
					      case 2:
					    	   //Connection con1 = null;
					    	    System.out.println(" Enter your account number ");
				    	        int an=s.nextInt();
				    	        System.out.println(" Enter the amount to be deposited ");
				    	        int b=s.nextInt();
						   
					            PreparedStatement ps1=con.prepareStatement("update Bank_details set acc_balance=acc_balance+? where acc_num=?");
				    	        ps1.setInt(1, b);
				    	        ps1.setInt(2, an);
				    	        ps1.executeUpdate();
				    	        //System.out.println("Balance:"+sd);
				    	        
				    	        break; 		
				    	        			
				    	      
					       case 3://Connection con2=null;
					    	   System.out.println(" Enter your account number ");
			    	           int and=s.nextInt();
			    	           System.out.println(" Enter the amount to  withdraw from your account ");
			    	           int bb=s.nextInt();
			    	           PreparedStatement ps2=con.prepareStatement("update Bank_details set acc_balance=acc_balance-? where acc_num=?");
			    	           ps2.setInt(1, bb);
			    	           ps2.setInt(2, and);
			    	           ps2.executeUpdate();
			    	           //System.out.println("Balance:"+and);
			    	         
			    	           break; 	
					    	    
					      case 4://Connection con4=null;
					    	    System.out.println(" Enter your account number ");
				    	        int anum=s.nextInt();
				    	        Statement st=con.createStatement();
				    	        ResultSet rs=st.executeQuery("select acc_num, acc_balance from Bank_details where acc_num="+anum);
				    	        while(rs.next()) {
				    	        	System.out.println(rs.getString(1)+" "+rs.getString(2));
				    	        }
				    	        rs.close();
				    	        break;				     
				    	 //case 5:
					    	   //System.out.println("Balance amount");
					       case 5:
					    	   System.exit(0);
					}
				}
			
				while(user_choice!='5');
			}	
				catch(Exception e) {
					e.printStackTrace();
				}
			
		}	
	}

		
			
				
		


		

