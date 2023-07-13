package AnimalsReestr;


public class Cat extends Pets{
    // minLifeTime: 12 years
    // maxLifeTime: 18 years

    public Cat(String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 12, 18, ownerFio);
    }

    @Override
    public String getInfo() {
        String res = "Class: Cat" + " " + super.getInfo();
        return res;
    }
}
