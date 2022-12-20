export interface CreateProductRequest {
    name: string
    price: number
    description: string
    productCategoryId: string
    storeId: string
    image: File
}