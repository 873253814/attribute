package collector;

import model.AttributeModule;
import model.AttributeType;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPlayerAttributeCollector implements IPlayerAttributeCollector{
    private static Map<AttributeModule, IPlayerAttributeCollector> collectors = new HashMap<>();

    public static Map<AttributeModule, IPlayerAttributeCollector> getCollectors() {
        return collectors;
    }

    public static IPlayerAttributeCollector getCollector(AttributeModule attributeModule) {
        return collectors.get(attributeModule);
    }

    @PostConstruct
    public void init() {
        if (collectors.containsKey(getAttributeModule())) {
            throw new RuntimeException();
        }
        collectors.put(getAttributeModule(), this);
    }

    @Override
    public List<Attribute> getAttributes(Player player) {
        throw new RuntimeException();
    }
}
