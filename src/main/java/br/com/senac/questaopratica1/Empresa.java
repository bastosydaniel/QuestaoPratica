package br.com.senac.questaopratica1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idempresa;

    private String nome;

    @ManyToMany(mappedBy = "empresas")
    private List<Divida> dividas = new ArrayList<>();


    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }
}
