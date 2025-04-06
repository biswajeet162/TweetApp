import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tweeter-left-navbar',
  standalone: false,
  
  templateUrl: './tweeter-left-navbar.component.html',
  styleUrl: './tweeter-left-navbar.component.css'
})
export class TweeterLeftNavbarComponent implements OnInit {

  userName: string | undefined;
  userHandle: string | undefined;

  constructor() { }

  ngOnInit(): void {
    this.userName = localStorage.getItem('username') ?? "";
    this.userHandle = localStorage.getItem('handle') ?? "";

    console.log("=======================================");
    console.log(this.userName, this.userHandle);
  }

  logout() {
    localStorage.clear();
    window.location.href = '/login';
  }

}
