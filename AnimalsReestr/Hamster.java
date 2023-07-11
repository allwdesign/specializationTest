package AnimalsReestr;

import java.util.Date;

public class Hamster extends Pets{
    // minLifeTime: 2 years
    // maxLifeTime: 4 years

    public Hamster(String name, String commands, Date birthday, Boolean gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 2, 4, ownerFio);
    }

    
}
