import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthenticationComponent } from './authentication/authentication.component';
import { HomeTimelineComponent } from './home-timeline/home-timeline.component';
import { UserTimelineComponent } from './user-timeline/user-timeline.component';
import { FormsModule } from '@angular/forms';
import { TweetComponent } from './tweet/tweet.component';
import { TweeterLeftNavbarComponent } from './tweeter-left-navbar/tweeter-left-navbar.component';
import { TweeterRightNavbarComponent } from './tweeter-right-navbar/tweeter-right-navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthenticationComponent,
    HomeTimelineComponent,
    UserTimelineComponent,
    TweetComponent,
    TweeterLeftNavbarComponent,
    TweeterRightNavbarComponent
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
