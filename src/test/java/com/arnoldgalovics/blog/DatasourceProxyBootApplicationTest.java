package com.arnoldgalovics.blog;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.arnoldgalovics.blog.domain.Person;

import net.ttddyy.dsproxy.QueryCountHolder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceProxyBootApplicationTest {
    @Autowired
    private TransactionUtil txUtil;

    @Test
    public void testInsertIsCaughtByTheDatasourceProxy() {
        // given
        Person person = new Person();
        person.setId(1);
        person.setName("Arnold");
        // when
        txUtil.doInTransaction(em -> em.persist(person));
        // then
        assertEquals(1, QueryCountHolder.getGrandTotal().getInsert());
    }
}
