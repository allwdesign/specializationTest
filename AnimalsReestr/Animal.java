package AnimalsReestr;

import java.util.Date;

public abstract class Animal {
    final private String[] sizes = new String[] {"Small", "Midlle", "Big"}; 

    private String name;
    private String commands;
    private Date birthday;
    private Boolean gender;
    private String size;
    private int minLifeTime;
    private int maxLifeTime;
    private String ownerFio;
    
    public Animal(String name, String commands, Date birthday, Boolean gender, String size, int minLifeTime,
            int maxLifeTime, String ownerFio) {
        this.name = name;
        this.commands = commands;
        this.birthday = birthday;
        this.gender = gender;
        this.size = size;
        this.minLifeTime = minLifeTime;
        this.maxLifeTime = maxLifeTime;
        this.ownerFio = ownerFio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getMinLifeTime() {
        return minLifeTime;
    }

    public void setMinLifeTime(int minLifeTime) {
        this.minLifeTime = minLifeTime;
    }

    public int getMaxLifeTime() {
        return maxLifeTime;
    }

    public void setMaxLifeTime(int maxLifeTime) {
        this.maxLifeTime = maxLifeTime;
    }

    public String getOwnerFio() {
        return ownerFio;
    }

    public void setOwnerFio(String ownerFio) {
        this.ownerFio = ownerFio;
    }

    

    
    
    
    
    
}
