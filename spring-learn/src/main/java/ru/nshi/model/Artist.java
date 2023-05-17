package ru.nshi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Artist {

    public static final String TABLE = "artist";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    private Integer id;
    private String name;
}
