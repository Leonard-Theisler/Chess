package view;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Sprite {
	
	private int x;
	private int y;
	
	private Image imageDisplayed;
	private int width;
	private int height;
	
	private BoardPanel canvas;
	

	public Sprite(Image image, int x, int y, BoardPanel canvas) {
		this.imageDisplayed = image;
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
		this.canvas = canvas;
		
		setX(x);
		setY(y);
	}
	
	public void drawUsing(Graphics2D g2) {
		g2.drawImage(imageDisplayed, null, null);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}
