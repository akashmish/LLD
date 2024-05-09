package com.project.controller;

import com.project.model.*;
import com.project.service.CardService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CardController {
    // We should be able to create/delete cards, assign/unassign a member to the card and modify attributes.
    // Users can create cards /edit boards.
    // We should also be able to move cards across lists in the same board      
    private CardService cardService;

    public void deleteCard(String cardId) throws Exception{
        cardService.deleteCard(cardId);
    }

    public Card createCard(String name,Integer priority,User user){
        return cardService.createCard(name, priority, user);
    }

    public void moveCard(String id,Board newBoard){
        cardService.moveCard(id, newBoard);
    }




}
