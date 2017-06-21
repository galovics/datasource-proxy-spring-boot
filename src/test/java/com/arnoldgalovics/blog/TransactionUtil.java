package com.arnoldgalovics.blog;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionUtil {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void doInTransaction(final Consumer<EntityManager> c) {
        c.accept(entityManager);
    }
}
