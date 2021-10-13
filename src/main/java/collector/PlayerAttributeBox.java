package collector;

import model.AttributeType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerAttributeBox {
    /**
     * 原始属性
     */
    private Map<AttributeType, List<Attribute>> rowBaseAttributeMap = new HashMap<>();
    /**
     * 基础属性
     */
    private Map<AttributeType, Long> baseAttributeMap = new HashMap<>();
    /**
     * 最终属性
     */
    private Map<AttributeType, Long> finalAttributeMap = new HashMap<>();

    public Map<AttributeType, List<Attribute>> getRowBaseAttributeMap() {
        return rowBaseAttributeMap;
    }

    public void setRowBaseAttributeMap(Map<AttributeType, List<Attribute>> rowBaseAttributeMap) {
        this.rowBaseAttributeMap = rowBaseAttributeMap;
    }

    public Map<AttributeType, Long> getBaseAttributeMap() {
        return baseAttributeMap;
    }

    public void setBaseAttributeMap(Map<AttributeType, Long> baseAttributeMap) {
        this.baseAttributeMap = baseAttributeMap;
    }

    public Map<AttributeType, Long> getFinalAttributeMap() {
        return finalAttributeMap;
    }

    public void setFinalAttributeMap(Map<AttributeType, Long> finalAttributeMap) {
        this.finalAttributeMap = finalAttributeMap;
    }
}
