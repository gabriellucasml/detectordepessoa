package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.MetricaChebychev;
import model.MetricaEuclidiana;
import model.MetricaManhattan;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*double[] imagem = {0.1426775,0.022300057,0.013624869,0.002011434,0.009016601,0.008111912,0.004226893,0.06023456,0.36143464,0.175294,0.042163473,0.049615115,0.009633254,0.012592713,0.010126161,0.012291956,0.051733162,0.38527963,0.37607208,0.014505879,0.005356422,0.0,0.0048559867,0.008477567,0.028010966,0.113595665,0.3984592,0.3984592,0.018630713,0.002336896,4.264969E-5,0.003124695,0.013684883,0.07630889,0.12579031,0.3984592,0.15510456,0.067709215,0.035842896,0.016909765,0.024994072,0.028578421,0.029764503,0.04988144,0.30101863,0.20640554,0.061344277,0.017240385,0.015559895,0.03180068,0.023682967,0.0561829,0.12233187,0.24884413,0.39725143,0.042239018,0.011362626,0.0043399897,0.010633643,0.01072583,0.043413017,0.08782567,0.39725143,0.39725143,0.08014885,0.04135782,0.061889406,0.09494329,0.07309386,0.1290168,0.2364493,0.39725143,0.32251123,0.046816166,0.015571678,0.0053394446,0.024070669,0.007332069,0.03791012,0.120237485,0.32251123,0.32251123,0.072397426,0.047260415,0.024074294,0.063560136,0.013090119,0.020035189,0.042870294,0.32251123,0.32251123,0.14129941,0.057947107,0.076462686,0.11369801,0.0863486,0.117147945,0.22503437,0.32251123,0.32251123,0.095464624,0.034902286,0.016278174,0.027779398,0.007260034,0.016028812,0.07469284,0.32251123,0.33028278,0.06815049,0.09329977,0.033269722,0.14196576,0.04889109,0.049427677,0.0741496,0.33028278,0.33028278,0.07310188,0.06475713,0.008688295,0.0922959,0.069149,0.0572885,0.07777645,0.33028278,0.3213213,0.03935353,0.025283493,0.013257241,0.019267183,0.011883425,0.026377335,0.08430079,0.33028278,0.33028278,0.15041144,0.015137705,0.01617491,0.022794122,0.013186444,0.028629592,0.13173164,0.33028278,0.32726744,0.045854367,0.02124173,0.008662708,0.019178106,0.016636409,0.017619127,0.053263206,0.31269994,0.32726744,0.057347223,0.014702658,0.015527265,0.043149825,0.018826611,0.014368425,0.02876611,0.23008178,0.32726744,0.26780847,0.05798253,0.015163869,0.010867628,0.003266324,0.021671716,0.14486098,0.32726744,0.32726744,0.32726744,0.17229994,0.0109003885,0.0024316204,4.7657354E-4,0.018782249,0.056053743,0.24447244,0.35071453,0.10101523,0.017784026,0.010698423,0.038453765,0.013913458,0.014445946,0.022547698,0.19598019,0.35071453,0.13379982,0.03936678,0.02247301,0.028413367,0.00864504,0.011330944,0.016117629,0.31066757,0.35071453,0.35071453,0.09947769,0.0022687681,0.001069781,3.5048186E-4,0.0048910445,0.0067116125,0.20100573,0.35071453,0.22896443,0.03180443,0.002601614,0.0030838044,0.0011113599,0.0052230693,0.002434709,0.32932803,0.32018372,0.080822706,0.023816694,0.027950596,0.0658876,0.0613786,0.057878833,0.10860124,0.21861504,0.2748519,0.022159705,0.003060082,0.025059594,0.13875479,0.15862806,0.17489786,0.24929659,0.32018372,0.32018372,0.1554098,0.02384287,0.0036769977,0.0064594597,0.00660786,0.035009716,0.09804652,0.26073107,0.32018372,0.054596853,0.018321358,0.008187398,0.019003373,0.027154658,0.10808492,0.2676888,0.32018372,0.3075677,0.016962102,0.011663595,0.016589863,0.05395853,0.07426933,0.08003676,0.08213155,0.2616059,0.30449945,0.035094596,0.029410038,0.043919392,0.08202077,0.10648777,0.20142725,0.097626686,0.16344811,0.3075677,0.022388527,0.016206853,0.016576996,0.011648109,0.0372593,0.07256188,0.10539128,0.3075677,0.3075677,0.036123592,0.12735333,0.18787545,0.06755402,0.3075677,0.3075677,0.13529196,0.2288419,0.037470683,0.023611415,0.01525444,0.09816657,0.19132742,0.07980813,0.119476475,0.037963707,0.027824834,0.0010617446,0.006644423,0.0028884665,0.24898851,0.4838595,0.038346373,0.012591589,0.0072739297,0.0023061575,0.044696357,0.037175417,0.122027405,0.23118983,0.16578893,0.25936192,0.37559777,0.06347976,0.048392627,0.0015612459,0.015909204,0.027720036,0.26705375,0.4838595,0.051333446,0.052078176,0.014120368,0.009346676,0.0,4.024646E-5,1.6863822E-5,0.2850945,0.5563859,0.017375141,0.003183659,0.0027214114,3.3230594E-5,0.0,0.0,0.0,0.07379389,0.33624443,7.091036E-4,0.0,0.0,0.0,0.0,6.036969E-4,6.1906374E-4,0.20382123,0.5563859,0.011253669,0.0032422026,0.0023234868,0.0,0.0,0.0,0.0,0.039450087,0.36327106,4.571938E-4,0.0,0.0,0.0,6.299472E-4,0.0026426837,0.026675185,0.065157294,0.15013131,0.004163554,0.012079265,0.0137421815,0.013983679,0.0027297707,0.005813904,0.059764855,0.1435087,0.50264144,0.010608344,0.049144767,0.058480505,0.060595937,0.008711753,0.0015958807,0.010200401,0.078858525,0.35475066,0.06949625,0.008688424,0.021386655,0.009515656,0.037750933,0.0057535144,0.02481565,0.2007045,0.67317617,0.18424146,0.035965152,0.09267549,0.041234512,0.001617046,0.0018079842,0.017554345,0.044112477,0.26519296,0.0037508993,0.022210676,0.02665254,0.028075622,0.014454799,0.004276852,0.012797938,0.0,0.018100938,0.0,0.011621866,0.0038838277,0.011061503,0.03304023,0.0078032645,0.0122409025,0.07655306,0.57643265,0.07639773,0.016865328,0.04261976,0.020078355,0.68259543,0.13660648,0.07620273,0.064019874,0.19964178,0.031050835,0.03462946,0.0485446,0.17527759,0.005311579,0.0012219396,0.0031526915,4.8690406E-4,0.008359128,0.0011551817,0.0036795244,0.001759483,0.0042891265,0.01688826,0.0061807497,0.005244322,0.004125158,0.05055063,0.025143208,0.006740728,0.019402495,0.019743236,0.46604726,0.2386617,0.018167194,0.015476715,0.063919015,0.016452985,0.014133928,0.020081893,0.1465564,0.46604726,0.46002272,0.052117776,0.013358575,0.05398065,0.0258257,0.012824766,0.19236274,0.46604726,0.010281029,0.004524865,0.005689638,0.006375736,0.022983087,0.013025503,0.008898505,0.013052435,0.013467087,0.007944069,0.006116354,0.09925335,0.35941625,0.35941625,0.03894797,0.020413121,0.027745664,0.02031848,0.28121516,0.15943608,0.063101254,0.011237637,0.031509068,0.011817289,0.010363247,0.07149729,0.23005083,0.32481888,0.29707074,0.2908389,0.35941625,0.35941625,0.03341259,0.009468411,0.01892691,0.13228041,0.0016277954,0.0017240281,0.13591294,0.36288375,0.36288375,0.021137603,0.005865433,0.008049279,0.004650952,0.0069059986,0.0024833246,0.06391332,0.36288375,0.36001554,0.021568054,0.005061831,0.002419742,0.00364039,0.062226348,0.085838184,0.18345495,0.36288375,0.36288375,0.018000133,6.150449E-4,0.0018643691,0.016001314,0.025750766,0.01521303,0.06511233,0.30533275,0.20042579,0.021973835,0.0044279676,0.008303729,0.00787453,0.35055742,0.011663441,0.007289357,2.2195597E-4,0.0023027337,0.011736948,0.059954606,0.13505468,0.35342133,0.35342133,0.035600618,0.013089766,0.0075883726,0.0045076334,0.032897897,0.16961497,0.21820164,0.35342133,0.16489796,0.01235807,0.005680365,2.8537193E-4,5.7634205E-4,0.0078117787,0.022922358,0.1331683,0.35342133,0.24177523,0.033929408,0.014105955,0.00975648,0.0043101073,0.015756743,0.09101193,0.18371417,0.35342133,0.33225548,0.046821192,0.02674351,0.018090408,0.027929755,0.011594772,0.06338882,0.09995079,0.33225548,0.33225548,0.11227148,0.08018359,0.1442001,0.17685696,0.07628639,0.10494772,0.16197702,0.33225548,0.2669616,0.04338255,0.020972522,0.015194675,0.022007827,0.0101219,0.072651215,0.13576534,0.29703274,0.27566972,0.07410857,0.0477136,0.061224334,0.068858564,0.03584139,0.045835618,0.17433505,0.33225548,0.30449888,0.15645126,0.07588051,0.1619541,0.1857259,0.08773916,0.093834616,0.16701786,0.30449888,0.30449888,0.09689013,0.03428477,0.026556987,0.03927388,0.015227186,0.025648393,0.07827543,0.27239305,0.30449888,0.11023514,0.056203377,0.06699298,0.06569248,0.030956533,0.033394847,0.1773777,0.30449888,0.30449888,0.14207278,0.09949014,0.07544419,0.08029823,0.04523052,0.039372284,0.12275842,0.30449888,0.16345008,0.050610755,0.07454238,0.049749676,0.03089252,0.029866127,0.03509357,0.08274524,0.22471596,0.26680294,0.28161794,0.1456118,0.072387956,0.031402115,0.0316318,0.04079528,0.09385428,0.20811844,0.21210845,0.0785362,0.24706109,0.28161794,0.26251113,0.13307768,0.06362748,0.16253178,0.17793867,0.15285145,0.28161794,0.28161794,0.28161794,0.20988394,0.10261113,0.054044615,0.068019085,0.055450197,0.3509361,0.3509361,0.14431286,0.030565452,0.013192049,0.008559282,0.024858195,0.09793234,0.23894674,0.32927796,0.3509361,0.22092016,0.008181746,0.0044981237,0.0,0.018443251,0.03777436,0.104426496,0.28907654,0.3509361,0.1703547,0.07031916,0.038178943,0.015854798,0.018502513,0.013007038,0.04764156,0.20794787,0.26477674,0.07604081,0.0104790805,0.026672235,0.0026534079,0.017041994,0.010551684,0.04675521,0.40358916,0.40358916,0.24226978,0.0083996765,0.021414496,0.0041097715,0.023924693,0.012274528,0.1391707,0.40358916,0.25877395,0.088880524,0.029415103,0.06339812,0.018726163,0.05067868,0.029555598,0.23062961,0.18854931,0.17964745,0.13196993,0.03750204,0.0962803,0.0055799806,0.06499906,0.035132676,0.09064391,0.1581178,0.10674124,0.098240994,0.11404822,0.27238566,0.039949574,0.10938356,0.094015546,0.16119148,0.36626798,0.15542999,0.069608204,0.032472502,0.04146691,0.045783073,0.05653519,0.06808664,0.22054954,0.36626798,0.09746709,0.07131364,0.04035328,0.059649885,0.11859982,0.105877034,0.20379117,0.36626798,0.12439439,0.10315492,0.08792661,0.09642511,0.15941048,0.10853197,0.13303328,0.15486749,0.16959623,0.14742997,0.10880195,0.06550604,0.070161186,0.13701758,0.24397004,0.21687382,0.24544217,0.19447254,0.22667891,0.034538943,0.047468863,0.04791914,0.042313695,0.07644812,0.071482345,0.07610241,0.17719808,0.14250736,0.04167844,0.26915404,0.34567937,0.20715523,0.34567937,0.34567937,0.045537435,0.09362432,0.06624795,0.06986886,0.047798835,0.04893468,0.0700617,0.10312222,0.10480184,0.08431136,0.08165842,0.054457236,0.08149953,0.15905885,0.14536662,0.16119255,0.34567937,0.34567937,0.058251917,0.0640653,0.008601125,0.0152647775,0.12357494,0.17491414,0.14456473,0.2659549,0.21429303,0.012808991,0.013170146,0.0010728957,0.0051258006,0.02631529,0.15884598,0.383187,0.07995827,0.032021966,0.0036120024,0.003520657,0.036681026,0.0104843,0.046057783,0.05754357,0.11127846,0.383187,0.32098955,0.046167687,0.05104757,0.13208345,0.007126115,0.00797755,0.09424402,0.383187,0.29438466,0.21531476,0.14446802,0.1756058,5.1137694E-4,2.556156E-4,7.8943284E-4,0.10066522,0.4154357,0.02313459,5.5406895E-4,9.6972806E-5,4.7999463E-4,0.0059624705,5.4226985E-5,0.0,0.013582646,0.2088359,0.0026839997,0.0,0.0,0.0022920694,0.35472336,0.023223555,9.558857E-4,0.06333947,0.4154357,0.16506821,0.081236854,0.12376256,0.26964995,0.4154357,0.0772027,0.0,0.006124175,0.16493551,0.028544059,0.005777559,0.026097983,0.36957788,0.031060891,0.015978627,8.399612E-4,0.0015017875,0.019395573,0.0073216725,4.4259665E-4,0.0016890946,0.007278913,0.16606842,0.04451176,0.0015329504,0.005336412,0.06388308,0.019157585,0.0013266498,0.009156151,0.047019742,0.46875325,0.45151308,0.004840878,1.2595719E-4,0.0047174147,0.0029650151,2.5374503E-4,6.222663E-4,0.18021333,0.46875325,0.46875325,0.00986572,0.0012995085,0.016654747,0.0080430135,6.3968624E-4,0.006737318,0.24739094,0.18642984,0.09141953,0.0036043446,0.0017973663,0.019089501,0.0041836263,2.7398972E-4,0.0026645763,0.02379999,0.36214316,0.38226593,0.016304428,0.0038932154,0.012390459,0.001789006,7.2875875E-4,0.003699479,0.022614926,0.40645742,0.3944891,0.008739634,6.486124E-4,0.005359635,0.0017178028,1.714897E-4,0.0025820585,0.14191543,0.40645742,0.40645742,0.03135111,9.05261E-4,0.0038330415,3.2025203E-4,3.2265374E-4,0.0014114797,0.033399194,0.3456895,0.3405137,0.0063292156,0.0022433703,0.010157276,0.002823,0.001297712,0.0050170524,0.053695466,0.3456895,0.23634885,0.013121713,8.8203634E-4,0.0036337634,0.00451481,0.008982538,0.13511069,0.2997958,0.3456895,0.3456895,0.010817028,3.93499E-4,0.0028139218,7.7976385E-4,8.012702E-4,0.0025235838,0.03723778,0.3456895};
		*/ArrayList<Float> img = new ArrayList<Float>();
		/*for(double d : imagem) {
			img.add((float)d);
		}*/
		String euclidian, manhattan, chebychev;
		//Dataset teste = new Dataset("C:\\Users\\gabri\\Downloads\\teste_2019_1.csv");
		Dataset dataset = new Dataset("C:\\Users\\gabri\\Downloads\\dataset_2019_1.csv");
		MetricaEuclidiana me = new MetricaEuclidiana();
		MetricaManhattan mm = new MetricaManhattan();
		MetricaChebychev mc = new MetricaChebychev();
		TratamentoImagem ti = new TratamentoImagem();
		img = (ArrayList<Float>) ti.TratarImage("C:\\Users\\gabri\\Downloads\\theGentlepeople.png");
			
		euclidian = me.knnfunction(3, img, dataset);
		manhattan = mm.knnfunction(3, img, dataset);
		chebychev = mc.knnfunction(3, img, dataset);
		System.out.println("euclidian: " + euclidian + " manhattan: " + manhattan + " chebychev: " + chebychev);
		if(euclidian.equals("Person detected") && manhattan.equals("Person detected") || euclidian.equals("Person detected")&&chebychev.equals("Person detected") || manhattan.equals("Person detected")&&chebychev.equals("Person detected")) {
			System.out.println("Person detected");
		}else {
			System.out.println("No person detected");
		}	
	}

}
