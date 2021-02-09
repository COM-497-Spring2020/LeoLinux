//COM 301 Final Project v5.6 - Chase S. Franse
//Project Imports
import java.nio.file.*;
import java.io.*;
import java.util.*;
import static java.nio.file.StandardOpenOption.*;

//JFrame Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project_v5_EXE extends JFrame implements ActionListener{
	/***
	 * ADDITIONAL FUNCTIONALITY:
	 * - CONVERT TO JFRAME [Done] {Version 5}
	 *  -> PROMPT USERS FOR I/O PATHS [Done] {Version 5}
	 *  -> Automatically know that the specified input file is a ".java" [Done] {Version 5}
	 *  -> Automatically name the output file [Done] {Version 5}
	 * - DETERMINE AND OUTPUT WHERE THE ERRORS OCCCUR
	 * 	-> Using the point in the stack, re-read the file and find that position's line number,
	 * 	   display that line number along with the error message(s).
	 *  -> Display the remaining items in the stack to the output file. [Done] {Version 6}
	 ***/
	
	//JFrame Creation Elements
	final int WIDTH = 600;
	final int HEIGHT = 300;
	JPanel section1 = new JPanel();
	JLabel inputPathRequestDia = new JLabel("Please Provide a Direct Input File Path (Path & File Name):");
	JTextField inputPathRequest = new JTextField((WIDTH/12));
	JLabel outputPathRequestDia = new JLabel("Please Provide an Output File Path (Path & Desired File Name.txt):");
	JTextField outputPathRequest = new JTextField((WIDTH/12));
	JLabel leftSpacing = new JLabel("------------------------------------------------");
	JLabel rightSpacing = new JLabel("------------------------------------------------");
	JButton button = new JButton("NEXT");
	JLabel result = new JLabel("");
	JLabel test = new JLabel("TEST");
	
	
	//JFrame Itself
	public Project_v5_EXE() {
		super("Bracket Checker");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(inputPathRequestDia);
		add(inputPathRequest);
		add(outputPathRequestDia);
		add(outputPathRequest);
		add(leftSpacing);
		add(button);
		add(rightSpacing);
		add(result);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent x) {
		String inputPath = inputPathRequest.getText();
		String outputPath = outputPathRequest.getText();
		
		inputPath.concat(".java");
		outputPath.concat("Bracket Checker Results.txt");
		
		//Get and create variables for the input and output paths
		Path file = Paths.get(inputPath);
		Path outPath = Paths.get(outputPath);
		
		//Checks to see if the output file already exists or not. If so, it deletes it, and will replace it with a new one later.
		File f = new File(outPath.toString());
		if (f.exists()) {
			f.delete();
		}
		
		InputStream input = null;
		OutputStream output = null;
		byte[] data;
		boolean CHECK = false;
		
		//Use a TRY-CATCH just in-case there are any I/O issues
		try {
			//Create a Buffered Reader and Output Stream for reading and writing to the files specified above
			input = Files.newInputStream(file);
			output = new BufferedOutputStream(Files.newOutputStream(outPath, CREATE));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String s = null;
			s = reader.readLine();
			data = s.getBytes();
			
			/******
			 * PROGRAM MUST:
			 * - Read through EVERY line of the provided file. [WHILE LOOP]
			 * - Determine if there are any issues with the "delimiters." [IF STATEMENTS]
			 * - Delimiters Include:
			 * 		-> [
			 * 		-> ]
			 * 		-> (
			 * 		-> )
			 * 		-> {
			 * 		-> }
			 * - If ANY of the delimiters don't have a pair, then there is an error.
			 * - If ALL of the delimiters have pairs, then there are no errors.
			 * - Display in Console && Output results to "Delimiter Results.txt"
			 * 
			 * HINT PROVIDED: Use a STACK data structure to hold each of the delimiters.
			 ******/
			
			//Creation of the Delimiter Stack
			Stack<String> st = new Stack<String>();
			
			//Read and output to Console every line of the specified file (CHANGING NOTHING WITHIN THE FILE)
			while (s != null) {
				//Checks for each instance of a delimiter and adds them all to the "Stack"
				if (s.contains("["))
					st.push("[");
				if (s.contains("]"))
					st.push("]");
				if (s.contains("("))
					st.push("(");
				if (s.contains(")"))
					st.push(")");
				if (s.contains("{"))
					st.push("{");
				if (s.contains("}"))
					st.push("}");
				
				CHECK = checkStack(st);
				
				System.out.println(s);
				s = reader.readLine();
			}
										
			if (CHECK == true) {
				//There were no errors
				String errorMsg = "No syntax errors were found.";
				data = errorMsg.getBytes();
				output.write(data);
				output.flush();
				System.out.println("\nNo syntax errors were found.");
				result.setText("No syntax errors were found.");
			} else if (CHECK == false) {
				//There were errors
				String errorMsg = "Syntax errors were found.";
				data = errorMsg.getBytes();
				output.write(data);
				//ADDITIONAL FUNCTIONALITY: Have the program determine which line the error occurred on.
				output.flush();
				System.out.println("\nSyntax errors were found.");
				result.setText("Syntax errors were found.");
			}
			
			reader.close();
			output.close();
			input.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

	public static void main(String[] args) {
		//JFrame Creation & Display
		Project_v5_EXE frame = new Project_v5_EXE();
		frame.setVisible(true);
	}
			
	public static void readStack(Stack<String> st) {
		for(int e = 0; e < st.size(); e++) {
			System.out.println(st.get(e));
		}
	}
	
	public static boolean checkStack(Stack<String> st) {
		boolean CHECK = true;
		//Loop through each element in the Stack.
		for(int e = 0; e < st.size(); e++) {
			String popped = st.pop();
			if (popped == "]" && st.peek() == "[") {
				st.pop();
			} else if (popped == ")" && st.peek() == "(") {
				st.pop();
			} else if (popped ==  "}" && st.peek() == "{") {
				st.pop();
			} else {
				st.push(popped);
			}
		}
		
		if (st.empty() == true)
			CHECK = true;
		else if (st.empty() == false)
			CHECK = false;
		
		return CHECK;
	}
		
	}
