package com.springpro.jdbc.jdbctemplate;

import com.springpro.jdbc.common.Album;
import com.springpro.jdbc.common.Singer;
import com.springpro.jdbc.common.SingerDao;
import com.springpro.jdbc.init.config.EmbeddedJdbcConfig;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log
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

    @Test
    public void testRowMapper() {
        GenericApplicationContext ctx  =
                new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());
        singers.forEach(singer -> System.out.println(singer.toString()));
        ctx.close();
    }
}
