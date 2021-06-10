package com.avaliacaodecasas.api.entities;

import com.avaliacaodecasas.api.services.validation.RoomInsert;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@RoomInsert
public class Comodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome do cômodo não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome do cômodo não pode exceder 30 caracteres.")
    private String room_name;

    @NotBlank(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento do cômodo não pode exceder 33 metros.")
    private Double room_length;

    @NotBlank(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura do cômodo não pode exceder 25 metros.")
    private Double room_width;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(Double room_length) {
        this.room_length = room_length;
    }

    public Double getRoom_width() {
        return room_width;
    }

    public void setRoom_width(Double room_width) {
        this.room_width = room_width;
    }

    public Double getAreaDoComodo(){
        return room_length*room_width;
    }
}
