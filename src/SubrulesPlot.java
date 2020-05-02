import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

// Any JavaFX application must extend the Application class, which is abstract.
public class SubrulesPlot extends Application {

	
	public final int RULENUM = 181;
	
	public static void main(String[] args) {
		
		// Launch the JavaFX application. This method creates a 
		// LineChartExample object and calls its start method.
		launch(args);
	}
	
	// The start method is the entry point for any JavaFX application. It is 
	// the only abstract method of the Application class and must be 
	// overridden.
	//
	// The launch method passes the start method a reference to the primary 
	// Stage of the application. This Stage is the window that displays the 
	// application content.
	public void start(Stage stage) throws IOException {

		// Each data series shown in a LineChart is stored in an XYChart.Series 
		// object. The LineChart created by this code shows two data series, so 
		// two XYChart.Series objects are needed.
		// 
		// The type parameters in the declaration of an XYChart.Series specify 
		// the data types of the x-values and y-values. The possible types are 
		// String and Number. This LineChart shows a couple of trigonometric 
		// functions, so the x-values and y-values are both Numbers.
		//
		// Each XYChart.Series object has a name field. This field is used to 
		// label the data in the chart legend.
		XYChart.Series<Number, Number> ChartZero = new XYChart.Series<>();
		ChartZero.setName("subrule 0");
		
		XYChart.Series<Number, Number> ChartOne = new XYChart.Series<>();
		ChartOne.setName("subrule 1");
		
		XYChart.Series<Number, Number> ChartTwo = new XYChart.Series<>();
		ChartTwo.setName("subrule 2");
		
		XYChart.Series<Number, Number> ChartThree = new XYChart.Series<>();
		ChartThree.setName("subrule 3");
		
		XYChart.Series<Number, Number> ChartFour = new XYChart.Series<>();
		ChartFour.setName("subrule 4");
		
		XYChart.Series<Number, Number> ChartFive = new XYChart.Series<>();
		ChartFive.setName("subrule 5");
		
		XYChart.Series<Number, Number> ChartSix = new XYChart.Series<>();
		ChartSix.setName("subrule 6");
		
		XYChart.Series<Number, Number> ChartSeven = new XYChart.Series<>();
		ChartSeven.setName("subrule 7");

		// Each XYChart.Series object stores a list of data points. The getData 
		// method returns a reference to this list.
		// 
		// Data is added to an XYChart.Series by adding it to its data list. 
		// The following lines simply store references to the data lists of 
		// sinSeries and cosSeries for use in the for-loop below.
		List<XYChart.Data<Number, Number>> zeroData = ChartZero.getData();
		List<XYChart.Data<Number, Number>> oneData = ChartOne.getData();
		List<XYChart.Data<Number, Number>> twoData = ChartTwo.getData();
		List<XYChart.Data<Number, Number>> threeData = ChartThree.getData();
		List<XYChart.Data<Number, Number>> fourData = ChartFour.getData();
		List<XYChart.Data<Number, Number>> fiveData = ChartFive.getData();
		List<XYChart.Data<Number, Number>> sixData = ChartSix.getData();
		List<XYChart.Data<Number, Number>> sevenData = ChartSeven.getData();


		// Calculate some data to display in the LineChart. To create your 
		// automaton plots, replace this loop with code that reads your Hamming 
		// distance or subrule counts data files.
		
			// Each data point in an XYChart.Series must be wrapped in an 
			// XYChart.Data object. The following lines add a point to 
			// sinSeries and cosSeries by adding a point to their data lists.
		
		System.out.println("Beginning");
		
		XYChart.Data<Number, Number> zeroPt = new XYChart.Data<>();
		XYChart.Data<Number, Number> onePt = new XYChart.Data<>();
		XYChart.Data<Number, Number> twoPt = new XYChart.Data<>();
		XYChart.Data<Number, Number> threePt = new XYChart.Data<>();
		XYChart.Data<Number, Number> fourPt = new XYChart.Data<>();
		XYChart.Data<Number, Number> fivePt = new XYChart.Data<>();
		XYChart.Data<Number, Number> sixPt = new XYChart.Data<>();
		XYChart.Data<Number, Number> sevenPt = new XYChart.Data<>();

		BufferedReader readerCircle = new BufferedReader(new FileReader("C:\\Users\\darre\\Desktop\\Project3\\project-3-Darrenfisherlol\\data\\subrules-elementary181-circularbc.csv"));
		
		String line = readerCircle.readLine();
		String[] DateDoubleArray = new String[7];
		
		int x = 0;
		while(line != null) {
			DateDoubleArray = line.split(",");
			
			int yAxis = Integer.parseInt(DateDoubleArray[0]);
			zeroPt = new XYChart.Data<>(x, yAxis);
			
			yAxis = Integer.parseInt(DateDoubleArray[1]);
			onePt = new XYChart.Data<>(x, yAxis);
			
			yAxis = Integer.parseInt(DateDoubleArray[2]);
			twoPt = new XYChart.Data<>(x, yAxis);
			
			yAxis = Integer.parseInt(DateDoubleArray[3]);
			threePt = new XYChart.Data<>(x, yAxis);
			
			yAxis = Integer.parseInt(DateDoubleArray[4]);
			fourPt = new XYChart.Data<>(x, yAxis);
			
			yAxis = Integer.parseInt(DateDoubleArray[5]);
			fivePt = new XYChart.Data<>(x, yAxis);
			
			yAxis = Integer.parseInt(DateDoubleArray[6]);
			sixPt = new XYChart.Data<>(x, yAxis);
			
			yAxis = Integer.parseInt(DateDoubleArray[7]);
			sevenPt = new XYChart.Data<>(x, yAxis);

			zeroData.add(zeroPt);
			oneData.add(onePt);
			twoData.add(twoPt);
			threeData.add(threePt);
			fourData.add(fourPt);
			fiveData.add(fivePt);
			sixData.add(sixPt);
			sevenData.add(sevenPt);
			
			
			line = readerCircle.readLine();
			x++;
		}
		
		readerCircle.close();
		
	
		

		// Create the x-axis and y-axis for the LineChart. The NumberAxis class 
		// is used because the data points are pairs of Numbers. If either the 
		// x-values or y-values were Strings, the CategoryAxis class would need 
		// to be used instead.
		//
		// NumberAxis has an overloaded constructor. The version used here has 
		// four parameters: the label, lower bound, upper bound, and tick unit.
		NumberAxis xAxis = new NumberAxis("step number", 0, 100, 5);
		NumberAxis yAxis = new NumberAxis("subrule count", 0, 100, 5);

		// Create the LineChart. The constructor takes references to both axes.
		//
		// Each LineChart object has a title field. If this field is set, the 
		// value will be shown at the top of the chart.
		//
		// By default, each data point is shown in the chart with a symbol, and 
		// the symbols are connected by lines. Setting the createSymbols field 
		// to false removes the symbols and only shows the lines.
		LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
		chart.setTitle("Elementary Rule 181 (Darren Fisher, ID#113463319)");
		chart.setCreateSymbols(false);

		// The data series shown in a LineChart are stored in a list. The 
		// getData method returns a reference to this list. (Note the 
		// similarity to the getData method of XYChart.Series.) The following 
		// lines add sinSeries and cosSeries to the LineChart.
		List<XYChart.Series<Number, Number>> seriesList = chart.getData();
		seriesList.add(ChartZero);
		seriesList.add(ChartOne);
		seriesList.add(ChartTwo);
		seriesList.add(ChartThree);
		seriesList.add(ChartFour);
		seriesList.add(ChartFive);
		seriesList.add(ChartSix);
		seriesList.add(ChartSeven);

		// The graphical components of a JavaFX application are stored in 
		// Scenes. In order to display the LineChart, it must be added to a 
		// Scene. The constructor used below takes a reference to the LineChart 
		// and integers specifying the width and height of the Scene in pixels.
		Scene scene = new Scene(chart, 960, 600);

		// Add the Scene to the application Stage (i.e., window), and call the 
		// show method to display it. (Only one Scene can be displayed in a 
		// Stage at a time.) The setTitle method is used to define the text 
		// that appears in the title bar of the window.
		stage.setScene(scene);
		stage.setTitle("Elementary Rule 181 (Darren Fisher, ID # 113463319)");
		stage.show();
		
		// Save a copy of the Scene as a PNG image.
		String filename = "plots" + File.separator + "subrules-elementary181-circularbc.png";
		saveScene(scene, filename);
	}
	
	// Create a PNG of the given Scene.
	public static void saveScene(Scene scene, String filename) throws 
			IOException {
		
		// Convert the given Scene to an image that can be written to a file.
		WritableImage image = scene.snapshot(null);
		BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
		
		// Create a file with the given name and save the image as a PNG.
		File output = new File(filename);
		ImageIO.write(bufferedImage, "png", output);
	}
}