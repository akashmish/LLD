package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.project.dao.Storage;
import com.project.model.*;
import com.project.service.BoardCrudService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BoardController {

    // Card to be uniquely identified on a board.
    // We should be able to create/delete boards, 
    //add/remove people from the members list (project members) and modify attributes. 
    //Deleting a board should delete all lists inside it.
    // We should also be able to move cards across lists in the same board
    // Ability to show a single board.
    private BoardCrudService boardCrudService;

    public void deleteBoard(String boardId) throws Exception{
        boardCrudService.deleteBoard(boardId);
    }

    public Board createBoard(String name,String url,ArrayList<User> userList, ArrayList<Project> projectList){
        return boardCrudService.createBoard(name, url, userList, projectList);
    }

    public void moveProject(String id,Board newBoard){
       boardCrudService.moveProject(id, newBoard);
    }

    public void addProjectToBoard(String boardId,Project newProject){
        boardCrudService.addProjectToBoard(boardId, newProject);
    }

    public void addMemebrtoBoard(String boardId,User newUser){
       boardCrudService.addMemebrtoBoard(boardId, newUser);
    }

    public ArrayList<User> getAllUsers(String boardId){
        return boardCrudService.getAllUsers(boardId);
    }
}
