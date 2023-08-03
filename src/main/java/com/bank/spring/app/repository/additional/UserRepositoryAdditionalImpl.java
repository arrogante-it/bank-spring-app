package com.bank.spring.app.repository.additional;

import com.bank.spring.app.model.Account;
import com.bank.spring.app.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryAdditionalImpl implements UserRepositoryAdditional {
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Account", Account.class).list();
        }
    }

    @Override
    public List<Account> getAccountsByUser(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Account a where a.user.id = :userId";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

    @Override
    public Account getMainAccountByUserId(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "from Account a where a.user.id = :userId";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("userId", userId);
            query.setMaxResults(1);
            List<Account> mainAccounts = query.list();
            return mainAccounts.isEmpty() ? null : mainAccounts.get(0);
        }
    }
}
