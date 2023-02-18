import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.*;

public class HashmapJFrame extends JFrame {

	JPanel panel;
	JPanel panelShow;
	JTextField key;
	JTextField value;
	JButton add;
	
	JTextField keySearch;
	JButton search;
	JTextField keyShow;
	JTextField valueShow;
	HashMap<String,String> sozluk;
	
	public HashmapJFrame() {
		keySearch = new JTextField(10);
		keySearch.setFont(new Font("Dialog", Font.PLAIN,20));
		keySearch.setHorizontalAlignment(JTextField.CENTER);
		search= new JButton("Search");
		search.setFont(new Font("Dialog", Font.PLAIN,20));
		search.setFocusable(false);
		search.setBorder(BorderFactory.createEtchedBorder());
		
		
		keyShow = new JTextField(10);
		keyShow.setEditable(false);
		keyShow.setFont(new Font("Dialog", Font.PLAIN,20));
		keyShow.setHorizontalAlignment(JTextField.CENTER);
		valueShow = new JTextField(10);
		valueShow.setEditable(false);
		valueShow.setFont(new Font("Dialog", Font.PLAIN,20));
		valueShow.setHorizontalAlignment(JTextField.CENTER);
		
		search.addActionListener(e->{
			boolean check=sozluk.containsKey(keySearch.getText());
			if(check) {
				keyShow.setText(keySearch.getText());
				valueShow.setText( sozluk.get(keySearch.getText()));
			
				
			}
			else {
				
				keyShow.setText("No");
				valueShow.setText("Match!!");
			}
		});
		
		
		sozluk= new HashMap<>();
		panel= new JPanel();
		panelShow= new JPanel();
		panelShow.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		key= new JTextField(10);
		key.setBorder(BorderFactory.createTitledBorder("Key"));
		value= new JTextField(10);
		value.setBorder(BorderFactory.createTitledBorder("Value"));
		add= new JButton("Add");

		add.addActionListener(e-> {

		String keyAdd=	key.getText();
		String valueAdd= value.getText();

		sozluk.put(keyAdd, valueAdd);

		key.setText("");
		value.setText("");
			
		});
		
		panelShow.setBackground(new Color(98,25,41));
		panelShow.setLayout(new GridLayout(2,2,20,20));
		panelShow.add(keySearch);
		panelShow.add(search);
		panelShow.add(keyShow);
		panelShow.add(valueShow);
		panel.add(key);
		panel.add(value);
		panel.add(add);
		
		this.add(panel);
		this.add(panelShow);

		this.setTitle("Add key and value, than search");
		this.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocation(700, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {


		new HashmapJFrame();
	}

}
