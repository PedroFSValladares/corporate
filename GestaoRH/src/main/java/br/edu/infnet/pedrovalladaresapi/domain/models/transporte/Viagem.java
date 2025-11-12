package br.edu.infnet.pedrovalladaresapi.domain.models.transporte;

import br.edu.infnet.pedrovalladaresapi.domain.enuns.TipoViagem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "viagens")
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "viagem_id")
    private int id;
    @ManyToOne()
    @JoinColumn(name = "codigo_linha", nullable = false)
    @NotNull(message = "O transporte deve ser infomado.")
    private Transporte transporte;
    @Column(name = "tipo_viagem", nullable = false)
    @NotNull(message = "O tipo da viagem deve ser informado.")
    private TipoViagem tipoViagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public TipoViagem getTipoViagem() {
        return tipoViagem;
    }

    public void setTipoViagem(TipoViagem tipoViagem) {
        this.tipoViagem = tipoViagem;
    }
}
