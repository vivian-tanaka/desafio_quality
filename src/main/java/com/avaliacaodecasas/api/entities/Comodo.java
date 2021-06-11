package com.avaliacaodecasas.api.entities;

import javax.validation.constraints.*;

public class Comodo {

    @NotEmpty(message = "O nome do cômodo não pode estar vazio.")
    @Size(max = 30, message = "O comprimento do nome do cômodo não pode exceder 30 caracteres.")
    @Pattern(regexp = "^([A-Z]+)([a-z]|[A-Z]|[0-9]|\\s)+", message = "Nome do comodo deve ser iniciada por maiuscula")
    private String room_name;

    @NotNull(message = "O comprimento do cômodo não pode estar vazio.")
    @Max(value = 33, message = "O comprimento do cômodo não pode exceder 33 metros.")
    private Double room_length;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @Max(value = 25, message = "A largura do cômodo não pode exceder 25 metros.")
    private Double room_width;

    public Comodo(){}

    public Comodo(String room_name, Double room_length, Double room_width) {
        this.room_name = room_name;
        this.room_length = room_length;
        this.room_width = room_width;
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
