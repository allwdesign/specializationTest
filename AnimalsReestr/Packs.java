package AnimalsReestr;

import java.util.UUID;

public abstract class Packs extends Animal{
    
    private final Boolean hooves = true; 

    public Packs(UUID uuid, String name, String commands, String birthday, String gender, String size, int minLifeTime,
            int maxLifeTime, String ownerFio) {
        super(uuid, "Packs", name, commands, birthday, gender, size, minLifeTime, maxLifeTime, ownerFio);
    }

    public Boolean getHooves() {
        return hooves;
    }

    @Override
    public String getInfo() {
        String res = "Type: Packs" + " " + super.getInfo();
        return res;
    }

    
    
}
