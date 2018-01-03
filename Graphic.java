import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.WindowConstants;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;
public class Graphic extends JFrame
{
	JFrame body;
	private JButton butInsert, butDelete, butUpdate, butBrowse, butQuery, butClear, butExit, butNext, butPrev;
	private JTextField tfIndex, tfId, tffName, tflName, tfAddy, tfEmail, tfPhone, tfQuery, tfQuery2, tfVisible, tfMax;
	private JLabel ofLabel, labfName, lablName,labAddy, labId, labEmail, labPhone, labVisible, labQuery, labQuery2;
	private JPanel panNav, panDisp, panQuery, panQuery2;
	private int pNum, recNum, visiNum, currentIndex;
	private String fName, lName, addy, email;
	private ArrayList listOfIndividuals;
	private int indiSize, a;
	IndividualQuery personQuery;
	
	
//---------------------------------------------------------------------------------------------	

	public Graphic()
	{
//---------------------------------------------------------------------------------------------	
		super("Address Book App");
		personQuery= new IndividualQuery();
		listOfIndividuals= new ArrayList();
		
//---------------------------------------------------------------------------------------------
// initializing
			fName = "";
			lName="";
			addy= "";
			email = "";
			pNum = 0;	
			visiNum= 0;
			recNum= -1;	
			bodyContent();
			
		
	}
	public void bodyContent(){
			panNav = new JPanel();
			butPrev = new JButton();
			butNext = new JButton();
			tfIndex= new JTextField(2);
			ofLabel = new JLabel();
			tfMax= new JTextField(2);
			
			panDisp = new JPanel();
			labAddy = new JLabel();
			tfAddy = new JTextField(10);
			labfName = new JLabel();
			tffName= new JTextField(10);
			lablName = new JLabel();
			tflName = new JTextField( 10 );
			labEmail = new JLabel();
			tfEmail = new JTextField( 10 );
			labPhone = new JLabel();
			tfPhone = new JTextField( 10 );
			 panQuery = new JPanel();
			 panQuery2 = new JPanel();
			 labQuery = new JLabel();
			 labQuery2 = new JLabel();
			 tfQuery = new JTextField( 10 );
			 tfQuery2 = new JTextField( 10 );
			 labVisible= new JLabel();
			 tfVisible= new JTextField(10);
			 butQuery = new JButton();
			 butBrowse = new JButton();
			 butInsert = new JButton();
			 butClear = new JButton("Clear");
			 butDelete = new JButton("Delete");
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		panNav.setLayout(new BoxLayout(panNav, BoxLayout.X_AXIS));
		
		//-------------------Previous button----------------------------------------------------
		butPrev.setText("Previous");
		butPrev.setEnabled(false);
		butPrev.addActionListener( new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{
						butPrevPerf(event);
					}
			 });
		panNav.add( butPrev );
		panNav.add( Box.createHorizontalStrut( 10 ) );
		
		
		//---------------------IndexField---------------------------------------------------------
		tfIndex.setHorizontalAlignment( JTextField.CENTER );
		tfIndex.setEditable(false);
		tfIndex.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{
					//	tfIndexActionPerf(event);
					}
			 });
			 
		//------------------------Navigation panel------------------------------------------------	 
		panNav.add( tfIndex );
		panNav.add( Box.createHorizontalStrut( 10 ) );

		ofLabel.setText( "of" );
		panNav.add( ofLabel );
		panNav.add( Box.createHorizontalStrut( 10 ) );
			
		tfMax.setHorizontalAlignment(JTextField.CENTER );
		tfMax.setEditable( false );
		panNav.add( tfMax );
		panNav.add( Box.createHorizontalStrut( 10 ) );
		
		
		//--------------Next Button------------------------------------------------------------------
		 butNext.setText("Next");
		 butNext.setEnabled( false );
		 butNext.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event)
				{
					butNextPerf(event);
				}
			 });
			
		 panNav.add( butNext );
		 
		 //--------------Add top Nav Panel to Body------------------------------------------------------
			 add( panNav );

			 
		//---------------Body Center Arrangement---------------------------------------------------------	 
			 panDisp.setLayout( new GridLayout( 6, 2, 4, 4 ) );

		//	 tfId.setEditable( false );
			 

			 labfName.setText( "First Name:" );
			 panDisp.add( labfName );
			 panDisp.add( tffName );

			 lablName.setText( "Last Name:" );
			 panDisp.add( lablName );
			 panDisp.add( tflName );
			 
			 labAddy.setText( "Address ID:" );
			 panDisp.add( labAddy );
			 panDisp.add( tfAddy );
			 
			 labEmail.setText( "Email:" );
			 panDisp.add( labEmail );
			 panDisp.add( tfEmail );

			 labPhone.setText( "Phone Number:" );
			 panDisp.add( labPhone );
			 panDisp.add( tfPhone );
			 
			  labVisible.setText( "Visibility:" );
			 panDisp.add( labVisible );
			 panDisp.add( tfVisible ); 
			 
			//-------------------ADD Dispaly panel to center of body------------------------------------
			 add( panDisp );
			//-------------------------------------------------------------------------------------------
			 panQuery.setLayout( new BoxLayout( panQuery, BoxLayout.X_AXIS) );
			 panQuery.setBorder( BorderFactory.createTitledBorder("Find an entry by last name" ) );	 
			 panQuery.add( Box.createHorizontalStrut( 50 ) );
			 
			 labQuery.setText( "Last Name:" );
			 panQuery.add( labQuery );
			 panQuery.add( Box.createHorizontalStrut( 10 ) );
			 
			 panQuery.add( tfQuery );
			 panQuery.add( Box.createHorizontalStrut( 10 ) );

			 butQuery.setText( "Find" );
			 panQuery.add(butQuery);
			 butQuery.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event){
							butQueryActionPerf( event);
					}
					
			 });				 
			 
			//-----------------------------------------------------------------
			add(panQuery);
			
			//---------------------------------------------------------------------
			 panQuery2.setLayout(new BoxLayout(panQuery2, BoxLayout.X_AXIS));
			 panQuery2.setBorder(BorderFactory.createTitledBorder("Delete Entry By Phone Number"));
			 panQuery2.add(Box.createHorizontalStrut(50));
			 
			 labQuery2.setText("Search For");
			 panQuery2.add(labQuery2);
			 panQuery2.add(Box.createHorizontalStrut(10));		
			 
			 panQuery2.add( tfQuery2 );
			 panQuery2.add( Box.createHorizontalStrut( 10 ) );
			 
			 butDelete.setText( "Delete Contact" );
			 panQuery2.add(butDelete);
			 
			butDelete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
						butDeleteActionPerf(event);
				}
			});
			 add(panQuery2);
