import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // Add this import
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
import { HttpClientModule } from '@angular/common/http';
import { PostTweetComponent } from './post-tweet/post-tweet.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog'; // Add this import
import { MatFormFieldModule } from '@angular/material/form-field'; // Add this import
import { MatInputModule } from '@angular/material/input';
import { AddCommentDialogComponent } from './add-comment-dialog/add-comment-dialog.component'; // Add this import
import { ReactiveFormsModule } from '@angular/forms';

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
    UserProfileComponent,
    PostTweetComponent,
    AddCommentDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatDialogModule, // Add this import
    MatFormFieldModule, // Add this import
    MatInputModule, // Add this import
    BrowserAnimationsModule, // Add this import
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }