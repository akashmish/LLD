package com.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    // Board: Each board should have an id, name, url, members, lists

    String name;
    @Builder.Default
    private String boardId = UUID.randomUUID().toString();
    private String url;
    // Each board contains different lists to signify sub-project
    private ArrayList<Project> subprojects;    
    private ArrayList<User> members;

    public void addMembers(User newUser){
        this.members.add(newUser);
    }

    public void addProjects(Project newProject){
        this.subprojects.add(newProject);
    }

    public void removeMember(User remUser){
        this.members.removeIf(user -> (user.getUserId().equals(remUser.getUserId())));
    }

    public void removeProject(Project remProject){
        this.subprojects.removeIf(id -> (id.getProjectId().equals(remProject.getProjectId())));
    }
}
