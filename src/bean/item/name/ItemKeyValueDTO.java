package bean.item.name;

public class ItemKeyValueDTO {

	/*
	 * 설문 사용자의 최적합 알고리즘을 찾기위해 정보를 LIST형태로 도정하여 담아 둘 DTO
	 * vitaA : INDEX 1 : 비타민 A
	 * vitaB : INDEX 2 : 비타민 B
	 * vitaC : INDEX 3 : 비타민 C
	 * vitaD : INDEX 4 : 비타민 D
	 * vitaE : INDEX 5 : 비타민 E
	 * vitaK : INDEX 6 : 비타민 K
	 * omega3 : INDEX 7 : 오메가3
	 * lutein : INDEX 8 : 루테인
	 * probiotics : INDEX 9 : 프로바이오틱스
	 * calcium : INDEX 10 : 칼슘
	 * collagen : INDEX 11 : 콜라겐
	 * redGinseng : INDEX 12 : 홍삼
	 * magnesium : INDEX 13 : 마그네슘
	 * mineral : INDEX 14 : 미네랄
	 * zinc : INDEX 15 : 아연
	 * biotin : INDEX 16 : 비오틴
	 * milkthistle : INDEX 17 : 밀크씨슬
	 * irom : INDEX 18 : 철
	 * Propolis : INDEX 19 : 프로폴리스
	 * amino : INDEX 20 : 아미노산
	 * dietryfiber : INDEX 21 : 식이섬유
	 * gammalinolenic : INDEX 22 : 감마 리놀레산
	 */
	
	
	// 기본값을 넣어주기 위한 기본 생성자
	public ItemKeyValueDTO() {
		this.vitaA = 0;
		this.vitaB = 0;
		this.vitaC = 0;
		this.vitaD = 0;
		this.vitaE = 0;
		this.vitaK = 0;
		this.omega3 = 0;
		this.lutein = 0;
		this.probiotics = 0;
		this.calcium = 0;
		this.collagen = 0;
		this.redGinseng = 0;
		this.magnesium = 0;
		this.mineral = 0;
		this.zinc = 0;
		this.biotin = 0;
		this.milkthistle = 0;
		this.irom = 0;
		this.propolis = 0;
		this.amino = 0;
		this.dietryfiber = 0;
		this.gammalinolenic = 0;
		
	}
	
	private String PRDLST_REPORT_NO;
	private double vitaA;
	private double vitaB;
	private double vitaC;
	private double vitaD;
	private double vitaE;
	private double vitaK;
	private double omega3;
	private double lutein;
	private double probiotics;
	private double calcium;
	private double collagen;
	private double redGinseng;
	private double magnesium;
	private double mineral;
	private double zinc;
	private double biotin;
	private double milkthistle;
	private double irom;
	private double propolis;
	private double amino;
	private double dietryfiber;
	private double gammalinolenic;
	
	public void addVitaA(double vitaA) {this.vitaA = this.vitaA + vitaA;}
	public void addVitaB(double vitaB) {this.vitaB = this.vitaB + vitaB;}
	public void addVitaC(double vitaC) {this.vitaC = this.vitaC + vitaC;}
	public void addVitaD(double vitaD) {this.vitaD = this.vitaD + vitaD;}
	public void addVitaE(double vitaE) {this.vitaE = this.vitaE + vitaE;}
	public void addVitaK(double vitaK) {this.vitaK = this.vitaK + vitaK;}
	public void addOmega3(double omega3) {this.omega3 = this.omega3 + omega3;}
	public void addLutein(double lutein) {this.lutein = this.lutein + lutein;}
	public void addProbiotics(double probiotics) {this.probiotics = this.probiotics + probiotics;}
	public void addCalcium(double calcium) {this.calcium = this.calcium + calcium;}
	public void addCollagen(double collagen) {this.collagen = this.collagen + collagen;}
	public void addRedGinseng(double redGinseng) {this.redGinseng = this.redGinseng + redGinseng;}
	public void addMagnesium(double magnesium) {this.magnesium = this.magnesium + magnesium;}
	public void addMineral(double mineral) {this.mineral = this.mineral + mineral;}
	public void addZinc(double zinc) {this.zinc = this.zinc + zinc;}
	public void addBiotin(double biotin) {this.biotin = this.biotin + biotin;}
	public void addMilkthistle(double milkthistle) {this.milkthistle = this.milkthistle + milkthistle;}
	public void addIrom(double irom) {this.irom = this.irom + irom;}
	public void addPropolis(double propolis) {this.propolis = this.propolis + propolis;}
	public void addAmino(double amino) {this.amino = this.amino + amino;}
	public void addDietryfiber(double dietryfiber) {this.dietryfiber = this.dietryfiber + dietryfiber;}
	public void addGammalinolenic(double gammalinolenic) {this.gammalinolenic = this.gammalinolenic + gammalinolenic;}
	
