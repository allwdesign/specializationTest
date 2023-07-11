package AnimalsReestr;

import java.util.Date;

public abstract class Packs extends Animal{
    
    private final Boolean hooves = true; 

    public Packs(String name, String commands, Date birthday, Boolean gender, String size, int minLifeTime,
            int maxLifeTime, String ownerFio) {
        super(name, commands, birthday, gender, size, minLifeTime, maxLifeTime, ownerFio);
    }

    public Boolean getHooves() {
        return hooves;
    }
    
}
