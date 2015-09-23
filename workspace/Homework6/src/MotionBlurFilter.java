
public class MotionBlurFilter implements Filter {
	public void filter(PixelImage pi) {
		int[][] weights = {{1,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0},
				{0,0,0,1,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0},
				{0,0,0,0,0,1,0,0,0},
				{0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,1}};
		pi.transformImage(weights);
	}

}
