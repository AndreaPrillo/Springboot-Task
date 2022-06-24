package SPID.demo.services;

import SPID.demo.entities.Spid;
import SPID.demo.entities.Status;
import SPID.demo.repository.SpidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpidService {

    @Autowired
    private SpidRepository repository;

    public Spid createSpid(Spid newSpid){

        if(newSpid.getStatus().equals(Status.PENDING)) return repository.save(newSpid);
        return null;
    }

    public Spid getSpid(long id){
    Optional<Spid> spid=repository.findById(id);
        if(spid.isPresent()) return spid.get();
        return null;
    }
public void deleteSpid(long id){
        Spid spidToDel=repository.getReferenceById(id);

        if (spidToDel!=null){
         repository.deleteById(id);}

}
public List<Spid> getAllSpids(){
        return repository.findAll();
}

    public Spid changeSpidStatus(long userid,long spidid){


        Spid spidStatusChange=repository.getReferenceById(spidid);
        if(spidStatusChange!=null){
            if(spidStatusChange.getUserId().getId()==userid){
                if(spidStatusChange.getStatus().equals(Status.PENDING)) {
                    spidStatusChange.setStatus(Status.READY_FOR_REVIEW);
                    return repository.save(spidStatusChange);
                }
            }
        }
        return null;
    }



}
