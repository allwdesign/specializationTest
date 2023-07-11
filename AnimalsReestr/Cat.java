package AnimalsReestr;

import java.util.Date;

public class Cat extends Pets{
    // minLifeTime: 12 years
    // maxLifeTime: 18 years

    public Cat(String name, String commands, Date birthday, Boolean gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 12, 18, ownerFio);
    }
}
