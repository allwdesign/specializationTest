package AnimalsReestr;

public class Hamster extends Pets{
    // minLifeTime: 2 years
    // maxLifeTime: 4 years

    public Hamster(String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 2, 4, ownerFio);
    }

    @Override
    public String getInfo() {
        String res = "Class: Hamster" + " " + super.getInfo();
        return res;
    }
}
