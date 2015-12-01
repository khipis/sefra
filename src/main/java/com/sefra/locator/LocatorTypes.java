package com.sefra.locator;

import java.util.HashMap;
import java.util.Map;

public enum LocatorTypes {

    XPATH("xpath"),
    CLASSNAME("classname"),
    NAME("name"),
    ID("id"),
    CSS("css"),
    LINK("link"),
    PARTIAL_LINK("partiallink");

    private String type;

    public static final Map<String, LocatorTypes> CACHE_BY_TYPE = new HashMap<>();

    static{
        for(LocatorTypes locator: LocatorTypes.values()){
            CACHE_BY_TYPE.put(locator.getType(),locator);
        }
    }

    public String getType() {
        return type;
    }

    LocatorTypes(String type) {
        this.type = type;
    }

}
