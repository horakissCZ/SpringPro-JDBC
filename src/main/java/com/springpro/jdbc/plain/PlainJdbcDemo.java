package com.springpro.jdbc.plain;

import com.springpro.jdbc.common.Singer;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Slf4j
public class PlainJdbcDemo {

    private static SingerDao singerDao = new PlainSingerDao();

    public static void main(String... args) {
        log.info("Listing initial singer data:");

        listAllSingers();

        log.info("-------------");
        log.info("Insert a  new singer");
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDay(new Date
                ((new GregorianCalendar(1991,  2, 1991)).getTime().getTime()));
        singerDao.insert(singer);
        log.info("Listing singer data after new singer created:");
        listAllSingers();

        log.info("-------------");
        log.info("Deleting the previous created singer");
        singerDao.delete(singer.getId());

        log.info("Listing singer data after new singer deleted:");
        listAllSingers();
    }

    private static void listAllSingers() {
        List<Singer> singers = singerDao.findAll();

        for (Singer singer : singers) {
            log.info(singer.toString());
        }
    }
}
