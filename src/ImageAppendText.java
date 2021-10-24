import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import javax.imageio.ImageIO;

/**
 * 1. Need to install the Font first
 * 2. Use Graphics2D to append text on Image
 * 
 * @author swGuan
 *
 */
public class ImageAppendText {

	public static void main(String[] args) {
		try {
			BufferedImage image = ImageIO
					.read(new FileInputStream(ImageAppendText.class.getResource("BACKGROUND.JPG").getFile()));
			Graphics2D g = image.createGraphics();

			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(Color.WHITE);
			
			Font title = new Font("PingFang TC Regular", Font.PLAIN, 50);
			Font fontRegularPlain = new Font("PingFang TC Regular", Font.PLAIN, 35);
			Font fontLightPlain = new Font("PingFang TC Light", Font.PLAIN, 20);
			Integer currency = 30;
			// title
			g.setFont(title);
			g.drawString("美金 USD", 45, 100);
			// item USD => TWD
			g.setFont(fontRegularPlain);
			g.drawString("匯率", 220, 235);
			g.setFont(fontRegularPlain);
			g.drawString("1 USD = " + currency, 340, 235);
			g.setFont(fontRegularPlain);
			g.drawString("TWD", 635, 235);

			g.setFont(fontLightPlain);
			g.drawString("＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿", 200, 260);

			// item USD => TWD
			g.setFont(fontRegularPlain);
			g.drawString("100", 220, 315);
			g.setFont(fontRegularPlain);
			g.drawString("USD = " + (100 * currency), 375, 315);
			g.setFont(fontRegularPlain);
			g.drawString("TWD", 640, 315);
			g.dispose();
			// output image
			ImageIO.write(image, "jpg", new File(new Date().getTime() + ".jpg"));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
