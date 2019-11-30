package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.ContactDetail;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLContactDetailDAO;
import com.loneliness.server.servise.DataService;

import java.util.Map;

public class ContactDetailService implements DataService<ContactDetail,String, Map<Integer,ContactDetail>> {
    private ContactDetailService(){}
    private static final ContactDetailService instance=new ContactDetailService();
    private SQLContactDetailDAO dao= DAOFactory.getInstance().getContactDetailDAO();
    public static ContactDetailService getInstance() {
        return instance;
    }


    @Override
    public String add(ContactDetail note) {
        return dao.add(note);
    }

    @Override
    public String update(ContactDetail note) {
        return dao.update(note);
    }

    @Override
    public ContactDetail receive(ContactDetail note) {
        return dao.receive(note);
    }

    @Override
    public String delete(ContactDetail note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, ContactDetail> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, ContactDetail> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
