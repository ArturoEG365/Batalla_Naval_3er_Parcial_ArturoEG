import java.util.*;
public class final_proyecto {
	public static void main(String[] args) {	
		//...:::::ZONA DE VARIABLES:::::.....
		Scanner leer_datos = new Scanner(System.in);
		int tamaño_tablero = 0, numero_de_barcos = 0;
		//......:::VARIABLES DE VERIFICACION:::.....
		int comprobar_maximo_barcos = 1;
		//....:::: ZONA DE PROGRAMAR::::::.......
		System.out.println("..........::::: PROOYECTO BATALLA NAVAL :::::..........");
		System.out.println("REGLAS: \n1.- Usar puros numeros\n2.- Minimo 1 barco y Maximo 4 barcos");
		do{
			int aux_numero_de_puntos_ocupados = 0;
			System.out.print("\n ¿De que tamaño el tablero? (nxn): ");
			tamaño_tablero = leer_datos.nextInt();
			System.out.print("\n ¿Con cuantos barcos jugamos?: ");
			numero_de_barcos = leer_datos.nextInt();
			for(int aux = 1; aux <= numero_de_barcos; aux++)
				aux_numero_de_puntos_ocupados+= aux;
			if(numero_de_barcos >= 1 && numero_de_barcos <= 4 && (tamaño_tablero*tamaño_tablero)>=aux_numero_de_puntos_ocupados){
				comprobar_maximo_barcos = 2; //COMENZAR EL JUEGO
				comenzar_juego(tamaño_tablero, numero_de_barcos);
			}else{
				System.out.println("\n\nIntenta de nuevo, revisa el tamaño de los barcos\n\n");
			}
		}while(comprobar_maximo_barcos==1);
	}//ultima llave main
//...........:::::ZONA DE FUNCIONES:::::.................
	public static void comenzar_juego(int tamaño_tablero, int numero_de_barcos){
		Scanner leer_datos = new Scanner(System.in);
		int TABLERO_JUGADOR_1 [][] = new int[tamaño_tablero+1][tamaño_tablero+1];
		int TABLERO_JUGADOR_2 [][] = new int[tamaño_tablero+1][tamaño_tablero+1];
		limpiar_pantalla();
		System.out.println("¿Como se llama el jugador 1?");
		String nombre_jugador_1 = leer_datos.nextLine();
		System.out.println("¿Como se llama el jugador 2?");
		String nombre_jugador_2 = leer_datos.nextLine();
		limpiar_pantalla();
		System.out.println(":::::::"+ nombre_jugador_1 + " vs " + nombre_jugador_2 + ":::::::");
		int acertados_jugador_1 = 0, acertados_jugador_2 = 0, aux_numero_de_puntos_ocupados = 0, x , y;
		for(int aux = 1; aux <= numero_de_barcos; aux++)
			aux_numero_de_puntos_ocupados+= aux;
		limpiar_pantalla();                                     //JUGADOR 1 METE SUS BARCOS
		System.out.println(nombre_jugador_1 + " Ingresa tus barcos por favor C:");
		for(int aux_puntos = 1; aux_puntos <= aux_numero_de_puntos_ocupados; aux_puntos++){
			mostrar_tablero_poniendo_barcos(tamaño_tablero, TABLERO_JUGADOR_1);
			System.out.println("Ingresa el punto #"+aux_puntos);
			System.out.println("POSICION EN X:");
			x = leer_datos.nextInt();
			System.out.println("POSICION EN Y:");
			y = leer_datos.nextInt();
			if(x >= 1 && x <= tamaño_tablero && y >= 1 && y <= tamaño_tablero ){
				if(TABLERO_JUGADOR_1 [y][x] == 7){
					System.out.println("Ya hay un barco en esa posicion, intenta de nuevo");
					aux_puntos--;
				}else{
					System.out.println("Tirada {"+x+","+y+"}");
					TABLERO_JUGADOR_1 [y][x] = 7;
				}
			}else{
				System.out.println("Error de dimenciones");
				aux_puntos--;
			}
		}
		//													JUGADOR 2 METE SUS BARCOS
		limpiar_pantalla();                                    
		System.out.println(nombre_jugador_2 + " Ingresa tus barcos por favor C:");
		for(int aux_puntos = 1; aux_puntos <= aux_numero_de_puntos_ocupados; aux_puntos++){
			mostrar_tablero_poniendo_barcos(tamaño_tablero, TABLERO_JUGADOR_2);
			System.out.println("Ingresa el punto #"+aux_puntos);
			System.out.println("POSICION EN X:");
			x = leer_datos.nextInt();
			System.out.println("POSICION EN Y:");
			y = leer_datos.nextInt();
			if(x >= 1 && x <= tamaño_tablero && y >= 1 && y <= tamaño_tablero ){
				if(TABLERO_JUGADOR_2 [y][x] == 7){
					System.out.println("Ya hay un barco en esa posicion, intenta de nuevo");
					aux_puntos--;
				}else{
					System.out.println("Tirada {"+x+","+y+"}");
					TABLERO_JUGADOR_2 [y][x] = 7;
				}
			}else{
				System.out.println("Error de dimenciones");
				aux_puntos--;
			}
		}
		limpiar_pantalla();
		//SIGUE EL PROGRAMA
		int tiros_buenos_1=0, tiros_buenos_2=0, campana=1;
		do{
			do{
				if(tiros_buenos_1>=aux_numero_de_puntos_ocupados){
					tiros_buenos_1++;
					System.out.println("Gana" + nombre_jugador_1);  // cd C:\Users\ArtuEG\Documents\PROGRAMAS-PRUEBAS
					mostrar_tablero(tamaño_tablero, TABLERO_JUGADOR_2);
					System.exit(0);
				}else{
					if(tiros_buenos_1<aux_numero_de_puntos_ocupados){
						System.out.println("\n\n\nTurno " + nombre_jugador_1+"   PUNTOS:"+ tiros_buenos_1);
						mostrar_tablero(tamaño_tablero, TABLERO_JUGADOR_2);
						System.out.println("ATAQUE");
						System.out.println("POSICION EN X:");
						x = leer_datos.nextInt();
						System.out.println("POSICION EN Y:");
						y = leer_datos.nextInt();
						System.out.println("Tiro {"+x+","+y+"}");
						if(x >= 1 && x <= tamaño_tablero && y >= 1 && y <= tamaño_tablero ){
							if(TABLERO_JUGADOR_2 [y][x] == 0){
								System.out.println("Fallaste");
								TABLERO_JUGADOR_2 [y][x] = 1;
								campana=2;
							}else{
								if(TABLERO_JUGADOR_2 [y][x] == 1 || TABLERO_JUGADOR_2 [y][x] == 2){
									System.out.println("Ya tiraste en esa posicion, intenta de nuevo");
								}else{
									if(TABLERO_JUGADOR_2 [y][x] == 7){
										System.out.println("Le diste a un barco");
										TABLERO_JUGADOR_2 [y][x] = 2;
										tiros_buenos_1++;
									}
								}
							}
						}else{
							System.out.println("Fuera de rango");
						}
					}
				}
			}while(campana==1);
			campana=1;
			do{
				if(tiros_buenos_2>=aux_numero_de_puntos_ocupados){
					tiros_buenos_2++;
					System.out.println("Gana" + nombre_jugador_2);  // cd C:\Users\ArtuEG\Documents\PROGRAMAS-PRUEBAS
					mostrar_tablero(tamaño_tablero, TABLERO_JUGADOR_1);
					System.exit(0);
				}else{
					if(tiros_buenos_2<aux_numero_de_puntos_ocupados){
						System.out.println("\n\n\nTurno " + nombre_jugador_2+"   PUNTOS:"+ tiros_buenos_2);
						mostrar_tablero(tamaño_tablero, TABLERO_JUGADOR_1);
						System.out.println("ATAQUE");
						System.out.println("POSICION EN X:");
						x = leer_datos.nextInt();
						System.out.println("POSICION EN Y:");
						y = leer_datos.nextInt();
						System.out.println("Tiro {"+x+","+y+"}");
						if(x >= 1 && x <= tamaño_tablero && y >= 1 && y <= tamaño_tablero ){
							if(TABLERO_JUGADOR_1 [y][x] == 0){
								System.out.println("Fallaste");
								TABLERO_JUGADOR_1 [y][x] = 1;
								campana=2;
							}else{
								if(TABLERO_JUGADOR_1 [y][x] == 1 || TABLERO_JUGADOR_1 [y][x] == 2){
									System.out.println("Ya tiraste en esa posicion, intenta de nuevo");
								}else{
									if(TABLERO_JUGADOR_1 [y][x] == 7){
										System.out.println("Le diste a un barco");
										TABLERO_JUGADOR_1 [y][x] = 2;
										tiros_buenos_2++;
									}
								}
							}
						}else{
							System.out.println("Fuera de rango");
						}
					}
				}
			}while(campana==1);
			campana=1;
		}while(tiros_buenos_1 <= aux_numero_de_puntos_ocupados && tiros_buenos_2 <= aux_numero_de_puntos_ocupados);
	}
	public static void mostrar_tablero_poniendo_barcos(int tamaño_tablero, int [][] TABLERO_JUGADOR){
		int aux_x =0, aux_y=0;
		for(aux_x = 1; aux_x<=tamaño_tablero; aux_x++)
			System.out.print("{"+aux_x+"} ");
		System.out.println("\n");
		for( aux_x = 1; aux_x <= (tamaño_tablero); aux_x++){
			for( aux_y  = 1; aux_y <= (tamaño_tablero); aux_y++){
				if(TABLERO_JUGADOR[aux_x][aux_y]==1){
					System.out.print("{-} ");  // TIRO FALLADO
				}else{
					if(TABLERO_JUGADOR[aux_x][aux_y]==2){
						System.out.print("{X} "); // TIRO ACERTADO
					}else{
						if(TABLERO_JUGADOR[aux_x][aux_y]==0 || TABLERO_JUGADOR[aux_x][aux_y]==5){
							System.out.print("{0} "); // POSICION LIBRE
						}else{
							if(TABLERO_JUGADOR[aux_x][aux_y]==7){
								System.out.print("{+} ");  // BARCO
							}
						}
					}
				}
			}
			System.out.println("  {"+aux_x+"} ");
		}
		System.out.println("\n*************************************");
	}
	public static void mostrar_tablero(int tamaño_tablero, int [][] TABLERO_JUGADOR){
		int aux_x =0, aux_y=0;
		for(aux_x = 1; aux_x<=tamaño_tablero; aux_x++)
			System.out.print("{"+aux_x+"} ");
		System.out.println("\n");
		for( aux_x = 1; aux_x <= (tamaño_tablero); aux_x++){
			for( aux_y  = 1; aux_y <= (tamaño_tablero); aux_y++){
				if(TABLERO_JUGADOR[aux_x][aux_y]==1){
					System.out.print("{-} ");  // TIRO FALLADO
				}else{
					if(TABLERO_JUGADOR[aux_x][aux_y]==2){
						System.out.print("{X} "); // TIRO ACERTADO
					}else{
						if(TABLERO_JUGADOR[aux_x][aux_y]==0 || TABLERO_JUGADOR[aux_x][aux_y]==7){
							System.out.print("{0} "); // POSICION LIBRE
						}
					}
				}
			}
			System.out.println("  {"+aux_x+"} ");
		}
		System.out.println("\n*************************************");
	}
	public static void limpiar_pantalla(){
		for(int aux = 0; aux <= 50; aux++)
			System.out.println();
	}
}//ULTIMA LLAVE