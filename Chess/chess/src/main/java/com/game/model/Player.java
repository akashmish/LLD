package com.game.model;

import com.game.enums.Color;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Player {
    private String name;
    private Integer id;
    private Color color;
}
