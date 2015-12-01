
package br.unibh.servicospessoas.servicos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unibh.servicospessoas.entidades.PessoaFisica;
import br.unibh.servicospessoas.persistencia.PessoaFisicaDAO;

// The Java class will be hosted at the URI path "/pessoafisica"
@Path("/pessoafisica")
public class ServicoPessoaFisicaRestJson {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public List<PessoaFisica> listar(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		return dao.findAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public PessoaFisica find(@PathParam("id") int id) {

		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		return dao.find(new Long (id));
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @Path("/salvar")
    public PessoaFisica salvar(PessoaFisica p) {
 
        PessoaFisicaDAO dao = new PessoaFisicaDAO();
        dao.insert(p);
        return dao.findCpf(p.getCpf());
    }
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atualizar/{id}")  
    public PessoaFisica atualizaPF(@PathParam("id")long id, PessoaFisica p){
    	PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	dao.update(p);
    	return dao.find(id);
    }
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/{id}")
    public void excluirPessoaFisica(@PathParam("id")long id){
    	PessoaFisicaDAO dao = new PessoaFisicaDAO();
    	PessoaFisica pf = new PessoaFisica();
    	pf=dao.find(id);
    	dao.delete(pf);
    }
}