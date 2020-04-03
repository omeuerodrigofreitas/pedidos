package br.com.codepampa.core.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.codepampa.core.model.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

}