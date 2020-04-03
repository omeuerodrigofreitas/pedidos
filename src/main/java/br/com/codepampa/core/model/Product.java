package br.com.codepampa.core.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

import br.com.codepampa.core.enums.Status;

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
	private String name;
    private String description;
    private BigDecimal price;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ATIVO;

    @JsonIgnore
    @Transient
    private int hashCode;

    public Product(){}   
  
	public Product(String name, String description, BigDecimal price, Category category, Status status) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.status = status;
    }  
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if (obj instanceof Product) {
            Product other = (Product) obj;
           return Objects.equals(this.name, other.name) &&
           Objects.equals(this.description, other.description) &&
           Objects.equals(this.price, other.price);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if(result == 0) {
            result = Objects.hash(this.name, this.description, this.price);
        }
        this.hashCode = result;
        return result; 
    }
    
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("nome", name)
                .add("descricao", description)
                .add("valor", price)
                .add("categoria", category.toString())
                .add("status", status)
                .toString();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}