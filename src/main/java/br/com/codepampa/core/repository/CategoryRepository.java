package br.com.codepampa.core.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.codepampa.core.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Category> {

}