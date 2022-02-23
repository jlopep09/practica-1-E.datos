package ule.ed.plane;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;


public class AirplaneArrayImpl implements IAirplane {

	private final int MAX_AGE_CHILDREN=17;
	private String name;
	private int nRows;
	private int nColumns; 

	private Passenger[][] seats;


	// OJO: NO SE PUEDEN AÑADIR MÁS ATRIBUTOS
	


	public AirplaneArrayImpl(String name, int nRows,int nColumns){ 
		// TODO: Debe crear el array de pasajeros con todas las posiciones a null
		this.name= name;
		this.nRows = nRows;
		this.nColumns = nColumns;
		seats = new Passenger[nRows][nColumns];
		
	}

	@Override
	public String getName() {
	  //TODO : Devolver en nombre del avión
	return this.name;
	}

	@Override
	public int getNumberOfRows() {
		// TODO : Devolver el número de filas del avión
	return this.nRows;
	}



	@Override
	public int getNumberOfColumns() {
		// TODO : Devolver el número de filas del avión
		return this.nColumns;
	}



	@Override
	public int getNumberOfPassengers() {
		// TODO devolver el número de pasajeros del avión
		int counter=0;
		for(int i = 0; i < nRows; i++){
			for(int j = 0; j < nColumns; j++){
				if(seats[i][j] != null){
					counter++;
				}
			}
		}
		return counter;
	}
	
	@Override
	public int getNumberOfChildren() {
		// TODO : ver interface
		int counter = 0;
		for(int i = 0; i < getNumberOfRows(); i++){
			for(int j = 0; j < getNumberOfColumns(); j++){
				if(seats[i][j] != null){
					if(seats[i][j].getAge() <= MAX_AGE_CHILDREN){
						counter++;
					}
				}
			}
		}
		return counter;
	}



	@Override
	public boolean isOccupiedSeat(int row, int column) {
		// TODO : ver interface
		return seats[row-1][column-1] != null;
	}


	@Override
	public int getNumberOfEmptySeats() {
		// TODO : ver interface

		return getNumberOfColumns() * getNumberOfRows() - getNumberOfPassengers();
	}



	@Override
	public int getNumberOfRowsWithChildren() throws NoneChildrenInAvionException{
		// TODO : ver interface
			int counter=0;
			for(int i = 0; i<nRows; i++){
				for(int j = 0; j<nColumns; j++){
					if(seats[i][j]!=null && seats[i][j].getAge()<=MAX_AGE_CHILDREN){
						counter++;
						i++;
					}
				}
			}
			if(counter==0){
				throw new NoneChildrenInAvionException();
			}
			return counter;

	}



	@Override
	public int getNumberOfRowWithMoreChildren() throws NoneChildrenInAvionException {
		// TODO : ver interface
		int numberOfRowWithMoreChildren=-1;
		int counter=0;
		int maxChildren=0;
		for(int i = 0; i<nRows; i++){
			for(int j = 0; j<nColumns; j++){
				if(seats[i][j]!=null && seats[i][j].getAge()<=MAX_AGE_CHILDREN){
					counter++;
				}
			}
			if(counter>maxChildren){
				maxChildren=counter;
				numberOfRowWithMoreChildren=i;
			}
			counter=0;
		}
		if(numberOfRowWithMoreChildren==-1){
			throw new NoneChildrenInAvionException();
		}
		return numberOfRowWithMoreChildren;
	}

	@Override
	public int getNumberOfColumnsWithChildren() throws NoneChildrenInAvionException {
		// TODO : ver interface
		int counter=0;
		for(int i = 0; i < nColumns; i++){
			for(int j = 0; j < nRows; j++){
				if(seats[j][i]!=null && seats[i][j].getAge()<=MAX_AGE_CHILDREN){
					counter++;
					i++;
				}
			}
		}
		if(counter==0){
			throw new NoneChildrenInAvionException();
		}
		return counter;
		}
		
	


	@Override
	public int getNumberOfColumnWithMoreChildren() throws NoneChildrenInAvionException {
		// TODO : ver interface
		int counter=0;
		int maxChildren=0;
		int numberOfColumnWithMoreChildren=-1;
		for(int i = 0; i < nColumns; i++){
			for(int j = 0; j < nRows; j++){
				if(seats[j][i]!=null && seats[i][j].getAge()<=MAX_AGE_CHILDREN){
					counter++;
				}
				if(maxChildren<counter){
					maxChildren=counter;
					numberOfColumnWithMoreChildren=i;
				}
				counter=0;
			}
		}
		if(numberOfColumnWithMoreChildren==-1){
			throw new NoneChildrenInAvionException();
		}
		return numberOfColumnWithMoreChildren+1;
	}
	

	@Override
	public List<Passenger> getListOfChildPassengers() {
		// TODO ver interface
		List<Passenger> listaChildPassengers=new ArrayList<Passenger>();
		for(int i = 0; i<this.nRows; i++){
			for(int j = 0; j < this.nColumns; j++){
				if(seats[i][j].getAge()<= MAX_AGE_CHILDREN){
					listaChildPassengers.add(seats[i][j]);
				}
			}
		}
		//TODO

		return listaChildPassengers;
		
	}



	@Override
	public List<Passenger> getListOfAdultsPassengers() {
		// TODO ver interface
		List<Passenger> listaAdultsPassengers=new ArrayList<Passenger>();
		for(int i = 0; i<this.nRows; i++){
			for(int j = 0; j < this.nColumns; j++){
				if(seats[i][j].getAge() > MAX_AGE_CHILDREN){
					listaAdultsPassengers.add(seats[i][j]);
				}
			}
		}
		return listaAdultsPassengers;
		}



