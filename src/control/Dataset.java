package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Dataset {
	ArrayList<ArrayList<Float>> features;
	ArrayList<String> tags;
	
	public Dataset(String caminho) throws FileNotFoundException, IOException {
		LeitorCSV dataset = new LeitorCSV(caminho);//cria um leitor de csv
		for(int i = 0; i < 100; i++) {
			dataset.ler(caminho);//lê a imagem do dataset
			this.features.add(dataset.popFeatures());
			this.tags.add(dataset.getTag());
		}		
	}
	
	public ArrayList<String> getTags() {
		return this.tags;
	}
	
	public ArrayList<ArrayList<Float>> getFeatures(){
		return this.features;
	}
}
