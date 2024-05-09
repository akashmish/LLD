package com.project;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.project.controller.BoardController;
import com.project.controller.CardController;
import com.project.controller.Projectcontroller;
import com.project.model.*;
import com.project.service.BoardCrudService;
import com.project.service.CardService;
import com.project.service.ProjectService;

import lombok.val;

/**
 * Unit test for simple App.
 */
public class TrelloTest 
{
    /**
     * Rigorous Test :-)
     */

    private  BoardController boardController;
    private CardController cardController;
    private Projectcontroller projectcontroller;
    
    @BeforeEach
    public void setup(){
        BoardCrudService boardCrudService = new BoardCrudService();
        ProjectService projectService = new ProjectService();
        CardService cardService = new CardService();
        boardController = new BoardController(boardCrudService);
        cardController = new CardController(cardService);
        projectcontroller = new Projectcontroller(projectService);
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        setup();
        User user1 = User.builder().name("Akas").email("abc@gmail").build();
        User user2 = User.builder().name("Aman").email("abc@gmail").build();
        User user3 = User.builder().name("Abhi").email("abc@gmail").build();

        Card c1 = cardController.createCard("UI",2, user1);
        Card c2 = cardController.createCard("UDX",4, user2);
        Card c3 = cardController.createCard("QA",3, user1);

        Project proj1 = projectcontroller.addProject("BackEnd", new ArrayList<Card>(Arrays.asList(c1,c2)));
        
        Board fboard = boardController.createBoard("GS Service","abc@gmail.com",new ArrayList<User>(Arrays.asList(user1,user2)),new ArrayList<Project>(Arrays.asList(proj1)));
        System.out.println("Board after creation : "+fboard);
        boardController.addMemebrtoBoard(fboard.getBoardId(), user3); 

        ArrayList<User> usersOnBoard = boardController.getAllUsers(fboard.getBoardId());
        System.out.println(usersOnBoard);

        fboard.removeProject(proj1);
        System.out.println("Board after removing project : "+fboard);

    }
}
