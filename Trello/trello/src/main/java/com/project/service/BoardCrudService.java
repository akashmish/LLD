package com.project.service;

import java.util.ArrayList;
import java.util.HashSet;

import com.project.dao.Storage;
import com.project.model.Board;
import com.project.model.Project;
import com.project.model.User;

import lombok.val;

public class BoardCrudService {

public void deleteBoard(String boardId) throws Exception{
        if(Storage.getBoards().containsKey(boardId)){
            //implement delete logic, from user vs card
            Storage.getBoards().remove(boardId);
        }else{
            throw new Exception("Board with given cardId: +" +boardId+ " not found");
        }
    }

    //Board: Each board should have an id, name, url, members, lists
    public Board createBoard(String name,String url,ArrayList<User> userList, ArrayList<Project> projectList){
        Board newBoard = Board.builder().name(name).members(userList).subprojects(projectList).build();
        Storage.getBoards().putIfAbsent(newBoard.getBoardId(), newBoard);
        Storage.getBoardMembers().putIfAbsent(newBoard.getBoardId(), new HashSet<>());
        for(var user : userList) Storage.getBoardMembers().get(newBoard.getBoardId()).add(user);
        return newBoard;
}

    public void moveProject(String id,Board newBoard){
        //take from old board, remove to new board
        Storage.getcardBoard().putIfAbsent(id,newBoard.getBoardId());
    }

    public void addProjectToBoard(String boardId,Project newProject){
        Storage.getBoards().get(boardId).addProjects(newProject);
    }

    public void addMemebrtoBoard(String boardId,User newUser){
       Storage.getBoards().get(boardId).addMembers(newUser);
    }

    public ArrayList<User> getAllUsers(String boardId){
        ArrayList<User> users = new ArrayList<>();
        users.addAll(Storage.getBoardMembers().get(boardId));
        return users;
    }
}
