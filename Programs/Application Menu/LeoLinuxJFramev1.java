
import java.io.FileReader;
import java.io.IOException;

import java.awt.event.*;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java.awt.Color;

/**** JSON Imports ****/
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.util.Map;
import java.util.Iterator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author Chase Franse
 */

public class LeoLinuxJFramev1 extends javax.swing.JFrame {

    /**
     * Creates new form LeoLinuxJFramev1
     * @throws Exception 
     */
    public LeoLinuxJFramev1() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        try {
			JSONReading();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /*
     * Collects .JSON from GitHub page, converts to a String Writer and writes to the function "jsonGetObjectFromStream."
     * Then converts to a string, and then finally into a JSONObject, which the function "JSONReading" uses.
     */
    private static JSONObject jsonFromGitHub() throws Throwable {
    	JSONObject jsonResponse = new JSONObject();
    	try {
			URL jsonURL = new URL("https://raw.githubusercontent.com/COM-497-Spring2020/LeoLinux/main/Programs/Application%20Menu/leoLinuxApps.json");
			HttpURLConnection jsonHttp = (HttpURLConnection) jsonURL.openConnection();
			
			InputStream jsonStream = jsonHttp.getInputStream();
			jsonResponse = jsonGetObjectFromStream(jsonStream);
			//System.out.println(jsonResponse);
			
			return jsonResponse;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	return jsonResponse;
    }
    
    private static JSONObject jsonGetObjectFromStream(InputStream jsonStream) throws IOException {
    	JSONObject obj = new JSONObject();
    	if (jsonStream != null) {
			Writer jsonWriter = new StringWriter();
 
			char[] jsonBuffer = new char[2048];
			try {
				Reader jsonReader = new BufferedReader(new InputStreamReader(jsonStream, "UTF-8"));
				int Counter;
				while ((Counter = jsonReader.read(jsonBuffer)) != -1) {
					jsonWriter.write(jsonBuffer, 0, Counter);
				}
			} finally {
				jsonStream.close();
			}
			String data = jsonWriter.toString();
			JSONParser parser = new JSONParser();
			
			try {
				obj = (JSONObject) parser.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			
			return obj;
		}
		return obj;
	}
    
    public int count(Map.Entry pair, int counter, String currentKey) {
    	String thisKey = pair.getKey().toString();
		if (thisKey != currentKey) {
			counter++;
			currentKey = thisKey;
		}
    	return counter;
    }
    
    /*
     * Global Variables
     */
    String currentSize = "";
    String currentDesc = "";
	int counter = 0;
    String[] VALUES = new String[(counter)];
    
    /*
     * JSON Reading
     */
    
    public void JSONReading(/*Object obj*/) throws Exception{
    	
    	// Collecting the .JSON from GitHub
    			JSONObject jo = new JSONObject();
    			try {
					jo = jsonFromGitHub();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
    			
    			//Mapping/Getting All Section Information 
    			Map infoGather = ((Map)jo.get("Information_Gathering"));
    			Map digitalForensics = ((Map)jo.get("Digital_Forensics"));
    			Map passwordCrack = ((Map)jo.get("Password_Cracking"));
    			Map vulAnalysis = ((Map)jo.get("Vulnerability_Analysis"));
    			Map wirelessAttack = ((Map)jo.get("Wireless_Attacks"));
    			Map other = ((Map)jo.get("OTHER"));
    			
    			/**
    			 * Makes the Arrays variable in length v
    			 */
    			String currentKey = "";
    			
    			Iterator<Map.Entry>itr7 = infoGather.entrySet().iterator();
    			while(itr7.hasNext()) {
    				Map.Entry pair = itr7.next();
    				counter = count(pair, counter, currentKey);
    			}
    			Iterator<Map.Entry>itr8 = digitalForensics.entrySet().iterator();
    			while(itr8.hasNext()) {
    				Map.Entry pair = itr8.next();
    				counter = count(pair, counter, currentKey);
    			}
    			Iterator<Map.Entry>itr9 = passwordCrack.entrySet().iterator();
    			while(itr9.hasNext()) {
    				Map.Entry pair = itr9.next();
    				counter = count(pair, counter, currentKey);
    			}
    			Iterator<Map.Entry>itr10 = vulAnalysis.entrySet().iterator();
    			while(itr10.hasNext()) {
    				Map.Entry pair = itr10.next();
    				counter = count(pair, counter, currentKey);
    			}
    			Iterator<Map.Entry>itr11 = wirelessAttack.entrySet().iterator();
    			while(itr11.hasNext()) {
    				Map.Entry pair = itr11.next();
    				counter = count(pair, counter, currentKey);
    			}
    			Iterator<Map.Entry>itr12 = other.entrySet().iterator();
    			while(itr12.hasNext()) {
    				Map.Entry pair = itr12.next();
    				counter = count(pair, counter, currentKey);
    			}
    			/**
    			 * Makes the Arrays variable in length ^
    			 */
    			
    			String Keys[] = new String[counter];
    			String Values[] = new String[(counter * 3)];
    			
    			int Kcounter = 0;
    			int Vcounter = 0;
    			
    			// Information Gathering Section
    			Iterator<Map.Entry>itr1 = infoGather.entrySet().iterator();
    			while (itr1.hasNext()) {
    				Map.Entry pair = itr1.next();
    				//System.out.println(pair.getKey() + " : " + pair.getValue());
    				
    				String key = pair.getKey().toString();
    				String values[] = new String[3];
    				values = pair.getValue().toString().split(",");
    				if(Keys[Kcounter] == null) {
    					Keys[Kcounter] = key;
    					for(int e = 0; e < values.length; e++) {
    						Values[Vcounter] = values[e];
    						Vcounter++;
    					}
    					Kcounter++;
    				}
    							
    			}

    			// Digital Forensics Section
    			Iterator<Map.Entry>itr2 = digitalForensics.entrySet().iterator();
    			while (itr2.hasNext()) {
    				Map.Entry pair = itr2.next();
    				//System.out.println(pair.getKey() + " : " + pair.getValue());

    				String key = pair.getKey().toString();
    				String values[] = new String[3];
    				values = pair.getValue().toString().split(",");
    				if(Keys[Kcounter] == null) {
    					Keys[Kcounter] = key;
    					for(int e = 0; e < values.length; e++) {
    						Values[Vcounter] = values[e];
    						Vcounter++;
    					}
    					Kcounter++;
    				}
    			}
    			
    			// Password Cracking Section
    			Iterator<Map.Entry>itr3 = passwordCrack.entrySet().iterator();
    			while (itr3.hasNext()) {
    				Map.Entry pair = itr3.next();
    				//System.out.println(pair.getKey() + " : " + pair.getValue());

    				String key = pair.getKey().toString();
    				String values[] = new String[3];
    				values = pair.getValue().toString().split(",");
    				if(Keys[Kcounter] == null) {
    					Keys[Kcounter] = key;
    					for(int e = 0; e < values.length; e++) {
    						Values[Vcounter] = values[e];
    						Vcounter++;
    					}
    					Kcounter++;
    				}
    			}
    			
    			// Vulnerability Analysis Section
    			Iterator<Map.Entry>itr4 = vulAnalysis.entrySet().iterator();
    			while (itr4.hasNext()) {
    				Map.Entry pair =itr4.next();
    				//System.out.println(pair.getKey() + " : " + pair.getValue());

    				String key = pair.getKey().toString();
    				String values[] = new String[3];
    				values = pair.getValue().toString().split(",");
    				if(Keys[Kcounter] == null) {
    					Keys[Kcounter] = key;
    					for(int e = 0; e < values.length; e++) {
    						Values[Vcounter] = values[e];
    						Vcounter++;
    					}
    					Kcounter++;
    				}
    			}
    			
    			// Wireless Attacks Section
    			Iterator<Map.Entry>itr5 = wirelessAttack.entrySet().iterator();
    			while (itr5.hasNext()) {
    				Map.Entry pair = itr5.next();
    				//System.out.println(pair.getKey() + " : " + pair.getValue());

    				String key = pair.getKey().toString();
    				String values[] = new String[3];
    				values = pair.getValue().toString().split(",");
    				if(Keys[Kcounter] == null) {
    					Keys[Kcounter] = key;
    					for(int e = 0; e < values.length; e++) {
    						Values[Vcounter] = values[e];
    						Vcounter++;
    					}
    					Kcounter++;
    				}
    			}
    			
    			// Other Section
    			Iterator<Map.Entry>itr6 = other.entrySet().iterator();
    			while (itr6.hasNext()) {
    				Map.Entry pair = itr6.next();
    				//System.out.println(pair.getKey() + " : " + pair.getValue());

    				String key = pair.getKey().toString();
    				String values[] = new String[3];
    				values = pair.getValue().toString().split(",");
    				if(Keys[Kcounter] == null) {
    					Keys[Kcounter] = key;
    					for(int e = 0; e < values.length; e++) {
    						Values[Vcounter] = values[e];
    						Vcounter++;
    					}
    					Kcounter++;
    				}			
    			}
    			
    			
    			
    			// Clean up the Values Array Items [Name Section]
    			for(int e = 2; e < Values.length; e+=3) {
    				Values[e] = Values[e].substring(8);
    				
    				String string = Values[e];
    				String reverse = new StringBuffer(string).reverse().toString();
    				Values[e] = reverse;
    				Values[e] = Values[e].substring(2);
    				
    				string = Values[e];
    				String correct = new StringBuffer(string).reverse().toString();
    				Values[e] = correct;
    				
    				//System.out.println(Values[e]);
    			} 
    			
    			
    			// Clean up the Values Array Items [Size Section]
    			for(int e = 1; e < Values.length; e+=3) {
    				Values[e] = Values[e].substring(8);
    				
    				String string = Values[e];
    				String reverse = new StringBuffer(string).reverse().toString();
    				Values[e] = reverse;
    				Values[e] = Values[e].substring(1);
    				
    				string = Values[e];
    				String correct = new StringBuffer(string).reverse().toString();
    				Values[e] = correct;
    				
    				//System.out.println(Values[e]);
    			} 
    			
    			// Clean up the Values Array Items [Desc Section]
    			for(int e = 0; e < Values.length; e+=3) {
    				Values[e] = Values[e].substring(9);
    				
    				String string = Values[e];
    				String reverse = new StringBuffer(string).reverse().toString();
    				Values[e] = reverse;
    				Values[e] = Values[e].substring(1);
    				
    				string = Values[e];
    				String correct = new StringBuffer(string).reverse().toString();
    				Values[e] = correct;
    				
    				//System.out.println(Values[e]);
    			}
    			
    			//Keys Array:
    			for(int e = 0; e < Keys.length; e++) {
    				//System.out.println(Keys[e]);
    			}
    			
    			//Values Array:
    			for(int e = 0; e < Values.length; e++) {
    				//System.out.println(Values[e]);
    			}
    			
    			VALUES = Values;
    			
    			/**
    			 * Add Menu Items
    			 */
    			addMenuItem(Keys, Values, jo);			
    }
    
    /**
     * Function to change the Main-Frame Title with each MenuItem selection
     * @param evt
     */
	public void tabAction (ActionEvent evt)  {
		JMenuItem currentItem = (JMenuItem) evt.getSource();
		String nameTxt = currentItem.getText();
		jLabel2.setText(nameTxt);
		int i = 0;
		
		//Size && Desc:
		while(nameTxt != VALUES[i]) {
			i++;
		}
		jLabel3.setText(VALUES[(i-1)]); //Size
		// Modify description VALUE position to replace "%" with "," JUST BEFORE setting the text
		VALUES[(i-2)] = VALUES[(i-2)].replace("%!", ",");
		jLabel4.setText(VALUES[(i-2)]); //Desc
	}
	
    /**
     * Function to create and add MenuItem to Menus
     * @param Keys, Values, jo
     */
    public void addMenuItem(String[] Keys, String[] Values, JSONObject jo) {
    	for(int e = 0; e < Keys.length; e++) {
    		/**
    		 * Information Gathering Section - Add Tabs to Menu && Change Main-Frame Title
    		 */
    		if(jo.get("Information_Gathering").toString().contains(Keys[e]) == true) {
    			//System.out.println("INFO GATHERING @" + e);
    			for(int i = 2; i < Values.length; i+=3) {  
    				if(Keys[e].toString().contains(Values[i])) {
	    				JMenuItem menuItem = new JMenuItem(Values[i].toString());
	    				jMenu1.add(menuItem);
	    				menuItem.addActionListener(new ActionListener() {
	    					public void actionPerformed(ActionEvent evt) {
	    						tabAction(evt);
	    						
	    					}
	    				});
    				}
    			}
    		} 
    		/**
    		 * Digital Forensics Section - Add Tabs to Menu && Change Main-Frame Title
    		 */
    		else if (jo.get("Digital_Forensics").toString().contains(Keys[e]) == true) {
    			//System.out.println("DIGITAL FORENSICS @" + e);
    			for(int i = 2; i < Values.length; i+=3) {  
    				if(Keys[e].toString().contains(Values[i])) {
	    				JMenuItem menuItem = new JMenuItem(Values[i].toString());
	    				jMenu2.add(menuItem);
	    				menuItem.addActionListener(new ActionListener() {
	    					public void actionPerformed(ActionEvent evt) {
	    						tabAction(evt);
	    					}
	    				});
	    			}
    			}
    		} 
    		/**
    		 * Password Cracking Section - Add Tabs to Menu && Change Main-Frame Title
    		 */
    		else if (jo.get("Password_Cracking").toString().contains(Keys[e]) == true) {
    			//System.out.println("PASSWORD CRACKING @" + e);
    			for(int i = 2; i < Values.length; i+=3) {  
    				if(Keys[e].toString().contains(Values[i])) {
	    				JMenuItem menuItem = new JMenuItem(Values[i].toString());
	    				jMenu5.add(menuItem);
	    				menuItem.addActionListener(new ActionListener() {
	    					public void actionPerformed(ActionEvent evt) {
	    						tabAction(evt);
	    					}
	    				});
	    			}
    			}
    		} 
    		/**
    		 * Vulnerability Analysis Section - Add Tabs to Menu && Change Main-Frame Title
    		 */
    		else if (jo.get("Vulnerability_Analysis").toString().contains(Keys[e]) == true) {
    			//System.out.println("VULNERABILITY ANALYSIS @" + e);
    			for(int i = 2; i < Values.length; i+=3) {  
    				if(Keys[e].toString().contains(Values[i])) {
	    				JMenuItem menuItem = new JMenuItem(Values[i].toString());
	    				jMenu3.add(menuItem);
	    				menuItem.addActionListener(new ActionListener() {
	    					public void actionPerformed(ActionEvent evt) {
	    						tabAction(evt);
	    					}
	    				});
	    			}
    			}
    		} 
    		/**
    		 * Wireless Attacks Section - Add Tabs to Menu && Change Main-Frame Title
    		 */
    		else if (jo.get("Wireless_Attacks").toString().contains(Keys[e]) == true) {
    			//System.out.println("WIRELESS ATTACKS @" + e);
    			for(int i = 2; i < Values.length; i+=3) {  
    				if(Keys[e].toString().contains(Values[i])) {
	    				JMenuItem menuItem = new JMenuItem(Values[i].toString());
	    				jMenu4.add(menuItem);
	    				menuItem.addActionListener(new ActionListener() {
	    					public void actionPerformed(ActionEvent evt) {
	    						tabAction(evt);
	    					}
	    				});
	    			}
    			}
    		} 
    		/**
    		 * OTHER Section - Add Tabs to Menu && Change Main-Frame Title
    		 */
    		else if (jo.get("OTHER").toString().contains(Keys[e]) == true) {
    			//System.out.println("OTHER @" + e);
    			for(int i = 2; i < Values.length; i+=3) {  
    				if(Keys[e].toString().contains(Values[i])) {
	    				JMenuItem menuItem = new JMenuItem(Values[i].toString());
	    				jMenu6.add(menuItem);
	    				menuItem.addActionListener(new ActionListener() {
	    					public void actionPerformed(ActionEvent evt) {
	    						tabAction(evt);
	    					}
	    				});
	    			}
    			}
    		} else {
    			System.out.println("SOMETHING WRONG @" + e);
    		}

    	} 
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenu7 = new javax.swing.JMenu();
        header = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        
        Border blackBorder = BorderFactory.createLineBorder(Color.black);
        jPanel1.setBorder(blackBorder);
        
        jLabel4.setBorder(new EmptyBorder(0, 25, 0, 20));
        
        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LeoLinux Application Store");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        header.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("LeoLinux Application Store");

        jButton1.setText("INSTALL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setName("center"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome to Leo Linux!");
        jLabel2.setName("appName"); // NOI18N
        
        /**
         * SIZE OF PROGRAM
         */
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //jLabel3.setText("Size: ");

        /**
         * DESCRIPTION OF PROGRAM
         */
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //jLabel4.setText("DESCRIPTION");
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(403, 403, 403))
	            .addGroup(jPanel1Layout.createSequentialGroup())
	        	.addGap(390, 390, 390)
	        	.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE) //Size
	        	.addGap(403, 403, 403)
	        	.addGap(390, 390, 390)
	        	.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE) //Desc
	        	.addGap(403, 403, 403)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
	            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
	        	.addGap(240, 240, 240)
	        	.addGap(240, 240, 240)
	        	.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenuBar1.setAlignmentY(0.5F);

        jMenu8.setText("                                                                                          ");
        jMenu8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu8.setEnabled(false);
        jMenu8.setName("Spacer"); // NOI18N
        jMenuBar1.add(jMenu8);

        jMenu1.setText("Information Gathering");
        jMenuBar1.add(jMenu1);
        jMenu2.setText("Digital Forensics");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("Password Cracking");
        jMenuBar1.add(jMenu5);
        jMenu3.setText("Vulnerability Analysis");
        jMenuBar1.add(jMenu3);
        jMenu4.setText("Wireless Attacks");
        jMenuBar1.add(jMenu4);
        jMenu6.setText("Other");
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /*
     * When pressed, the INSTALL button should run the "installer.sh" file located in: "/.leolinuxcustom/programs", and run the desired install command.
     */
    // TODO - CREATE AND CORRECT INSTALLER BUTTON FUNCTION!
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ProcessBuilder install = new ProcessBuilder();
        install.command("/.leolinuxcustom/programs/test.sh");
        try{
            Process installProcess = install.start();
        } catch (IOException e){
            JOptionPane.showMessageDialog(rootPane, "Error Occured!");
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }                                        

    /**
     * @param args the command line arguments
     * @throws Exception 
     */
    public static void main(String args[]) throws Exception {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeoLinuxJFramev1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeoLinuxJFramev1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeoLinuxJFramev1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeoLinuxJFramev1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new LeoLinuxJFramev1().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
                
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
