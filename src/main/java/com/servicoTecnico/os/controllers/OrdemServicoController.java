package com.servicoTecnico.os.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicoTecnico.os.dtos.OrdemServicoDTO;
import com.servicoTecnico.os.models.OrdemServico;
import com.servicoTecnico.os.services.OrdemServicoService;
@CrossOrigin("*")
@RestController
@RequestMapping("/ordemservico")
public class OrdemServicoController {
	
	@Autowired
	private OrdemServicoService osService;
	
	@PostMapping	
	ResponseEntity<OrdemServicoDTO> criarOS(@Valid @RequestBody OrdemServicoDTO os){
		
		
		
		OrdemServico obj = osService.criarOS(os);
		
		OrdemServicoDTO newObj = new OrdemServicoDTO(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
	}
	
	@GetMapping
	ResponseEntity<List<OrdemServicoDTO>> listarOS(){
		
		List<OrdemServicoDTO> obj = osService.listarOS();
		
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/{id}")
	ResponseEntity<OrdemServicoDTO> listarOSPorId(@PathVariable Long id){
		
		OrdemServico obj = osService.listarOSPorId(id);
		OrdemServicoDTO newObj = new OrdemServicoDTO(obj);
		return ResponseEntity.ok().body(newObj);
		
		
	}
	
	@PutMapping
	//não iremos alterar pelo id e sim alterar o id na propria ordem de serviço:
	ResponseEntity<OrdemServicoDTO> alteraOS(@Valid @RequestBody OrdemServicoDTO os){
		
		OrdemServico obj = osService.alteraOs(os);
		
		OrdemServicoDTO newObj = new OrdemServicoDTO(obj);
		
		return ResponseEntity.ok().body(newObj);
	}
}
