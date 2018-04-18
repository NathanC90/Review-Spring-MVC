package ch02._01_setter._02;

public class Veterinary {
	IAnimal  animal;
    
    public Veterinary() {	
	}	

	public Veterinary(IAnimal animal) {
		super();
		this.animal = animal;
	}

	public IAnimal getAnimal() {
		return animal;
	}

	public void setAnimal(IAnimal animal) {
		this.animal = animal;
	}

	public void vaccinate (){
        animal.cry() ;                  	                                     
        if ( animal instanceof Horse) {  		
            Horse h = (Horse)animal ;       	
            h.run() ;             		
        } else if ( animal instanceof Pig) {
  	      Pig p = (Pig)animal ;             
  	      p.sleep() ;                    
        }
	}
}
