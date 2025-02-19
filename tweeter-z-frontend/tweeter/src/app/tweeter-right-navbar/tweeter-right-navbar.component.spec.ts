import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TweeterRightNavbarComponent } from './tweeter-right-navbar.component';

describe('TweeterRightNavbarComponent', () => {
  let component: TweeterRightNavbarComponent;
  let fixture: ComponentFixture<TweeterRightNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TweeterRightNavbarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TweeterRightNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
