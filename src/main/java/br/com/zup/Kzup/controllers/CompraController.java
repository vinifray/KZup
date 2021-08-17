package br.com.zup.Kzup.controllers;

import br.com.zup.Kzup.models.Compra;
import br.com.zup.Kzup.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public void registrarCompra(@RequestBody Compra compra){
        compraService.registrarCompra(compra);
    }
}
