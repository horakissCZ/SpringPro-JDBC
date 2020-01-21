package com.springpro.jdbc.jdbctemplate;

import com.springpro.jdbc.plain.SingerDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JdbcCfgTest {

    @Test
    public void testH2DB() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        testDao(ctx.getBean(SingerDao.class ));
    }

    private void testDao(SingerDao bean) {
        assertNotNull(bean);
        String singerName = bean.findNameById(1L);
        assertEquals("John Mayer", singerName);
    }
}
