package br.com.senac.questaopratica1;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valordivida;

    @ManyToMany
    @JoinTable(name = "divida_empresa",
            joinColumns = @JoinColumn(name = "divida_id"),
            inverseJoinColumns = @JoinColumn(name = "empresa_id"))
    private List<Empresa> empresas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idedevedor")
    private Devedor devedor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValordivida() {
        return valordivida;
    }

    public void setValordivida(BigDecimal valordivida) {
        this.valordivida = valordivida;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Devedor getDevedor() {
        return devedor;
    }

    public void setDevedor(Devedor devedor) {
        this.devedor = devedor;
    }
}

