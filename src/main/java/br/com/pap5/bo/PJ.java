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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name = "PJ.consultarTodos",
            query="select p from PJ p")
})
@SequenceGenerator(name = "pj_seq", sequenceName = "pj_seq", allocationSize = 1, initialValue = 1)
@Table(name = "pj")
public class PJ implements Serializable {

    private static final long serialVersionUID = 8721785143270058580L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pj_seq")
    private Long id;
    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;
    @Column(length = 60, nullable = false)
    private String razao;
    @Column(length = 12, nullable = false, unique = true)
    private String inscricao;
    @Column(length = 40, nullable = false)
    private String responsavel;
    @Column(nullable = false)
    private Character infotribut;
    @Column(length = 12, nullable = false)
    private String telcontat;
    @Column(length = 12)
    private String telcel;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datainscricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public String getInscricao() {
        return inscricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public Character getInfotribut() {
        return infotribut;
    }

    public String getTelcontat() {
        return telcontat;
    }

    public String getTelcel() {
        return telcel;
    }

    public Date getDatainscricao() {
        return datainscricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setInfotribut(Character infotribut) {
        this.infotribut = infotribut;
    }

    public void setTelcontat(String telcontat) {
        this.telcontat = telcontat;
    }

    public void setTelcel(String telcel) {
        this.telcel = telcel;
    }

    public void setDatainscricao(Date datainscricao) {
        this.datainscricao = datainscricao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
