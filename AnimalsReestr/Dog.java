package AnimalsReestr;


public class Dog extends Pets{
    // minLifeTime: 10 years
    // maxLifeTime: 13 years

    public Dog(String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 10, 13, ownerFio);
    }

    @Override
    public String getInfo() {
        String res = "Class: Dog" + " " + super.getInfo();
        return res;
    }
    
}
