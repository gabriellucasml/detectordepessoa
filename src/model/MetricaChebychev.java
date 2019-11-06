package model;

import java.util.ArrayList;
import control.Dataset;

public class MetricaChebychev extends Knn {
	public String knnfunction(int k, ArrayList<Float> imagem, Dataset dataset) {
		ArrayList<Float> distanciaChebychev = new ArrayList<Float>();
		ArrayList<Float> distanciaAux = new ArrayList<Float>();
		ArrayList<Float> knn = new ArrayList<Float>();
		Float dif;
		for(int i = 0; i < 100; i++) {//compara cada param da imagem passada com os das imagens do dataset
			for(int j = 0; j < 1000; j++) {
				dif = dataset.getFeatures().get(i).get(j) - imagem.get(j);
				distanciaAux.add(dif);
			}
			Float max = distanciaAux.get(0);
			for(int l = 0; l<distanciaAux.size(); l++) {//percorre o vetor que segura as distências entre a imagem passada e a iésima imagem do dataset
				if(distanciaAux.get(l)>max){
					max = distanciaAux.get(l);//encontra a maior componente do vetor
				}
			}
			distanciaChebychev.add(max);//a maior componente do vetor é adicionada ao vetor das distancias
			distanciaAux = new ArrayList<Float>();
		}
		knn = this.findSmallest(distanciaChebychev, k);//encontra os k vizinhos mais próximos
		for(int i = 0; i < k; i++) {
			int index = distanciaChebychev.indexOf(knn.get(i));//descobre qual o índice iésima da imagem no dataset
			String tag = dataset.getTags().get(index);//observa qual é a tag da iésima imagem do dataset
			if(tag.equals("person")){//se for person, acresce no membrom person
				person += 1;
			} else {//se não, acrece no membro noPerson
				noPerson += 1;
			}
		}
		if(person >= noPerson) {//se dos k vizinhos, houver um empate, ou houver mais person, retorna pessoa detectada (nesse contexto, falso positivo é mais favorável do que falso negativo)
			return "Person detected";
		}else {//se não, retorna que nenhuma pessoa foi detectada
			return "Person not detected";
		}
	}
}
