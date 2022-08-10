package com.example.dto;

import java.time.LocalDateTime;

public class CarTypeDTO {

    private int id;
    private String name;
    private String code;
    private String description;
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReg_date() {
        return reg_date;
    }

    public void setReg_date(LocalDateTime reg_date) {
        this.reg_date = reg_date;
    }

    public LocalDateTime getMod_date() {
        return mod_date;
    }

    public void setMod_date(LocalDateTime mod_date) {
        this.mod_date = mod_date;
    }
}
