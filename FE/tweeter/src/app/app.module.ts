import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeTimelineComponent } from './home-timeline/home-timeline.component';
import { UserTimelineComponent } from './user-timeline/user-timeline.component';
import { FormsModule } from '@angular/forms';
import { TweetComponent } from './tweet/tweet.component';
import { TweeterLeftNavbarComponent } from './tweeter-left-navbar/tweeter-left-navbar.component';
import { TweeterRightNavbarComponent } from './tweeter-right-navbar/tweeter-right-navbar.component';
import { LoginComponent } from './authentication/login/login.component';
import { SignupComponent } from './authentication/signup/signup.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeTimelineComponent,
    UserTimelineComponent,
    TweetComponent,
    TweeterLeftNavbarComponent,
    TweeterRightNavbarComponent,
    LoginComponent,
    SignupComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
