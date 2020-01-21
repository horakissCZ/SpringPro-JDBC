package com.springpro.jdbc.jdbctemplate;

import com.springpro.jdbc.common.SingerDao;
import com.springpro.jdbc.init.config.EmbeddedJdbcConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JdbcCfgTest {

    @Test
    public void testH2DB() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        testDao(ctx.getBean(SingerDao.class));
    }

    private void testDao(SingerDao singerDao) {
        assertNotNull(singerDao);
        String singerName = singerDao.findNameById(1L);
        assertEquals("John Mayer", singerName);
    }
}
