import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TweetServiceService } from '../services/tweet-service.service';
import { TweetDTO } from '../model/tweet-dto';

@Component({
  selector: 'app-home-timeline',
  standalone: false,
  templateUrl: './home-timeline.component.html',
  styleUrl: './home-timeline.component.css'
})
export class HomeTimelineComponent implements OnInit {
  tweets: TweetDTO[] = [];
  showDialog: boolean = false;
  currentTweetId: number | null = null;

  constructor(
    private tweetService: TweetServiceService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.tweetService.getHomeTimeline().subscribe(
      (data: any) => {
        this.tweets = data;
      },
      (error) => {
        console.error('Error fetching tweets:', error);
      }
    );
  }

  likeTweet(tweetId: number): void {
    this.tweetService.likeTweet(tweetId, Number(localStorage.getItem("userId") ?? "000")).subscribe(() => {
      const tweet = this.tweets.find(t => t.tweetId === tweetId);
      if (tweet) {
        tweet.likes.push(tweet.likes.length + 1); // Increment the like count by adding a dummy object
        this.snackBar.open('Tweet liked successfully!', 'Close', {
          duration: 6000,
        });
      }
    }, error => {
      console.error('Error liking tweet:', error);
      const errorMessage = error.error?.message || 'An error occurred';
      this.snackBar.open(errorMessage, 'Close', {
        duration: 6000,
      });
    });
  }

  toggleComments(tweetId: number): void {
    const tweet = this.tweets.find(t => t.tweetId === tweetId);
    if (tweet) {
      tweet.showComments = !tweet.showComments;
    }
  }

  addComment(tweetId: number): void {
    this.currentTweetId = tweetId;
    this.showDialog = true;
  }

  handleCommentAdded(commentContent: string): void {
    if (this.currentTweetId !== null) {
      const tweet = this.tweets.find(t => t.tweetId === this.currentTweetId);
      if (tweet) {
        const commentRequest = {
          userId: 1, // Replace with actual user ID
          content: commentContent
        };
        this.tweetService.addComment(this.currentTweetId, commentRequest).subscribe(() => {
          tweet.comments.push({
            userHandle: 'currentUser', // Replace with actual user handle
            content: commentContent,
            createdAt: new Date(),
            commentId: 0,
            tweetId: 0,
            userId: 0,
            updatedAt: new Date()
          });
          this.snackBar.open('Comment added successfully!', 'Close', {
            duration: 6000,
          });
        }, error => {
          console.error('Error adding comment:', error);
          const errorMessage = error.error?.message || 'An error occurred';
          this.snackBar.open(errorMessage, 'Close', {
            duration: 6000,
          });
        });
      }
    }
    this.showDialog = false;
    this.currentTweetId = null;
  }

  handleDialogClosed(): void {
    this.showDialog = false;
    this.currentTweetId = null;
  }
}