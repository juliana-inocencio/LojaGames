package com.generation.lojadegames.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // para dizer que é uma tabela 
@Table(name = "tb_produto") //nome da tabela 
public class Produto {

	@Id // indica que será a chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*-- @GeneratedValue indica que a Chave Primária será gerada pelo Banco de dados
	  -- strategy indica de que forma esta Chave Primária será gerada
	  -- GenerationType.IDENTITY indica que a Chave Primária será gerada pelo Banco de dados através da
		 opção auto-incremento
	 */
	private Long id; 
	
	@NotBlank(message = "O nome é obrigatório!")
	@Size(min = 5, max = 255, message = "O nome deve ter no mínimo 5 e no máximo 255 caracteres")
	private String nome;
	
	@NotNull(message = "O preço é obrigatório!")
	@DecimalMin(value = "0.01", message = "O preço do produto deve ser um número positivo e  a partir de R$ 0.01!")
	private BigDecimal preco;
	
	@NotBlank(message = "A descrição é obrigatória")
	@Size(min = 10, max = 1000, message = "A descrição deve ter mínimo 10 e no máximo 1000 caracteres")
	private String descricao;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
