package main.boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

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
		
		frame.getContentPane().add(btnSearch, "8, 10, center, top");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagenum =0;
				String name = txtSearchByName.getText();
				DAO dao = new DAO();
				dao.connect();
				String search = dao.getSearchString(t, chckbxAncesters.isSelected(), chckbxDecendents.isSelected(), chckbxUseNameFilter.isSelected(),chckbxUseLocationFilter.isSelected(), chckbxUseDateFilter.isSelected(),txtSearchByName.getText(), txtSearchByCountry.getText(), txtSearchByDate.getText()); 
				dao.connect();
				list = dao.getPersonPhotos(search);
				btnPreviousPage.setVisible(false);
				btnPreviousPage.setEnabled(false);
				showSearchResults();
				if(list.size()>9) {
					btnNext.setVisible(true);
					btnNext.setEnabled(true);
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
	
	public void showPhoto(JLabel label, String imagePath) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
	}
	
	public void showSearchResults() {
		int i=(pagenum*9);
		if(list.size()<1) {
			showPhoto(slots[0], "Fotos/noResults.JPG");
		}
		int length=0;
		if(slots.length< list.size()) {
			length = slots.length;
		}
		else {
			length = list.size();
		}
		for( int j=0; j<length; i++) {
			if(list.size() >= j && list.size()>0) {
				showPhoto(slots[j], list.get(i));
			}
			else {
				if(i==0) {
					showPhoto(slots[j], "Fotos/noResults.JPG");
				}
				else {
					showPhoto(slots[j], "noResults.JPG");//white.JPG
				}
			}
			j++;
			//if(j>slots.length-1) {
			//	i=list.size();
			//}
		}
		/*for(int k=j; k<9;k++) {
			if(k==0) {
				showPhoto(slots[1], "Fotos/noResults.JPG");
				System.out.println(k+"Fotos/noResults.JPG");
			}
			showPhoto(slots[k], "white.JPG");
		}*/
		
	}
}
