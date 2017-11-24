package com.medcare.dao;

import java.util.ArrayList;
import java.util.List;

import com.medcare.model.UserLoginModel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginDaoImpl implements UserLoginDaoI{

    @Autowired
    SessionFactory sessionFactory;
    Transaction tx = null;
    Session session = null;

    @SuppressWarnings("unchecked")
    @Override
    public UserLoginModel login(UserLoginModel user) {

//	    session = sessionFactory.openSession();
//		tx = session.beginTransaction();
//		session.save(user);
//		tx.commit();
//		session.close();
//		System.out.println("sdaoend");
//		return true;

        List<UserLoginModel> list;
        session = sessionFactory.openSession();
        tx = session.beginTransaction();


        System.out.println("in dao");
        SQLQuery query = session.createSQLQuery("select * from user where phno = '"+user.getPhno()+"' and password = '"+user.getPassword()+"'");
        query.addEntity(UserLoginModel.class);
        list = query.list();
        tx.commit();
        session.close();
        if(!list.isEmpty()){
            return list.get(0);

        }
        else
        {
            System.out.println("error");
            return null;
        }
    }
}