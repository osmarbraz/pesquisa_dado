public class Cronometro {  

	private static long valorInicio;  
	private static long valorParada;  
	private static long tempoDiferenca;  
	
	public static void inicio() {  
		valorInicio = System.currentTimeMillis();  
		valorParada = 0;  
		tempoDiferenca = 0;  
	}  

	public static void parada() {  
		valorParada = System.currentTimeMillis();  
		tempoDiferenca = valorParada - valorInicio;  
	}  

	public static long tempoGasto() {  
		return tempoDiferenca;  
	}  
}