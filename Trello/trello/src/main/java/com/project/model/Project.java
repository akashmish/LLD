package com.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    //List: Each list(subproject/project) should have an id, name and cards .
    @Builder.Default
    private String projectId = UUID.randomUUID().toString();
    private String name;
    
    //Each list contain different cards signifying smaller tasks
    private ArrayList<Card> cardsList;

    
}
