import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeTimelineComponent } from './home-timeline/home-timeline.component';
import { UserTimelineComponent } from './user-timeline/user-timeline.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  { path: '', redirectTo: 'home-timeline', pathMatch: 'full' }, // Default route
  { path: 'profile', component: UserProfileComponent },          // Home route
  { path: 'home-timeline', component: HomeTimelineComponent },          // Home route
  { path: 'user-timeline', component: UserTimelineComponent }, // User Timeline route
  { path: 'login', component: UserTimelineComponent }, // User Timeline route
  { path: 'signup', component: UserTimelineComponent }, // User Timeline route
  { path: '**', redirectTo: '' }, // User Timeline route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
