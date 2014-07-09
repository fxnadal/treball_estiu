
public class Equip {
	private int idLigaX;
	private int idEquipoX;
	private String nombreEquipoX;
	private int golesFavorX;
	private int golesEnContraX;
	private int partidosGanadosX;
	private int partidosPerdidosX;
	
	public void setIdLiga(int idLiga){
		idLigaX=idLiga;
		
	}
	
	
	
	public int getIdLiga(){
		return idLigaX;
		
	}
	public String toString()
	{
		return nombreEquipoX;
	}
	public int getIdEquipo(){
		return idEquipoX;
		
	}
	
	public void setIdEquipo(int idEquipo){
		idEquipoX=idEquipo;
	}
	
	public String getNombreEquipo(){
		return nombreEquipoX;
		
	}
	
	public void setNombreEquipo(String nombreEquipo){
		nombreEquipoX=nombreEquipo;
	}
	
	public int getGolesFavor(){
		return golesFavorX;
		
	}
	
	public void setGolesFavor(int golesFavor){
		golesFavorX=golesFavor;
	}
	
	public int getPartidosGanados(){
		return partidosGanadosX;
	
	}
	
	public void setPartidosGanados(int partidosGanados){
		partidosGanadosX=partidosGanados;
	}
	
	public int getPartidosPerdidos(){
		return partidosPerdidosX;
		
	}
	
	public void setPartidosPerdidos(int partidosPerdidos){
		partidosPerdidosX=partidosPerdidos;
	}
	
	public int getGolesEnContra(){
		return golesEnContraX;
	
	}
	
	public void setGolesEnContra(int golesEnContra){
		golesEnContraX=golesEnContra;
	}
}
