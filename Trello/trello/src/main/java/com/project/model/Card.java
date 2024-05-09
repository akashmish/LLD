package com.project.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    //Card: Each card should have an id, name, assigned user, priority.
    //Cards inside a list should be sorted by priorityprivate 

    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String name;
    private Integer priority;
    private User assignedUser;


    public int compareTo(Card c){
        //previous elements priorty is higher so no swap else swap
        if(this.priority > c.priority) return -1;
        return 1;
    }
}
