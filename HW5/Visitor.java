package Practic;

public class Visitor{
    public String name;
    public String passId;

    public Visitor(String name, String passId){
        this.name = name;
        this.passId = passId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassId() {
        return passId;
    }
    public void setPassId(String passId) {
        this.passId = passId;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Visitor)) return false;
        Visitor visitor = (Visitor) o;
        return name.equals(visitor.name) && passId.equals(visitor.passId);
    }
    @Override
    public int hashCode() {
        return passId.hashCode();
    }
}