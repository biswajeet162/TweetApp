import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  standalone: false,
  
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.css'
})
export class UserProfileComponent implements OnInit {

  userName: string | undefined;
  userHandle: string | undefined;

  constructor() { }

  ngOnInit(): void {
    this.userName = localStorage.getItem('username') ?? "";
    this.userHandle = localStorage.getItem('handle') ?? "";

    console.log("=======================================");
    console.log(this.userName, this.userHandle);
  }

}
