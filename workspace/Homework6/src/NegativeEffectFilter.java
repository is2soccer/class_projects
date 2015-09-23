
public class NegativeEffectFilter implements Filter {
	public void filter(PixelImage pi){
		Pixel[][] data = pi.getData();
		for (int col = 0; col < pi.getHeight(); col++){
			for (int row = 0; row < pi.getWidth(); row++){
				data[col][row].red = 255 - data[col][row].red;
				data[col][row].green = 255 - data[col][row].green;
		        data[col][row].blue = 255 - data[col][row].blue;
			}
		}

		pi.setData(data);
	}
}
