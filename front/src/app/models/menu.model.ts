export interface Root {
    id: string
    name: string
    description: string
    logoUrl: string
    categoryList: CategoryList[]
  }
  
  export interface CategoryList {
    id: string
    categoryName: string
    productList: ProductList[]
  }
  
  export interface ProductList {
    id: string
    name: string
    price: number
    description: string
    imageUrl: string
  }