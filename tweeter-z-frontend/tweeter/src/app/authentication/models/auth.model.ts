export interface LoginRequest {
  handle: string;
  password: string;
}

export interface LoginResponse {
  handle: string;
  userName: string;
  userId: number;
  token: string;
} 