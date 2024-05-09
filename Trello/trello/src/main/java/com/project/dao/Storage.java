package com.project.dao;

import java.util.*;
import java.util.Objects;

import com.project.model.*;

public class Storage {
    //private so no one can access other than this calls static so can be called by classname
    //to store all created boards
    private static HashMap<String,Board> boards; //boardId vs board
    private static HashMap<String,Card> cards; //cardsId vc card
    private static HashMap<String,String> cardBoard; //card vs project
    private static HashMap<String,String> carduser; // card assigned to which user 
    private static HashMap<User,List<Card>> userCard; //list of card for ech user
    private static HashMap<String,Project> projects; //cardsId vc card
    private static HashMap<String,HashSet<Card>> boardCard; //cardsId vc card
    private static HashMap<String,HashSet<User>> boardMembers;

    //private constructor
    private Storage(){};

    public static HashMap<String,Board> getBoards(){
        if(Objects.isNull(boards)){
            boards = new HashMap<>();
        }
        return boards;
    }

    public static HashMap<String,Card> getCards(){
        if(Objects.isNull(cards)){
            cards = new HashMap<>();
        }
        return cards;
    }

    public static HashMap<String,String> getcardBoard(){
        if(Objects.isNull(cardBoard)){
            cardBoard = new HashMap<>();
        }
        return cardBoard;
    }

    public static HashMap<User,List<Card>> getUserCard(){
        if(Objects.isNull(userCard)){
            userCard = new HashMap<>();
        }
        return userCard;
    }

    public static HashMap<String,Project> getProject(){
        if(Objects.isNull(projects)){
            projects = new HashMap<>();
        }
        return projects;
    }

    public static HashMap<String,HashSet<User>> getBoardMembers(){
        if(Objects.isNull(boardMembers)){
            boardMembers =  new HashMap<>();
        }
        return boardMembers;
    }
}
