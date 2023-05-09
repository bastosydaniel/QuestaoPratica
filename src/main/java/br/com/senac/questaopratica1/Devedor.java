package br.com.senac.questaopratica1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Devedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "devedor")
    private List<Divida> dividas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
