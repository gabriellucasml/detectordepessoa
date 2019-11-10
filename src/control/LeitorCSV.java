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
	private ArrayList<String> tags;
	private int linhas;
	
	public LeitorCSV(String caminho) throws IOException, FileNotFoundException{
		file = new FileReader(caminho);
		buffer = new BufferedReader(file);
		features = new ArrayList<Float>();
		tags = new ArrayList<String>();
	}
	
	public void ler(String caminho) throws IOException{
		String ref = ","; //Divisor de arquivos csv
		String line = buffer.readLine();
		while(line != null) {
			if(line != null) {
				String[] ln = line.split(ref);
				for(String feature : ln) {
					try {
						Float aux = Float.parseFloat(feature);//elemento auxiliar para segurar o valor da feature
						features.add(aux);
					}catch(NumberFormatException e) {
						tags.add(feature);
					}
				}
			}
			line = buffer.readLine();
			this.linhas += 1;
		}
	}
	
	public ArrayList<String> getTag() {
		return this.tags;
	}
	
	public int getLinhas() {
		return this.linhas;
	}
	
	public ArrayList<Float> getFeatures(){
		return this.features;
	}
}
