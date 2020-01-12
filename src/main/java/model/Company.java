package model;

import annotation.ColumnSoft;
import annotation.EntitySoft;
import annotation.IdSoft;
import annotation.TableSoft;

@EntitySoft
@TableSoft (name = "company")
public class Company {

    @IdSoft
    private int id;

    @ColumnSoft(name = "name")
    private String name;

    @ColumnSoft(name = "employees")
    private int employees;

    @ColumnSoft(name = "city")
    private String city;


}
