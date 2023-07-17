package AnimalsReestr;

import java.util.UUID;

public class Horse extends Packs{
    // minLifeTime: 25 years
    // maxLifeTime: 30 years

    public Horse(UUID uuid, String name, String commands, String birthday, String gender, String size, String ownerFio) {
        super(uuid, name, commands, birthday, gender, size, 25, 30, ownerFio);
    }

    @Override
    public String getInfo() {
        String res = "Class: Horse" + " " + super.getInfo();
        return res;
    }
    
}
