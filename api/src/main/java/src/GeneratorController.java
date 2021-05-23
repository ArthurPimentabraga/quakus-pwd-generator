package src;

import com.google.gson.Gson;
import dto.PwdInfosDTO;
import dto.ResponseDTO;
import lombok.extern.java.Log;
import src.service.GeneratorService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pwd")
@Log
public class GeneratorController {

    @Inject
    GeneratorService service;

    @GET
    @Path("generator")
    @Produces(MediaType.TEXT_PLAIN)
    public Response generator() {
        try {
            Gson gson = new Gson();
            String pwd = service.generator(new PwdInfosDTO(5, true, true, true, true));

            ResponseDTO responseDTO = ResponseDTO.builder().description("Funfou").pwd(pwd).build();
            return Response.status(200).entity(gson.toJson(responseDTO)).build();
        } catch (Exception ex) {
            return Response.status(500).entity(ex.getMessage()).build();
        }
    }
}