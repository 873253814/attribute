package model;

public enum AttributeType {
    ATTACK(1, "攻击力"),
    ;

    private int code;

    private String desc;

    AttributeType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
