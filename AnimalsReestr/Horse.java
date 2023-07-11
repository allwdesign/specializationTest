package AnimalsReestr;

import java.util.Date;

public class Horse extends Packs{
    // minLifeTime: 25 years
    // maxLifeTime: 30 years

    public Horse(String name, String commands, Date birthday, Boolean gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 25, 30, ownerFio);
    }

    
    
}
