package br.com.pap5.bo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "Doacao.consultarTodos",
            query = "select d from Doacao d")
})
@SequenceGenerator(name = "doacao_seq", sequenceName = "doacao_seq", initialValue = 1, allocationSize = 1)
@Table(name = "doacao")
public class Doacao implements Serializable{
    
    private static final long serialVersionUID = 1241818602614900855L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "doacao_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idpf", referencedColumnName = "id")
    private PF pf;
    @ManyToOne
    @JoinColumn(name = "idpj", referencedColumnName = "id")
    private PJ pj;
    @Column(nullable = false)
    private Double valordoado;
    @ManyToOne
    @JoinColumn(name = "idinstituicao", referencedColumnName = "id")
    private Instituicao instituicao;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;

    public Long getId() {
        return id;
    }

    public PF getPf() {
        return pf;
    }

    public PJ getPj() {
        return pj;
    }

    public Double getValordoado() {
        return valordoado;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public Date getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPf(PF pf) {
        this.pf = pf;
    }

    public void setPj(PJ pj) {
        this.pj = pj;
    }

    public void setValordoado(Double valordoado) {
        this.valordoado = valordoado;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
