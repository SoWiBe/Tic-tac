package sample;

public class Gamer {
    private String Name;
    private String Motion;

    public Gamer(String name, String motion) {
        Name = name;
        Motion = motion;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMotion() {
        return Motion;
    }

    public void setMotion(String motion) {
        Motion = motion;
    }
}
