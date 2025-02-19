import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-timeline',
  standalone: false,
  
  templateUrl: './home-timeline.component.html',
  styleUrl: './home-timeline.component.css'
})
export class HomeTimelineComponent implements OnInit {
  tweetsss = [
    {
      tweetId: 1,
      userId: 1,
      content: 'Helloooo - 1',
      createdAt: '2025-01-14T14:29:07.712+00:00',
      updatedAt: '2025-01-14T14:29:07.712+00:00',
      imageUrl: [
        "url1",
        "url2"
      ],
      "videoUrl":[
        "url1",
        "url2"
      ],
      comments: [
        {
          commentId: 2,
          tweetId: 2,
          userId: 2,
          userHandle: "sham kumar",
          content: "Comment Hello  2",
          createdAt: "2025-01-14T14:29:07.977+00:00",
          updatedAt: "2025-01-14T14:29:07.977+00:00"
      },
      {
        commentId: 2,
        tweetId: 2,
        userId: 2,
        userHandle: "sham kumarii",
        content: "Comment Hello  27687",
        createdAt: "2025-01-14T14:29:07.977+00:00",
        updatedAt: "2025-01-14T14:29:07.977+00:00"
    }
      ],
      likes: [2,3,4,5,6],
      showComments: false,
    },
  ];

tweets = [
    {
      tweetId: 1,
      userId: 1,
      userHandle: "Alpha",
      userName: "Alok Sharma",
      content: "Exploring the beautiful mountains! Nature is truly amazing. 🏞️✨",
      createdAt: "2025-01-14T14:29:07.712+00:00",
      updatedAt: "2025-01-14T14:29:07.712+00:00",
      imageUrl: ["https://picsum.photos/800/600?image=1043", "https://picsum.photos/800/600?image=1044"],
      videoUrl: ["src/assets/vvvv.mp4"],
      comments: [
        {
          commentId: 1,
          tweetId: 1,
          userId: 2,
          userHandle: "sham kumar",
          content: "What a stunning view! 😍",
          createdAt: "2025-01-14T14:35:07.977+00:00",
          updatedAt: "2025-01-14T14:35:07.977+00:00",
        },
        {
          commentId: 2,
          tweetId: 1,
          userId: 3,
          userHandle: "neha",
          content: "Where is this place? Looks amazing!",
          createdAt: "2025-01-14T14:40:07.977+00:00",
          updatedAt: "2025-01-14T14:40:07.977+00:00",
        },
      ],
      likes: [2, 3, 4, 5, 6],
      showComments: false,
    },
    {
      tweetId: 2,
      userId: 2,
      userHandle: "BetaCoder",
      userName: "Priya Singh",
      content: "Just finished a challenging coding project! Feeling accomplished! 💻🚀",
      createdAt: "2025-01-14T15:00:00.000+00:00",
      updatedAt: "2025-01-14T15:00:00.000+00:00",
      imageUrl: ["https://picsum.photos/800/600?image=1027"],
      videoUrl: [],
      comments: [
        {
          commentId: 3,
          tweetId: 2,
          userId: 1,
          userHandle: "Alpha",
          content: "Congrats, Priya! Keep up the good work! 💪",
          createdAt: "2025-01-14T15:10:00.000+00:00",
          updatedAt: "2025-01-14T15:10:00.000+00:00",
        },
        {
          commentId: 4,
          tweetId: 2,
          userId: 3,
          userHandle: "neha",
          content: "What was the project about? Sounds interesting!",
          createdAt: "2025-01-14T15:20:00.000+00:00",
          updatedAt: "2025-01-14T15:20:00.000+00:00",
        },
      ],
      likes: [1, 3, 6],
      showComments: false,
    },
    {
      tweetId: 3,
      userId: 3,
      userHandle: "GourmetGuru",
      userName: "Rajesh Khanna",
      content: "This homemade pasta is to die for! 🍝😋 Who wants the recipe?",
      createdAt: "2025-01-14T16:15:00.000+00:00",
      updatedAt: "2025-01-14T16:15:00.000+00:00",
      imageUrl: ["https://picsum.photos/800/600?image=1080"],
      videoUrl: ["https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_2mb.mp4"],
      comments: [
        {
          commentId: 5,
          tweetId: 3,
          userId: 4,
          userHandle: "Foodie",
          content: "Looks delicious! Please share the recipe. 😍",
          createdAt: "2025-01-14T16:20:00.000+00:00",
          updatedAt: "2025-01-14T16:20:00.000+00:00",
        },
      ],
      likes: [2, 4, 5],
      showComments: false,
    },
    {
      tweetId: 4,
      userId: 4,
      userHandle: "Bookworm",
      userName: "Ananya Roy",
      content: "Diving into a new novel: 'The Mountains Sing.' 📚✨ #BookLover",
      createdAt: "2025-01-14T17:00:00.000+00:00",
      updatedAt: "2025-01-14T17:00:00.000+00:00",
      imageUrl: ["https://picsum.photos/800/600?image=1049"],
      videoUrl: [],
      comments: [
        {
          commentId: 6,
          tweetId: 4,
          userId: 2,
          userHandle: "BetaCoder",
          content: "That's on my reading list! How are you finding it?",
          createdAt: "2025-01-14T17:10:00.000+00:00",
          updatedAt: "2025-01-14T17:10:00.000+00:00",
        },
      ],
      likes: [1, 5, 7],
      showComments: false,
    },
    {
      tweetId: 5,
      userId: 5,
      userHandle: "FitnessFreak",
      userName: "Rohit Gupta",
      content: "Morning runs are the best way to start the day! 🏃‍♂️☀️ #HealthyLife",
      createdAt: "2025-01-14T18:30:00.000+00:00",
      updatedAt: "2025-01-14T18:30:00.000+00:00",
      imageUrl: ["https://picsum.photos/800/600?image=1029"],
      videoUrl: [],
      comments: [
        {
          commentId: 7,
          tweetId: 5,
          userId: 3,
          userHandle: "GourmetGuru",
          content: "Great way to stay healthy! How long was your run?",
          createdAt: "2025-01-14T18:35:00.000+00:00",
          updatedAt: "2025-01-14T18:35:00.000+00:00",
        },
      ],
      likes: [2, 3, 6, 8],
      showComments: false,
    },
    {
      tweetId: 6,
      userId: 6,
      userHandle: "TravelerDiaries",
      userName: "Sanya Patel",
      content: "Paris is magical at night! 🌃🇫🇷 #TravelGoals",
      createdAt: "2025-01-14T20:00:00.000+00:00",
      updatedAt: "2025-01-14T20:00:00.000+00:00",
      imageUrl: ["https://picsum.photos/800/600?image=1057"],
      videoUrl: ["https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_3mb.mp4"],
      comments: [
        {
          commentId: 8,
          tweetId: 6,
          userId: 7,
          userHandle: "MusicManiac",
          content: "Paris is on my bucket list! Hope to go there soon.",
          createdAt: "2025-01-14T20:10:00.000+00:00",
          updatedAt: "2025-01-14T20:10:00.000+00:00",
        },
      ],
      likes: [1, 4, 5, 9],
      showComments: false,
    }
  ];
  




  constructor() {}

  ngOnInit(): void {}

  likeTweet(tweetId: number): void {
    console.log("jeesdasdas")
    console.log(tweetId)
    // const tweet = this.tweets.find(t => t.tweetId === tweetId);
    // if (tweet) {
    //   // tweet.likes.push({}); // Placeholder for a like object
    // }
  }

  toggleComments(tweetId: number): void {
    console.log("jee")
    const tweet = this.tweets.find(t => t.tweetId === tweetId);
    if (tweet) {
      tweet.showComments = !tweet.showComments;
    }
  }
}