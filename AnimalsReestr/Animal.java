package AnimalsReestr;

import java.util.UUID;

public abstract class Animal implements ReestrInterface {
    private UUID uuid; 
    private String type;
    private String name;
    private String commands;
    private String birthday;
    private String gender;
    private String size;
    private int minLifeTime;
    private int maxLifeTime;
    private String ownerFio;

    public Animal(UUID uuid, String type, String name, String commands, String birthday, String gender, String size,
            int minLifeTime, int maxLifeTime, String ownerFio) {
        this.uuid = uuid;
        this.type = type;
        this.name = name;
        this.commands = commands;
        this.birthday = birthday;
        this.gender = gender;
        this.size = size;
        this.minLifeTime = minLifeTime;
        this.maxLifeTime = maxLifeTime;
        this.ownerFio = ownerFio;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    @Override
    public String getInfo() {
        String pattern = "Name: %s Commands: %s";
        return String.format(pattern, getName(), getCommands());
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s", getUuid().toString(), getType(),
                getClass().getSimpleName(), getName(), getCommands(), getBirthday(),
                getGender(), getSize(), getOwnerFio());
    }

    


}
