package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Dataset {
	private ArrayList<ArrayList<Float>> features;
	private ArrayList<String> tags;
	private int qntImagens;
	
	public Dataset(String caminho) throws FileNotFoundException, IOException {
		features = new ArrayList<ArrayList<Float>>();
		tags = new ArrayList<String>();
		LeitorCSV dataset = new LeitorCSV(caminho);//cria um leitor de csv
		dataset.ler(caminho);//lê as imagens do dataset
		ArrayList<Float> datasetAjustado = new ArrayList<Float>();
		datasetAjustado = dataset.getFeatures();
		for(int i = 0; i < dataset.getLinhas(); i++) {
			ArrayList<Float> auxFeatures = new ArrayList<Float>();
			for(int j = 0; j<1000; j++) {
				auxFeatures.add(datasetAjustado.get(j));
			}
			try {
				features.add(auxFeatures);
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			datasetAjustado.subList(0, 1000).clear();
		}
		this.tags = dataset.getTag();
		this.qntImagens = dataset.getLinhas();
	}
	
	public ArrayList<String> getTags() {
		return this.tags;
	}
	
	public ArrayList<ArrayList<Float>> getFeatures(){
		return this.features;
	}
	
	public int getQntImagens() {
		return this.qntImagens;
	}
}
