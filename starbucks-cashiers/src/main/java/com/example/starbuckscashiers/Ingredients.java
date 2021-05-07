package com.example.starbuckscashiers;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredients {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        MILK, SIZE; 
    }
    
}
