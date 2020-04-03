package br.com.codepampa.core.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.codepampa.core.model.Category;
import br.com.codepampa.core.repository.CategoryRepository;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    private CategoryRepository categoryRepository;
    

    @POST
    @Transactional
    public Response createCategoria(@RequestBody Category category) {
        categoryRepository.persist(category);
        return Response.ok(category).build();
    }

}