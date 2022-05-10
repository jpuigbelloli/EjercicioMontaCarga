package ar.edu.unlam.pb2.montacarga;

import java.util.ArrayList;

public class MontaCarga {
	private Double cargaMaxima;
	private ArrayList<Carga> listaDeCargas = new ArrayList<Carga>();
	private Double pesoTotalDescargado = 0.0;
	private Integer cantidadDeVecesQueDescargo= 0;
	
	MontaCarga(Double maximo){
		this.cargaMaxima = maximo;
	}
	public Double obtenerCarga() {
		Double cargaActual = 0.0;
		for(Carga cargaAux : listaDeCargas) {
			cargaActual += cargaAux.getValor();
		}
		return cargaActual;
	}
	public Boolean cargar(Carga carga) {
		Double comparar = obtenerCarga() + carga.getValor();
		if(comparar <= cargaMaxima) {
			listaDeCargas.add(carga);
			return true;
		}
		return false;
	}
	public Double descargar() {
		for(Carga cargaAux : listaDeCargas) {
			this.pesoTotalDescargado += cargaAux.getValor();
		}
		this.cantidadDeVecesQueDescargo ++;
		listaDeCargas.clear();
		return pesoTotalDescargado;
	}
	public Double obtenerCargaPromedio() {
		return pesoTotalDescargado / cantidadDeVecesQueDescargo;
	}
}
