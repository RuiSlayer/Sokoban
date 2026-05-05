package Active_Objs;

import AbstractObjs.AbstractObjs;
import Movabel_Objs.Movabel;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.Map;

public class Portal_Azul extends ActiveObjs {

	public Portal_Azul(Point2D pos) {
		super("Portal_Azul", pos, 1, true);
	}
	
	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {
		Point2D novaPos = nivel.getPortal_Azul_Pos(pos);
		nivel.getObjcsOnPoint(novaPos);
		for(AbstractObjs a : nivel.getObjcsOnPoint(novaPos)) {
			if(a instanceof Movabel)
				return;
		}
		m.setPosition(novaPos);
		
		ImageMatrixGUI.getInstance().removeImage(m);
		ImageMatrixGUI.getInstance().update();
		ImageMatrixGUI.getInstance().addImage(m);
		ImageMatrixGUI.getInstance().update();
	}
}
