package database;

import java.util.HashMap;
import java.util.Map;

import com.web.springboot.demo.entities.USER;
import com.web.springboot.demo.entities.SPID;

public class Database {

    Map<Long, USER> dbUser;
    Map<Long, SPID> dbSpid;

    public Database() {

        dbUser=new HashMap<Long,USER>();
        dbSpid=new HashMap<Long,SPID>();


    }

    public HashMap<Long, USER> getDbUser() {
        return (HashMap<Long, USER>) dbUser;
    }



    public HashMap<Long, SPID> getDbSpid() {
        return (HashMap<Long, SPID>) dbSpid;
    }



}
