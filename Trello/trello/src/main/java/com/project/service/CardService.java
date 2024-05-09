package com.project.service;

import com.project.dao.Storage;
import com.project.model.*;

public class CardService {
        // We should be able to create/delete cards, assign/unassign a member to the card and modify attributes.
    // Users can create cards /edit boards.
    // We should also be able to move cards across lists in the same board      

    public void deleteCard(String cardId) throws Exception{
        if(Storage.getCards().containsKey(cardId)){
            //extensive delete logic
            Storage.getCards().remove(cardId);
        }else{
            throw new Exception("Card with given cardId: +" +cardId+ " not found");
        }
    }

    public Card createCard(String name,Integer priority,User user){
        Card newCard = Card.builder()
                        .name(name)
                        .priority(priority)
                        .assignedUser(user)
                        .build();
        //adding to storage
        Storage.getCards().putIfAbsent(newCard.getId(), newCard);
        return newCard;
    }

    public void moveCard(String id,Board newBoard){
        //take from old board, remove to new board
        Storage.getcardBoard().putIfAbsent(id,newBoard.getBoardId());
    }




}
