package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import model.MetricaEuclidiana;
import model.MetricaManhattan;

public class CommandMain {	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		int k = 3;
		String caminhoDataset = "C:\\Users\\gabri\\Downloads\\dataset_2019_1.csv\\";
		String caminhoTeste = "C:\\Users\\gabri\\Downloads\\teste_2019_1.csv";
		String caminhoImagem = "";
		ArrayList<Float> imagem;
		String euclidian, manhattan;
		Dataset teste = new Dataset(caminhoTeste);
		Dataset dataset = new Dataset(caminhoDataset);
		MetricaEuclidiana me = new MetricaEuclidiana();
		MetricaManhattan mm = new MetricaManhattan();
		TratamentoImagem ti = new TratamentoImagem();
		System.out.println("Imagens do dataset teste:");
		for(int i = 0; i < teste.getQntImagens(); i++) {	
			euclidian = me.knnfunction(k, teste.getFeatures().get(i), dataset);
			manhattan = mm.knnfunction(k, teste.getFeatures().get(i), dataset);
			if(euclidian.equals("Person detected")&&manhattan.equals("Person detected")) {
				System.out.println("Person detected");
			}else {
				System.out.println("Person not detected");
			}
		}
		try {
			System.out.println("Imagem passada pelo usuário:");
			imagem = ti.TratarImage(caminhoImagem);
			euclidian = me.knnfunction(k, imagem, dataset);
			manhattan = mm.knnfunction(k, imagem, dataset);
			if(euclidian.equals("Person detected")&&manhattan.equals("Person detected")) {
				System.out.println("Person detected");
			}else {
				System.out.println("Person not detected");
			}
		}catch(Exception e) {
			System.out.println("Escolha uma imagem válida.");
		}
	}

}