//---------------------------------------------------------------------
			
			butBrowse.setText( "Browse All Entries" );
			butBrowse.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent event){
						butBrowseActionPerf(event);
					}
			 });
			add( butBrowse );

			butInsert.setText( "Insert New Entry" );
			butInsert.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{
						butInsertActionPerf(event);
					}
			});
			add(butInsert);
			
			butClear.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
						butClearActionPerf(event);
				}});
			add(butClear);
			
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent event){
					personQuery.close();
					System.exit(0);
				}});		 		
	}
		public void butInsertActionPerf(ActionEvent event){
				int result=0;
				String tfPhoneString, tfVisibleString;
				
				fName= tffName.getText();
				lName= tflName.getText();
				addy = tfAddy.getText();
				tfPhoneString= tfPhone.getText();
				email= tfEmail.getText();
				tfVisibleString= tfVisible.getText();				
				
				if(fName.equals("")||lName.equals("") || addy.equals("") || email.equals("") || tfPhoneString.equals("") || tfVisibleString.equals("")){
					JOptionPane.showMessageDialog(null, "Please Fill Empty Field");
				}else{
					pNum = Integer.parseInt(tfPhoneString);
					visiNum= Integer.parseInt(tfVisibleString);
					
					Individual addNewPerson= new Individual(fName,lName,addy,pNum,email,visiNum);
				
					result= personQuery.savePerson(addNewPerson);
				
					if(result== 1){
					JOptionPane.showMessageDialog(null, "Upload Successful", "New Person Added", JOptionPane.PLAIN_MESSAGE);
					butClearActionPerf(event);
					}
					else
					JOptionPane.showMessageDialog(null, "Upload Failed", "Error Adding New Person", JOptionPane.PLAIN_MESSAGE);	
					
				}
				
			}	
		public void butBrowseActionPerf(ActionEvent eventB){
					try{								
							
							listOfIndividuals.clear();
							listOfIndividuals= personQuery.browse();
							indiSize= listOfIndividuals.size();	
												
							
							tfMax.setText(""+indiSize);					
							
							if(indiSize != 0){
							System.out.print("" +currentIndex);
							Individual currentPerson= (Individual) listOfIndividuals.get(currentIndex);
							tffName.setText(currentPerson.getfName());
							tflName.setText(currentPerson.getlName());
							tfAddy.setText(currentPerson.getAddress());
							tfPhone.setText("" + currentPerson.getPhone());
							tfEmail.setText(currentPerson.getEmail());
							tfVisible.setText("" +currentPerson.getVisible());
							tfIndex.setText("" +(1+ currentIndex));
							
							butNext.setEnabled(true);
							butNext.setActionCommand(eventB.getActionCommand());
							butPrev.setEnabled(true); 
							butPrev.setActionCommand(eventB.getActionCommand());
							}
							}catch(Exception e){
								System.out.print(e);
							}							
			
			}		
		public void butQueryActionPerf(ActionEvent eventF){
					try{
					lName= tfQuery.getText();
					if(!lName.equals("")){
					listOfIndividuals= personQuery.searchperson(lName);					

					indiSize= listOfIndividuals.size();
					System.out.print("\n 1A.." + indiSize);
					tfMax.setText("" +indiSize);
					if(indiSize != 0)
					{						
						Individual currentPerson= (Individual) listOfIndividuals.get(currentIndex);
						tffName.setText(currentPerson.getfName());
						tflName.setText(currentPerson.getlName());
						tfAddy.setText(currentPerson.getAddress());
						tfPhone.setText("" + currentPerson.getPhone());
						tfEmail.setText(currentPerson.getEmail());
						tfVisible.setText("" +currentPerson.getVisible());
						tfIndex.setText(""+ ( 1+currentIndex) );
						butNext.setEnabled(true);
						butNext.setActionCommand(eventF.getActionCommand());
						butPrev.setEnabled(true);
						butPrev.setActionCommand(eventF.getActionCommand());
					}
					}else{
						JOptionPane.showMessageDialog(null,"Please fill in Search Filed", "Input Last Name", JOptionPane.PLAIN_MESSAGE);
					}
					}catch ( Exception e )
						{
							e.printStackTrace();
						} // end catch
			}
		public void butNextPerf(ActionEvent event){
							try{
							
							if(event.getActionCommand() == "Browse All Entries")
								{
									System.out.print("Event is browse" + a);
									currentIndex++;
									if(currentIndex >= indiSize)
											{	
												currentIndex= 0;
												}
									tfIndex.setText("" +(1+ currentIndex));
									listOfIndividuals.clear();
									butBrowseActionPerf(event);
									}
							if(event.getActionCommand() == "Find")
								{	
									System.out.print("This is the correct Event is Find" );
									currentIndex++;
									if(currentIndex >= indiSize)
											{	
												currentIndex= 0;
												}
									tfIndex.setText("" +(1+ currentIndex));
									listOfIndividuals.clear();
									butQueryActionPerf(event);
									}
								
							
								
								
							}catch(Exception e){
								System.out.print(e);
							}
						}			
		public void butPrevPerf(ActionEvent event){
					try{
						if(event.getActionCommand() == "Browse All Entries")
							{
								--currentIndex;
								if(currentIndex < 0)
								currentIndex= indiSize-1;
								
								listOfIndividuals.clear();
								tfMax.setText("");
								butBrowseActionPerf(event);
						}
						if(event.getActionCommand() == "Find"){
								--currentIndex;
								if(currentIndex < 0)
								currentIndex= indiSize-1;
								
								listOfIndividuals.clear();
								tfMax.setText("");
								butQueryActionPerf(event);
						}
							}catch(Exception e){
								System.out.print(e);
								}
						
		}
		public void butClearActionPerf(ActionEvent event){
			listOfIndividuals.clear();
			currentIndex=0;
			tffName.setText("");
			tflName.setText("");
			tfAddy.setText("");
			tfPhone.setText("");
			tfEmail.setText("");
			tfVisible.setText("");
			tfQuery.setText("");
			tfQuery2.setText("");
			tfIndex.setText("");
			tfMax.setText("");
			butPrev.setEnabled(false);
			butNext.setEnabled(false);
		}
		public void butDeleteActionPerf(ActionEvent event){
			int result;
			String theNum= tfQuery2.getText();
			if(!theNum.equals("")){
				int numToDelete= Integer.parseInt(theNum);
				try{
				result= personQuery.deletePerson(numToDelete);
				if(result==1){
				JOptionPane.showMessageDialog(null," Contact Successfully Deleted ");
				}else{
				JOptionPane.showMessageDialog(null, " Error COntact Could Not Be Deleted \n Contact Not In Registry");
				}
				}catch(Exception e)
				{
					System.out.print(e);
				}
			}else{
				JOptionPane.showMessageDialog(null, " Please Input number to be Deleted ");
			}
		}
		
}