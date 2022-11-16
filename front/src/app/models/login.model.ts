export interface LoginResponse {
    access_token: string
    refresh_token: string
}

export interface LoginRequest {
    username: string
    password: string
  }
  const login: Partial<LoginRequest> = {};