import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class IndividualQuery
{
	private static String DB= "";
	private static String USERNAME= "";
	private static String PASSWORD= "";
	Connection connect = null;
	PreparedStatement	insert= null;
	PreparedStatement	searchBy= null;
	PreparedStatement	searchAll= null;
	PreparedStatement	update= null;
	PreparedStatement	del= null;
	private ArrayList 	listOfPerson;

	public IndividualQuery(){
			listOfPerson= new ArrayList();
			try{
					//	Setup Connection with Database
		//-----------------------------------------------------------
					connect = DriverManager.getConnection(DB, USERNAME, PASSWORD);
		// statement For Querying Database
					insert 	= connect.prepareStatement("INSERT INTO person (id,fname,lname, address,phone,email,visible) VALUES (NULL,?,?,?,?,?,?)");
													
					searchAll	= connect.prepareStatement("SELECT * FROM person");
					searchBy	= connect.prepareStatement("SELECT * FROM person WHERE lname=?");
					update	= connect.prepareStatement("UPDATE person SET address=?, phone=?, email=? WHERE lname=?");
					del		= connect.prepareStatement("DELETE FROM person WHERE phone= ?");
			}
			catch(SQLException e){
				e.printStackTrace();
				System.exit(1);
			}
	}

// Executing statement query
	
		public ArrayList searchperson(String param)
		{
			
			try{
					searchBy.setString(1,param);
					ResultSet rs= searchBy.executeQuery();
					 int id;
					 String fName="";
					 String lName="";
					 String address="";
					 int phone;
					 String email="";					 
					 int visible;
					
					while(rs.next())
					{
						id= rs.getInt("id");
						fName= rs.getString("fName");
						lName= rs.getString("lName");
						address= rs.getString("address");
						phone= rs.getInt("phone");
						email= rs.getString("email");						
						visible= rs.getInt("visible");
						Individual person= new Individual(fName, lName, address,phone, email, visible);
						listOfPerson.add(person);
					}
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			return listOfPerson;
		}
		public int savePerson(Individual person)
		{
			int result= 0;
			try{
					insert.setString(1,person.getfName());
					insert.setString(2,person.getlName());
					insert.setString(3,person.getAddress());
					insert.setInt(4,person.getPhone());
					insert.setString(5,person.getEmail());
					insert.setInt(6,person.getVisible());
					result= insert.executeUpdate();
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
			return result;
		}
		
	public ArrayList browse()
		{
			
			try{
					ResultSet rs= searchAll.executeQuery();
					 int id;
					 String fName="";
					 String lName="";
					 String address="";
					 int phone;
					 String email="";					
					 int visible;
					
					while(rs.next())
					{
						id= rs.getInt("id");
						fName= rs.getString("fName");
						lName= rs.getString("lName");
						address= rs.getString("address");
						phone= rs.getInt("phone");
						email= rs.getString("email");						
						visible= rs.getInt("visible");
						Individual person= new Individual(fName, lName, address,phone, email, visible);
						listOfPerson.add(person);
					}
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			return listOfPerson;
		}

		//Update
		//--------------------------------------------------------------------------------
		public int updatePerson(Individual person)
		{
			int result= 0;
			try{
				update.setString(1,person.getAddress());
				update.setInt(2,person.getPhone());
				update.setString(3,person.getEmail());
				update.setString(4,person.getlName());
				result= update.executeUpdate();
			}catch(Exception e)
			{
				System.out.println(e + "New Error");
			}
			return result;
		}
		public int deletePerson( int num)
		{
			int result= 0;
			try{
					del.setInt(1,num);
					result= del.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
				}
			return result;
		}
		//close connection
		//----------------------------------------------
		
		public void close()
		{
			try {
				if(connect != null)
					connect.close();
				}catch(SQLException e){
					e.printStackTrace();
					}
		}
}