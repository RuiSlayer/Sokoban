package AbstractObjs;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Point2D;

public abstract class AbstractObjs implements ImageTile {

	public String fileName;
	public Point2D pos;
	public int layer;
	public boolean tranposabel;
	
	public AbstractObjs(String fileName, Point2D pos, int layer, boolean transposabel) {
		this.fileName = fileName;
		this.pos = pos;
		this.layer = layer;
		this.tranposabel = transposabel;
	}
	
	@Override
	public  String getName() {
		return fileName;
	}
	
	@Override
	public  Point2D getPosition() {
		return pos;
	}
	
	public void setPosition(Point2D pos) {
		this.pos = pos;
	}
	
	public void setLayer(int novoLayer) {
		this.layer = novoLayer;
	}
	
	public boolean isTranposabel() {
		return tranposabel;
	}
	
	public void setTranposabel() {
		tranposabel = false;
	}
	
	@Override
	public  int getLayer() {
		return layer;
	}
	
	@Override
	public  String toString() {
		return fileName + " pos=" + pos + " layer=" + layer;
	}
}
