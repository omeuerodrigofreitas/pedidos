package br.com.codepampa.core.enums;


public enum Status {
    ATIVO("Ativos"), INATIVO("Inativo");

    private String nameLabel;

    private Status(String nameLabel) {
        this.nameLabel = nameLabel;
    }

    public String getNameLabel(){
        return nameLabel;
    }
   
}