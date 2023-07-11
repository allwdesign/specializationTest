package AnimalsReestr;

import java.util.Date;

public class Donkey extends Packs{
    // minLifeTime: 27 years
    // maxLifeTime: 40 years

    public Donkey(String name, String commands, Date birthday, Boolean gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 27, 40, ownerFio);
    }   
    
}
