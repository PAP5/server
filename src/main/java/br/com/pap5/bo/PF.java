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
    @NamedQuery(name = "PF.consultarTodos",
            query = "select p from PF p"),
    @NamedQuery(name = "PF.consultarPorUsuario",
            query = "select p from PF p where p.usuario.id = :id")
})
@SequenceGenerator(name = "pf_seq", sequenceName = "pf_seq", allocationSize = 1, initialValue = 1)
@Table(name = "pf")
public class PF implements Serializable {

    private static final long serialVersionUID = 1927945430038634337L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pf_seq")
    private Long id;
    @Column(length = 40, nullable = false)
    private String nome;
    private Character sexo;
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date datanasc;
    @Column(length = 12, nullable = false)
    private String telcontat;
    @Column(length = 12)
    private String telcel;
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date datainscricao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDatanasc() {
        return datanasc;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
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