package Active_Objs;

import Movabel_Objs.Empilhadora;
import Movabel_Objs.Movabel;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class Martelo extends ActiveObjs{

	public Martelo(Point2D pos) {
		super("Martelo", pos, 1, true);
	}
	
	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {
		if(m instanceof Empilhadora) {
			nivel.getEmpilhadora().setMartelo(true);
			nivel.getNivel().remove(this);
			ImageMatrixGUI.getInstance().removeImage(this);	
		}
	}

}
