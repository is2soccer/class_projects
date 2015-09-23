// Write your short report here (-2 if there is no report)
//
// When I was looking for how to do gray scale, I changed pixel image to buffered image
// and make it gray scale. After that, I tried to switch buffered image back to pixel image.
// however, it did not work. So I found a ratio of rgb in one pixel in gray scale, and added them
// together for each red, green, and blue. that's how i solved it.
// I added Motion blur, gray scale, and emboss filter.
// First, when I wrote a code, I only focus on 3x3 transformation.
// but i really need to write a code that works for any transformation(5x5 or 9x9)
// Especially i used 9x9 transformation for motion blur.
// My solution is 4 for loops to write a code that works for any transformation by weights.


/**
 * A class to configure the SnapShop application
 *
 * @author SEUNGHWAN LEE
 * @version DEC / 08 / 2014
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {

    theShop.setDefaultFilename("billg.jpg");
    theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
    theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
    // add your other filters below
    theShop.addFilter(new GaussianFilter(), "Gaussian");
    theShop.addFilter(new LaplacianFilter(), "Laplacian");
    theShop.addFilter(new UnsharpMasking(), "Unsharp masking");
    theShop.addFilter(new EdgyFilter(), "Edgy");
    theShop.addFilter(new EmbossFilter(), "Emboss");
    theShop.addFilter(new MotionBlurFilter(), "Motion Blur");
    theShop.addFilter(new NegativeEffectFilter(), "Negative");
    theShop.addFilter(new GrayScaleFilter(), "Grayscale");
  }
}
