package AnimalsReestr;

import java.util.Date;

public abstract class Animal {
    final public String[] sizes = new String[] {"Small", "Midlle", "Big"}; 

    public String name;
    public String commands;
    public Date birthday;
    public Boolean gender;
    public String size;
    public String ownerFio;
    
    public Animal(String name, String commands, Date birthday, Boolean gender, String size, String ownerFio) {
        this.name = name;
        this.commands = commands;
        this.birthday = birthday;
        this.gender = gender;
        this.size = size;
        this.ownerFio = ownerFio;
    }
    
    
    
}