	public double getVitaA() {
		return vitaA;
	}
	public void setVitaA(double vitaA) {
		this.vitaA = vitaA;
	}
	public double getVitaB() {
		return vitaB;
	}
	public void setVitaB(double vitaB) {
		this.vitaB = vitaB;
	}
	public double getVitaC() {
		return vitaC;
	}
	public void setVitaC(double vitaC) {
		this.vitaC = vitaC;
	}
	public double getVitaD() {
		return vitaD;
	}
	public void setVitaD(double vitaD) {
		this.vitaD = vitaD;
	}
	public double getVitaE() {
		return vitaE;
	}
	public void setVitaE(double vitaE) {
		this.vitaE = vitaE;
	}
	public double getVitaK() {
		return vitaK;
	}
	public void setVitaK(double vitaK) {
		this.vitaK = vitaK;
	}
	public double getOmega3() {
		return omega3;
	}
	public void setOmega3(double omega3) {
		this.omega3 = omega3;
	}
	public double getLutein() {
		return lutein;
	}
	public void setLutein(double lutein) {
		this.lutein = lutein;
	}
	public double getProbiotics() {
		return probiotics;
	}
	public void setProbiotics(double probiotics) {
		this.probiotics = probiotics;
	}
	public double getCalcium() {
		return calcium;
	}
	public void setCalcium(double calcium) {
		this.calcium = calcium;
	}
	public double getCollagen() {
		return collagen;
	}
	public void setCollagen(double collagen) {
		this.collagen = collagen;
	}
	public double getRedGinseng() {
		return redGinseng;
	}
	public void setRedGinseng(double redGinseng) {
		this.redGinseng = redGinseng;
	}
	public double getMagnesium() {
		return magnesium;
	}
	public void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}
	public double getMineral() {
		return mineral;
	}
	public void setMineral(double mineral) {
		this.mineral = mineral;
	}
	public double getZinc() {
		return zinc;
	}
	public void setZinc(double zinc) {
		this.zinc = zinc;
	}
	public double getBiotin() {
		return biotin;
	}
	public void setBiotin(double biotin) {
		this.biotin = biotin;
	}
	public double getMilkthistle() {
		return milkthistle;
	}
	public void setMilkthistle(double milkthistle) {
		this.milkthistle = milkthistle;
	}
	public double getIrom() {
		return irom;
	}
	public void setIrom(double irom) {
		this.irom = irom;
	}
	public double getPropolis() {
		return propolis;
	}
	public void setPropolis(double propolis) {
		this.propolis = propolis;
	}
	public double getAmino() {
		return amino;
	}
	public void setAmino(double amino) {
		this.amino = amino;
	}
	public double getDietryfiber() {
		return dietryfiber;
	}
	public void setDietryfiber(double dietryfiber) {
		this.dietryfiber = dietryfiber;
	}
	public double getGammalinolenic() {
		return gammalinolenic;
	}
	public void setGammalinolenic(double gammalinolenic) {
		this.gammalinolenic = gammalinolenic;
	}
	public String getPRDLST_REPORT_NO() {
		return PRDLST_REPORT_NO;
	}
	public void setPRDLST_REPORT_NO(String pRDLST_REPORT_NO) {
		PRDLST_REPORT_NO = pRDLST_REPORT_NO;
	}
	
	
	
}
