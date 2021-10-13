package container;

import collector.AoiCreature;
import collector.AoiPlayer;
import model.AttributeType;

import java.util.HashMap;
import java.util.Map;

public class AoiCreatureAttributeContainer<T extends AoiCreature> {
    protected T owner;

    protected Map<AttributeType, Long> finalMap = new HashMap<>();

    public AoiCreatureAttributeContainer(T owner) {
        this.owner = owner;
        if (owner instanceof AoiPlayer) {
            AoiPlayer aoiPlayer = (AoiPlayer) owner;
            this.finalMap = aoiPlayer.getPlayerAttributeBox().getFinalAttributeMap();
        }
    }
}
