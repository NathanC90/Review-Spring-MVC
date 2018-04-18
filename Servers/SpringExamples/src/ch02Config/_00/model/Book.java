// 設計程式Book.java，此類別實作IProduct介面。
package ch02Config._00.model;
import ch02Config._00.IProduct;

public class Book implements IProduct {
	private String title;
	Integer price;
	Integer stock;
	
	public Book() { 
	}

	public Book(String title, Integer price, Integer stock) {
		System.out.println("正在執行Bean元件的帶參的建構子");
		this.title = title;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public Integer getPrice() {
		return price;
	}
	@Override
	public Integer getStock() {
		return stock;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String getDescriptin() {
		return "Book [title=" + title + ", price=" + price + ", stock=" + stock + "]";
	}
	public void init() {
		System.out.println("在Book類別的init()方法");
	}
	public void destroy() {
		System.out.println("在Book類別的destroy()方法");
	}
}