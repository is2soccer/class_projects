import java.awt.image.*;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage {
	private BufferedImage myImage;
	private int width;
	private int height;

	/**
	 * Map this PixelImage to a real image
	 * 
	 * @param bi
	 *            The image
	 */
	public PixelImage(BufferedImage bi) {
		// initialise instance variables
		this.myImage = bi;
		this.width = bi.getWidth();
		this.height = bi.getHeight();
	}

	/**
	 * Return the width of the image
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Return the height of the image
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Return the BufferedImage of this PixelImage
	 */
	public BufferedImage getImage() {
		return this.myImage;
	}

	/**
	 * Return the image's pixel data as an array of Pixels. The first coordinate
	 * is the x-coordinate, so the size of the array is [width][height], where
	 * width and height are the dimensions of the array
	 * 
	 * @return The array of pixels
	 */
	public Pixel[][] getData() {
		Raster r = this.myImage.getRaster();
		Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
		int[] samples = new int[3];

		for (int row = 0; row < r.getHeight(); row++) {
			for (int col = 0; col < r.getWidth(); col++) {
				samples = r.getPixel(col, row, samples);
				Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
				data[row][col] = newPixel;
			}
		}

		return data;
	}

	/**
	 * Set the image's pixel data from an array. This array matches that
	 * returned by getData(). It is an error to pass in an array that does not
	 * match the image's dimensions or that has pixels with invalid values (not
	 * 0-255)
	 * 
	 * @param data
	 *            The array to pull from
	 */
	public void setData(Pixel[][] data) {
		int[] pixelValues = new int[3]; // a temporary array to hold r,g,b
										// values
		WritableRaster wr = this.myImage.getRaster();

		if (data.length != wr.getHeight()) {
			throw new IllegalArgumentException("Array size does not match");
		} else if (data[0].length != wr.getWidth()) {
			throw new IllegalArgumentException("Array size does not match");
		}

		for (int row = 0; row < wr.getHeight(); row++) {
			for (int col = 0; col < wr.getWidth(); col++) {
				pixelValues[0] = data[row][col].red;
				pixelValues[1] = data[row][col].green;
				pixelValues[2] = data[row][col].blue;
				wr.setPixel(col, row, pixelValues);
			}
		}
	}

	// add a method to compute a new image given weighted averages
	public void transformImage(int[][] weights) {
	  Pixel[][] data = this.getData();
	  Pixel[][] data2 = this.getData(); // this way data2
	  // has automatically the same size as data
	  int dominator = 0;
	  for(int i = 0; i<weights.length; i++){
		  for(int j = 0; j<weights.length; j++){
			  dominator += weights[i][j];
		  }
	  }
	  
	  // loop to create the new pixels and you put them in data2
	  // data2[i][j].red = weights[0][0]*data[i-1][j-1].red ...
//	  for(int i = 1; i<height-1; i++){
//		  for(int j = 1; j<width-1; j++){
//			  if( dominator != 0){
//				  data2[i][j].red = (weights[0][0]*data[i-1][j-1].red + weights[0][1]*data[i-1][j].red + weights[0][2]*data[i-1][j+1].red +
//						  weights[1][0]*data[i][j-1].red + weights[1][1]*data[i][j].red + weights[1][2]*data[i][j+1].red +
//						  weights[2][0]*data[i+1][j-1].red + weights[2][1]*data[i+1][j].red + weights[2][2]*data[i+1][j+1].red) /dominator;
//				  data2[i][j].green = (weights[0][0]*data[i-1][j-1].green + weights[0][1]*data[i-1][j].green + weights[0][2]*data[i-1][j+1].green +
//						  weights[1][0]*data[i][j-1].green + weights[1][1]*data[i][j].green + weights[1][2]*data[i][j+1].green +
//						  weights[2][0]*data[i+1][j-1].green + weights[2][1]*data[i+1][j].green + weights[2][2]*data[i+1][j+1].green) /dominator;
//				  data2[i][j].blue = (weights[0][0]*data[i-1][j-1].blue + weights[0][1]*data[i-1][j].blue + weights[0][2]*data[i-1][j+1].blue +
//						  weights[1][0]*data[i][j-1].blue + weights[1][1]*data[i][j].blue + weights[1][2]*data[i][j+1].blue +
//						  weights[2][0]*data[i+1][j-1].blue + weights[2][1]*data[i+1][j].blue + weights[2][2]*data[i+1][j+1].blue) /dominator;
//			  }else{
//				  data2[i][j].red = (weights[0][0]*data[i-1][j-1].red + weights[0][1]*data[i-1][j].red + weights[0][2]*data[i-1][j+1].red +
//						  weights[1][0]*data[i][j-1].red + weights[1][1]*data[i][j].red + weights[1][2]*data[i][j+1].red +
//						  weights[2][0]*data[i+1][j-1].red + weights[2][1]*data[i+1][j].red + weights[2][2]*data[i+1][j+1].red);
//				  data2[i][j].green = (weights[0][0]*data[i-1][j-1].green + weights[0][1]*data[i-1][j].green + weights[0][2]*data[i-1][j+1].green +
//						  weights[1][0]*data[i][j-1].green + weights[1][1]*data[i][j].green + weights[1][2]*data[i][j+1].green +
//						  weights[2][0]*data[i+1][j-1].green + weights[2][1]*data[i+1][j].green + weights[2][2]*data[i+1][j+1].green);
//				  data2[i][j].blue = (weights[0][0]*data[i-1][j-1].blue + weights[0][1]*data[i-1][j].blue + weights[0][2]*data[i-1][j+1].blue +
//						  weights[1][0]*data[i][j-1].blue + weights[1][1]*data[i][j].blue + weights[1][2]*data[i][j+1].blue +
//						  weights[2][0]*data[i+1][j-1].blue + weights[2][1]*data[i+1][j].blue + weights[2][2]*data[i+1][j+1].blue);
//				  
	  for(int i = weights.length/2; i<height-weights.length/2; i++){
		  for(int j = weights.length/2; j<width-weights.length/2; j++){
			  int sumR = 0;
			  int sumG = 0;
			  int sumB = 0;
			  for(int s = 0; s<weights.length; s++){
				  for(int t = 0; t<weights.length; t++){
					  sumR += (weights[s][t]*data[i-weights.length/2+s][j-weights.length/2+t].red);
					  sumG += (weights[s][t]*data[i-weights.length/2+s][j-weights.length/2+t].green);
					  sumB += (weights[s][t]*data[i-weights.length/2+s][j-weights.length/2+t].blue);
					  if (dominator !=0){
						  data2[i][j].red = sumR / dominator;
						  data2[i][j].green = sumG / dominator;
						  data2[i][j].blue = sumB / dominator;
					  }else{
						  data2[i][j].red = sumR;
						  data2[i][j].green = sumG;
						  data2[i][j].blue = sumB;
						  
					  }
				  }
			  }
			  sumR = 0;
			  sumG = 0;
			  sumB = 0;
			  if(data2[i][j].red < 0){
				  data2[i][j].red = 0;
			  }
			  if(data2[i][j].green < 0){
				  data2[i][j].green = 0;
			  }
			  if(data2[i][j].blue < 0){
				  data2[i][j].blue = 0;
			  }
			  if(data2[i][j].red > 255){
				  data2[i][j].red = 255;
			  }
			  if(data2[i][j].green > 255){
				  data2[i][j].green = 255;
			  }
			  if(data2[i][j].blue > 255){
				  data2[i][j].blue = 255;
			  }
		  }
	  
	  }
	  this.setData(data2);
	}

}


