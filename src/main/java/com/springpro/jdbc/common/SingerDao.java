package com.springpro.jdbc.common;

import java.util.List;

public interface SingerDao {

    List<Singer> findAll();
    String findNameById(Long id);
    List<Singer> findByFirstName(String firstName);
    String findLastNameById(Long id);
    String findFirstNameById(Long id);
    void insert(Singer singer);
    void update(Singer singer);
    void delete(Long singerId);
    List<Singer> findAllWithDetail();
    void insertWithDetail(Singer  singer);

}
