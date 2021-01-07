package main.boundary;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;

public class eFamilyFotoBookApp {

	private JFrame frame;

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
		frame.setBounds(100, 100, 575, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		String imagePath = "Fotos/Confusion.JPG";
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
		
		JLabel jPhoto1 = new JLabel(new ImageIcon(""));
		showPhoto(jPhoto1, imagePath2);
		frame.getContentPane().add(jPhoto1, "4, 6");
		
		JLabel jPhoto2 = new JLabel(new ImageIcon(""));
		showPhoto(jPhoto2, imagePath2);
		frame.getContentPane().add(jPhoto2, "6, 6");
		
		JLabel jPhoto3 = new JLabel(new ImageIcon(""));
		showPhoto(jPhoto3, imagePath);
		frame.getContentPane().add(jPhoto3, "8, 6");
		
		JLabel jPhoto4 = new JLabel(new ImageIcon(""));
		showPhoto(jPhoto4, imagePath);
		frame.getContentPane().add(jPhoto4, "4, 8");
		
		
	}
	
	public void showPhoto(JLabel label, String imagePath) {
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
	}

}
