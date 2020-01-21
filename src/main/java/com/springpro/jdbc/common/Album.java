package com.springpro.jdbc.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Album implements Serializable {

    private Long id;
    private Long singerId;
    private String title;
    private Date releaseDate;
}
