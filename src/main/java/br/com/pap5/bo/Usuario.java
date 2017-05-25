package br.com.pap5.bo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name = "Usuario.consultarTodos",
            query = "select u from Usuario u"),
    @NamedQuery(name = "Usuario.consultarPorUsuario", 
            query = "select u from Usuario u where u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.consultarPF",
            query = "select p from PF p where p.usuario.id = :id"),
    @NamedQuery(name = "Usuario.consultarPJ",
            query = "select p from PJ p where p.usuario.id = :id")
})
@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1, initialValue = 1)
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -2303132715363711887L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_seq")
    private Long id;
    @Column(length = 60, nullable = false, unique = true)
    private String usuario;
    @Column(length = 40, nullable = false)
    private String senha;
    @Column(length = 60, nullable = false, unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
