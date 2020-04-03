package br.com.codepampa.core.resource;


import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.codepampa.core.model.Product;
import br.com.codepampa.core.repository.ProductRepository;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    
    @Inject
    private ProductRepository productRepository;

    @POST
    @Transactional
    public Response create(@RequestBody final Product product) {
        productRepository.persist(product);
        return Response.ok(product).build();
    }

    @GET
    @Transactional
    public Response listAll() {
        return Response.ok(productRepository.listAll()).build();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Response findById(@PathParam("id") final Long id) {
        final Optional<Product> product = productRepository.findByIdOptional(id);
        return product.map(Response::ok).orElseGet(() -> Response.noContent()).build();
    }

    
}