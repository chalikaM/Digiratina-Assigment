import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParcelRegistrationComponent } from './parcel-registration.component';

describe('ParcelRegistrationComponent', () => {
  let component: ParcelRegistrationComponent;
  let fixture: ComponentFixture<ParcelRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ParcelRegistrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParcelRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
