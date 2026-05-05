package Active_Objs;

import Movabel_Objs.Movabel;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;
import sokoban.starter.SokobanGame;

public class Bateria extends ActiveObjs  {
	
	public Bateria(Point2D pos) {
		super("Bateria", pos, 1, true);
	}
	
	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {
		ImageMatrixGUI.getInstance().removeImage(this);
		nivel.getNivel().remove(this);
		SokobanGame.getInstance().getPlayer().resetBateria();
		ImageMatrixGUI.getInstance().update();
	}
}
