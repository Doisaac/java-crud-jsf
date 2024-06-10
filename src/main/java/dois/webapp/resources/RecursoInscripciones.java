package dois.webapp.resources;

import dois.webapp.entidades.Inscripciones;
import dois.webapp.negocio.DataService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/inscripciones")
public class RecursoInscripciones {

    @EJB
    DataService servicio;
    
    @GET
    public Response getInscripciones() {
        List<Inscripciones> inscripciones = servicio.getInscripciones();
        return Response.ok(inscripciones).build();
    }
    
    @POST
    public Response saveInscripciones(Inscripciones inscripciones) {
        servicio.saveInscripcion(inscripciones);
        return Response.ok("Inscripcion creada exitosamente").build();
    }
}
