package br.org.com.recode.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.org.com.recode.model.Cliente;
import br.com.recode.clientes.repository.ClienteRepository;

public class ClienteController {
	
	@Autowired
    private ClienteRepository clienteRepository;

	
	
// lista todos os dados
	//aqui
   @GetMapping ("/cliente")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");


       
       List<Cliente> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);



       return modelAndView;
    }
    
   //chama a view cadastrar e passa objeto vazio
   
   @GetMapping("/cadastrar")
   public ModelAndView cadastrar() {
       ModelAndView modelAndView = new ModelAndView("cliente/cadastro");



      modelAndView.addObject("cliente", new Cliente());



      return modelAndView;
   }
   
   
   
   @PostMapping("/cadastrar")
   public ModelAndView cadastrar(Cliente cliente, @RequestParam("fileCliente") MultipartFile file) throws IOException {
       

      try {
           cliente.setImagem(file.getBytes());
       } catch (IOException e) {
           e.printStackTrace();
       }    
       
       
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");
   
       clienteRepository.save(cliente);



      return modelAndView;
   }
   
   // mostra imagem
   @GetMapping("/imagem/{id}")
   @ResponseBody
   public byte[] exibirImagen(@PathVariable("id") Long id) {
       Cliente cliente = this.clienteRepository.getOne(id);
       return cliente.getImagem();
   }
   
   @GetMapping("/{id}")
   public ModelAndView detalhar(@PathVariable Long id) {
       ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");



      Cliente cliente = clienteRepository.getOne(id);
       modelAndView.addObject("cliente", cliente);



      return modelAndView;
   }
   
   @GetMapping("/{id}/excluir")
   public ModelAndView excluir(@PathVariable Long id) {
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");



      clienteRepository.deleteById(id);



      return modelAndView;
   }
   
   @GetMapping("/{id}/editar")
   public ModelAndView editar(@PathVariable Long id) {
       ModelAndView modelAndView = new ModelAndView("cliente/edicao");



      Cliente cliente = clienteRepository.getOne(id);
       modelAndView.addObject("cliente", cliente);



      return modelAndView;
   }
   
   @PostMapping("/{id}/editar")
   public ModelAndView editar(Cliente cliente) {
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");



      clienteRepository.save(cliente);



      return modelAndView;
   }

}
