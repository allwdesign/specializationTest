package AnimalsReestr;

import java.util.UUID;

public class Dog extends Pets{
    // minLifeTime: 10 years
    // maxLifeTime: 13 years

    public Dog(UUID uuid, String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(uuid, name, commands, birthday, gender, size, 10, 13, ownerFio);
    }


    @Override
    public String getInfo() {
        String res = "Class: Dog" + " " + super.getInfo();
        return res;
    }
    
}
