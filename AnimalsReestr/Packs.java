package AnimalsReestr;


public abstract class Packs extends Animal{
    
    private final Boolean hooves = true; 

    public Packs(String name, String commands, String birthday, String gender, String size, int minLifeTime,
            int maxLifeTime, String ownerFio) {
        super(name, commands, birthday, gender, size, minLifeTime, maxLifeTime, ownerFio);
    }

    public Boolean getHooves() {
        return hooves;
    }

    @Override
    public String getInfo() {
        String res = "Type: Packs" + " " + super.getInfo();
        return res;
    }
    
}
