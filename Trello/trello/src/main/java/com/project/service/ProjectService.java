package com.project.service;

import java.util.ArrayList;

import com.project.dao.Storage;
import com.project.model.*;

public class ProjectService {
        
    public void addCardtoList(String projectId,String cardId) throws Exception{
        Card fetchedCard = Storage.getCards().get(cardId);
        if(Storage.getProject().containsKey(projectId)){
            Storage.getProject().get(projectId).getCardsList().add(fetchedCard);
            Storage.getcardBoard().putIfAbsent(fetchedCard.getId(),projectId);
        }else{
            throw new Exception("Project with given Id deosnt exists");
        }
    }
    
    //We should also be able to move cards across lists in the same board
    public void moveCardToAnotherList(String cardId,String projectId){
        Storage.getcardBoard().putIfAbsent(cardId,projectId);
    }

    public Project addProject(String name,ArrayList<Card> cardList){
        Project newProj = Project.builder().name(name).cardsList(cardList).build();
        //adding to storage
        // Storage.getCards().putIfAbsent(newCard.getId(), newCard);
        return newProj;
    }

}
