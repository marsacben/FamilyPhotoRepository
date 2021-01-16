package main.boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import main.database.DAO;
import main.model.Tree;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class eFamilyFotoBookApp extends JFrame{

	private JFrame frame;
	private JTextField txtSearchByName;
	JLabel jPhoto1 = new JLabel(new ImageIcon(""));
	JLabel jPhoto2 = new JLabel(new ImageIcon(""));
	JLabel jPhoto3 = new JLabel(new ImageIcon(""));
	JLabel jPhoto4 = new JLabel(new ImageIcon(""));
	JLabel jPhoto5 = new JLabel(new ImageIcon(""));
	JLabel jPhoto6 = new JLabel(new ImageIcon(""));
	JLabel jPhoto7 = new JLabel(new ImageIcon(""));
	JLabel jPhoto8 = new JLabel(new ImageIcon(""));
	JLabel jPhoto9 = new JLabel(new ImageIcon(""));
	JLabel[] slots = {jPhoto1, jPhoto2, jPhoto3, jPhoto4, jPhoto5, jPhoto6, jPhoto7, jPhoto8, jPhoto9};
	private JTextField txtSearchByCountry;
	private JTextField txtSearchByDate;
	private JCheckBox chckbxUseLocationFilter;
	private JCheckBox chckbxUseNameFilter;
	private JCheckBox chckbxUseDateFilter;
	private final JCheckBox chckbxAncesters = new JCheckBox("Ancesters");
	private final JCheckBox chckbxDecendents = new JCheckBox("Decendents");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eFamilyFotoBookApp window = new eFamilyFotoBookApp();
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
	public eFamilyFotoBookApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(13dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("center:default"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("min:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		String imagePath = "Fotos/CatyRock-Elisa-2020-Mexico.jpg";
		String imagePath2 = "Fotos/Elisa-Esteban-04-07-1931.jpg";
		/*
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("strawberry.jpg"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		//ImageIcon photo= new ImageIcon(myPicture)
		
		//Image photo = img.getScaledInstance(Jphoto1.getWidth(), Jphoto1.getHeight(),
		//        Image.SCALE_SMOOTH);
		*/
		
		//JLabel jPhoto1 = new JLabel(new ImageIcon(""));
		//showPhoto(jPhoto1, imagePath2);
		//frame.getContentPane().add(jPhoto1, "4, 6");
		
		//JLabel jPhoto2 = new JLabel(new ImageIcon(""));
		//showPhoto(jPhoto2, imagePath2);
		//frame.getContentPane().add(jPhoto2, "6, 6");
		
		//JLabel jPhoto3 = new JLabel(new ImageIcon(""));
		//showPhoto(jPhoto3, imagePath);
		//frame.getContentPane().add(jPhoto3, "8, 6");
		
		//JLabel jPhoto4 = new JLabel(new ImageIcon(""));
		//showPhoto(jPhoto4, imagePath);
		//frame.getContentPane().add(jPhoto4, "4, 8");
		String[] arr = {imagePath2, imagePath2,imagePath2, imagePath2};
		
		txtSearchByName = new JTextField();
		txtSearchByName.setText("Search by name");
		
		
		frame.getContentPane().add(txtSearchByName, "4, 4, left, center");
		txtSearchByName.setColumns(10);
		
		txtSearchByCountry = new JTextField();
		txtSearchByCountry.setText("Search by Country");
		frame.getContentPane().add(txtSearchByCountry, "6, 4, left, center");
		txtSearchByCountry.setColumns(10);
		
		txtSearchByDate = new JTextField();
		txtSearchByDate.setText("Search by Date");
		frame.getContentPane().add(txtSearchByDate, "8, 4, left, top");
		txtSearchByDate.setColumns(10);
		
		chckbxUseNameFilter = new JCheckBox("Use Name Filter");
		frame.getContentPane().add(chckbxUseNameFilter, "4, 6");
		
		chckbxUseLocationFilter = new JCheckBox("Use Location Filter");
		frame.getContentPane().add(chckbxUseLocationFilter, "6, 6, left, top");
		
		chckbxUseDateFilter = new JCheckBox("Use Date Filter");
		frame.getContentPane().add(chckbxUseDateFilter, "8, 6");
		
		frame.getContentPane().add(chckbxAncesters, "4, 8");
		
		frame.getContentPane().add(chckbxDecendents, "4, 10");
		JButton btnSearch = new JButton("Search");
		
		Tree t = new Tree();
		t.createTree();
		
		frame.getContentPane().add(btnSearch, "8, 10, center, top");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtSearchByName.getText();
				DAO dao = new DAO();
				dao.connect();
				String search = dao.getSearchString(t, chckbxAncesters.isSelected(), chckbxDecendents.isSelected(), chckbxUseNameFilter.isSelected(),chckbxUseLocationFilter.isSelected(), chckbxUseDateFilter.isSelected(),txtSearchByName.getText(), txtSearchByCountry.getText(), txtSearchByDate.getText()); 
				dao.connect();
				String[] arr= dao.getPersonPhotos(search);
				showSearchResults(arr);
			}
		});
		//showSearchResults(arr);
		frame.getContentPane().add(jPhoto1, "6, 12");
		frame.getContentPane().add(jPhoto2, "4, 12");
		frame.getContentPane().add(jPhoto3, "8, 12");
		frame.getContentPane().add(jPhoto4, "4, 14");
		frame.getContentPane().add(jPhoto5, "6, 14");
		frame.getContentPane().add(jPhoto6, "8, 14");
		frame.getContentPane().add(jPhoto7, "4, 16");
		frame.getContentPane().add(jPhoto8, "6, 16");
		frame.getContentPane().add(jPhoto9, "8, 16");
		
		
	}
	
	public void showPhoto(JLabel label, String imagePath) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
	}
	
	public void showSearchResults(String[] arr) {
		for(int i=0; i<slots.length; i++) {
			if(arr[i] != null) {
				//JLabel jPhoto1 = new JLabel(new ImageIcon(""));
				showPhoto(slots[i], arr[i]);
			}
			else {
				if(i==0) {
					showPhoto(slots[i], "Fotos/noResults.JPG");
				}
				else {
					showPhoto(slots[i], "noResults.JPG");//white.JPG
				}
			}
		}
		/*if(arr[0] != null) {
			//JLabel jPhoto1 = new JLabel(new ImageIcon(""));
			showPhoto(jPhoto1, arr[0]);
			frame.getContentPane().add(jPhoto1, "4, 6");
		}
		
		if(arr[1] != null) {
			JLabel jPhoto2 = new JLabel(new ImageIcon(""));
			showPhoto(jPhoto2, arr[1]);
			frame.getContentPane().add(jPhoto2, "6, 6");
		}
		
		if(arr[2] != null) {
		JLabel jPhoto3 = new JLabel(new ImageIcon(""));
		showPhoto(jPhoto3, arr[2]);
		frame.getContentPane().add(jPhoto3, "8, 6");
		}
		
		
		if(arr[3] != null) {
		JLabel jPhoto4 = new JLabel(new ImageIcon(""));
		showPhoto(jPhoto4, arr[3]);
		frame.getContentPane().add(jPhoto4, "4, 8");
		}*/
	}
}
