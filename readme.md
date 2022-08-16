## Relational Database Design

### One-to-Many

In a "class roster" database, a teacher may teach zero or more classes, while a class is taught by one (and only one) teacher. In a "company" database, a manager manages zero or more employees, while an employee is managed by one (and only one) manager. In a "product sales" database, a customer may place many orders; while an order is placed by one particular customer. This kind of relationship is known as one-to-many.

Teachers -> Classes

### Many-to-Many

In a "product sales" database, a customer's order may contain one or more products; and a product can appear in many orders. In a "bookstore" database, a book is written by one or more authors; while an author may write zero or more books. This kind of relationship is known as many-to-many.

Orders -> OrderDetails <- Products

### One-to-One

In a "product sales" database, a product may have optional supplementary information such as image, moreDescription and comment. Keeping them inside the Products table results in many empty spaces (in those records without these optional data). Furthermore, these large data may degrade the performance of the database.

Products -> ProductDetails

## Database Design

#### tokens

| id | token | created_date | user |

#### cart

| id | created_date | product | user | quantity |

#### categories

| id | category_name | description | image_url |

#### credit_card

| id | user_id | first_name | last_name | card_number | last_4_digits | expiration_month | expiration_year | cvv | 


#### product 

| id | name | image_url | price | description | category | 

#### wishlist

| id | user | creadted_date | product_id | 

## API design

#### Cart

* "/cart" GET

	getCartItems

* "/cart/add" POST

	addToCart

#### Category

* "/category" GET

	getCategories

* "/category/create" POST

	createCategory

* "/category/update/{categoryID}" POST

	updateCategory

#### Product

* "/product" GET

	getProducts

* "/product/add" POST

	addProduct

* "/product/update/{productID}" POST
	
	updateProduct

#### WishList

* "/wishlist/add" POST

	addWishList

* "/wishlist/{token}" GET

	getWishList


#### User

* "/user" POST

	createUser

Request:

```
{
    "userName": "jakit",
    "password": "12345678",
    "firstName": "Bayrjawkhlan",
    "lastName": "demchigjaw",
    "email": "jawhaabayr255@gmail.com"
}
```




* "/user" GET
	
	getUser

* "/userInfo"

	getUserInfo






































 
















































