
public class EmbossFilter implements Filter {
	public void filter(PixelImage pi) {
		int[][] weights = {{-2,-1,0},{-1,1,1},{0,1,2}};
		pi.transformImage(weights);
	}
}
