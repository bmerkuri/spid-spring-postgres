package com.example.demo.service;

import com.example.demo.model.Spid;
import com.example.demo.model.User;
import com.example.demo.utils.Status;
import com.example.demo.utils.Type;
import com.example.demo.utils.arr;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpidService {
    private List<Spid> data = new ArrayList<Spid>();
    private arr arr = new arr();


    //spid section
    public Spid getSpid(long id) throws Exception {
        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i).getId() == id) {
                return data.get(i);
            }
        }
        throw new Exception(String.format("Spid with an id:'%d' does not exists!", id));
    }

    public Spid createsSpid(User user) {
        long id = arr.iota();
        Spid spid = new Spid(id, new Date(),new Date(), user);
        user.setSpid(spid);
        data.add(spid);
        System.out.println(String.format("Spid %d created successfully!", id));
        return spid;
    }


    public void modifySpid(long id, Status status, Type type) throws Exception {
        getSpid(id).setStatus(status);
        getSpid(id).setType(type);
    }


    public void aproveSpid(long id) throws Exception {
        getSpid(id).setStatus(Status.APPROVED);
        getSpid(id).setType(Type.LEVEL_2);

    }


    public void showList() {
        System.out.println("\nList of SPIDs: ");
        data.forEach(el -> System.out.println("\t" + el));
    }

}
