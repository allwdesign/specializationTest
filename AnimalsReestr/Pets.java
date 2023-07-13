package AnimalsReestr;


public abstract class Pets extends Animal{

    public Pets(String name, String commands, String birthday, String gender, String size, int minLifeTime,
            int maxLifeTime, String ownerFio) {
        super(name, commands, birthday, gender, size, minLifeTime, maxLifeTime, ownerFio);
    }

    @Override
    public String getInfo() {
        String res = "Type: Pets" + " " + super.getInfo();
        return res;
    }
    
    
}
