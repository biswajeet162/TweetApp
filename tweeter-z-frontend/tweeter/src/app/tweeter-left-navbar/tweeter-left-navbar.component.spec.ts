import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TweeterLeftNavbarComponent } from './tweeter-left-navbar.component';

describe('TweeterLeftNavbarComponent', () => {
  let component: TweeterLeftNavbarComponent;
  let fixture: ComponentFixture<TweeterLeftNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TweeterLeftNavbarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TweeterLeftNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
