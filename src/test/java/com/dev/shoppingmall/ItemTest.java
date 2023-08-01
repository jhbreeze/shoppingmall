package com.dev.shoppingmall;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemTest {
    @Autowired
    EntityManager entityManager;

    @Test
    void test() {
        // given
        Item item = Item.builder()
                .name("테스트")
                .build();
        entityManager.persist(item);

        // when
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QItem qItem = QItem.item;
        Item foundItem = jpaQueryFactory.selectFrom(qItem).fetchOne();

        // then
        assertNotNull(foundItem);
        assertEquals(item.getId(), foundItem.getId());
        assertEquals("테스트", foundItem.getName());
    }
}