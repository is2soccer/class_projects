
public class GrayScaleFilter implements Filter{
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		for (int i = 0; i<pi.getHeight(); i++){
			for (int j = 0; j<pi.getWidth(); j++){
				int red= (int) (data[i][j].red * 0.299);
				int green = (int) (data[i][j].green * 0.587);
				int blue = (int) (data[i][j].blue * 0.114);
				data[i][j].red = red+green+blue;
				data[i][j].green = red+green+blue;
				data[i][j].blue = red+green+blue;
			}
		}
		pi.setData(data);
	}
	
}