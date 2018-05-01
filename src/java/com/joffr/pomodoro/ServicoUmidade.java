
package com.joffr.pomodoro;

import com.google.gson.Gson;
import com.joffr.DAO.UmidadeDAO;
import com.joffr.model.Umidade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author joffr
 */
@Path("/umidade")
public class ServicoUmidade {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicoUmidade
     */
    public ServicoUmidade() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //Umidade u = new Umidade(1, 23.9);
        List<Umidade> lista = new UmidadeDAO().listar();
        if(lista.size() <= 0){
            return Response
                        .status(Response.Status.NO_CONTENT)
                        .build();
        }else{
        //Gson g = new Gson();
        return Response.status(Response.Status.OK).entity(new Gson().toJson(lista)).build();
        }
    }

    /*@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }*/
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletar(){
        boolean sucesso = new UmidadeDAO().excluir();
        if(sucesso){
            return Response
                    .status(Response.Status.OK)
                    .entity(new OutputMessage(200,"Objetos removidos."))
                    //.entity(new OutputMessage(200,"Objeto removido por "+ securityContext.getUserPrincipal().getName()))
                    .build();
        }else{
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new OutputMessage(500,"Erro ao excluir"))
                    .build();
        }
    }
}
