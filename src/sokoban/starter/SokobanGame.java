package sokoban.starter;


import javax.swing.JOptionPane;

import AbstractObjs.AbstractObjs;
import Active_Objs.Alvo;
import Movabel_Objs.Empilhadora;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.observer.Observed;
import pt.iul.ista.poo.observer.Observer;

public class SokobanGame implements Observer {
	private String playerName = JOptionPane.showInputDialog("Enter player name:");
	
	private static SokobanGame single_instance = null;
//__________________Status_____________________________\\
	private int nivelNr = 0;
	
//__________________Objectos____________________________\\
	private Map nivel;
	private Empilhadora player;

//_________________MetodoSolitao_________________________\\
	public static SokobanGame getInstance() {
		if (single_instance == null)
			single_instance = new SokobanGame();
		return single_instance;
	}
	
//_________________crearNivel_____________________________\\
	private void createLevel() {
		nivel = LoadLevel.load("levels/level"+getNivelNr() + ".txt");
		player = nivel.getEmpilhadora();
		for(AbstractObjs a : nivel.getNivel())
			ImageMatrixGUI.getInstance().addImage(a);
	}
	
//_________________Construtor______________________________\\
	private SokobanGame(){
		createLevel();
	}
	
//-------------------Update---------------------------------\\
	@Override
	public void update(Observed arg0) {
		int lasKeyPressed = ((ImageMatrixGUI) arg0).keyPressed();
		if(lasKeyPressed == 82) {
			resetNivel();
			return;
		}
		player.movementeRecibe(nivel, lasKeyPressed);

		statusBarUpdate();
		
		verifyBateriaLevel();
		
		passarNivel();
	}
//--------------------End_Sokoban_Update-----------------------------\\

//_________________Verificar_O_NivelDeBateria____________________________\\	
	private void verifyBateriaLevel() {
		if(player.getBateriaLevel() < 0) {
			LevelMesages.runOutOffBeta();
			resetNivel();
		}
	}
	
//______________________ResetNivel___________________________\\
//_______________se_carregar_no _R_o_nivel_�_reiniciado_______\\	
	public void resetNivel() {
		player.resetStatusVaribles();
		statusBarUpdate();
		ImageMatrixGUI.getInstance().clearImages();
		createLevel();
		ImageMatrixGUI.getInstance().update();
	}
//______________________Vitoria_______________________________\\	
	private void passarNivel() {
		int countAlvoSet = 0;
		
		for(Alvo a : nivel.getAlvos()) {
			if(a.isCaixoteAbove()) {
				countAlvoSet++;
			}
		}
		if(countAlvoSet == nivel.getAlvos().size()) {
			LeaderBoard.LerLeaderBoard();
			LevelMesages.success();
			setNextNivelNr();
			countAlvoSet = 0;
			ImageMatrixGUI.getInstance().clearImages();
			createLevel();
			statusBarUpdate();
			ImageMatrixGUI.getInstance().update();
		}
	}

//______________________Geters&Seters___________________________\\	
	public int getNivelNr() {
		return nivelNr;
	}
	
	public void setNextNivelNr() {
		this.nivelNr++;
	}
	
	public Empilhadora getPlayer() {
		return player;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	private String marteloEquiped() {
		if(player.isMartelo())
			return "Equiped";
		return "Unequiped";
	}
	
//______________________StatusBarUpdate___________________________\\
	public void statusBarUpdate(){
		ImageMatrixGUI.getInstance().setStatusMessage(
				 "   level: " + SokobanGame.getInstance().getNivelNr()+
				 "  Score: " + player.getScore() 
				+"  Bateria: " + player.getBateriaLevel() + "% " 
				+" | Martelo - " + marteloEquiped() 
				+"   R - ResetLevel  " );
		ImageMatrixGUI.getInstance().update();
	}
}
