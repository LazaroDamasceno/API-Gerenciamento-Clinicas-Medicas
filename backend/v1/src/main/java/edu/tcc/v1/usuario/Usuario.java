package edu.tcc.v1.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "V1_USUARIO")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    @Size(min = 11, max = 12, message = "O CPF tem 11 dígitos.")
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Size(min = 11, max = 12, message = "O telefone tem 11 dígitos.")
    private String telefone;

    @Column(nullable = false)
    private String genero;

    private Usuario(CadastrarUsuarioDTO dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.dataNascimento = dto.dataNascimento();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.genero = dto.genero();
    }

    public Usuario instanciar(CadastrarUsuarioDTO dto) {
        return new Usuario(dto);
    }

}
