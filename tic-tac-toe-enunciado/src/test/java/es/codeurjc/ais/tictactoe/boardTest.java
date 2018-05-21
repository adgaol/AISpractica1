package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.assertThat;


import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Before;




import es.codeurjc.ais.tictactoe.Board;
import es.codeurjc.ais.tictactoe.Player;
import es.codeurjc.ais.tictactoe.TicTacToeGame;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;


public class boardTest {
	private Player jugador1;
	private Player jugador2;
	private Board tablero;
	private TicTacToeGame juego;
	/*@Parameters
	public static Collection<Object[]> data() {
	Object[][] values = {
			{ 2, 3, 0, 4, 1, 5 },
			{ 3, 2, 4, 0, 5, 1 }
	};
	return Arrays.asList(values);
	}
	@Parameter(0) public int moveOne;*/
	@Before
	public void setUp() {
		jugador1=new Player(1, "pepe", "pepe");
		jugador2=new Player(2, "manolo", "manolo");
		tablero=new Board();
		juego=new TicTacToeGame();
		juego.addPlayer(jugador1);
		juego.addPlayer(jugador2);
                tablero.enableAll();
	}
	@Test
	public void ifwin() {
                juego.mark(2);
		juego.mark(3);
		juego.mark(0);
		juego.mark(4);
		juego.mark(1);
		int[] introducidos = new int[3];
		introducidos[0]=2;
		introducidos[1]=0;
		introducidos[2]=1;
                
		int [] tableroGanado=tablero.getCellsIfWinner(jugador2.getLabel());
                /*System.out.println(tableroGanado==null);*/
		for(int i=0;i<tableroGanado.length;i++) {
			assertThat(introducidos[i],equalTo(tableroGanado[i]));
		}
	}

}
