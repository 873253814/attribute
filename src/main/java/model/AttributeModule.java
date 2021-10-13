package model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum AttributeModule {
    /**
     * 全局节点
     */
    GLOBAL(1, null),
    /**
     * 等级
     */
    LEVEL(2, GLOBAL),
    /**
     * 装备
     */
    EQUIPMENT(3, GLOBAL),
    /**
     * 装备等级
     */
    EQUIPMENT_LEVEL(4, EQUIPMENT)
    ;

    private int code;
    private AttributeModule parent;
    private List<AttributeModule> childrens;
    /**
     * 是否给其它模块集成属性
     */
    private boolean integrate;


    AttributeModule(int code, AttributeModule parent) {
        this.code = code;
        this.parent = parent;
    }

    public static final Map<Integer, AttributeModule> idMap;
    public static final AttributeModule[] Elems = AttributeModule.values();
    public static final Set<AttributeModule> parents = Arrays.stream(Elems).map(AttributeModule::getParent).filter(Objects::nonNull).collect(Collectors.toSet());
    public static List<AttributeModule> depthList = new ArrayList<>(values().length);
    public static List<AttributeModule> integrateModuleList = new ArrayList<>(values().length);

    static {
        for (AttributeModule value : values()) {
            if (value.parent != null) {
                List<AttributeModule> childrens = value.getParent().childrens;
                if (childrens == null) {
                    childrens = new ArrayList<>();
                    value.getParent().childrens = childrens;
                }
                childrens.add(value);
            }
        }
        visitModuleNode(depthList, GLOBAL);
        Collections.reverse(depthList);
        initIntegrateModule(integrateModuleList);

        boolean duplicate = false;

        Map<Integer, List<AttributeModule>> checkDuplicateMap = Arrays.stream(values())
                .collect(Collectors.groupingBy(AttributeModule::getCode));
        for (Map.Entry<Integer, List<AttributeModule>> entry : checkDuplicateMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicate = true;
            }
        }
        if (duplicate) {
            System.exit(0);
        }

        idMap = Arrays.stream(values()).collect(Collectors.toMap(AttributeModule::getCode, Function.identity()));

    }

    private static void initIntegrateModule(List<AttributeModule> list) {
        for (AttributeModule elem : Elems) {
            if (!elem.isIntegrate()) {
                continue;
            }
            list.add(elem);
        }
    }
    /**
     * 查看所有节点
     * @param visitedList
     * @param attributeModule
     */
    private static void visitModuleNode(List<AttributeModule> visitedList, AttributeModule attributeModule) {
        visitedList.add(attributeModule);
        if (attributeModule.childrens != null) {
            for (AttributeModule children : attributeModule.childrens) {
                visitModuleNode(visitedList, children);
            }
        }
    }

    /**
     * 收集叶子节点
     * @param leafModules
     * @param module
     */
    private void collectLeafModules(List<AttributeModule> leafModules, AttributeModule module) {
        if (module.childrens == null || module.childrens.isEmpty()) {
            leafModules.add(module);
        } else {
            for (AttributeModule children : module.childrens) {
                collectLeafModules(leafModules, children);
            }
        }
    }

    public List<AttributeModule> getLeafModules() {
        if (this.childrens == null || this.childrens.isEmpty()) {
            return Collections.singletonList(this);
        }
        List<AttributeModule> leafModules = new ArrayList<>();
        collectLeafModules(leafModules, this);
        return leafModules;
    }

    public AttributeModule getParent() {
        return parent;
    }

    public boolean isIntegrate() {
        return integrate;
    }

    public int getCode() {
        return code;
    }
}
