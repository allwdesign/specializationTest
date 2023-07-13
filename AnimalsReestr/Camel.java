package AnimalsReestr;


public class Camel extends Packs{
    // minLifeTime: 40 years
    // maxLifeTime: 50 years

    public Camel(String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 40, 50, ownerFio);
    }

    @Override
    public String getInfo() {
        String res = "Class: Camel" + " " + super.getInfo();
        return res;
    }
    
}
