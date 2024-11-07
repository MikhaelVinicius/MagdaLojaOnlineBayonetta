package main.java.com.example.magda.Entity;



import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo; //"Cartão de Crédito", "Boleto", "Pix", etc.

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataPagamento;

    @Column(nullable = false)
    private String status; // "Pago", "Pendente", "Cancelado", etc.

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    public Pagamento() {}

    public Pagamento(String tipo, BigDecimal valor, LocalDateTime dataPagamento, String status, Pedido pedido) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
