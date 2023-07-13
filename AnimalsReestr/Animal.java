package AnimalsReestr;


public abstract class Animal implements ReestrInterface{
    
    private String name;
    private String commands;
    private String birthday;
    private String gender;
    private String size;
    private int minLifeTime;
    private int maxLifeTime;
    private String ownerFio;
    
    public Animal(String name, String commands, String birthday, String gender, String size, int minLifeTime,
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
        return String.format("Name: %s Hash: %s", getName(), this.hashCode());
    }

    
    
    
    
    
}
