import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// This class is used to express the data from Benford class as a graph.
// first, read the user input file and create Benford class to read counts for
// each leading digit. Then, using method from Benford to get percentage arraylist
// to display the percentage of each leading digits comparing to the benford frequencies
public class BenfordPlot {
	
	public static double[] benFreq = new double[]{0, 31.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};

	public static void main(String[] args) {
		Benford b = new Benford();
		String name = null;
		Scanner console = new Scanner(System.in);
		do{
			System.out.print("File name?: ");
			name = console.nextLine();
			try{
				Scanner input = new Scanner(new File(name));
				b.readCounts(input);
			}
			catch (FileNotFoundException ex){
				System.out.println("Error: File not found");
				name = null;
			}
			
		}while (name == null);
		
		
		double[] percents = b.benfordPercent(b.counts);
		
		double max = findMax(percents);
		
		drawGraph(max, percents);
		
		
	}
	// This method is used to find a maximum percantage value in percents arraylist
	// if there is a bigger value than the biggest value in benford frequencies
	public static double findMax(double[] d){
		double max = 30.1;
		for(int i = 0; i < d.length; i++){
			if(d[i] > max){
				max = d[i];
			}
		}
		return max;
	}
	
	// This method is used to draw graph for each leading digit percentage
	// gets maximum value and double arraylist as parameters.
	// Depends on the maximum value, graph scale changes.
	public static void drawGraph(double max, double[] percents){
		DrawingPanel d = new DrawingPanel(1200,880);
		d.setBackground(Color.BLACK);
		Graphics g = d.getGraphics();
		double mult = 1000.0 / max;
		g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		for(int i =1; i<percents.length; i++){
			if( i%2 == 1){
				g.setColor(Color.red);
			}else{
				g.setColor(Color.green);
			}
			g.fillRect(100, 80 * i, (int) (mult * percents[i]), 80);
			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(i), 50, 120 + 80 * (i-1));
			g.setColor(Color.BLACK);
			g.drawString(String.format( "%.1f", (percents[i])), (int) (100 + mult * percents[i] / 2), 120 + 80 * (i-1));
		}
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.ITALIC, 50));
		g.drawString("Population of Countries",300 , 50);
		for(int i = 1; i < benFreq.length; i++){
			g.drawString("^", (int) (100 + mult * benFreq[i]), 150 + 80 * (i-1));
		}
	}
}
