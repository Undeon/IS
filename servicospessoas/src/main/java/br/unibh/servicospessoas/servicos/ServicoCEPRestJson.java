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

import br.unibh.servicospessoas.entidades.CEP;
import br.unibh.servicospessoas.persistencia.CEPDAO;

// The Java class will be hosted at the URI path "/cep"
@Path("/cep")
public class ServicoCEPRestJson {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public List<CEP> listar(){
		CEPDAO dao = new CEPDAO();
		return dao.findAll();
	}

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar/{endereco}")
    public List<CEP> buscarCepPorEndereco(@PathParam(value="endereco")String endereco){
    	CEPDAO dao = new CEPDAO();
    	return dao.findCep(endereco);
    }

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{cep}")
	public CEP find(@PathParam("cep") int cep) {

		CEPDAO dao = new CEPDAO();
		return dao.find(new Long (cep));
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/salvar")
	public CEP salvar(CEP p) {

		CEPDAO dao = new CEPDAO();
		dao.insert(p);
		return dao.find(p.getCep());
	}

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atualizar/{cep}")  
    public CEP atualizaCep(@PathParam("cep")long cep, CEP c){
    	CEPDAO dao = new CEPDAO();
    	dao.update(c);
    	return dao.find(cep);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/{cep}")
    public String excluirCep(@PathParam("cep")long cep){
    	CEPDAO dao = new CEPDAO();
    	CEP pJ = new CEP();
    	pJ=dao.find(cep);

    	dao.delete(pJ);
    	
    	return "CEP excluido";
    }

}
