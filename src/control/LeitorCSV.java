package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//classe para ler um arquivo csv e retornar um array de características de uma dada imagem
public class LeitorCSV {
	private FileReader file;
	private BufferedReader buffer;
	private ArrayList<Float> features;
	private String tag;
	
	public LeitorCSV(String caminho) throws IOException, FileNotFoundException{
		file = new FileReader(caminho);
		buffer = new BufferedReader(file);
		features = new ArrayList<Float>();
	}
	
	public void ler(String caminho) throws IOException{
		String ref = ","; //Divisor de arquivos csv
		String line = buffer.readLine();
		if(line != null) {
			String[] ln = line.split(ref);
			for(String feature : ln) {
				try {
					Float aux = Float.parseFloat(feature);//elemento auxiliar para segurar o valor da feature
					features.add(aux);
				}catch(NumberFormatException e) {
					tag = feature;
				}
			}
		}
	}
	
	public String getTag() {
		return this.tag;
	}
	
	public ArrayList<Float> popFeatures(){
		ArrayList<Float> novo = this.features;
		this.features = new ArrayList<Float>();
		return novo;
	}
}
