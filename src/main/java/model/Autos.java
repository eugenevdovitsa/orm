package model;

import annotation.EntitySoft;
import annotation.ForeignKeySoft;
import annotation.TableSoft;

@EntitySoft
@TableSoft (name = "autos")
public class Autos {

    @ForeignKeySoft
    private String name;

    private int year;
}
