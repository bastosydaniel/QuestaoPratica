package br.com.senac.questaopratica1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Main implements ApplicationListener<ContextRefreshedEvent> {

    private final EmpresaRepository empresaRepository;
    private final DevedorRepository devedorRepository;
    private final DividaRepository dividaRepository;

    public Main(EmpresaRepository empresaRepository, DevedorRepository devedorRepository, DividaRepository dividaRepository) {
        this.empresaRepository = empresaRepository;
        this.devedorRepository = devedorRepository;
        this.dividaRepository = dividaRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //criação de uma empresa
        Empresa empresa = new Empresa();
        empresa.setNome("Empresa A");
        empresaRepository.save(empresa);

        //criação de um devedor
        Devedor devedor = new Devedor();
        devedor.setNome("Devedor A");
        devedorRepository.save(devedor);

        //criação de uma dívida
        Divida divida = new Divida();
        divida.setValordivida(new BigDecimal("1000.00"));
        divida.setDevedor(devedor);
        divida.getEmpresas().add(empresa);
        dividaRepository.save(divida);

        //verificação das persistências
        System.out.println("Empresas: " + empresaRepository.findAll());
        System.out.println("Devedores: " + devedorRepository.findAll());
        System.out.println("Dívidas: " + dividaRepository.findAll());
    }
}
