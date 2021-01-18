package main.boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

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

@SuppressWarnings("serial")
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
	private final JCheckBox chckbxAncesters = new JCheckBox("Ancestors");
	private final JCheckBox chckbxDecendents = new JCheckBox("Decendents");
	private final JButton btnNext = new JButton("Next Page");
	LinkedList<String> list = null;
	int pagenum = 0;
	private final JButton btnPreviousPage = new JButton("Previous Page");

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
		frame.setBounds(100, 100, 900, 825);
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		
		txtSearchByName = new JTextField();
		txtSearchByName.setText("Search by name");
		
		btnNext.setVisible(false);
		btnNext.setEnabled(false);
		btnPreviousPage.setVisible(false);
		btnPreviousPage.setEnabled(false);
		
		
		frame.getContentPane().add(txtSearchByName, "4, 4, fill, center");
		txtSearchByName.setColumns(10);
		
		txtSearchByCountry = new JTextField();
		txtSearchByCountry.setText("Search by Country");
		frame.getContentPane().add(txtSearchByCountry, "6, 4, fill, center");
		txtSearchByCountry.setColumns(10);
		
		txtSearchByDate = new JTextField();
		txtSearchByDate.setText("Search by Date");
		frame.getContentPane().add(txtSearchByDate, "8, 4, fill, top");
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
		
		/**
		 * Listener for the submit button
		 * when button is clicked a query with the specified filter will be sent to the database to search for photos
		 * the database returns the address of were the specific pictures are located
		 */
		frame.getContentPane().add(btnSearch, "8, 10, center, top");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagenum =0;
				DAO dao = new DAO();
				int con = 0;
				con = dao.connect();
				if(con == 0) {
					txtSearchByCountry.setText("DB NOT connected");
				}
				
				String search = dao.getSearchString(t, chckbxAncesters.isSelected(), chckbxDecendents.isSelected(), chckbxUseNameFilter.isSelected(),chckbxUseLocationFilter.isSelected(), chckbxUseDateFilter.isSelected(),txtSearchByName.getText(), txtSearchByCountry.getText(), txtSearchByDate.getText()); 
				dao.connect();
				list = dao.getPersonPhotos(search);
				btnPreviousPage.setVisible(false);
				btnPreviousPage.setEnabled(false);
				showSearchResults();
				//this will add a next page button if there are more pictures that were returned that can fit into one page
				if(list.size()>9) {
					btnNext.setVisible(true);
					btnNext.setEnabled(true);
				}else {
					btnNext.setVisible(false);
					btnNext.setEnabled(false);
				}
			}
		});
		frame.getContentPane().add(jPhoto1, "6, 12");
		frame.getContentPane().add(jPhoto2, "4, 12");
		frame.getContentPane().add(jPhoto3, "8, 12");
		frame.getContentPane().add(jPhoto4, "4, 14");
		frame.getContentPane().add(jPhoto5, "6, 14");
		frame.getContentPane().add(jPhoto6, "8, 14");
		frame.getContentPane().add(jPhoto7, "4, 16");
		frame.getContentPane().add(jPhoto8, "6, 16");
		frame.getContentPane().add(jPhoto9, "8, 16");
		
		btnPreviousPage.setVisible(false);
		btnPreviousPage.setEnabled(false);
		
		/**
		 * Next button listener
		 * Next button will give you the next page of pictures and will also make a previous page button appear 
		 */
		frame.getContentPane().add(btnPreviousPage, "4, 18, left, default");
		btnNext.setVisible(false);
		btnNext.setEnabled(false);
		frame.getContentPane().add(btnNext, "10, 16, center, top");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagenum++;
				int pagesavailable = (list.size())/9;
				int remainder= (list.size())%9;
				if(remainder != 0) {pagesavailable++;}
				if(pagenum<pagesavailable) {
					btnNext.setVisible(false);
					btnNext.setEnabled(false);
				}
				if(pagenum>0) {
					btnPreviousPage.setVisible(true);
					btnPreviousPage.setEnabled(true);
				}
				showSearchResults();
			}
		});
		
		/**
		 * Previous Page button listener
		 * Previous Page button will return you to the previous page
		 */
		frame.getContentPane().add(btnNext, "8, 18");
		btnPreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagenum--;
				int pagesavailable = (list.size())/9;
				int remainder= (list.size())%9;
				if(remainder != 0) {pagesavailable++;}
				if(pagenum<pagesavailable) {
					btnNext.setVisible(true);
					btnNext.setEnabled(true);
				}
				if(pagenum==0) {
					btnPreviousPage.setVisible(false);
					btnPreviousPage.setEnabled(false);
				}
				showSearchResults();
			}
		});
		
		
	}
	
	/**
	 * showPhoto() takes a JLabel and an image Path
	 * it will insert the image into the jLabel
	 */
	public void showPhoto(JLabel label, String imagePath) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
	}
	
	
	/**
	 * showSearchResults will display the images 
	 * found from the search
	 * if no photos were found in the search "no results found" will appear
	 */
	public void showSearchResults() {
		int i=(pagenum*9);
		int j=0;
		if(list.size()<1) {
			showPhoto(slots[0], "Fotos/noResults.JPG");
		}
		for( j=0; j<slots.length; j++) {
			if(list.size() > i) {
				showPhoto(slots[j], list.get(i));
				i++;
			}
			else {
				if(i==0) {
					showPhoto(slots[j], "Fotos/noResults.JPG");
					i++;
				}
				else {
					showPhoto(slots[j], "Fotos/white.JPG");
				}
			}
			
			
		}
	}
}
