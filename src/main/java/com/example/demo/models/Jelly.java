package com.example.demo.models;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Jelly {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UID;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private String name;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private String shape;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private String sweetness;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private String sourness;

    @Size(min = 1, max = 15)
    @NotBlank(message = "Поле не должно быть пустым")
    private String juice;


    public Jelly(){
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public Jelly(String name, String shape, String sweetness, String sourness, String juice) {
        this.name = name;
        this.shape = shape;
        this.sweetness = sweetness;
        this.sourness = sourness;
        this.juice = juice;
    }
    public void setName(String name){this.name = name;
    }
    public String getShape(){return shape;
    }
    public void setShape(String shape){this.shape = shape;
    }
    public String getSweetness(){return sweetness;
    }
    public void setSweetness(String sweetness){ this.sweetness = sweetness;}
    public String getSourness(){return sourness;
    }
    public void setSourness(String sourness){this.sourness = sourness;
    }
    public void setJuice(String juice) {this.juice = juice;
    }
    public String getJuice(){return juice;
    }

    public String getName() {
        return name;
    }
}