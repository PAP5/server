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
    @NamedQuery(name = "Instituicao.consultarTodos",
            query="select i from Instituicao i")
})
@SequenceGenerator(name = "instituicao_seq", sequenceName = "instituicao_seq", allocationSize = 1, initialValue = 1)
@Table(name = "instituicao")
public class Instituicao implements Serializable {

    private static final long serialVersionUID = -6753701196564034495L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "instituicao_seq")
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
    private String telcontat1;
    @Column(length = 12)
    private String telcontat2;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datainscricao;
    @Column(length = 500)
    private String descricao;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datavalidacao;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datavalidade;
    @Column(length = 40)
    private String contabancaria;
    
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

    public String getTelcontat1() {
        return telcontat1;
    }

    public String getTelcontat2() {
        return telcontat2;
    }

    public Date getDatainscricao() {
        return datainscricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDatavalidacao() {
        return datavalidacao;
    }

    public Date getDatavalidade() {
        return datavalidade;
    }

    public String getContabancaria() {
        return contabancaria;
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

    public void setTelcontat1(String telcontat1) {
        this.telcontat1 = telcontat1;
    }

    public void setTelcontat2(String telcontat2) {
        this.telcontat2 = telcontat2;
    }

    public void setDatainscricao(Date datainscricao) {
        this.datainscricao = datainscricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDatavalidacao(Date datavalidacao) {
        this.datavalidacao = datavalidacao;
    }

    public void setDatavalidade(Date datavalidade) {
        this.datavalidade = datavalidade;
    }

    public void setContabancaria(String contabancaria) {
        this.contabancaria = contabancaria;
    }    
}
