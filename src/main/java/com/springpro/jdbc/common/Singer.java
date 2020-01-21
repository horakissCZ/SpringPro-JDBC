package com.springpro.jdbc.common;

import com.springpro.jdbc.common.Album;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Data
@ToString
public class Singer implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private List<Album> albums;

    public boolean addAlbum(Album album) {
        if (albums == null) {
            albums = new ArrayList<>();
            albums.add(album);
            return true;
        } else {
            if (albums.contains(album)) {
                return false;
            }
        }
        albums.add(album);
        return true;
    }
}
