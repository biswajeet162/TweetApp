export interface SignUpRequest {
    name: string;
    handle: string;
    password: string;
}

export interface SignUpResponse {
    valid: boolean;
    handle: string;
    userName: string;
    userId: number;
    token: string;
    expiryDate: string;
} 