package collector;

import model.AttributeModule;
import model.AttributeType;

import java.util.List;

public interface IPlayerAttributeCollector {
    AttributeModule getAttributeModule();

    List<Attribute> getAttributes(Player player);
}
