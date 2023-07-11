package AnimalsReestr;

import java.util.Date;

public class Dog extends Pets{
    // minLifeTime: 10 years
    // maxLifeTime: 13 years

    public Dog(String name, String commands, Date birthday, Boolean gender, String size, String ownerFio) {
        super(name, commands, birthday, gender, size, 10, 13, ownerFio);
    }

   
    
}
