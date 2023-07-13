package AnimalsReestr;


public class Donkey extends Packs{
    // minLifeTime: 27 years
    // maxLifeTime: 40 years

    public Donkey(String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 27, 40, ownerFio);
    }   
    
    @Override
    public String getInfo() {
        String res = "Class: Donkey" + " " + super.getInfo();
        return res;
    }
}
