package entity;

public class Position {
    private int id;
    private PositionName name;


    public enum PositionName{
        DEV, TEST, SCRUM_MASTER, PM
    }
}
