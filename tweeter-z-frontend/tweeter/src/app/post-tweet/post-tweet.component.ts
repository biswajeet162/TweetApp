import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TweetServiceService } from '../services/tweet-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-post-tweet',
  standalone: false,
  templateUrl: './post-tweet.component.html',
  styleUrl: './post-tweet.component.css'
})
export class PostTweetComponent {
  tweet = {
    userId: '',
    userHandle: '',
    userName: '',
    content: '',
    imageUrls: [] as string[],
    videoUrls: [] as string[]
  };
  selectedImages: File[] = [];
  selectedVideos: File[] = [];

  constructor(private http: HttpClient, private tweetService: TweetServiceService, private snackBar: MatSnackBar) {}

  onFileChange(event: any, type: 'images' | 'videos') {
    if (type === 'images') {
      this.selectedImages = Array.from(event.target.files);
    } else {
      this.selectedVideos = Array.from(event.target.files);
    }
  }

  async onSubmit() {
    try {
      this.tweet.imageUrls = await this.uploadFiles(this.selectedImages);
      this.tweet.videoUrls = await this.uploadFiles(this.selectedVideos);

      this.tweet.userId = localStorage.getItem('userId') ?? ""; // Hardcoded for now
      this.tweet.userHandle = localStorage.getItem('username') ?? ""; // Hardcoded for now
      this.tweet.userName =  localStorage.getItem('handle') ?? ""; // Hardcoded for now

      this.tweetService.createTweet(this.tweet).subscribe(response => {
        console.log('Tweet created successfully:', response);
        this.snackBar.open('post added successfully!', 'Close', {
          duration: 6000,
        });
      });
      } catch (error) {
        console.error('Error adding comment:', error);
        const errorMessage = (error as any).error?.message || 'An error occurred';
        this.snackBar.open(errorMessage, 'Close', {
          duration: 6000,
        });
    }
  }

  async uploadFiles(files: File[]): Promise<string[]> {
    const urls: string[] = [];
    const storageAccount = "tweetstorage162";
    const containerName = "tweets"; // Your actual container name
    const sasToken = "sv=2024-11-04&ss=bfqt&srt=sco&sp=rwdlacupiytfx&se=2025-03-27T13:05:42Z&st=2025-03-26T05:05:42Z&spr=https,http&sig=pMEr0SCqMGoeT62H1aXx4MphwQYMfflF4giAgNVq4DI%3D"
  
    for (const file of files) {
      const blobUrl = `https://${storageAccount}.blob.core.windows.net/${containerName}/${file.name}`;
  
      try {
        const response = await this.http.put(blobUrl + "?" + sasToken, file, {
          headers: {
            'x-ms-blob-type': 'BlockBlob',
            'Content-Type': file.type
          },
          observe: 'response'
        }).toPromise();
  
        if (response && (response.status === 201 || response.status === 202)) {
          console.log(`File uploaded successfully: ${blobUrl}`);
          urls.push(blobUrl); // ✅ Store clean URL (without SAS token)
        } else {
          throw new Error(`File upload failed with status ${response?.status}`);
        }
      } catch (error) {
        console.error(`Error uploading file ${file.name}:`, error);
      }
    }

    return urls;
  }
  
}