	@Override
	public List<String> getListOfEmptySeats() {
		// TODO : ver interface
		List<String> listaEmptySeats=new ArrayList<String>();

		for(int i = 0; i<this.nRows; i++){
			for(int j = 0; j < this.nColumns; j++){
				if(seats[i][j] == null){
					listaEmptySeats.add("Asiento ["+i+","+j+"]");
				}
			}
		}
	// TODO
		
		return listaEmptySeats;
		}
	



	@Override
	public List<String> getListOfOccupiedSeats() {
		// TODO : ver interface
		List<String> listaOccupiedSeats=new ArrayList<String>();

		for(int i = 0; i<this.nRows; i++){
			for(int j = 0; j < this.nColumns; j++){
				if(seats[i][j] != null){
					listaOccupiedSeats.add("("+(i+1)+","+(j+1)+")");
				}
			}
		}
		return listaOccupiedSeats;
		}
	



	@Override
	public Passenger getPassenger(int row, int column) {
		// TODO : ver interface
		return seats[row-1][column-1];
	}
	private int cornerSeat(int row, int column){
		int index = 0;
		if(row == 1){
			if(column == 1){
				index = 1;
			}else if(column == getNumberOfColumns()){
				index = 2;
			}
		}
		if(row == getNumberOfRows()){
			if(column == 1){
				index = 3;
			}else if(column == getNumberOfColumns()){
				index = 4;
			}
		}
		return index;
	}
	private char borderSeat(int row, int column){
		char index = '0';
		if(row == 1 && cornerSeat(row,column) == 0){
			index = 'L';
		}else if(row == getNumberOfRows() && cornerSeat(row,column) == 0){
			index = 'R';
		}else if(column == 1 && cornerSeat(row,column) == 0){
			index = 'U';
		}else if(column == getNumberOfColumns() && cornerSeat(row,column) == 0){
			index = 'D';
		}
		return index;
	}
    private boolean covidSeat(int row, int column){
		if(cornerSeat(row, column) == 0 && borderSeat(row,column) == 0){
			if((seats[row-2][column-1]==null) && seats[row][column-1]==null){
				if(seats[row-1][column-2]==null && seats[row-1][column-2]==null){
					return true;
				}
		   }
		}else if(cornerSeat(row, column) == 1 && seats[row][column-1]==null &&	seats[row-1][column]== null){
			return true;
		}else if(cornerSeat(row, column) == 4 && seats[row-2][column-1]==null &&	seats[row-1][column-2]== null){
			return true;
		}else if(cornerSeat(row, column) == 2 && seats[row][column-1]==null &&	seats[row-1][column-2]== null){
			return true;
		}else if(cornerSeat(row, column) == 3 && seats[row-2][column-1]==null &&	seats[row-1][column]== null){
			return true;
		}else if(borderSeat(row, column) == 'L' && seats[row][column-1] == null && seats[row-2][column-1] == null && seats[row-1][column] == null){
			return true;
		}else if(borderSeat(row, column) == 'R' && seats[row][column-1] == null && seats[row-2][column-1] == null && seats[row-1][column-2] == null){
			return true;
		}else if(borderSeat(row, column) == 'U' && seats[row-1][column] == null && seats[row-1][column-2] == null && seats[row][column-1] == null){
			return true;
		}else if(borderSeat(row, column) == 'D' && seats[row-1][column] == null && seats[row-1][column-2] == null && seats[row-2][column-1] == null){
			return true;
		}

		return false;
	}
	private boolean repeatedPassenger(Passenger a){
		for (int i=0;i<nRows;i++) {
			for (int j = 0; j < nColumns; j++) {
			if(a.equals(seats[i][j])){
				return true;
			}
			}
		}
		return false;
	}

	@Override
	public boolean addPassenger(int row, int column, String nif, String name, int edad) {
		// TODO : ver interface
		Passenger newPassengers = new Passenger(nif,name,edad);
		if(repeatedPassenger(newPassengers)){
			return false;
		}
		if(seats[row-1][column-1]==null && covidSeat(row, column)){
			seats[row-1][column-1] = newPassengers;
			return true;
		}
		return false;
	}


	@Override
	public boolean addPassenger(String nif, String name, int edad) {
		// TODO 
		Passenger newPassengers = new Passenger(nif,name,edad);

		if(repeatedPassenger(newPassengers)){
			return false;
		}
		for(int i = 0; i<this.nRows; i++){
			for(int j = 0; j < this.nColumns; j++){
				if(seats[i][j] == null && covidSeat(i+1, j+1)){
					seats[i][j] = newPassengers;
					return true;
				}
			}
		}
		return false;
	}



	@Override
	public boolean emptySeat(int row, int column) {
		// TODO : ver interface
		if(seats[row-1][column-1] != null){
			seats[row-1][column-1] = null;
			return true;
		}
	 return false;
	}
	
	
	
	public String toString() {
		String cadena="[";
		for (int i=0;i<nRows;i++) {
			for (int j=0; j<nColumns;j++) {
				if (seats[i][j]==null)
					cadena+="(null)";
				else {
					cadena+=seats[i][j].toString();
			}
			
		}
			cadena+="\n";
	}
		return cadena+"]";
	}


	
}



		
	


	