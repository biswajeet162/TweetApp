import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeTimelineComponent } from './home-timeline/home-timeline.component';
import { UserTimelineComponent } from './user-timeline/user-timeline.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { PostTweetComponent } from './post-tweet/post-tweet.component';
import { LoginComponent } from './authentication/login/login.component';
import { SignupComponent } from './authentication/signup/signup.component';
import { AuthGuard } from './auth.guard'; // Import the AuthGuard

const routes: Routes = [
  { path: '', redirectTo: 'home-timeline', pathMatch: 'full' }, // Default route
  { path: 'profile', component: UserProfileComponent, canActivate: [AuthGuard] }, // Protected route
  { path: 'post', component: PostTweetComponent, canActivate: [AuthGuard] }, // Protected route
  { path: 'home-timeline', component: HomeTimelineComponent, canActivate: [AuthGuard] }, // Protected route
  { path: 'user-timeline', component: UserTimelineComponent, canActivate: [AuthGuard] }, // Protected route
  { path: 'login', component: LoginComponent }, // Public route
  { path: 'signup', component: SignupComponent }, // Public route
  { path: '**', redirectTo: 'home-timeline' }, // Wildcard route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}