package grafica;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import rescate.Escenario;

public class CampoDeBatallaConsola extends JPanel{
	private JLabel robot;
	private JLabel energia;
	private JLabel bombas;
	private JLabel nivelVida;
	private JLabel rescatados;
	private JLabel municiones;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/*
	 * Constructor de la clase TableroConsola 
	 */
	public CampoDeBatallaConsola(){
		this.setBounds(5, 5, 25,23);
		this.setBackground(Color.DARK_GRAY);
		this.setLocation(50,50);
		setForeground(new Color(192, 192, 192));
		setLayout(null);		

		this.robot = new JLabel("ROBOT HUMANO");
		this.robot.setBounds(40, 40,40,40);	
	}	
	
	public void actualizar(Escenario escenario) {
		robot.setText(""+this.robot);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
