import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
public class GUIRunner2 extends NameVault{
	public NameVault vault;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_8;
	
	/**
	* Launch the application.
	*/
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIRunner2 window = new GUIRunner2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	* Create the application.
	*/
	public GUIRunner2() {
		initialize();
		vault = new NameVault();
	}

	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNamevault = new JLabel("Continuum of Care Registry");
		lblNamevault.setBounds(283, 0, 2000, 20);
		frame.getContentPane().add(lblNamevault);

		JButton btnGetInformation = new JButton("Get Information");
		btnGetInformation.setBounds(402, 46, 203, 72);
		frame.getContentPane().add(btnGetInformation);

		JButton btnGetInformation2 = new JButton("Remove Entry");
		btnGetInformation2.setBounds(402, 226, 203, 72);
		frame.getContentPane().add(btnGetInformation2);
		
		textField = new JTextField();
		textField.setBounds(107, 155, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(23, 158, 69, 20);
		frame.getContentPane().add(lblName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JLabel lblyn = new JLabel("(Y/N)");
		lblyn.setBounds(23, 250, 119, 20);
		frame.getContentPane().add(lblyn);
		
		JLabel lblyn2 = new JLabel("(Y/N)");
		lblyn2.setBounds(23, 275, 119, 20);
		frame.getContentPane().add(lblyn2);
		
		JCheckBox chckbxEmployed2 = new JCheckBox("Veteran");
		chckbxEmployed2.setBounds(100, 275, 200, 20);
		frame.getContentPane().add(chckbxEmployed2);

		JLabel label = new JLabel("Name");
		label.setBounds(373, 161, 69, 20);
		frame.getContentPane().add(label);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(457, 158, 146, 26);
		frame.getContentPane().add(textField_8);

		JCheckBox chckbxEmployed = new JCheckBox("Employed");
		chckbxEmployed.setBounds(100, 250, 200, 20);
		frame.getContentPane().add(chckbxEmployed);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(102,46,203,72);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnSubmit2 = new JButton("Print List");
		btnSubmit2.setBounds(102,346,203,72);
		frame.getContentPane().add(btnSubmit2);
		btnSubmit2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{		
				ArrayList<Person> list = vault.printHash();
				try
				{
				    PrintWriter pr = new PrintWriter("file.txt");    

				    for (int i=0; i<list.size() ; i++)
				    {
				        pr.println(list.get(i));
				    }
				    pr.close();
				}
				catch (Exception e1)
				{
				    e1.printStackTrace();
				    System.out.println("No such file exists.");
				}
				JOptionPane.showMessageDialog(frame,"List exported to text file.");
			}
		});
		
		btnGetInformation2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{					
				String name = textField_8.getText();
				if(vault.locatePerson(name) == null){
					JOptionPane.showMessageDialog(frame,"An entry could not be found.");
				}
				else{
					vault.removeName(name);
					JOptionPane.showMessageDialog(frame,"Entry removed.");
				}
				textField_8.setText("");
			}
		});
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{					
				String name = textField.getText();
				int employed;
				if(chckbxEmployed.isSelected()){
					employed = 1;
				}
				else{
					employed = 0;
				}
				int vet;
				if(chckbxEmployed2.isSelected()){
					vet = 1;
				}
				else{
					vet = 0;
				}
				vault.inputName(name, employed, vet);
				JOptionPane.showMessageDialog(frame, "Submission confirmed.");
				chckbxEmployed.setSelected(false);
				chckbxEmployed2.setSelected(false);
				textField.setText("");
			}
		});
		btnGetInformation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{					
				String name = textField_8.getText();
				Person temp = vault.locatePerson(name);
				if(vault.locatePerson(name) == null){
					JOptionPane.showMessageDialog(frame,"An entry could not be found.");
					textField_8.setText("");
				}
				else{
				String name2 = temp.getName();
				String emp = temp.generateEmpStatus();
				String vet = temp.generateVetStatus();
				JOptionPane.showMessageDialog(frame,name2 + ", Enrolled"+ ", " + emp + ", " + vet);
				textField_8.setText("");
				}
			  }
			});
		}
	}
