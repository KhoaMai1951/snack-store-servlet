package entities;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> items = new ArrayList<Product>();
	private int sumPrice = 0;
	private int orderQuantity = 0;

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

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
	
	public void addToCart(Product product, int orderQuantity)
	{	
		//item is not in cart
		if(!checkIfItemAlreadyInCart(product))
		{
			product.setOrderQuantity(orderQuantity);
			this.items.add(product);
			this.sumPrice += product.getPrice() * orderQuantity;
		}
		//item is already in cart
		else if(checkIfItemAlreadyInCart(product))
		{
			int newOrderQuantity = product.getOrderQuantity() + orderQuantity;
			product.setOrderQuantity(newOrderQuantity);
			addExistingItemInCart(product);		
			this.sumPrice += product.getPrice() * orderQuantity;
		}
	}
	
	//Add existing item in cart
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
	
	//Check if an item is already in cart
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
	
	//Delete an item in cart
	public void deleteItem(int product_id)
	{
		//delete that item
		for(int i = 0; i < this.items.size(); i++)
		{
			if(product_id == this.items.get(i).getId())
			{
				this.items.remove(i);
				break;
			}
		}
		//Recalculate the sum of cart after delete an item
		recalculateSumAterDeleteAnItem();
	}
	
	//Recalculate the sum of cart after delete an item
	public void recalculateSumAterDeleteAnItem()
	{
		this.sumPrice = 0;
		for(int i = 0; i < this.items.size(); i++)
		{
			this.sumPrice += this.items.get(i).getPrice() * this.items.get(i).getOrderQuantity();
		}
	}
}
