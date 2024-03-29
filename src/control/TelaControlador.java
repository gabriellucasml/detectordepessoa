package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.MetricaChebychev;
import model.MetricaEuclidiana;
import model.MetricaManhattan;

public class TelaControlador implements Initializable{
	private int k = 3;
	private String datasetPath = "detectordepessoas\\dataset.csv";
	private boolean euclidianCheck, manhattanCheck, chebychevCheck;
	
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private Button applayMetric;
	
	@FXML
	private Button searchImage;
	
	@FXML
	private Text imagePath;
	
	@FXML
	private TextField imageTxt;
	
	@FXML 
	private ImageView imageView;
	
	@FXML
	private Label result, imageURL;
	
	@FXML
	private MenuBar menuBar;
	
	@FXML
	private Menu dataset, metric, help;
	
	@FXML
	private MenuItem changeDataset, cahngeK, about;
	
	@FXML
	private CheckMenuItem euclidianCheckbox, manhattanCheckbox, chebychevCheckbox;
	
	@FXML
	public void searchAction(ActionEvent e){
		try {
			imageURL.setText("");
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new ExtensionFilter("PNG file", "*.png"));
			File file = fileChooser.showOpenDialog(null);
			imageTxt.setText(file.getAbsolutePath());
		}catch(Exception excetion){
			imageURL.setText("Something seems to be wrong here. Choose another file.");
		}
	}
	
	@FXML
	public void applyMetric(ActionEvent e) {
		ArrayList<Float> img = new ArrayList<Float>();
		String euclidian, manhattan, chebychev;
		try {
			Dataset dtset = new Dataset(datasetPath);
			MetricaEuclidiana me = new MetricaEuclidiana();
			MetricaManhattan mm = new MetricaManhattan();
			MetricaChebychev mc = new MetricaChebychev();
			TratamentoImagem ti = new TratamentoImagem();
			if(imageTxt.getText().equals("")) {
				result.setText("Insert the image path.");
			}else {
				img = (ArrayList<Float>) ti.TratarImage(imageTxt.getText());
				euclidian = me.knnfunction(this.k, img, dtset);
				manhattan = mm.knnfunction(this.k, img, dtset);
				chebychev = mc.knnfunction(this.k, img, dtset);
				if(this.euclidianCheck && !this.manhattanCheck && !this.chebychevCheck) {
					if(euclidian.equals("Person detected")){
						result.setText("Person detected");
					}else{
						result.setText("Person not detected");
					}	
				}else if(this.manhattanCheck && !this.euclidianCheck && !this.chebychevCheck) {
					if(manhattan.equals("Person detected")){
						result.setText("Person detected");
					}else{
						result.setText("Person not detected");
					}
				}else if(this.chebychevCheck && !this.euclidianCheck && !this.manhattanCheck) {
					if(chebychev.equals("Person detected")){
						result.setText("Person detected");
					}else{
						result.setText("Person not detected");
					}
				}else if(this.euclidianCheck && this.manhattanCheck && !this.chebychevCheck) {
					if(euclidian.equals("Person detected") || manhattan.equals("Person detected")){
						result.setText("Person Detected");
					}else{
						result.setText("Person not detected");
					}	
				}else if(this.euclidianCheck && this.chebychevCheck && !this.manhattanCheck) {
					if(euclidian.equals("Person detected") || chebychev.equals("Person detected")){
						result.setText("Person Detected");
					}else{
						result.setText("Person not detected");
					}
				}else if(this.manhattanCheck && this.chebychevCheck && !this.euclidianCheck) {
					if(manhattan.equals("Person detected") || chebychev.equals("Person detected")){
						result.setText("Person Detected");
					}else{
						result.setText("Person not detected");
					}
				}else if(this.euclidianCheck && this.chebychevCheck && this.manhattanCheck) {
					if(euclidian.equals("Person detected") && manhattan.equals("Person detected") || euclidian.equals("Person detected")&&chebychev.equals("Person detected") || manhattan.equals("Person detected")&&chebychev.equals("Person detected")){
						result.setText("Person Detected");
					}else{
						result.setText("Person not detected");
					}
				}else {
					result.setText("Select at least one metric.");
				}
			}
		} catch (FileNotFoundException e1) {
			result.setText("Unable to find dataset.");
		} catch (IOException e1) {
			result.setText("Something seems to be wrong with the dataset!");
		} catch (Exception e1) {
			result.setText("Something wrong with the image");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
