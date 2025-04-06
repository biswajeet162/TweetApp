import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { SignUpRequest, SignUpResponse } from './models';
@Component({
  selector: 'app-signup',
  standalone: false,
  
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  signupForm: FormGroup;
  isLoading = false;
  errorMessage = '';
  handleAvailable = true;

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.signupForm = this.fb.group({
      name: ['', [Validators.required, Validators.maxLength(50)]],
      handle: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9_]{4,15}$')]],
      password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(20)]]
    });

    // Check handle availability as user types
    this.signupForm.get('handle')?.valueChanges.subscribe(handle => {
      if (handle && handle.length >= 4) {
        this.checkHandleAvailability(handle);
      }
    });
  }

  checkHandleAvailability(handle: string) {
    // Add your handle availability check endpoint here
    // this.http.get(`http://localhost:8081/api/auth/check-handle/${handle}`)...
  }

  onSubmit() {
    if (this.signupForm.valid) {
      this.isLoading = true;
      this.errorMessage = '';

      const signUpRequest: SignUpRequest = this.signupForm.value;

      this.http.post<SignUpResponse>('http://localhost:8081/auth/signup', signUpRequest)
        .subscribe({
          next: (response) => {
            localStorage.setItem('token', response.token);
            localStorage.setItem('userId', response.userId.toString());
            localStorage.setItem('username', response.userName);
            localStorage.setItem('handle', response.handle);
            // Navigate to home page or dashboard
            this.router.navigate(['/home-timeline']);
          },
          error: (error) => {
            this.errorMessage = error.error.message || 'An error occurred during signup';
            this.isLoading = false;
          },
          complete: () => {
            this.isLoading = false;
          }
        });
    }
  }
}
