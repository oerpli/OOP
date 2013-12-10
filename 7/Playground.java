import java.util.concurrent.*;
import java.util.Random;

class Playground {
	private Box[][] boxes;
	private CopyOnWriteArrayList<Thread> threadList;
	private int consum;
	private int[] time;
	
	/**
	 * @param width: Breite des Feldes. Zwischen 1 und 80
	 * @param height: Höhe des Feldes. Zwischen 1 und 80
	 * @param consumption: Nährlösungsverbrauch pro Teilung. Zwischen 0 und 100.
	 * @param prolifTime: Millisekunden pro Teilung für 25-50, 50-75 und 75-100 Prozent Nährlösung. Absteigend.
	 */
	public Playground(int width, int height, int consumption, int[] prolifTime) {
		boxes = new Box[width][height];
		threadList = new CopyOnWriteArrayList<>();
		time = prolifTime;
		consum = consumption;
	}
	
	public int getConsum() {
		return consum;
	}
	
	public int getTime(int index) {
		return time[index];
	}
	
	/**
	 * Paramter: Wo werden Bakterien und Pilze platziert? Wo wie viel Nährstoff?
	 */
	public void start() {
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				boxes[x][y] = new Box(75);
			}
		}
		
		Bacterium bac = new Bacterium(this, boxes[0][0], 1);
		boxes[0][0].setResident(bac);
		Fungus myk = new Fungus(this, boxes[boxes.length-1][boxes[0].length-1], 1); //Arrayoutofbounds error fix, array.length ist 1 zu gro�
		boxes[boxes.length-1][boxes[0].length-1].setResident(myk);  //Arrayoutofbounds error fix, array.length ist 1 zu gro�
		Thread bT = new Thread(bac);
		bT.start();
		threadList.add(bT);
		Thread fT = new Thread(myk);
		fT.start();
		threadList.add(fT);
	}
	
	/**
	 * Gibt ein Array zurück, das alle umliegenden Boxen enthält.
	 * @param box: die mittlere Box
	 * @return Array mit allen Nachbarn
	 */
	public Box[] getNeighbors(Box box) {
		int x = 0;
		int y = 0;
		
		int[] Pos=getPos(box);
		x=Pos[0];
		y=Pos[1];
		Box[] result = new Box[8];
		int neighbours = 0;
		int maxX = boxes.length - 1; //Array beginnt bei 0 ->length ist 1 zu groß
		int maxY = boxes[0].length - 1;
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				if (((x+dx) <= maxX) && ((x+dx) >= 0) && ((y+dy) <= maxY) && ((y+dy) >= 0) && ((dy != 0) || (dx != 0))) {
					result[neighbours] = boxes[x+dx][y+dy];
		        		neighbours++;
	        		}
			}
		}
		Box[] result1 = new Box[neighbours];
		for (int i = 0; i < neighbours; i++) {
			result1[i] = result[i];
		}
		return result1;
	  }
	/**
	 * Sucht Box im array und gibt x y werte als array zur�ck
	 * @param Box
	 * @return Array mit X und Y Wert
	 */
	public int[] getPos(Box box){
		int[] pos=new int[2];
		for (int i = 0; i < boxes.length; i++) {
			for (int j = 0; j < boxes[0].length; j++) {
				if(boxes[i][j]==box){
					//x=i;
					//y=j;
					pos[0]=i;
					pos[1]=j;
				}
			}
		}
		return pos;
	}
	/**
	 * Findet heraus, ob ein Nachbar ein Fungus ist. Sonst false.
	 * @param box: die mittlere Box
	 */	
	public boolean nearFungus(Box box) {
		Box[] neighbors= getNeighbors(box);
		for(Box b: neighbors){
			if(b.getFungus()!=null) return true;
		}
		return false;
	}

	/**
	 * Sortiert das übergebene Array absteigend nach dem Nutrient Wert.
	 * @param zu sortierendes Array
	 * @return absteigend sortiertes array
	 */
	public Box[] sort(Box[] toSort) {
		boolean unsortiert = true;
		Box temp;
		while (unsortiert) {
			unsortiert = false;
			for (int i = 0; i < toSort.length - 1; i++) {
				if (toSort[i].getNutrient() < toSort[i + 1].getNutrient()) {
					temp = toSort[i];
					toSort[i] = toSort[i + 1];
					toSort[i + 1] = temp;
					unsortiert = true;
				}
			}
		}
		return toSort;
	}
	
	/**
	 * Alle Zellen werden über ihren Tod benachrichtigt.
	 */
	synchronized public void killAllCells() {
		for (Thread t: threadList) {
			t.interrupt();
		}
	}
	
	/*
	 * Die übergebene Zelle wird über ihren Tod benachrichtigt.
	 * Die übergebene Zelle wird aus ihrem Container gelöscht.
	 */
	public void killCell(Bacterium cell) {
		if(cell.getThread()!=null)
			cell.getThread().interrupt(); // null testen?
		cell.getContainer().setResident((Bacterium)null);
	}
	
	/*
	 * Die übergebene Zelle wird über ihren Tod benachrichtigt.
	 * Die übergebene Zelle wird aus ihrem Container gelöscht.
	 */
	public void killCell(Fungus cell) {
		cell.getThread().interrupt();
		cell.getContainer().setResident((Fungus)null);
	}
	
	/*
	 * Die übergebene Zelle wird in einem neuen Thread belebt.
	 * Die übergebene Zelle wird in ihren Container platziert.
	 */
	synchronized public void createCell(Bacterium cell) {
		cell.getContainer().setResident(cell); // Bakterium wird in Box eingetragen
		Thread t = new Thread(cell); // Bakterium wird belebt
		t.start();
		threadList.add(t);
	}
	
	/*
	 * Die übergebene Zelle wird in einem neuen Thread belebt.
	 * Die übergebene Zelle wird in ihren Container platziert.
	 */
	synchronized public void createCell(Fungus cell) {
		cell.getContainer().setResident(cell); // Pilz wird in Box eingetragen
		Thread t = new Thread(cell); // Pilz wird belebt
		t.start();
		threadList.add(t);
	}
	/**
	 * Erstellt zuf�llige Zelle an zuf�lligem Ort
	 */
	public void makeRandomCell(){
		Random random=new Random();
		int type=random.nextInt(2);
		if(type==0)
		{	
			createCell(new Fungus(this,boxes[random.nextInt(boxes.length)][random.nextInt(boxes[0].length)],1));
		}
		else if(type==1)
		{	
			createCell(new Bacterium(this,boxes[random.nextInt(boxes.length)][random.nextInt(boxes[0].length)],1));
		}
	}
	/**
	 * Gibt Zell Information aus
	 * 
	 */
	public void printCellInfo() {
		int bac=0;
		int fung=0;
		String result = null;
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				if (boxes[x][y].isTakenBy() == 2) {
					bac++;
					result+=boxes[x][y].getBacterium().toString()+"\n";
				}
				else if (boxes[x][y].isTakenBy() == 1) {
					fung++;
					result+=boxes[x][y].getFungus().toString()+"\n";
				}
			}
		}
		System.out.println(result);
		System.out.println("Stats: \n Bacterium: "+ bac +"\n Fungus: "+fung);
	}
	/**
	 * Z�hlt die Bakterien
	 * @return aktuelle Anzahl Bakterien
	 */
	public int countBacterium(){
		int count=0;
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				if(boxes[x][y].isTakenBy()==2) 
					count++;
			}
		}
		return count;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int x = 0; x < boxes.length; x++) {
			for (int y = 0; y < boxes[0].length; y++) {
				if (boxes[x][y].isTakenBy() == 0) {
					result += (boxes[x][y].getNutrient() / 10);
					result += " ";
				} 
				else if(boxes[x][y].isTakenBy() == 1)
						result += "x ";
				else if(boxes[x][y].isTakenBy() == 2)
						result += "o ";
				
			}
			result += System.getProperty("line.separator");
		}
		return result;
	}
}
