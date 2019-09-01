package com.davidagood.redis;

import java.util.Map;

public interface Redis {
    String getHashField(String var1, String var2);

    Map<String, String> getHashFields(String var1);

    boolean setHashField(String var1, String var2, String var3);
}
