import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Equipos extends JFrame {

	private JPanel contentPane;
	private JTextField nombreEquipo;
	private JTextField golesFavor;
	private JTextField golesEnContra;
	private JTextField partidosGanados;
	private JTextField partidosPerdidos;
	private JTextField textField_5;
	
	JComboBox<Equip> listadoEquipos;
	
	ControllerDB cDB = new ControllerDB();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipos frame = new Equipos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Equipos() {
		inicializarVentana();
		
		cDB.leerEquipos(listadoEquipos);
	}

	private void inicializarVentana(){
		setTitle("Equipos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listadoEquipos = new JComboBox<Equip>();
		listadoEquipos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				int index=listadoEquipos.getSelectedIndex();
				System.out.println(index);
				Equip equip1=listadoEquipos.getItemAt(listadoEquipos.getSelectedIndex());
				textField_5.setText(String.valueOf(equip1.getIdEquipo()));
				
				golesFavor.setText(String.valueOf(equip1.getGolesFavor()));
				
				golesEnContra.setText(String.valueOf(equip1.getGolesEnContra()));
				
				partidosGanados.setText(String.valueOf(equip1.getPartidosGanados()));
				
				partidosPerdidos.setText(String.valueOf(equip1.getPartidosPerdidos()));
					
			    nombreEquipo.setText(String.valueOf(equip1.getNombreEquipo()));
			}
		})
			
		;
		listadoEquipos.setBounds(0, 36, 424, 20);
		contentPane.add(listadoEquipos);

		JLabel lblEquiposDeFutbol = new JLabel("Equipos de Futbol");
		lblEquiposDeFutbol.setBounds(0, 11, 289, 14);
		contentPane.add(lblEquiposDeFutbol);

		JLabel label = new JLabel("Nombre del Equipo");
		label.setBounds(0, 81, 106, 14);
		contentPane.add(label);

		nombreEquipo = new JTextField();
		nombreEquipo.setText("Nombre equipo");
		nombreEquipo.setColumns(10);
		nombreEquipo.setBounds(116, 78, 308, 20);
		contentPane.add(nombreEquipo);

		JLabel label_1 = new JLabel("Goles a Favor");
		label_1.setBounds(0, 117, 106, 14);
		contentPane.add(label_1);

		golesFavor = new JTextField();
		golesFavor.setText("0");
		golesFavor.setColumns(10);
		golesFavor.setBounds(116, 114, 50, 20);
		contentPane.add(golesFavor);

		JLabel label_2 = new JLabel("Goles en Contra");
		label_2.setBounds(0, 154, 106, 14);
		contentPane.add(label_2);

		golesEnContra = new JTextField();
		golesEnContra.setText("0");
		golesEnContra.setColumns(10);
		golesEnContra.setBounds(116, 151, 50, 20);
		contentPane.add(golesEnContra);

		JLabel label_3 = new JLabel("Partidos Ganados");
		label_3.setBounds(0, 194, 106, 14);
		contentPane.add(label_3);

		partidosGanados = new JTextField();
		partidosGanados.setText("0");
		partidosGanados.setColumns(10);
		partidosGanados.setBounds(116, 192, 50, 20);
		contentPane.add(partidosGanados);

		JLabel label_4 = new JLabel("Partidos Perdidos");
		label_4.setBounds(0, 234, 106, 14);
		contentPane.add(label_4);

		partidosPerdidos = new JTextField();
		partidosPerdidos.setText("0");
		partidosPerdidos.setColumns(10);
		partidosPerdidos.setBounds(116, 231, 50, 20);
		contentPane.add(partidosPerdidos);

		JButton btnGuardarEquipoEn = new JButton("Guardar equipo en DB");
		btnGuardarEquipoEn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//pasar de txt a int
				String a = textField_5.getText();
				int x1 = Integer.parseInt(a);
				String b = golesFavor.getText();
				int x2 = Integer.parseInt(b);
				String c = golesEnContra.getText();
				int x3 = Integer.parseInt(c);
				String d = partidosGanados.getText();
				int x4 = Integer.parseInt(d);
				String e = partidosPerdidos.getText();
				int x5 = Integer.parseInt(e);	
				String s1 = nombreEquipo.getText();
				
				//datos que recibe el metodo insertarEquipos 
				cDB.insertarEquipos(x1, s1, x2, x3, x4, x5, listadoEquipos);
			}
		});
		btnGuardarEquipoEn.setBounds(0, 283, 166, 23);
		contentPane.add(btnGuardarEquipoEn);

		JLabel lblIdliga = new JLabel("IdLiga");
		lblIdliga.setBounds(314, 117, 50, 14);
		contentPane.add(lblIdliga);

		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setText("0");
		textField_5.setColumns(10);
		textField_5.setBounds(374, 114, 50, 20);
		contentPane.add(textField_5);		
	}
}