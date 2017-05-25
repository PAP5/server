package br.com.pap5.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Doacao.consultarTodos",
            query = "select d from Doacao d"),
    @NamedQuery(name = "Doacao.consultarPorUsuario",
            query = "select d from Doacao d where d.usuario.id = :id")
})
@SequenceGenerator(name = "doacao_seq", sequenceName = "doacao_seq", initialValue = 1, allocationSize = 1)
@Table(name = "doacao")
public class Doacao implements Serializable{
    
    private static final long serialVersionUID = 1241818602614900855L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "doacao_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;
    @Column(nullable = false)
    private Double valordoado;
    @ManyToOne
    @JoinColumn(name = "idinstituicao", referencedColumnName = "id")
    private Instituicao instituicao;

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Double getValordoado() {
        return valordoado;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setValordoado(Double valordoado) {
        this.valordoado = valordoado;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

}
