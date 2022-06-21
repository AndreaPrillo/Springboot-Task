package main;

import entities.SPID;
import entities.Status;
import entities.USER;
import service.Service;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Service service=new Service();
        service.createUser(1, new Timestamp(System.currentTimeMillis()), "andrea28", "andrea", "prillo", "andrea28");
        service.createUser(2, new Timestamp(System.currentTimeMillis()), "devis04", "devis", "dervishi", "devis04");
        USER user=(USER)service.getDbUser(1);
	    service.createSpid(1,new Timestamp(System.currentTimeMillis()),(USER)service.getDbUser(1),"Spid one");
		service.createSpid(2,new Timestamp(System.currentTimeMillis()),(USER)service.getDbUser(2),"Spid two");

        System.out.println(user);

		service.editSpid(1, "Spid one updated", Status.APPROVED);
		service.editUser(2, "devis05", "david", "beckham");

		for(SPID s:service.listAllSpids()) {
			System.out.println(s);
		}
        System.out.println(service.spidConnectedToUser(1));
    	System.out.println(service.spidCreatedBy(2));
    }
}
