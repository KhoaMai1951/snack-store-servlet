package entities;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> items = new ArrayList<Product>();
	private int sumPrice = 0;

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public ArrayList<Product> getItems() {
		return items;
	}

	public void setItems(ArrayList<Product> items) {
		this.items = items;
	}
	
	public void addToCart(Product product)
	{	
		if(!checkIfItemAlreadyInCart(product))
		{
			this.items.add(product);
		}
		else if(checkIfItemAlreadyInCart(product))
		{
			addExistingItemInCart(product);
		}
	}
	
	public void addExistingItemInCart(Product product)
	{
		for(int i=0; i < this.items.size(); i++)
		{
			if(product.getId() == this.items.get(i).getId())
			{				
				int newOrderQuantity = this.items.get(i).getOrderQuantity() + product.getOrderQuantity();
				this.items.get(i).setOrderQuantity(newOrderQuantity);
				break;
			}
		}
	}
	
	public boolean checkIfItemAlreadyInCart(Product product)
	{
		boolean flag = false;
		if(this.items.size() > 0)
		{
			for(int i=0; i < this.items.size(); i++)
			{
				if(product.getId() == this.items.get(i).getId())
				{
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
	public void sumPrice() 
	{
		for(int i=0; i < this.items.size(); i++)
		{
			this.sumPrice += this.items.get(i).orderQuantity * this.items.get(i).getPrice();
		}
	}
}
