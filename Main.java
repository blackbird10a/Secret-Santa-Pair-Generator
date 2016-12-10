import java.awt.EventQueue;
import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
public class Main {

	private JFrame frmSecretFriendPair;
	private JTextField Nameinputfield;
	public static ArrayList<String> names = new ArrayList<String>();
	private JTextArea NamesInput;
	private JButton btnGeneratePairings;
	private JTextArea Random;
	private JSeparator separator;
	private JButton btnImportNames;
	private JSplitPane splitPane;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmSecretFriendPair.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSecretFriendPair = new JFrame();
		frmSecretFriendPair.setTitle("Secret Friend Pair Generator");
		frmSecretFriendPair.setBounds(100, 100, 450, 300);
		frmSecretFriendPair.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSecretFriendPair.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow]"));
		
		Nameinputfield = new JTextField();
		frmSecretFriendPair.getContentPane().add(Nameinputfield, "flowx,cell 0 1,alignx left");
		Nameinputfield.setColumns(10);
		
		JButton btnInputname = new JButton("Input Name");
		btnInputname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				names.add(Nameinputfield.getText());
				NamesInput.append("\n"+Nameinputfield.getText());
				Nameinputfield.setText("");
				
			}
		});
		frmSecretFriendPair.getContentPane().add(btnInputname, "cell 0 1");
		
		separator = new JSeparator();
		frmSecretFriendPair.getContentPane().add(separator, "flowx,cell 0 2");
		
		btnGeneratePairings = new JButton("Generate Pairings");
		btnGeneratePairings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random.setText("Random:\n"+SecretFriend.Generate(names));
			}
		});
		frmSecretFriendPair.getContentPane().add(btnGeneratePairings, "cell 0 1");
		
		btnImportNames = new JButton("Import Names");
		btnImportNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(frmSecretFriendPair);
				if(returnVal==chooser.APPROVE_OPTION){
					File namesInput = chooser.getSelectedFile();
					try{
					Scanner myInput = new Scanner(namesInput);
					while(myInput.hasNextLine()){
						String temp = myInput.nextLine();
						names.add(temp);
						NamesInput.append("\n"+temp);
					}
					}
					catch(IOException error){
						System.out.println(error.getMessage());
					}
				}
			}
		});
		frmSecretFriendPair.getContentPane().add(btnImportNames, "cell 0 1");
		
		splitPane = new JSplitPane();
		frmSecretFriendPair.getContentPane().add(splitPane, "cell 0 2,grow");
		
		scrollPane_2 = new JScrollPane();
		splitPane.setLeftComponent(scrollPane_2);
		
		NamesInput = new JTextArea();
		scrollPane_2.setViewportView(NamesInput);
		NamesInput.setEditable(false);
		NamesInput.setWrapStyleWord(true);
		NamesInput.setLineWrap(true);
		NamesInput.setText("Names:");
		
		scrollPane_3 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_3);
		
		Random = new JTextArea();
		scrollPane_3.setViewportView(Random);
		Random.setEditable(false);
		Random.setText("Random:");
		Random.setLineWrap(true);
		
		
		
		
	}
}
