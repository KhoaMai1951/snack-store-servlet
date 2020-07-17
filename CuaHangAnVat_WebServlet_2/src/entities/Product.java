package entities;

public class Product
{
	int id;
	String name;
	String imgName;
	int quantity; // how much's left in inventory
	int orderQuantity;
	int price;
	boolean isDeleted;
	int categoryID;
	String categoryNameFromForeignKey;

	public Product(int id, String name, String imgName, int quantity, int price, int categoryID,
			String categoryNameFromForeignKey, String description)
	{
		super();
		this.categoryID = categoryID;
		this.id = id;
		this.name = name;
		this.imgName = imgName;
		this.quantity = quantity;
		this.price = price;
		this.categoryNameFromForeignKey = categoryNameFromForeignKey;
		this.description = description;
	}

	public Product(int id, String name, String imgName, int quantity, int price, int categoryID, String description)
	{
		super();
		this.id = id;
		this.name = name;
		this.imgName = imgName;
		this.quantity = quantity;
		this.price = price;
		this.categoryID = categoryID;
		this.description = description;
	}

	public Product(int id, String name, String imgName, int quantity, int orderQuantity, int price, int categoryID,
			String description)
	{
		super();
		this.id = id;
		this.name = name;
		this.imgName = imgName;
		this.quantity = quantity;
		this.orderQuantity = orderQuantity;
		this.price = price;
		this.categoryID = categoryID;
		this.description = description;
	}

	public int getOrderQuantity()
	{
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity)
	{
		this.orderQuantity = orderQuantity;
	}

	public String getCategoryNameFromForeignKey()
	{
		return categoryNameFromForeignKey;
	}

	public void setCategoryNameFromForeignKey(String categoryNameFromForeignKey)
	{
		this.categoryNameFromForeignKey = categoryNameFromForeignKey;
	}

	String description;

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getImgName()
	{
		return imgName;
	}

	public void setImgName(String imgName)
	{
		this.imgName = imgName;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public boolean isDeleted()
	{
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted)
	{
		this.isDeleted = isDeleted;
	}

	public int getCategoryID()
	{
		return categoryID;
	}

	public void setCategoryID(int categoryID)
	{
		this.categoryID = categoryID;
	}

	public Product()
	{

	}
}
