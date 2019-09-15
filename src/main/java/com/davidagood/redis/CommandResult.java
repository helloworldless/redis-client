package com.davidagood.redis;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CommandResult {
    private Long resultCode;
    private String resultDescription;
    private boolean result;
}
