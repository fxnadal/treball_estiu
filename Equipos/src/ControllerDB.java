import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;


public class ControllerDB {
	//DB
	Connection conexion = null; //maneja la conexión
	Statement instruccion = null;// instrucción de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	
	public ControllerDB() {
		//Nos conectamos a la base de datos
		crearConexion();
	}

	private void crearConexion(){
		//Conectarnos a la base de datos
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexión a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","");
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}// fin de catch			
	}

	//En este método leeremos de la base de datos los equipos existentes
	// 1.- Leer de la base de datos
	// 2.- Actualizar el combobox
	public void leerEquipos(JComboBox<Equip> listadoEquipos){
		//Aquí realizaremos la consulta y actualización del combobox
		
		try{			
			// consulta la base de datos
			instruccion = (Statement) conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM equipos");
			
			// actualizacion combobox
			
			
			while(conjuntoResultados.next()){
				
				Equip equip1= new Equip();
				equip1.setNombreEquipo(conjuntoResultados.getString("nombreEquipo"));
				equip1.setIdEquipo((int) conjuntoResultados.getObject("idEquipo"));
				equip1.setPartidosPerdidos((int)conjuntoResultados.getObject("partidosPerdidos"));
				equip1.setPartidosGanados((int)conjuntoResultados.getObject("partidosGanados"));
				equip1.setGolesFavor((int)conjuntoResultados.getObject("golesFavor"));
				equip1.setGolesEnContra((int)conjuntoResultados.getObject("golesEnContra"));
				//equip1.setIdLiga((int)conjuntoResultados.getObject("nombreEquipo"));
				listadoEquipos.addItem(equip1);
				
			}
			//conexion.close();
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin
	
	}

	//En este método leeremos de la base de datos los equipos existentes
	// 1.- Crearemos la consulta a la base de datos (Statement)
	// 2.- Lanzaremos la consulta
	// 3.- Eliminaremos todos los elementos del combobox
	// 4.- Volveremos a rellenar el combobox
	public void insertarEquipos(int x1,String s1,int x2,int x3, int x4,int x5,JComboBox<Equip> listadoEquipos){
		//Aquí realizaremos la consulta

	try {			
			instruccion = (Statement) conexion.createStatement();
			
			// consulta la base de datos
			String sql_inst="INSERT INTO equipos ( idLiga,nombreEquipo,golesFavor,golesEnContra,partidosGanados,partidosPerdidos )";
			sql_inst=sql_inst+ "VALUES( "+x1+",'"+s1+"',"+x2+","+x3+","+x4+","+x5+")";
			System.out.println(sql_inst);
			instruccion.executeUpdate(sql_inst);
			
			conjuntoResultados.next();				
			//conexion.close();
			
			
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin
				
		//Actualización del combobox
		listadoEquipos.removeAllItems();
		leerEquipos(listadoEquipos);
	}
}