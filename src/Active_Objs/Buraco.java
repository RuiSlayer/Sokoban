package Active_Objs;



import Movabel_Objs.BigStone;
import Movabel_Objs.Caixote;
import Movabel_Objs.Empilhadora;
import Movabel_Objs.Movabel;
import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Point2D;
import sokoban.starter.LevelMesages;
import sokoban.starter.Map;
import sokoban.starter.SokobanGame;

public class Buraco extends ActiveObjs  {
	
	public Buraco(Point2D pos) {
		super("Buraco", pos, 1, true);
	}
	
	public void observarMovabel(Movabel m, Map nivel, int lastKeyPressed) {
		if(!(nivel.getBigStone().inPosition)) {
			if(m instanceof BigStone) {
				((BigStone)m).block();
				return;
			}
			m.setLayer(0);
			nivel.getNivel().remove(m);
			ImageMatrixGUI.getInstance().update();
			
			if(m instanceof Empilhadora) {
				LevelMesages.gameOver();
				SokobanGame.getInstance().resetNivel();
				ImageMatrixGUI.getInstance().update();
			}
			if(m instanceof Caixote) {
				if((nivel.getCaixotes().size() - 1) < nivel.getAlvos().size())
					LevelMesages.gameOver();
					SokobanGame.getInstance().resetNivel();
					ImageMatrixGUI.getInstance().update();
			}
		}
	}
	
}
