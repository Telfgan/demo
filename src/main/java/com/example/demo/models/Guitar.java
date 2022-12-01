package com.example.demo.models;
import com.example.demo.services.GuitarService;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Guitar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private Integer strings;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private Double menzure;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private String drop;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private Integer cost;


    public Guitar(){
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Guitar(String name, Integer strings, Double menzure, String drop, Integer cost) {
        this.name = name;
        this.strings = strings;
        this.menzure = menzure;
        this.drop = drop;
        this.cost = cost;
    }
    public void setName(String name){this.name = name;
    }
    public Integer getStrings(){return strings;
    }
    public void setStrings(Integer strings){this.strings = strings;
    }
    public Double getMenzure(){return menzure;
    }
    public void setMenzure(Double menzure){ this.menzure = menzure;}
    public String getDrop(){return drop;
    }
    public void setDrop(String drop){this.drop = drop;
    }
    public void setCost(Integer cost) {this.cost = cost;
    }
    public Integer getCost(){return cost;
    }

    public String getName() {
        return name;
    }
}