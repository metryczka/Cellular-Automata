package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import controller.Rule;

public class ArtPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private Rule rule;
	private static final int ON_COLOR = 0x00FF00;
	private static final int OFF_COLOR = 0x000000;
	private Random random = new Random();

	public ArtPanel(Rule rule) {
		this.rule = rule;

	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		if (image == null || image.getWidth() != width || image.getHeight() != height) {
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}

		boolean on = true;
		for (int x = 0; x < width; x++) {
			image.setRGB(x, 0, on ? ON_COLOR : OFF_COLOR);

			if (random.nextInt(20) == 0) {
				on = !on;
			}

		}
		
		for (int y =1; y <height; y++) {
			for (int x = 0; x < width; x++) {
				int xLeft = x == 0 ? width -1 : x-1;
				int xRight = x == width -1 ? 0: x +1;
				int leftColour = image.getRGB(xLeft, y-1) & 0xFFFFFF;
				int centerColour = image.getRGB(x, y-1) & 0xFFFFFF;
				int rightColour = image.getRGB(xRight, y-1) & 0xFFFFFF;
				int left = leftColour == ON_COLOR ? 1:0;
				int center = centerColour == ON_COLOR ? 1:0;
				int right = rightColour == ON_COLOR ? 1:0;
				int value = (left <<2)| (center<<1)|right;
				int pixelOn = rule.get(value);
				image.setRGB(x, y, pixelOn==1 ? ON_COLOR:OFF_COLOR);
				
				
			}
		}
		g.drawImage(image, 0, 0, null);
	}

}
