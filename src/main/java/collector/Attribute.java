package collector;

import model.AttributeType;

public class Attribute {

    private AttributeType type;

    private long value;

    public Attribute(AttributeType type, long value) {
        this.type = type;
        this.value = value;
    }

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
