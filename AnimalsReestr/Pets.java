package AnimalsReestr;

import java.util.Date;

public abstract class Pets extends Animal{

    public Pets(String name, String commands, Date birthday, Boolean gender, String size, int minLifeTime,
            int maxLifeTime, String ownerFio) {
        super(name, commands, birthday, gender, size, minLifeTime, maxLifeTime, ownerFio);
    }
    
    
}
