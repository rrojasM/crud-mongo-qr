package com.rrojas.mongocrud.model;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "QR")
public class GenerarQr {

	@Id
	@Field("_id")
	private String id;
	private String cliente;
	private Integer numeroCuenta;
	private double total;
	private ArrayList<Product> listProduct = new ArrayList<>();

	public GenerarQr() {
	}

	public GenerarQr(String id, String cliente, Integer numeroCuenta, double total, ArrayList<Product> listProduct) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.numeroCuenta = numeroCuenta;
		this.total = total;
		this.listProduct = listProduct;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getTotal() {
		for (int i = 0; i < listProduct.size(); i++) {
			total += listProduct.get(i).getPrecio();
		}
		System.out.println("TOTAL: " + total);
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(ArrayList<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public ArrayList<String> productsList() {

		ArrayList<String> newList = new ArrayList<>();

		for (int i = 0; i < listProduct.size(); i++) {
			newList.add(listProduct.get(i).getTitle() + "\n"+ listProduct.get(i).getPrecio());
		}

		return newList;

	}

}
