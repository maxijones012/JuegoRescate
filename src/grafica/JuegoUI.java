package grafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import rescate.Config;
import rescate.Elemento;
import rescate.Escenario;
import rescate.Robot;


public class JuegoUI extends JFrame implements JuegoListener{
	/**
	 * Clase JuegoUI donde se genera la parte grafica del juego
	 */
	private static final long serialVersionUID = 1L;
	private Config config = new Config();
	private Tablero tableroJuego;
	private TableroConsola tableroConsola;
	private Escenario escenario;
	
	
	/**
	 * Constructor de la clase JuegoUI en la que se setean las vistas en general
	 * @param escenario
	 */
	public JuegoUI(Escenario escenario){
		this.escenario = escenario;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		tableroConsola = new TableroConsola();		
		tableroJuego = new Tablero(escenario);					
		Container panel = this.getContentPane(); //PANEL		
		panel.setLayout(new BorderLayout());						
//		panel.add(tableroConsola,  (BorderLayout.EAST));
		
		agregarMenu(panel);				
		
		panel.add(tableroJuego, null);		 
		this.setSize(config.getAnchoTablero(),config.getAltoTablero());			
		this.setVisible(true);
		
		this.setVisible(true);
		tableroJuego.inicializar();
	}




	
	
	/**
	 * dijuba nuevamente todos los elementos que se encuentran el GUI
	 * @param escenario 
	 */
	@Override
	public void actualizar(Escenario escenario) {
		this.tableroJuego.actualizar();
		addKeyListener(tableroJuego);		
	}
	
	
	/**
	 * Agregamos elementos menu al panel del juego
	 * @param panel
	 */
	public void agregarMenu(Container panel){
		//menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setSize(800,20);
		
		JMenuItem mntmPausar = new JMenuItem("Pausar");		
		mntmPausar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				for(int i=0; i<escenario.getElementos().size(); i++){
					Elemento e1 = escenario.getElementos().get(i);
					e1.getEscenario().setPausa(true);
				}
				JOptionPane.showMessageDialog(tableroJuego, "JUEGO PAUSADO");
			}
		});
		
		//AÑADIMOS EL BOTON DE PAUSA
		menuBar.add(mntmPausar);
		
		
		JMenuItem mntmReanudar = new JMenuItem("Reanudar");
		mntmReanudar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
					for(int i=0; i<escenario.getElementos().size(); i++){
						Elemento e1 = escenario.getElementos().get(i);
						e1.getEscenario().setPausa(false);
					}
					}	
			});
		
		menuBar.add(mntmReanudar);
		
		//LO AÑADIMOS AL CONTAINER
		panel.add(menuBar);
	}






	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}


	
	
	
 
}
