package br.com.codepampa.core.model;



import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

import br.com.codepampa.core.enums.Status;

@Entity(name = "Category")
@Table(name = "category")
public class Category {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
	private String name;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @JsonIgnore
    @Transient
    private int hashCode;


    public Category() {
    }
    
    public Category(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if (obj instanceof Category) {
            Category other = (Category) obj;
           return Objects.equals(this.name, other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if(result == 0) {
            result = Objects.hash(this.name);
        }
        this.hashCode = result;
        return result; 
    }

    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("nome", name)
                .add("status", status)
                .toString();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
    }    
    
	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}