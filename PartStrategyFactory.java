package com.autoparts.factory;

import com.autoparts.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartStrategyFactory {
    @Autowired
    private EnginePartStrategy engineStrategy;
    @Autowired
    private BrakePartStrategy brakeStrategy;
    @Autowired
    private DefaultPartStrategy defaultStrategy;

    public PartDisplayStrategy getStrategy(Integer categoryId) {
        // 假设分类ID: 1=发动机, 2=刹车
        if (categoryId == 1) {
            return engineStrategy;
        } else if (categoryId == 2) {
            return brakeStrategy;
        }
        return defaultStrategy;
    }
}