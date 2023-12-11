package Vue;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;

import Controleur.GestionFenPaiement;
import Controleur.GestionSaisirLogement;
import jdbc.CictOracleDataSource;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class SaisirLogement extends JInternalFrame{
	private GestionSaisirLogement gsl;
	private AbstractButton btn_Inserer;
	private JButton btn_Annuler;
	private JCheckBox chckbx_Garage;
	private JCheckBox chckbx_Jardin;
	private JCheckBox chckbx_Balcon;
	private JComboBox CB_TypeLogement;
	private JSpinner sp_Icc;
	private JSpinner sp_Surface;
	private JSpinner sp_nbLogment;
	private JSpinner sp_Etage;
	private JComboBox CB_NbBatiment;
	private JLabel lblLeNumeroDu_1;
	// private JTable tableC;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaisirCreneau frame = new SaisirCreneau(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public SaisirLogement() {
		setBorder(new LineBorder(SystemColor.activeCaption, 2));
		setTitle("Saisie des informations");
		setBounds(100, 100, 471, 567);
		getContentPane().setLayout(null);
		this.gsl = new GestionSaisirLogement(this);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(14, 49, 439, 479);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saisir les informations du Logement");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(115, 26, 236, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblLeNumeroDu = new JLabel("Le numero du logement : ");
		lblLeNumeroDu.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLeNumeroDu.setBounds(20, 34, 129, 13); 
		panel.add(lblLeNumeroDu);
		
		sp_nbLogment = new JSpinner();
		sp_nbLogment.setModel(new SpinnerNumberModel(0, 0, null, 1));
		sp_nbLogment.setBounds(159, 23, 256, 35);/*(159, 79, 256, 35);*/
		panel.add(sp_nbLogment);
		
		JLabel labelVille = new JLabel("Etage :");
		labelVille.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelVille.setBounds(20, 90, 129, 13);
		panel.add(labelVille);
		
		sp_Etage = new JSpinner();
		sp_Etage.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		sp_Etage.setBounds (159, 79, 256, 35);
		panel.add(sp_Etage);
		
		JLabel labelDebsemc = new JLabel("Type logement :");
		labelDebsemc.setFont(new Font("Tahoma", Font.BOLD, 10));
		labelDebsemc.setBounds (20, 152, 129, 13);/*(20, 214, 129, 13);*/
		panel.add(labelDebsemc);
		
		CB_TypeLogement = new JComboBox();
		CB_TypeLogement.setModel(new DefaultComboBoxModel(new String[] {"T1", "T2", "T3", "T4", "T5", "T6"}));
		CB_TypeLogement.setSelectedIndex(0);
		CB_TypeLogement.setBounds(159, 135, 256, 35);
		panel.add(CB_TypeLogement);
		
		JLabel label_Id_GrpC_1 = new JLabel("Surface : ");
		label_Id_GrpC_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_Id_GrpC_1.setBounds(20, 214, 129, 13);
		panel.add(label_Id_GrpC_1);
		
		sp_Surface = new JSpinner();
		sp_Surface.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(100), Float.valueOf(1)));
		sp_Surface.setBounds(159, 191, 256, 35);
		panel.add(sp_Surface);
		
		JLabel label_Id_GrpC = new JLabel("ICC :");
		label_Id_GrpC.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_Id_GrpC.setBounds(20, 278, 129, 13);
		panel.add(label_Id_GrpC);
		
		sp_Icc = new JSpinner();
		sp_Icc.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
		sp_Icc.setBounds(159, 247, 256, 35);
		panel.add(sp_Icc);
		
		chckbx_Garage = new JCheckBox("Garage");
		chckbx_Garage.setBounds(40, 382, 97, 23);
		panel.add(chckbx_Garage);
		
		chckbx_Jardin = new JCheckBox("Jardin");
		chckbx_Jardin.setBounds(174, 382, 97, 23);
		panel.add(chckbx_Jardin);
		
		chckbx_Balcon = new JCheckBox("Balcon");
		chckbx_Balcon.setBounds(308, 382, 97, 23);
		panel.add(chckbx_Balcon);
		
		btn_Inserer = new JButton("Inserer");
		btn_Inserer.addActionListener(this.gsl);
		btn_Inserer.setBounds(263, 436, 85, 21);
		panel.add(btn_Inserer);
		
		btn_Annuler = new JButton("Annuler");
		btn_Annuler.addActionListener(this.gsl);
		btn_Annuler.setBounds(89, 436, 85, 21);
		panel.add(btn_Annuler);
		
		JLabel lblLeNumeroDub = new JLabel("Le numero du batiment : ");
		lblLeNumeroDub.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLeNumeroDub.setBounds(20, 334, 129, 13); 
		panel.add(lblLeNumeroDub);
		
		/*CB_NbBatiment = new JComboBox();
		try {
			CictOracleDataSource cictOracleDataSource = new CictOracleDataSource();
			String[] valeursBat = cictOracleDataSource.getColomnValues("ID_BATIMENT");
			CB_NbBatiment.setModel(new DefaultComboBoxModel(valeursBat));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		CB_NbBatiment.setBounds(159, 309, 256, 35);
		panel.add(CB_NbBatiment);
		
		
		
		
		
		
		/*CB_NbBatement = new JComboBox();
		CB_NbBatement.setBounds(159, 23, 256, 35);
		panel.add(CB_NbBatement);
		
		lblLeNumeroDu_1 = new JLabel("Le numero du batement : ");
		lblLeNumeroDu_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblLeNumeroDu_1.setBounds(20, 34, 129, 13);
		panel.add(lblLeNumeroDu_1);*/
		
		
	}

	public int getTextFieldNbBatement() {
	    return (int) Integer.valueOf(this.CB_NbBatiment.getItemAt(this.CB_NbBatiment.getSelectedIndex()).toString());
	}

	public int getTextFieldNbLogement() {
		return (int) this.sp_nbLogment.getValue();
	}
	
	public int getTextFieldEtage() {
		return (int)this.sp_Etage.getValue();
	}

	public String getTextFieldTypeLogement() {
		return this.CB_TypeLogement.getItemAt(this.CB_TypeLogement.getSelectedIndex()).toString();
	}

	public float getTextFieldSurface() {
		return (float) this.sp_Surface.getValue();
	}

	public float getTextFieldICC() {
		return (float) this.sp_Icc.getValue();
	}


	public int getTextFieldGarage() {
		int i =0;
		if (this.chckbx_Garage.isSelected())
			i=1;
			return i ;
	}


	public int getTextFieldJardin() {
		int i =0;
		if (this.chckbx_Jardin.isSelected())
			i=1;
			return i ;
	}
	
	public int getTextFieldBalcon() {
		int i =0;
		if (this.chckbx_Balcon.isSelected())
			i=1;
			return i;
	}


	public GestionSaisirLogement getGsl() {
		return gsl;
	}
}

