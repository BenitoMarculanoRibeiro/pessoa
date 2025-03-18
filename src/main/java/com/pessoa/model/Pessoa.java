package com.pessoa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String pNome;

	@Column(name = "data_nascimento")
	private LocalDate pData;

	private String pCPF;

	private char pSexo;

	private double pAltura;

	private double pPeso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getpNome() {
		return pNome;
	}

	public void setpNome(String pNome) {
		this.pNome = pNome;
	}

	public LocalDate getpData() {
		return pData;
	}

	public void setpData(LocalDate pData) {
		this.pData = pData;
	}

	public String getpCPF() {
		return pCPF;
	}

	public void setpCPF(String pCPF) {
		this.pCPF = pCPF;
	}

	public char getpSexo() {
		return pSexo;
	}

	public void setpSexo(char pSexo) {
		this.pSexo = pSexo;
	}

	public double getpAltura() {
		return pAltura;
	}

	public void setpAltura(double pAltura) {
		this.pAltura = pAltura;
	}

	public double getpPeso() {
		return pPeso;
	}

	public void setpPeso(double pPeso) {
		this.pPeso = pPeso;
	}

	public double calcularPesoIdeal() {
		if (pSexo == 'M') {
			return (72.7 * pAltura) - 58;
		} else {
			return (62.1 * pAltura) - 44.7;
		}
	}
}
