package collector;

import model.AttributeModule;
import model.AttributeType;

import java.util.List;

public class EquipLevelAttrCollector extends AbstractPlayerAttributeCollector{
    @Override
    public List<Attribute> getAttributes(Player player) {
        throw new RuntimeException();
    }
    @Override
    public AttributeModule getAttributeModule() {
        return null;
    }
}
