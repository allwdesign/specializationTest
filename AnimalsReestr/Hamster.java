package AnimalsReestr;

import java.util.UUID;

public class Hamster extends Pets{
    // minLifeTime: 2 years
    // maxLifeTime: 4 years

    public Hamster(UUID uuid, String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(uuid, name, commands, birthday, gender, size, 2, 4, ownerFio);
    }

    @Override
    public String getInfo() {
        String res = "Class: Hamster" + " " + super.getInfo();
        return res;
    }
}
