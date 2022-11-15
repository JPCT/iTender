export class MenuModel {
    id?: String;
    name?: String;
    description?: String;
    logoUrl?: String;
    categoryList?: Array<CategoryModel>
  
   }

class CategoryModel {
    id?: String
    categoryName?: String
    productList?: Array<ProductModel>
}

class ProductModel {
    id?: String
    name?: String
    price?: Number
    description?: String
    imageUrl?: String
}