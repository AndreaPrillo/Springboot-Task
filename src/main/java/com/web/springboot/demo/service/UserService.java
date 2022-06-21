package com.web.springboot.demo.service;
import com.web.springboot.demo.entities.USER;
import com.web.springboot.demo.entities.SPID;
import com.web.springboot.demo.entities.Status;
import database.Database;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Set;

@Service
public class UserService {

    Database db;

    public UserService() {
        db=new Database();
    }

    public Database getDb() {
        return this.db;
    }

    public USER getDbUser(long id) {
        return db.getDbUser().get(id);
    }

    public SPID getDbSpid(long id) {
        return db.getDbSpid().get(id);
    }

    public void createUser(long id, Timestamp createdAt, String createdBy, String name, String surname, String username) {
        USER newUser=new USER(id,createdAt,createdBy,name,surname,username);
        db.getDbUser().put(newUser.getId(), newUser);

    }

    public void createSpid(long id,Timestamp createdAt,USER user, String description) {

        SPID newSpid=new SPID(id,createdAt, user, description, Status.PENDING);
        db.getDbSpid().put(newSpid.getId(), newSpid);
    }

    public void editUser(long id,String newUsername,String newSurname,String newName) {
        USER userToBeEdited=(USER) db.getDbUser().get(id);
        userToBeEdited.setName(newName);
        userToBeEdited.setUsername(newUsername);
        userToBeEdited.setSurname(newSurname);
        db.getDbUser().put(id, userToBeEdited);
    }

    public void editSpid(long id,String newDescription,Status newStatus) {
        SPID spidToBeEdited=(SPID) db.getDbSpid().get(id);
        spidToBeEdited.setDescription(newDescription);
        spidToBeEdited.setStatus(newStatus);
        db.getDbSpid().put(id, spidToBeEdited);
    }

    public void changeSpidStatusToAproved(long id) {
        SPID spidToBeEdited=(SPID) db.getDbSpid().get(id);
        spidToBeEdited.setStatus(Status.APPROVED);
        db.getDbSpid().put(id, spidToBeEdited);
    }

    public ArrayList<SPID> listAllSpids(){
        ArrayList<SPID> spidList=new ArrayList<>();
        Set<Long> keys=db.getDbSpid().keySet();
        Iterator<Long> iterator=keys.iterator();
        while(iterator.hasNext()) {
            Long key=iterator.next();
            spidList.add((SPID) db.getDbSpid().get(key));
        }
        return spidList;

    }
    public String spidConnectedToUser(long userId) {
        SPID spid=(SPID)db.getDbSpid().get(userId);
        USER user=(USER)db.getDbUser().get(userId);
        if(spid==null) return ""+user.getUsername()+" is  not conected to a SPID";
        else return ""+user.getUsername()+" is  conected to a SPID "+spid.getId();

    }

    public String userCreatedBy(long id) {

        USER user=(USER) db.getDbUser().get(id);
        if(user!=null) {
            return "User created by "+user.getCreatedBy();
        }
        else return "User doesnt exist";
    }

    public String spidCreatedBy(long id) {

        SPID spid=(SPID)db.getDbSpid().get(id);
        if(spid!=null) {
            return "Spid created by "+spid.getCreatedBy();
        }
        else return "Spid doesnt exist";
    }

}
