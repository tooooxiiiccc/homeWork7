package utils;

import java.time.Duration;

public final class Timeouts {
    public static final Duration DEFAULT = Duration.ofSeconds(10);
    public static final Duration SHORT = Duration.ofSeconds(5);
    public static final Duration LONG = Duration.ofSeconds(20);
    
    private Timeouts(){}
}

