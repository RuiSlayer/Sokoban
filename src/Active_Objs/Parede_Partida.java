package Active_Objs;


import Movabel_Objs.Empilhadora;
import Movabel_Objs.Movabel;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class Parede_Partida extends ActiveObjs{

	public Parede_Partida(Point2D pos) {
		super("Parede_Partida", pos, 1, false);
	}
	
	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {
		
		if(m instanceof Empilhadora && nivel.getEmpilhadora().isMartelo()) {
			nivel.getEmpilhadora().setMartelo(false);
			nivel.getNivel().remove(this);
			ImageMatrixGUI.getInstance().removeImage(this);	
		}
	}
	
}
