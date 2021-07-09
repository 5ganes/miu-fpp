package homework4;

class Computer{

    private String manufacturer;
    private String processor;
    private int ramSize;
    double processorSpeed;
    Computer(String manufacturer, String processor, int ramSize, double processorSpeed){
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.processorSpeed = processorSpeed;
    }

    public int getRamSize(){ return ramSize; }

    public double getProcessorSpeed(){ return this.processorSpeed; }

    public double computePower(){ return ramSize * processorSpeed; }

    public String toString(){
        return manufacturer + " with Ram Size " + ramSize + " and Processor Speed " + processorSpeed + " has power " + computePower();
    }

    @Override
    public boolean equals(Object ob){
        if(ob == null) return false;
        // if(this.getClass() != ob.getClass()) return false;
        if(!(ob instanceof Computer)) return false;
        Computer c = (Computer) ob;
        return manufacturer.equals(c.manufacturer) && this.processor.equals(c.processor) && ramSize == c.ramSize && processorSpeed == c.processorSpeed;
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = (hash * 11 * 13) + manufacturer.hashCode() + processor.hashCode() + ramSize + (int)Double.doubleToLongBits(processorSpeed);
        return hash;
    }

}

public class EqualsHashCodeProblem5 {
    public static void main(String[] args) {
        Computer computer1 = new Computer("Dell", "Intel", 4, 2.33);
        Computer computer2 = new Computer("Dell", "Intel", 4, 2.33);
        // Computer c = computer1;
        System.out.println("Are the objects equal : " + computer1.equals(computer2));
        System.out.println("Hash Code of computer1 = " + computer1.hashCode());
        System.out.println("Hash Code of computer2 = " + computer2.hashCode());
        System.out.println("Do both computers have same hash code : " + (computer1.hashCode() == computer2.hashCode()));



    }
}
