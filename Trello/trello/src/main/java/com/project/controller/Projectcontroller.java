package com.project.controller;

import java.util.ArrayList;

import com.project.model.*;
import com.project.service.ProjectService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Projectcontroller {

    private ProjectService projectService;

    void addCardtoList(String projectId,String cardId) throws Exception{
       projectService.addCardtoList(projectId, cardId);
    }
    
    //We should also be able to move cards across lists in the same board
    void moveCardToAnotherList(String cardId,String projectId){
        projectService.moveCardToAnotherList(cardId, projectId);
    }

    public Project addProject(String name,ArrayList<Card> cardList){
        return projectService.addProject(name, cardList);
    }
}
